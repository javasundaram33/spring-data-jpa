package com.javasundaram.spring.data.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Guardian {

    private String guardianName;
    private Long guradianMobile;
    private String guardianEmail;
}
