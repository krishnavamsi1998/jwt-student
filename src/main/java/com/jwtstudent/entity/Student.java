package com.jwtstudent.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "STUDENT_TBL")
public class Student {
	@Id
	private int studentId;
	@Column(unique = true)
	@NotNull
	private String studentName;
	@NotNull
	private String studentPassword;
	@NotNull
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "student_id", referencedColumnName = "studentId")
	private List<Course> courseList = new ArrayList<>();

}
