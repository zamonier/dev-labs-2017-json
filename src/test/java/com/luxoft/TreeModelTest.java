package com.luxoft;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TreeModelTest {

    @Before
    public void init() {

    }

    @Test
    public void test() throws IOException, URISyntaxException {

        String content = getFileContent("person.json");
        ObjectMapper mapper = new ObjectMapper();

        JsonNode rootNode = mapper.readValue(content, JsonNode.class);
        String lastName = rootNode.get("lastName").asText();

        JsonNode childNode = rootNode.get("address");
        String city = childNode.get("city").asText();

        System.out.println(lastName + " " + city);
    }

    private String getFileContent(String name) throws URISyntaxException, IOException {
        URI uri = Thread.currentThread().getContextClassLoader().getResource(name).toURI();
        return new String(Files.readAllBytes(Paths.get(uri)));
    }

}
