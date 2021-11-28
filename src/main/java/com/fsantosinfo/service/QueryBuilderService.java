package com.fsantosinfo.service;

import com.fsantosinfo.model.dto.QueryRequestDto;
import com.fsantosinfo.util.QueryHelper;

public interface QueryBuilderService {
    
    QueryHelper queryBuilder(QueryRequestDto requestBody);
}
