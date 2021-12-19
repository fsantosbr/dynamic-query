package com.fsantosinfo.repository;

import java.util.List;

import com.fsantosinfo.model.dto.QueryResponseDto;
import com.fsantosinfo.util.QueryHelper;

public interface QueryRepository {
    
    List<QueryResponseDto> getAllByQuery(QueryHelper queryHelper);
}
