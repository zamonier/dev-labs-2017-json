package com.luxoft.lifehacks;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

public class PolymorphicDeserializationTest {

    @Test
    public void test() throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        String baseJson =
                "{\"" +
                    "type\":\"BaseClass\"," +
                    "\"baseName\":\"base name\"" +
                "}";
        BaseClass baseCopy = mapper.readValue(baseJson, BaseClass.class);
        System.out.println(baseCopy.getClass());

        String aJson =
                "{\"" +
                    "type\":\"a-class\"," +
                    "\"baseName\":\"base name\"," +
                    "\"aName\":\"a name\"" +
                 "}";
        BaseClass aCopy = mapper.readValue(aJson, BaseClass.class);
        System.out.println(aCopy.getClass());

        String bJson =
                "{\"" +
                        "type\":\"b-class\"," +
                        "\"baseName\":\"base name\"," +
                        "\"bName\":\"b name\"" +
                 "}";
        BaseClass bCopy = mapper.readValue(bJson, BaseClass.class);
        System.out.println(bCopy.getClass());

    }
}

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ChildA.class, name = "a-class"),
        @JsonSubTypes.Type(value = ChildB.class, name = "b-class")})
class BaseClass {
    public String baseName = "base name";
}

class ChildA extends BaseClass {
    public String aName = "a name";
}

class ChildB extends BaseClass {
    public String bName = "b name";
}

