package com.fsantosinfo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class QueryRequestDto {

    private Integer numTeachers;
    private String paymentType;
    private Integer activePeriod;    
}
