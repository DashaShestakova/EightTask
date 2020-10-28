package com.epam.idea.task.eight.parser.impl;

import com.epam.idea.task.eight.entity.OldCard;
import com.epam.idea.task.eight.exception.ParserException;

import java.text.ParseException;
import java.util.List;

public interface Parser {
    List<OldCard> buildOldCardList(String fileName) throws ParserException;
}
