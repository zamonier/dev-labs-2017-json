package com.luxoft;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

public class TreeModelTest {

    @Test
    public void test() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readValue("{\"message\":\"Hi\",\"place\":{\"name\":\"World!\"}}", JsonNode.class);
        String message = rootNode.get("message").asText(); // get property message
        JsonNode childNode =  rootNode.get("place"); // get object Place
        String place = childNode.get("name").asText(); // get property name
        System.out.println(message + " " + place); // print "Hi World!"
    }

}
