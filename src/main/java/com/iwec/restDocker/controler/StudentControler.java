package com.iwec.restDocker.controler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iwec.restDocker.entity.Student;
import com.iwec.restDocker.repository.StudentRepository;

@RestController
@RequestMapping("/v1")
public class StudentControler {

	@Autowired
	private StudentRepository studentRepository;

	// GET method to fetch all students
	//@GetMapping("/students")
	@RequestMapping(value = "/students", method= RequestMethod.GET)
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	// GET method to fetch student by Id
	//@GetMapping("/students/{id}")
	@RequestMapping(value = "/students/{id}", method= RequestMethod.GET)
	public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") Integer id) throws Exception {
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new Exception("Student " + id + " not found"));
		return ResponseEntity.ok().body(student);
	}

	// POST method to create a student
	@PostMapping("/students")
	public Student createStudent(@Valid @RequestBody Student student) {
		return studentRepository.save(student);
	}

	// PUT method to update a students's details
	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Integer id,
			@Valid @RequestBody Student studentDetails) throws Exception {
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new Exception("Student " + id + " not found"));

		student.setFirstName(studentDetails.getFirstName());
		student.setLastName(studentDetails.getLastName());

		final Student updatedStudent = studentRepository.save(student);
		return ResponseEntity.ok(updatedStudent);
	}

	// DELETE method to delete a student
	@DeleteMapping("/student/{id}")
	public Map<String, Boolean> deleteStudent(@PathVariable(value = "id") Integer id) throws Exception {
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new Exception("Student " + id + " not found"));

		studentRepository.delete(student);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
