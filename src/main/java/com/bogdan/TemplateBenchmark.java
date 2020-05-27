package com.bogdan;

import org.openjdk.jmh.annotations.*;

import java.util.HashMap;
import java.util.Map;

@State(Scope.Benchmark)
public class TemplateBenchmark {

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @Fork(value = 1, warmups = 1)
    public void testService(ExecutionPlan plan) {
        Map<String, String> map = new HashMap<>();
        map.put("placeholder1", "value1");
        map.put("placeholder2", "value2");
        String value = plan.templateService.fillTemplate("http://localhost:1234/url-$<placeholder1>>-$<placeholder2>>.html", map, "$<", ">>");
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @Fork(value = 1, warmups = 1)
    public void testSubstitutor(ExecutionPlan plan) {
        Map<String, String> map = new HashMap<>();
        map.put("placeholder1", "value1");
        map.put("placeholder2", "value2");
        String value = plan.templateSubstitutor.substitute("http://localhost:1234/url-$<placeholder1>>-$<placeholder2>>.html", map, "$<", ">>");
    }

}
