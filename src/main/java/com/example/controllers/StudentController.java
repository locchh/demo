package com.example.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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

    /**
     * Get List of Student object
     * @return students
     */
    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    /**
     * Get specific student object by path variables
     * @param firstName
     * @param lastName
     * @return student
     * 
     * Example: localhost:8080/student/John/Doe
     */
    @GetMapping("/student/{firstName}/{lastName}")
    public Student studentPathVariable(@PathVariable("firstName") String firstName,
    @PathVariable("lastName") String lastName){
        return new Student(firstName, lastName);
    }

    /**
     * Get specific student object by request params
     * @param firstName
     * @param lastName
     * @return student
     * 
     * Example: localhost:8080/student/query?firstName=John&lastName=Doe
     */
    @GetMapping("/student/query")
    public Student studentQueryParam(@RequestParam(name="firstName") String firstName,
    @RequestParam(name="lastName") String lastName){
        return new Student(firstName, lastName); 
    }

    /**
     * Add new student object
     * @param student
     * @return void
     * 
     * Example: localhost:8080/student
     */
    @PostMapping("/student")
    public void addStudent(@RequestBody Student student){
        //  When Spring deserializes the JSON request body into a Student object,
        //  it uses object setter methods. 
        // Add student to list
        students.add(student);
    }
    
    /**
     * Update student first name follow request body json object
     * @param firstName
     * @param student
     * @return void
     * 
     * Example: localhost:8080/student/John
     */
    @PutMapping("/student/{firstName}")
    public void updateStudent(@PathVariable("firstName") String firstName, @RequestBody Student student){
        // Search for student by first name
        for (Student s : students){
            if (s.getFirstName().equals(firstName)){
                // Update student first name by request body json object
                s.setFirstName(student.getFirstName());
                // Update student last name by request body json object
                s.setLastName(student.getLastName());
            }
        }
    }

    @DeleteMapping("/student/{firstName}")
    public void deleteStudent(@PathVariable("firstName") String firstName){
        // Search for student by first name
        for (Student s : students){
            if (s.getFirstName().equals(firstName)){
                // Remove student from list and break the loop
                students.remove(s);
                break; // Exit the loop after removing to avoid ConcurrentModificationException
            }
        }
        // students.removeIf(s -> s.getFirstName().equals(firstName));
    }
}
