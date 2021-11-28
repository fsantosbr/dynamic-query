package com.fsantosinfo.util;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QueryHelper {
    
    private StringBuilder stringBuilder;
    private List<ParameterQuery> parameters;
}
