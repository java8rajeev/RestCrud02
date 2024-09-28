package com.app.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Student;
import com.app.service.IStudentService;

@RestController
@RequestMapping("/rest")
public class StudentController {
	
	@Autowired
	private IStudentService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveStd(@RequestBody Student std){
		ResponseEntity<String> rsp=null;
		try{
		Integer id=service.saveStd(std);
		String msg="student saved with this '"+id+"' number";
		rsp=new ResponseEntity<String>(msg,HttpStatus.CREATED);
		}catch(Exception e) {
			rsp=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		
		return rsp;
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllStd(){
		ResponseEntity<?> rsp=null;
	    List<Student> list=service.getAll();
	    if(list==null||list.isEmpty()) {
	    	rsp=new ResponseEntity<String>("LIST IS EMPTY",HttpStatus.BAD_REQUEST);
	    }else {
		     rsp=new ResponseEntity<List<Student>>(list,HttpStatus.OK);

		}
		
		return rsp;
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStd(@PathVariable("id") Integer id){
		ResponseEntity<String> rsp=null;
		boolean present=service.isPresent(id);
		if(present) {
			service.deleteStd(id);
		rsp=new ResponseEntity<String>(" '"+id+"' deleted succesfully",HttpStatus.OK);
		}else{
			rsp=new ResponseEntity<String>("'"+id+"' not exist ",HttpStatus.BAD_REQUEST);
			
		}
		return rsp;
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateStd(@PathVariable("id") Integer id,@RequestBody Student std){
		ResponseEntity<String> rsp=null;
		boolean present=service.isPresent(id);
		if(present) {
			service.updateStd(std);
		rsp=new ResponseEntity<String>(" '"+id+"' updated succesfully",HttpStatus.OK);
		}else{
			rsp=new ResponseEntity<String>("'"+id+"' not exist ",HttpStatus.BAD_REQUEST);
			
		}
		return rsp;
		
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getOneStd(@PathVariable("id") Integer id){
		ResponseEntity<?> rsp=null;
		boolean present=service.isPresent(id);
		if(present) {
			Optional<Student> onestudent = service.getOneStd(id);
		rsp=new ResponseEntity<Optional<Student>>(onestudent,HttpStatus.OK);
		}else{
			rsp=new ResponseEntity<String>("'"+id+"' not exist ",HttpStatus.BAD_REQUEST);
			
		}
		return rsp;
		
	}
	
	
	
	
	
	
	
	

}
