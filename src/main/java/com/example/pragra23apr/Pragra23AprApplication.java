package com.example.pragra23apr;

import com.example.pragra23apr.dao.CourseDAO;
import com.example.pragra23apr.dao.StudentDAO;
import com.example.pragra23apr.domain.Course;
import com.example.pragra23apr.domain.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.Instant;

@SpringBootApplication
public class Pragra23AprApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(Pragra23AprApplication.class, args);
        StudentDAO dao = context.getBean(StudentDAO.class);
        CourseDAO courseDAO = context.getBean(CourseDAO.class);

        Student student_1 = Student.builder().id(1).firstName("Amon").lastName("chhina").createDate(Instant.now()).build();
        Student student_2 = Student.builder().id(2).firstName("Ak").lastName("sidhu").createDate(Instant.now()).build();
        Student student_2_1 = Student.builder().firstName("Akash").lastName("sidhu").createDate(Instant.now()).id(2).build();
        dao.createStudent(student_2);
        dao.createStudent(student_1);
        System.out.println(dao.getStudents());
        System.out.println(dao.getStudents());
        dao.updateStudent(student_2_1);
//        Course java = Course.builder().id(2).courseName("Java").courseFee(1000).createDate(Instant.now()).build();
//        Course maths = Course.builder().id(1).courseName("Maths").courseFee(500).createDate(Instant.now()).build();
//        Course maths1 = Course.builder().courseName("Maths").courseFee(6000).createDate(Instant.now()).updateDate(Instant.now()).id(1).build();
//        courseDAO.createCourse(java);
//        courseDAO.createCourse(maths);
//        courseDAO.updateCourse(maths1);

        System.out.println(courseDAO.getCourses());

    }

}
