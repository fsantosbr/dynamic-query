package com.fsantosinfo.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ConverterList {

    public static<T> List<T> checkingConversionToAnyList(Class<? extends T> desiredClassType, Collection<?> rawCollection){
        
        List<T> resultList = new ArrayList<>(rawCollection.size());
        for (Object obj : rawCollection) {
            try {
                resultList.add(desiredClassType.cast(obj));
            } catch (ClassCastException e) {
                throw new RuntimeException("Conversion to Object not allowed", e.getCause());               
            }
        }

        return resultList;
    }
    
}
