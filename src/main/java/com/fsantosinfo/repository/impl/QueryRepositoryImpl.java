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
    public List<QueryResponseDto> getAllByQuery(QueryHelper queryHelper) {

        Query query = entityManager.createNativeQuery(queryHelper.getStringBuilder().toString(),
                "queryResultSetMapping");

        for (Map.Entry<String, Object> entry : queryHelper.getParameters().entrySet()) {
            String mapKeyValue = entry.getKey();
            query.setParameter(mapKeyValue, entry.getValue());
        }

        return ClassUtils.checkingListCasting(QueryResponseDto.class, query.getResultList());
    }

}
