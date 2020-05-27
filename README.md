# Benchmark test of Template engines
This benchmark used JMH https://openjdk.java.net/projects/code-tools/jmh/

# To run:
mvn clean package

And run from IDE:
BenchmarkRunner.java

# Benchmark results:

## templateSubstitutor - Custom one

Result "TemplateBenchmark.testSubstitutor":
  2194375.393 ±(99.9%) 223374.068 ops/s [Average]
  (min, avg, max) = (2094994.000, 2194375.393, 2246279.219), stdev = 58009.536
  CI (99.9%): [1971001.326, 2417749.461] (assumes normal distribution)


## templateService - Apache StringSubstitutor

Result "TemplateBenchmark.testService":
  1910095.953 ±(99.9%) 16226.758 ops/s [Average]
  (min, avg, max) = (1905483.216, 1910095.953, 1916354.023), stdev = 4214.038
  CI (99.9%): [1893869.195, 1926322.711] (assumes normal distribution)
  
# Conclusion
The custom template substitutor is around 15% faster than the Apache StringSubstitutor in this particular benchmark.  
```
2194375/1910095=~1,15
```