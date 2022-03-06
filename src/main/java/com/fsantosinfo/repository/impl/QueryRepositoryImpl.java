package com.fsantosinfo.repository.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.fsantosinfo.model.dto.QueryResponseDto;
import com.fsantosinfo.repository.QueryRepository;
import com.fsantosinfo.util.ClassUtils;
import com.fsantosinfo.util.QueryHelper;

public class QueryRepositoryImpl implements QueryRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<QueryResponseDto> getAllByCustomQuery(QueryHelper queryHelper) {

        Query query = entityManager.createNativeQuery(queryHelper.getStringBuilder().toString(),
                "queryResultSetMapping");

        setParametersToQuery(queryHelper.getParameters(), query);

        return ClassUtils.checkingListCasting(QueryResponseDto.class, query.getResultList());
    }

    private void setParametersToQuery(Map<String, Object> parameters , Query query) {
        for (Map.Entry<String, Object> entry : parameters.entrySet()) {
            String mapKeyValue = entry.getKey();
            query.setParameter(mapKeyValue, entry.getValue());
        }
    }

}
