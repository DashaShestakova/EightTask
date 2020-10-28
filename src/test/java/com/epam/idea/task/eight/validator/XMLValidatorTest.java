package com.epam.idea.task.eight.validator;

import org.junit.Assert;
import org.junit.Test;

public class XMLValidatorTest {
    private final static String XML_FILE = "src/main/resources/oldCard.xml";
    private final static String XSD_FILE = "src/main/resources/oldCard.xsd";


    @Test
    public void testValidateXMLSchemaShouldValidateWhenSchemaIsValid(){
        XMLValidator validator = new XMLValidator();

        boolean flag  = validator.validateXMLSchema(XSD_FILE, XML_FILE);

        Assert.assertTrue(flag);
    }
}
