package com.jwtstudent.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jwtstudent.entity.Course;
import com.jwtstudent.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	Student findByStudentName(String studentName);

	@Query(value = "SELECT c.course_name FROM course_tbl c where c.student_id=?1", nativeQuery = true)
	List<String> findByCourseName(Integer studentId);

	@Modifying
	@Transactional
	@Query(value = "UPDATE student_tbl s set s.student_password=?2 where s.student_id=?1", nativeQuery = true)
	int changePassword(Integer studentId, String studentPassword);
}
