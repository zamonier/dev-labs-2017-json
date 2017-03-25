package com.luxoft;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.fasterxml.jackson.core.JsonToken.VALUE_STRING;

public class StreamingAPITest {

    @Test
    public void test() throws IOException, URISyntaxException {

        String content = getFileContent("person.json");

        JsonParser jsonParser = new JsonFactory().createParser(content);

        do {
            JsonToken jsonToken = jsonParser.nextToken();

            if (jsonToken == VALUE_STRING) {
                System.out.print(jsonParser.getText() + " ");
            }

        } while (jsonParser.hasCurrentToken());

        System.out.println();
    }

    private String getFileContent(String name) throws URISyntaxException, IOException {
        URI uri = Thread.currentThread().getContextClassLoader().getResource(name).toURI();
        return new String(Files.readAllBytes(Paths.get(uri)));
    }
}
