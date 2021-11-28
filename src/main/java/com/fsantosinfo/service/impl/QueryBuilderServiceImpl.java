package com.fsantosinfo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fsantosinfo.model.dto.QueryRequestDto;
import com.fsantosinfo.service.QueryBuilderService;
import com.fsantosinfo.util.QueryHelper;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class QueryBuilderServiceImpl implements QueryBuilderService {

    private static final String PAYMENT_TYPE = "paymentType";
    private static final String ACTIVE_PERIOD = "activePeriod";
    private static final String NUM_TEACHERS = "numTeachers";

    @Override
    public QueryHelper queryBuilder(QueryRequestDto requestBody) {
        
        //List<ParameterQuery> parameters = new ArrayList<>();
        Map<String, Object> parametersMap = new HashMap<>();

        StringBuilder stringQuery = new StringBuilder();
        List<String> whereClauseList = new ArrayList<>();

        stringQuery.append("select ");
        stringQuery.append("st.student_number as studentId, st.student_name as studentName, st.lastname as studentLastname, st.student_age as studentAge");
        
         // INNER JOIN
        stringQuery.append(" from tab_student4 st");
        stringQuery.append(" inner join tab_school sch on st.school_id = sch.school_id");       

        // payment type
        if (StringUtils.isNotEmpty(requestBody.getPaymentType())) {
            stringQuery.append(" inner join tab_payment pay on st.payment_id = pay.payment_id");
            whereClauseList.add(" and pay.payment_type = :" + PAYMENT_TYPE);
            parametersMap.put(PAYMENT_TYPE, requestBody.getPaymentType());
        }

        // active period
        if (requestBody.getActivePeriod() != null) {
            stringQuery.append(" inner join tab_period pr on st.period_id = pr.period_id");
            whereClauseList.add(" and pr.active_period = :" + ACTIVE_PERIOD);
            parametersMap.put(ACTIVE_PERIOD, requestBody.getActivePeriod());
        }


        //WHERE
        stringQuery.append(" where ");
        stringQuery.append("sch.num_teachers >= :" + NUM_TEACHERS);
        parametersMap.put(NUM_TEACHERS, requestBody.getNumTeachers());


        for (String whereClause : whereClauseList) {
            stringQuery.append(whereClause);
        }

        System.out.println(stringQuery.toString());

        return new QueryHelper(stringQuery, parametersMap);       
    }
    
}
