package com.fsantosinfo.util;

import java.util.HashMap;
import java.util.Map;

public class QueryHelper {

    private Map<String, Object> parameters = new HashMap<>();
    private StringBuilder stringBuilder = new StringBuilder();

    public void addStringQuery(String string) {
        this.stringBuilder.append(string);
    }

    public void addStringQuery(Character character) {
        this.stringBuilder.append(character);
    }

    public StringBuilder getStringBuilder() {
        return this.stringBuilder;
    }

    public void addParameter(String parameterName, Object parameterValue) {
        this.parameters.put(parameterName, parameterValue);
    }

    public Map<String, Object> getParameters() {
        return this.parameters;
    }

}
