package com.luxoft.paths;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static com.luxoft.TestUtils.getFileContent;

public class JSONPathTest {
    @Test
    public void test() throws IOException, URISyntaxException {

        String content = getFileContent("store.json");

        // the authors of all books in the store
        List<String> authors = JsonPath.read(content, "$.store.book[*].author");
        System.out.println(authors);
        System.out.println();

        // the price of everything in the store.
        List<Integer> prices = JsonPath.read(content, "$.store..price");
        System.out.println(prices);
        System.out.println();

        // the last book in order.
        JSONArray book = JsonPath.read(content, "$..book[-1:]");
        System.out.println(book);
        System.out.println();

    }


}
