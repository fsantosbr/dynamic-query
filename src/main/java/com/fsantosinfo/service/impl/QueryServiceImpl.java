package com.fsantosinfo.service.impl;

import java.util.List;

import com.fsantosinfo.model.dto.QueryRequestDto;
import com.fsantosinfo.model.dto.QueryResponseDto;
import com.fsantosinfo.repository.StudentRepository;
import com.fsantosinfo.service.QueryService;
import com.fsantosinfo.util.QueryHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryServiceImpl implements QueryService {

    @Autowired
    private StudentRepository studentRepository;   

    @Autowired
    private QueryBuilderServiceImpl queryBuilderService;

    @Override
    public List<QueryResponseDto> searchAllByQuery(QueryRequestDto requestBody) {
        
        QueryHelper queryHelper = queryBuilderService.queryBuilder(requestBody);
        return this.studentRepository.getAllByQuery(queryHelper);        
    }
    
}
