package com.epam.idea.task.eight.parser;

import com.epam.idea.task.eight.entity.OldCard;
import com.epam.idea.task.eight.exception.ParserException;
import com.epam.idea.task.eight.parser.impl.saxparser.SaxParser;
import org.junit.Assert;

import java.util.List;

public class SaxParserTest extends AbstractTest{
    @Override
    public void testParser() throws ParserException {
        SaxParser saxParser = new SaxParser();

        List<OldCard> actualList = saxParser.buildOldCardList(FILEPATH);

        Assert.assertEquals(actualList, expectedList);
    }
}
