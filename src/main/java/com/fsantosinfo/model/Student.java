package com.fsantosinfo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Student {
    
    @Column(name = "student_number")
    @Id
    private Long studentNumber;
}
