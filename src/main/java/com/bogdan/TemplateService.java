package com.bogdan;

import org.apache.commons.text.StringSubstitutor;

import java.util.Map;

public class TemplateService {

    public String fillTemplate(final String template, final Map<String, String> valuesMap, String prefix, String suffix) {
        StringSubstitutor stringSubstitutor = new StringSubstitutor(valuesMap);
        stringSubstitutor.setVariablePrefix(prefix);
        stringSubstitutor.setVariableSuffix(suffix);
        stringSubstitutor.setEnableUndefinedVariableException(true);
        return stringSubstitutor.replace(template);
    }
}
