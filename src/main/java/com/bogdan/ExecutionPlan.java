package com.bogdan;

import org.openjdk.jmh.annotations.*;

@State(Scope.Benchmark)
public class ExecutionPlan {

    @Param({"500"})
    public int iterations;

    TemplateService templateService;
    TemplateSubstitutor templateSubstitutor;

    @Setup(Level.Invocation)
    public void setUp() {
        templateService = new TemplateService();
        templateSubstitutor = new TemplateSubstitutor();
    }
}
