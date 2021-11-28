package com.fsantosinfo.repository.impl;

import static com.fsantosinfo.util.ConverterList.checkingConversionToAnyList;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.fsantosinfo.repository.QueryRepository;
import com.fsantosinfo.util.ParameterQuery;
import com.fsantosinfo.util.QueryHelper;

public class QueryRepositoryImpl implements QueryRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Object[]> getAllByQuery(QueryHelper queryHelper) {
        
        Query query = entityManager.createNativeQuery(queryHelper.getStringBuilder().toString());

        for (ParameterQuery param : queryHelper.getParameters()) {
            if (param.getParameterValue() instanceof Long){
                query.setParameter(param.getParameterName(), param.getParameterValue());
            }
            if (param.getParameterValue() instanceof Integer){
                query.setParameter(param.getParameterName(), param.getParameterValue());
            }
            if (param.getParameterValue() instanceof String){
                query.setParameter(param.getParameterName(), param.getParameterValue());
            }
        }

        return checkingConversionToAnyList(Object[].class, query.getResultList());
    }
    
}
