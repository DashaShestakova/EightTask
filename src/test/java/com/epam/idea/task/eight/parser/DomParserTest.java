package com.epam.idea.task.eight.parser;

import com.epam.idea.task.eight.entity.OldCard;
import com.epam.idea.task.eight.exception.ParserException;
import com.epam.idea.task.eight.parser.impl.domparser.DomParser;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class DomParserTest extends AbstractTest{
    @Test
    @Override
    public void testParser() throws ParserException {
        DomParser domParser = new DomParser();

        List<OldCard> actualList = domParser.buildOldCardList(FILEPATH);

        Assert.assertEquals(actualList, expectedList);
    }
}
