package com.jwtstudent.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jwtstudent.entity.Student;
import com.jwtstudent.repository.StudentRepository;

@Service
public class CustomStudentDetailService implements UserDetailsService {

	@Autowired
	private StudentRepository repo;

	@Override
	public UserDetails loadUserByUsername(String studentName) throws UsernameNotFoundException {

		Student student = repo.findByStudentName(studentName);

		return new org.springframework.security.core.userdetails.User(student.getStudentName(),
				student.getStudentPassword(), new ArrayList<>());
	}

}
