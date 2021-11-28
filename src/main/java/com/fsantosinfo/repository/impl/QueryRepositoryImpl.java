package com.fsantosinfo.repository.impl;

import static com.fsantosinfo.util.ConverterList.checkingConversionToAnyList;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.fsantosinfo.repository.QueryRepository;
import com.fsantosinfo.util.QueryHelper;

public class QueryRepositoryImpl implements QueryRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Object[]> getAllByQuery(QueryHelper queryHelper) {
        
        Query query = entityManager.createNativeQuery(queryHelper.getStringBuilder().toString());
        Map<String, Object> parametersMap = queryHelper.getParameters();
        for (String key : parametersMap.keySet()) {
            query.setParameter(key, parametersMap.get(key));           
        }

        return checkingConversionToAnyList(Object[].class, query.getResultList());
    }
    
}
