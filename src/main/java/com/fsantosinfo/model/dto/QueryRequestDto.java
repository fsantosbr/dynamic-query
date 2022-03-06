package com.fsantosinfo.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class QueryRequestDto implements Serializable {

    private static final long serialVersionUID = 2L;
    
    private Integer teacherQuantity;
    private String paymentType;
    private Integer activePeriod;    
}
