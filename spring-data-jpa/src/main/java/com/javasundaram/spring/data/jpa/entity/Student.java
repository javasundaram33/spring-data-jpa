package com.javasundaram.spring.data.jpa.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="tbl_student", uniqueConstraints={@UniqueConstraint(columnNames={"email"})})
public class Student {

    @Id
    @SequenceGenerator(
            name="student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator ="student_sequence")
    private Long studentId;
    private String firstName;
    private String lastName;
    @Column(name="email", nullable = false)
    private String email;

    @Embedded
    private Guardian guardian;
}
