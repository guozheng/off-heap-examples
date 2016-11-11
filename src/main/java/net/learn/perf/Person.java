package net.learn.perf;

import java.io.Serializable;

/**
 * Created by gzge on 11/7/16.
 * See <url>https://github.com/OpenHFT/Chronicle-Map#chronicle-map-3-tutorial</url> for requirement on the value
 */
public class Person implements Serializable {
    private String name;
    private int age;
    private String address;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public static class PersonBuilder {
        private String name;
        private int age;
        private String address;

        public static PersonBuilder newBuilder() {
            return new PersonBuilder();
        }

        public PersonBuilder name (String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder age (int age) {
            this.age = age;
            return this;
        }

        public PersonBuilder address (String address) {
            this.address = address;
            return this;
        }

        public Person build() {
            return new Person(name, age, address);
        }
    }
}
