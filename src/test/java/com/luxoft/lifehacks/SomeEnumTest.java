package com.luxoft.lifehacks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class SomeEnumTest {

    @Test
    public void test() throws IOException {

        String content = "{\"field\":\"second-value\"}";

        ObjectMapper mapper = new ObjectMapper();

        AClass aClass = mapper.readValue(content, AClass.class);

        assertThat(aClass.getField(), is(equalTo(SomeEnum.SECOND_VALUE)));

    }

    @Test
    public void test2() throws IOException {

        String content = "{\"field\":\"first-value\"}";

        ObjectMapper mapper = new ObjectMapper();

        AClass aClass = mapper.readValue(content, AClass.class);

        assertThat(aClass.getField(), is(equalTo(SomeEnum.FIRST_VALUE)));

    }
}

class AClass {
    @JsonProperty("field")
    private SomeEnum field;

    public SomeEnum getField() {
        return field;
    }
}

enum SomeEnum {

    FIRST_VALUE("first-value"),
    SECOND_VALUE("second-value"),
    THIRD_VALUE("third-value");

    private String name;

    private final static Map<String, SomeEnum> namesMap =
            Stream.of(SomeEnum.values()).
                    collect(Collectors
                            .toMap(v -> v.name, v -> v));

    @JsonCreator
    public static SomeEnum forValue(String value) {
        return namesMap.get(value);
    }

    SomeEnum(String name) {
        this.name = name;
    }

}