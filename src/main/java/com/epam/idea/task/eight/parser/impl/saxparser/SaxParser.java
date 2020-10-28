package com.epam.idea.task.eight.parser.impl.saxparser;

import com.epam.idea.task.eight.entity.OldCard;
import com.epam.idea.task.eight.exception.ParserException;
import com.epam.idea.task.eight.parser.impl.Parser;
import com.epam.idea.task.eight.parser.impl.saxparser.OldCardHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class SaxParser implements Parser {
    private static Logger logger = LogManager.getLogger();
    private OldCardHandler oldCardHandler;
    private XMLReader reader;

    public SaxParser() throws ParserException{
        oldCardHandler = new OldCardHandler();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setNamespaceAware(true);
            SAXParser parser = factory.newSAXParser();
            reader = parser.getXMLReader();
            reader.setContentHandler(oldCardHandler);
        } catch (SAXException | ParserConfigurationException e) {
            throw new ParserException(e.getMessage());
        }
    }
    @Override
    public List<OldCard> buildOldCardList(String path) throws ParserException {
        try {
            reader.parse(path);
        } catch (SAXException e) {
            throw new ParserException(e.getMessage());
        } catch (IOException e) {
            throw new ParserException(e.getMessage());
        }
        return oldCardHandler.getOldCards();
    }
}
