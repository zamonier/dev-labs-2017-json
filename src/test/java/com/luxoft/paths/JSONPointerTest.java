package com.luxoft.paths;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.luxoft.TestUtils.getFileContent;

public class JSONPointerTest {

    @Test
    public void test() throws IOException, URISyntaxException {

        String content = getFileContent("store.json");

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(content);

        // the author of 2nd book in the store
        String author = root.at("/store/book/1/author").asText();
        System.out.println(author);
        System.out.println();

        // the price of bicycle
        Double price = root.at("/store/bicycle/price").asDouble();
        System.out.println(price);
        System.out.println();

    }
}
