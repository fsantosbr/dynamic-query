package com.fsantosinfo.service.impl;

import java.util.List;

import com.fsantosinfo.model.dto.QueryRequestDto;
import com.fsantosinfo.model.dto.QueryResponseDto;
import com.fsantosinfo.repository.StudentRepository;
import com.fsantosinfo.service.QueryBuilderService;
import com.fsantosinfo.service.QueryService;
import com.fsantosinfo.util.QueryHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryServiceImpl implements QueryService {

    @Autowired
    private StudentRepository studentRepository;   

    @Autowired
    private QueryBuilderService queryBuilderService;

    @Override
    public List<QueryResponseDto> searchAllByCustomQuery(QueryRequestDto requestBody) {
        
        QueryHelper queryHelper = queryBuilderService.buildQueryUsingRequestBody(requestBody);
        return this.studentRepository.getAllByCustomQuery(queryHelper);        
    }
    
}
