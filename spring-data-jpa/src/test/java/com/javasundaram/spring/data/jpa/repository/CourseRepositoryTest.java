package com.javasundaram.spring.data.jpa.repository;

import com.javasundaram.spring.data.jpa.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}