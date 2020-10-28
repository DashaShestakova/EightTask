package com.epam.idea.task.eight.parser;

import com.epam.idea.task.eight.entity.OldCard;
import com.epam.idea.task.eight.exception.ParserException;
import com.epam.idea.task.eight.parser.impl.jaxbparser.JaxbParser;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class JaxbParserTest extends AbstractTest{
    @Test
    @Override
    public void testParser() throws ParserException {
        JaxbParser jaxbParser = new JaxbParser();

        List<OldCard> actualList = jaxbParser.buildOldCardList(FILEPATH);

        Assert.assertEquals(actualList, expectedList);
    }
}
