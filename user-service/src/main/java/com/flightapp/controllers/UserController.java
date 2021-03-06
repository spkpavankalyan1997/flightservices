package com.flightapp.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.flightapp.entities.BookingDetails;
import com.flightapp.entities.ERole;
import com.flightapp.entities.Role;
import com.flightapp.entities.User;
import com.flightapp.payload.JwtResponse;
import com.flightapp.payload.LoginRequest;
import com.flightapp.payload.MessageResponse;
import com.flightapp.payload.SignupRequest;
import com.flightapp.repositories.RoleRepository;
import com.flightapp.repositories.UserRepository;
import com.flightapp.security.config.JwtUtils;
import com.flightapp.services.UserDetailsImpl;
import com.flightapp.services.UserService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private UserService userService;
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getUsername(), 
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				default:
					Role userRole = roleRepository.findByName(ERole.USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@PostMapping("/users")
	public Long saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@GetMapping("/users/{id}")
	public User getUser(Long id) {
		return userService.getUser(id);
	}

	@GetMapping("/bookings/bypnr/{pnr}")
	private BookingDetails[] getBookingsByPnr(@PathVariable int pnr) {

		ResponseEntity<BookingDetails[]> response = restTemplate
				.getForEntity("http://FLIGHT-SERVICE/bookings/bypnr/{pnr}", BookingDetails[].class, pnr);

		return response.getBody();
	}

	@GetMapping("/bookings/byuserid/{userid}")
	private BookingDetails[] getBookingsByUserID(@PathVariable int userid) {

		ResponseEntity<BookingDetails[]> response = restTemplate
				.getForEntity("http://FLIGHT-SERVICE/bookings/byuserid/{userid}", BookingDetails[].class, userid);

		return response.getBody();
	}

	@GetMapping("/bookings/book/{flightID}")
	private void blockAirlines(@PathVariable int flightID) {
		restTemplate.getForObject("http://FLIGHT-SERVICE/bookings/book/{flightID}", Void.class, flightID);
	}
}
