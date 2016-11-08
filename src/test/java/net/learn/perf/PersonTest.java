package net.learn.perf;

import net.learn.perf.Person;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by gzge on 11/7/16.
 */
public class PersonTest {

    @Test
    public void testPerson() {
        String testName = "Alex";
        int testAge = 10;
        String testAddress = "Infinity Loop 1, Cupertino, CA";

        Person.PersonBuilder pb = Person.PersonBuilder.newBuilder();
        Person p = pb.name(testName)
            .age(testAge)
            .address(testAddress)
            .build();

        Assert.assertEquals(p.getName(), testName);
        Assert.assertEquals(p.getAge(), testAge);
        Assert.assertEquals(p.getAddress(), testAddress);
    }
}
