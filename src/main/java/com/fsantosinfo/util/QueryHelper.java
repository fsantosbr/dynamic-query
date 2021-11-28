package com.fsantosinfo.util;

import java.util.Map;

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
    private Map<String, Object> parameters;
    //private List<ParameterQuery> parameters;
}
