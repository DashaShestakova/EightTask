package com.epam.idea.task.eight.parser.impl.jaxbparser;

import com.epam.idea.task.eight.entity.OldCard;
import com.epam.idea.task.eight.exception.ParserException;
import com.epam.idea.task.eight.entity.OldCards;
import com.epam.idea.task.eight.parser.impl.Parser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class JaxbParser implements Parser {
    private static Logger logger = LogManager.getLogger();
    @Override
    public List<OldCard> buildOldCardList(String path) throws ParserException {
        try {
            File file = new File(path);
            JAXBContext jaxbContext = JAXBContext.newInstance(OldCard.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            OldCards oldCards = (OldCards) jaxbUnmarshaller.unmarshal(file);
            logger.info("Successful parsing JaxbParser");
            return oldCards.getOldCardList();
        }catch (JAXBException e){
            throw new ParserException(e.getMessage());
        }
    }
}