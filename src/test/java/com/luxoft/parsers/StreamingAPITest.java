package com.luxoft.parsers;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.fasterxml.jackson.core.JsonToken.VALUE_STRING;
import static com.luxoft.TestUtils.getFileContent;

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


}
