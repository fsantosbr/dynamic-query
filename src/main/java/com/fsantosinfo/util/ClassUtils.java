package com.fsantosinfo.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.QueryException;

import lombok.extern.log4j.Log4j2;

@Log4j2
public final class ClassUtils {

    private ClassUtils() {
        throw new IllegalStateException("Utility Class");
    }

    public static <T> List<T> checkingListCasting(Class<? extends T> desiredClassType, Collection<?> rawCollection) {

        List<T> resultList = new ArrayList<>(rawCollection.size());
        for (Object obj : rawCollection) {
            try {
                resultList.add(desiredClassType.cast(obj));
            } catch (ClassCastException exception) {
                log.info(exception);
                throw new QueryException("Conversion to Object not allowed");
            }
        }

        return resultList;
    }

}
