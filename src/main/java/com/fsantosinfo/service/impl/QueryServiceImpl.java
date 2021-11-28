package com.fsantosinfo.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
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
    private StudentRepository repository;
    //testar trocar aqui par a implementação direta

    @Autowired
    private QueryBuilderServiceImpl queryBuilderService;

    @Override
    public List<QueryResponseDto> searchAllByQuery(QueryRequestDto requestBody) {
        
        QueryHelper queryHelper = queryBuilderService.queryBuilder(requestBody);
        return convertResultListToDto(this.repository.getAllByQuery(queryHelper));        
    }    

    private List<QueryResponseDto> convertResultListToDto(List<Object[]> resultList) {
        
        List<QueryResponseDto> responseDtoList = new ArrayList<>(resultList.size());
        for (Object[] obj : resultList) {
            responseDtoList.add(new QueryResponseDto(
                (BigDecimal) obj[0],
                 (String) obj[1],
                 (String) obj[2],
                 (BigDecimal) obj[3]));
        }

        return responseDtoList;        
    }
    
}
