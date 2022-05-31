package com.javasundaram.spring.data.jpa.repository;

import com.javasundaram.spring.data.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select s from Student s where guardian_name=?1")
    List<Student> findByGuardianName(String guardianName);

    @Query(
            value="select * from tbl_student where email=?1",
            nativeQuery = true
    )
    Student findByEmail(String email);

    @Query(
            value="select * from tbl_student where first_name= :firstName and last_name = :lastName",
            nativeQuery = true
    )
    Student findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query("select s from Student s where last_name=?1")
    List<Student> findByLast_NameOrderByFirst_NameAsc(String lastName);
}
