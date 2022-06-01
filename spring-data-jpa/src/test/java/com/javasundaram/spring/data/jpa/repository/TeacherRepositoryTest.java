package com.javasundaram.spring.data.jpa.repository;

import com.javasundaram.spring.data.jpa.entity.Course;
import com.javasundaram.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository repository;

    @Test
    public void saveTeacher(){
        Course computerNetwork = Course.builder()
                .courseName("computerNetwork")
                .credit(4)
                .build();

        Course advanceComputerArchitecture = Course.builder()
                .courseName("Advance Computer Architecture")
                .credit(4)
                .build();
        Teacher t  = Teacher.builder()
                .firstName("Chitra")
                .lastName("Chitra")
               // .courses(List.of(computerNetwork,advanceComputerArchitecture))
                .build();
        repository.save(t);
    }

}