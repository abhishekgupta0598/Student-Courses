package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/student")
    public List<Student> getData(){
        return studentService.getAllStudent();
    }

    @GetMapping("/student/{id}")
    public Student getById(@PathVariable String id){
        return studentService.getStudent(id);
    }

    @GetMapping("/student/{studentId}/course")
    public List<Course> getCourse(@PathVariable String studentId){
        return studentService.getAllCourse(studentId);
    }

    @GetMapping("/student/{studentId}/course/{id}")
    public Course getCourseById(@PathVariable String id, @PathVariable String studentId){
        return studentService.getCourses(id,studentId);
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable String id){
        studentService.deleteById(id);
    }

    @DeleteMapping("/student/{id}/course/{courseId}")
    public void deleteCourse(@PathVariable String id, @PathVariable String courseId){
        studentService.deleteCourseById(id,courseId);
    }

    @PostMapping("/student")
    public void createStudent(@RequestBody Student student){
        studentService.createData(student);
    }

    @PostMapping("/student/{studentId}/course")
    public void createCourse(@RequestBody Course course, @PathVariable String studentId){
        studentService.createCourseData(course, studentId);
    }

    @PutMapping("/student/{id}")
    public void updateStudent(@RequestBody Student student, @PathVariable String id){
        studentService.updateData(student,id);
    }


}