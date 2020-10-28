package com.epam.idea.task.eight.parser.factory;

import com.epam.idea.task.eight.exception.ParserException;
import com.epam.idea.task.eight.parser.impl.Parser;
import com.epam.idea.task.eight.parser.impl.jaxbparser.JaxbParser;

public class JaxbParserFactory implements ParserFactory{
    @Override
    public Parser createFactory() throws ParserException {
        return new JaxbParser();
    }
}
