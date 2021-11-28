package com.fsantosinfo.model.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class QueryResponseDto {

    private BigDecimal studentId;
    private String studentName;
    private String studentLastname;
    private BigDecimal studentAge;
    
}
