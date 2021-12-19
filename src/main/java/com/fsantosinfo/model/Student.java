package com.fsantosinfo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.fsantosinfo.model.dto.QueryResponseDto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(
    name = "queryResultSetMapping",
    classes ={
        @ConstructorResult (
            targetClass =QueryResponseDto.class,
    columns ={
        @ColumnResult(name ="studentId", type = Long.class),
        @ColumnResult(name ="studentName"),
        @ColumnResult(name ="studentLastname"),
        @ColumnResult(name ="studentAge", type = Integer.class)        
    }
        )
    }
)
@Entity
@NoArgsConstructor
@Getter
@Table(name = "tab_student4")
public class Student implements Serializable {

    private static final long serialVersionUID = 2L;
    
    @Column(name = "student_number")
    @Id
    private Long studentNumber;
}
