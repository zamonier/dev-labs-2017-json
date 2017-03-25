package com.luxoft.lifehacks;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class CustomSerializationTest {

    @Test
    public void test() throws IOException {


        String bar = "{\"A\":false}";
        String foo = "one";

        String expectedJson = "{\"foo\":\"" + foo + "\",\"bar\":" + bar + "}";

        Pojo pojo = new Pojo();
        pojo.foo = foo;
        pojo.bar = bar;

        ObjectMapper objectMapper = new ObjectMapper();
        String output = objectMapper.writeValueAsString(pojo);
        System.out.println(output);

        assertEquals(expectedJson, output);
    }
}

class Pojo {

    public String foo;

    @JsonRawValue
    public String bar;
}