package net.learn.perf;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by gzge on 11/8/16.
 */
@State(Scope.Thread)
public class HashMapPerf {

    int capacity = 100000;
    Map<Integer, Person> jdkPeople;

    @Setup(Level.Trial)
    public void prepare() {
        jdkPeople = new ConcurrentHashMap<Integer, Person>(capacity);
    }

    @Benchmark
    @BenchmarkMode(Mode.All)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void testJdkHashMapPut() {
        jdkHashMapPut(1000);
    }

    @Benchmark
    @BenchmarkMode(Mode.All)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void testJdkHashMapGet() {
        jdkHashMapGet(1000);
    }

    public void jdkHashMapPut(int count) {
        Person.PersonBuilder pb = null;
        Person p = null;
        for (int i = 0; i < count; i++) {
            pb = new Person.PersonBuilder();
            p = pb.name("Alex" + i)
                .age(i)
                .address("First Ave #" + i)
                .build();
            jdkPeople.put(i, p);
        }
    }

    public void jdkHashMapGet(int count) {
        Person p = null;
        for (int i = 0; i < count; i++) {
            p = jdkPeople.get(i);
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
            .include(HashMapPerf.class.getName())
            .forks(1)
            .build();

        new Runner(options).run();
    }
}
