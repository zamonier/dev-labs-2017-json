package com.luxoft.parsers;

import com.jayway.jsonpath.JsonPath;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.luxoft.TestUtils.getFileContent;

public class PathTest {

    @Test
    public void test() throws IOException, URISyntaxException {
        String content = getFileContent("person.json");

        String lastName = JsonPath.read(content, "$.lastName");
        String city = JsonPath.read(content, "$.address.city");

        System.out.println(lastName + " " + city);
    }
}
