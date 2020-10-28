package com.epam.idea.task.eight.parser.factory;

import com.epam.idea.task.eight.exception.ParserException;
import com.epam.idea.task.eight.parser.impl.Parser;

public interface ParserFactory {
    Parser createFactory() throws ParserException;
}
