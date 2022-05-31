package com.javasundaram.spring.data.jpa.repository;

import com.javasundaram.spring.data.jpa.entity.Guardian;
import com.javasundaram.spring.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student s = Student.builder()
                .email("sundarammohan82@gmail.com")
                .firstName("palani")
                .lastName("mohanasundaram")
                .build();
        studentRepository.save(s);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian g = Guardian.builder()
                .guardianName("Logu")
                .guradianMobile(6899876237L)
                .guardianEmail("logu@gmail.com")
                .build();
        Student s = Student.builder()
                .email("rokesh@gmail.com")
                .firstName("loganathan")
                .lastName("rokesh")
                .guardian(g)
                .build();
        studentRepository.save(s);
    }

    @Test
    public void getStudentList(){
        List<Student> s = studentRepository.findAll();
        System.out.println(s);
    }

    @Test
    public void getStudentListByGuardianName(){
        String guardianName = "palani";
        List<Student> s = studentRepository.findByGuardianName(guardianName);
        System.out.println(s);
    }

    @Test
    public void getStudentByEmail(){
        String email = "sundarammohan82@gmail.com";
        Student s = studentRepository.findByEmail(email);
        System.out.println(s);
    }

    @Test
    public void findByFirstNameLastNameAsc(){
        String lastName ="palani";
        List<Student> s = studentRepository.findByLast_NameOrderByFirst_NameAsc(lastName);
        System.out.println(s);
    }
}