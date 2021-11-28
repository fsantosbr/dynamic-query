package com.fsantosinfo.repository;

import java.util.List;

import com.fsantosinfo.util.QueryHelper;

public interface QueryRepository {
    
    List<Object[]> getAllByQuery(QueryHelper queryHelper);
}
