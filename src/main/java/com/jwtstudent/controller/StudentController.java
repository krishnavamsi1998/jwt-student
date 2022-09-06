package com.jwtstudent.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwtstudent.entity.AuthorizationRequest;
import com.jwtstudent.entity.Course;
import com.jwtstudent.entity.Student;
import com.jwtstudent.repository.StudentRepository;
import com.jwtstudent.util.JwtUtil;

@RestController

public class StudentController {

	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private StudentRepository studentRepo;

	@GetMapping("/")
	public String hello() {
		return "Hello Student";
	}

	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthorizationRequest authRequest) throws Exception {
		try {

			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		} catch (Exception ex) {
			throw new Exception("invalid username/password");
		}
		return jwtUtil.generateToken(authRequest.getUserName());
	}

	@GetMapping("/getMyCourse/{studentId}")
	public List<String> getMyCourse(@PathVariable("studentId") Integer studentId) {

		return studentRepo.findByCourseName(studentId);
	}

	@GetMapping("/myDetails/{studentId}")
	public Optional<Student> getMyDetails(@PathVariable("studentId") Integer studentId) {

		return studentRepo.findById(studentId);
	}

	@PutMapping("/changeMyPassword/{studentId}/{studentPassword}")
	public String changeMyPassword(@PathVariable("studentId") Integer studentId,
			@PathVariable("studentPassword") String studentPassword)

	{

		studentRepo.changePassword(studentId, studentPassword);
		return "Password changed Successfully for Id " + studentId;

	}

}
