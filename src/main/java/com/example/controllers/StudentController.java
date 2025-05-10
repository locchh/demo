package com.example.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.beans.Student;

@RestController
public class StudentController {

    // Attributes
    public static List<Student> students = new ArrayList<Student>();

    // Contructor
    public StudentController(){
        students.add(new Student("John","Doe"));
        students.add(new Student("King","Kochhar"));
        students.add(new Student("Shreya","Sharma"));
        students.add(new Student("Sarah","Bowling"));
        students.add(new Student("Gautam","Bhalla"));
    }

    // Methods
    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    @GetMapping("/student/{firstName}/{lastName}")
    public Student studentPathVariable(@PathVariable("firstName") String firstName,
    @PathVariable("lastName") String lastName){
        return new Student(firstName, lastName);
    }
    
}
