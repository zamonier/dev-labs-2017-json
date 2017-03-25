package com.luxoft;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestUtils {

    public static String getFileContent(String name) throws URISyntaxException, IOException {
        URI uri = Thread.currentThread().getContextClassLoader().getResource(name).toURI();
        return new String(Files.readAllBytes(Paths.get(uri)));
    }
}
