package com.bogdan;

import java.util.Map;

/**
 * TemplateSubstitutor is used to substitute placeholders in a template using key-value pairs.
 *
 * <p> E.g.
 * template: A-$<placeholder>-B
 * prefix: $<
 * suffix: >
 * values: {placeholder:value}
 * result: A-value-B
 */
public class TemplateSubstitutor {

    private static final int UNSET = -1;


    /**
     * Substitutes placeholders in the provided template using provided values
     *
     * @param template template to substitute placeholders in
     * @param values   map of placeholders to corresponding values
     * @return composed string with placeholders replaced by corresponding values
     * @throws IllegalArgumentException thrown when key-value is missing for at least one placeholder in the template
     */
    public String substitute(final String template, final Map<String, String> values, String prefix1, String suffix1) throws IllegalArgumentException {

        char[] prefix = prefix1.toCharArray();
        char[] suffix = suffix1.toCharArray();
        int prefixLength = prefix1.length();
        int suffixLength = suffix1.length();

        final char[] templateArr = template.toCharArray();
        final int templateLength = template.length();
        String result = template;
        int prefixIndex = 0;
        int suffixIndex = 0;
        int start = UNSET;
        int end = UNSET;

        for (int i = 0; i <= templateLength; i++) {
            if (prefixIndex == prefixLength) {
                start = i - prefixIndex;
                prefixIndex = 0;
            }
            if (suffixIndex == suffixLength) {
                end = i - 1;
                suffixIndex = 0;
            }
            if (start != UNSET && end != UNSET) {
                final String placeholderKey = template.substring(start + prefixLength, end - suffixLength + 1);
                final String value = values.get(placeholderKey);
                if (value == null) {
                    throw new IllegalArgumentException("No value passed for placeholder: " + placeholderKey);
                }
                int diff = result.length() - templateLength;
                result = replacePlaceholder(result, value, start + diff, end + diff);
                start = UNSET;
                end = UNSET;
            }
            if (i != templateLength && start == UNSET && templateArr[i] == prefix[prefixIndex]) {
                prefixIndex++;
            }
            if (i != templateLength && start != UNSET && templateArr[i] == suffix[suffixIndex]) {
                suffixIndex++;
            }
        }
        return result;
    }

    private String replacePlaceholder(final String template, final String value, final int start, final int end) {
        return template.substring(0, start) + value + template.substring(end + 1);
    }


}
