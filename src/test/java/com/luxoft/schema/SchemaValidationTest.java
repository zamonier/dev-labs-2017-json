package com.luxoft.schema;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.luxoft.TestUtils.getFileContent;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SchemaValidationTest {

    @Test
    public void test() throws IOException, URISyntaxException, ProcessingException {

        String schema = getFileContent("schema.json");
        String file = getFileContent("person.json");
        JsonNode schemaNode = JsonLoader.fromString(schema);

        JsonNode jsonToValidate = JsonLoader.fromString(file);

        ProcessingReport validate = JsonSchemaFactory.byDefault().getJsonSchema(schemaNode).validate(jsonToValidate);


        validate.forEach(System.out::println);
        System.out.println(validate.isSuccess());
        assertThat(validate.isSuccess(), is(true));

    }
}
