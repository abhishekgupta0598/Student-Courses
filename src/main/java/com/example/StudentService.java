package com.example;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


@Service
public class StudentService{
    private static List<Student> student = new ArrayList<>();

    static {

        Course course1 = new Course("1","java","java description","java steps");
        Course course2 = new Course("2","python","python description","python steps");
        Course course3 = new Course("3","Cpp","Cpp description","Cpp steps");

        Student raj = new Student("1","raj","raj description",new ArrayList<>(Arrays
                .asList(course1,course2,course3)));

        Student rahul = new Student("2","rahul","rahul description",new ArrayList<>(Arrays
                .asList(course1,course2,course3)));

        student.add(raj);
        student.add(rahul);

    }

    public List<Student> getAllStudent(){
        return student;
    }

    public Student getStudent(String id){
        for(Student student: student){
            if(student.getId().equals(id)){
                return student;
            }
        }
        return null;
    }

    public List<Course> getAllCourse(String studentId){
        Student student = getStudent(studentId);
        if(student == null)
            return null;
        else
            return student.getCourse();
    }

    public Course getCourses(String id, String studentId){
        Student student = getStudent(studentId);
        List<Course> course = student.getCourse();
        for(Course c : course){
            if(c.getId().equals(id)){
                return c;
            }
        }
        return null;
    }

    public void deleteById(String id){
        Iterator<Student> s = student.iterator();
        while(s.hasNext()){
            Student s1 = s.next();
            if(s1.getId().equals(id)){
                s.remove();
            }
        }
    }

    public void deleteCourseById(String id, String courseId){
        Student s = getStudent(id);
        List<Course> course = s.getCourse();
        Iterator<Course> c = course.iterator();
        while(c.hasNext()){
            Course c1 = c.next();
            if(c1.getId().equals(courseId)){
                c.remove();
            }
        }
    }

    public void createData(Student studentData){
        student.add(studentData);
    }

    public void createCourseData(Course courseData, String id){
        Student s = getStudent(id);
        s.getCourse().add(courseData);
    }

    public void updateData(Student studentData, String id){
        Iterator<Student> s = student.iterator();
        while(s.hasNext()){
            Student s1 = s.next();
            if(s1.getId().equals(id)){
                s.remove();
            }
        }
        student.add(studentData);
    }

}
