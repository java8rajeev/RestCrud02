package com.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Student;
import com.app.repo.IStudentRepo;
import com.app.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService{
	
	@Autowired
	private IStudentRepo repo;

	@Override
	public Integer saveStd(Student std) {
		// TODO Auto-generated method stub
		return repo.save(std).getStdId();
	}

	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<Student> getOneStd(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public void deleteStd(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public void updateStd(Student std) {
		// TODO Auto-generated method stub
		repo.save(std);
	}

	@Override
	public boolean isPresent(Integer id) {
		// TODO Auto-generated method stub
		return repo.existsById(id);
	}

}
