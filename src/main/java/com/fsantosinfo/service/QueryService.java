package com.fsantosinfo.service;

import java.util.List;

import com.fsantosinfo.model.dto.QueryRequestDto;
import com.fsantosinfo.model.dto.QueryResponseDto;

public interface QueryService {

    List<QueryResponseDto> searchAllByQuery(QueryRequestDto requestBody);

}
