package com.luxoft.parsers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static com.luxoft.TestUtils.getFileContent;

public class DataBindTest {

    @Test
    public void test() throws IOException, URISyntaxException {

        String content = getFileContent("person.json");

        ObjectMapper mapper = new ObjectMapper();
        Person person = mapper.readValue(content, Person.class);

        System.out.println(person.getLastName()+ " " + person.getAddress().getCity());
    }
}

class Person {

    private String firstName;
    private String lastName;
    private Address address;
    private List<String> phoneNumbers = null;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }
}

class Address {

    private String streetAddress;
    private String city;
    private Integer postalCode;

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public Integer getPostalCode() {
        return postalCode;
    }
}

