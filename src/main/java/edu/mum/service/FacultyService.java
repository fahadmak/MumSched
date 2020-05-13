package edu.mum.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import edu.mum.domain.Faculty;
import edu.mum.domain.UserProfile;
import edu.mum.repository.FacultyRepository;

@Service
@Transactional
public class FacultyService {
	
	Authentication auth;
	@Autowired
    FacultyRepository facultyRepository;
	public List<Faculty> getAllfaculty()
	{
		return (List<Faculty>) facultyRepository.findAll();
	}
	
	public Faculty saveFaculty(Faculty faculty)
	{
		return facultyRepository.save(faculty);
	}
	
	public Faculty getFacultyById(Long id)
	{
		return facultyRepository.findOne(id);
	}
	public void deleteFaculty(Long id)
	{
		facultyRepository.delete(id);
	}
	
	public Faculty getFacultyByName(String firstName){
		return facultyRepository.findByUserProfileFirstName(firstName);
	}
	
	public Faculty getFacultyByUserProfile(UserProfile userProfile){
		return facultyRepository.findByUserProfile(userProfile);
	}
}
