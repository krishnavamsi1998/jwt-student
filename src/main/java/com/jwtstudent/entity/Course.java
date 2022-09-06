package com.jwtstudent.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "COURSE_TBL")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int courseId;
	@NotNull
	private int courseCode;
	@NotNull
	private String courseName;
	@NotNull
	private String teacherName;
	@NotNull
	private int credits;
	
	
	
	
	
}
