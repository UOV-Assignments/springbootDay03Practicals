package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/app")
public class AppController {
	
	Student st1 = new Student("kamal",21, "IT",3.1,"2020ICT001");
	Student st2 = new Student("Nimal",22, "CS",3.8,"2020ICT002");
	Student st3 = new Student("Sunil",23, "BIO",3.3,"2020ICT003");

	List<Student> students = new ArrayList<Student>();
	@GetMapping("/student")
	public Student getStudent() {
		return st1;
	}
	@PostConstruct
    public void init() {
        students.add(st1);
        students.add(st2);
        students.add(st3);
    }
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		return students;
	}
	
	@GetMapping("/student/{id}")
	public Student getStudent(@PathVariable("id") String regNo) {
		try {
			for (Student student : students) {
				if (student.getRegNo().equals(regNo)) {
					return student;
				}
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}
	
	@GetMapping("/student/age-between")
	public List<Student> getAgeBetween(){
		List<Student> range = new ArrayList<Student>();
		
		for(Student student :students) {
			if(student.getAge()>20 && student.getAge()<25) {
				range.add(student);
			}
		}
		return range;
	}
	
	@GetMapping("/student/sorted-by-gpa")
    public List<Student> getStudentsSortedByGPA() {

        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students.get(j).getGpa() > students.get(j + 1).getGpa()) {
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }
        return students;
    }

}
