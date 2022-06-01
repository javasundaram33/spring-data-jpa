package com.javasundaram.spring.data.jpa.repository;

import com.javasundaram.spring.data.jpa.entity.Course;
import com.javasundaram.spring.data.jpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    CourseMaterialRepository repository;

    @Test
    public void saveCourseMaterial(){
        Course c = Course.builder()
                .courseName("Java")
                .credit(6)
                .build();
        CourseMaterial cm = CourseMaterial.builder()
                .url("www.google.com")
                .course(c)
                .build();
        repository.save(cm);
    }

    @Test
    public void printAllCourseMaterial(){
        List<CourseMaterial> cm = repository.findAll();
        System.out.println(cm);

    }

}