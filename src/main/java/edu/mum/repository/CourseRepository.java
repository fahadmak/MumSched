package edu.mum.repository;

import org.springframework.data.repository.CrudRepository;

import edu.mum.domain.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {

	Course findByCourseName(String courseName);}