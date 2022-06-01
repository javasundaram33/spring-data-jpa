package com.javasundaram.spring.data.jpa.repository;

import com.javasundaram.spring.data.jpa.entity.Course;
import com.javasundaram.spring.data.jpa.entity.Guardian;
import com.javasundaram.spring.data.jpa.entity.Student;
import com.javasundaram.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository repository;

    @Test
    public void printAllCourses(){
        List<Course> c = repository.findAll();
        System.out.println(c);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher t = Teacher.builder()
                .firstName("Devi")
                .lastName("Durga").build();
        Course c = Course.builder()
                .courseName("Computer Architecture")
                .credit(3)
                .teacher(t)
                .build();

        repository.save(c);
    }

    @Test
    public void printCourseByPage(){
       PageRequest r = PageRequest.of(1,2);
        List<Course> res = repository.findAll(r).getContent();
        System.out.println(res);
    }

    @Test
    public void findCourseByPageSortByCredit(){
        PageRequest r = PageRequest.of(1,3, Sort.by("credit"));
        List<Course> res = repository.findAll(r).getContent();
        System.out.println(res);
    }

    @Test
    public void saveCourseWithStudent(){
        Teacher t = Teacher.builder()
                .firstName("Keerthi")
                .lastName("Vasan").build();

        Guardian g = Guardian.builder()
                .guardianEmail("test@gmail.com")
                .guardianName("g")
                .guradianMobile(11111111L)
                .build();
        Student s = Student.builder()
                .firstName("ramesh")
                .lastName("suresh")
                .email("rameshsuresh@gmail.com")
                .guardian(g).build();
        Course c = Course.builder()
                .courseName("AWS")
                .credit(6)
                .teacher(t)
                .students(List.of(s))
                .build();

        repository.save(c);
    }
}