package com.epam.idea.task.eight.parser.impl.domparser;

import com.epam.idea.task.eight.entity.*;
import com.epam.idea.task.eight.entity.enums.OldCardTheme;
import com.epam.idea.task.eight.entity.enums.OldCardType;
import com.epam.idea.task.eight.entity.enums.OldCardValuable;
import com.epam.idea.task.eight.entity.enums.OldCardsFields;
import com.epam.idea.task.eight.exception.ParserException;
import com.epam.idea.task.eight.parser.impl.Parser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomParser implements Parser {
    private static Logger logger = LogManager.getLogger();
    private DocumentBuilder builder;

    public DomParser() throws ParserException {
    }
    @Override
    public List<OldCard> buildOldCardList(String filename) throws ParserException {
        List<OldCard> oldCardList = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(filename);
            Element root = document.getDocumentElement();
            NodeList congratulationOldCardList = root.getElementsByTagName(OldCardsFields.INFORMATION_CARD.getValue());
            NodeList informationOldCardList = root.getElementsByTagName(OldCardsFields.CONGRATULATION_CARD.getValue());
            for (int i = 0; i < congratulationOldCardList.getLength(); i++) {
                Element congratulationOldCardElement = (Element) congratulationOldCardList.item(i);
                OldCard oldCard = createCongratulationOldCard(congratulationOldCardElement);
                oldCardList.add(oldCard);
                logger.info("CongratulationOldCard is parsed");
            }
            for (int i = 0; i < informationOldCardList.getLength(); i++) {
                Element informationOldCardElement = (Element) informationOldCardList.item(i);
                OldCard oldCard = createInformationOldCard(informationOldCardElement);
                oldCardList.add(oldCard);
                logger.info("InformationOldCard is parsed");
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new ParserException("There is an exception while parsing the file");
        }
        return oldCardList;
    }

    private OldCard createCongratulationOldCard(Element oldCardElement) {
        CongratulationOldCard congratulationOldCard = new CongratulationOldCard();
        createAbstractOldCard(oldCardElement, congratulationOldCard);
        congratulationOldCard.setCongratulationText(getElementTextContent(oldCardElement, OldCardsFields.CONGRATULATION_TEXT.getValue()));
        return congratulationOldCard;
    }

    private OldCard createInformationOldCard(Element oldCardElement) {
        InformationOldCard informationOldCard = new InformationOldCard();
        createAbstractOldCard(oldCardElement, informationOldCard);
        informationOldCard.setSenderName(getElementTextContent(oldCardElement, OldCardsFields.SENDER_NAME.getValue()));
        informationOldCard.setSenderAddress(getElementTextContent(oldCardElement, OldCardsFields.SENDER_ADDRESS.getValue()));
        informationOldCard.setText(getElementTextContent(oldCardElement, OldCardsFields.INFORMATION_TEXT.getValue()));
        return informationOldCard;
    }

    private void createAbstractOldCard(Element oldCardElement, OldCard oldCard) {
        oldCard.setID(Integer.parseInt(getElementTextContent(oldCardElement, OldCardsFields.ID.getValue())));
        oldCard.setTheme(OldCardTheme.valueOf(getElementTextContent(oldCardElement, OldCardsFields.THEME.getValue())));
        oldCard.setType(OldCardType.valueOf((getElementTextContent(oldCardElement, OldCardsFields.TYPE.getValue())).toUpperCase()));
        oldCard.setCountry(getElementTextContent(oldCardElement, OldCardsFields.COUNTRY.getValue()));
        oldCard.setYear(Integer.parseInt(getElementTextContent(oldCardElement, OldCardsFields.YEAR.getValue())));
        oldCard.setAuthor(getElementTextContent(oldCardElement, OldCardsFields.AUTHOR.getValue()));
        oldCard.setValuable(OldCardValuable.valueOf(getElementTextContent(oldCardElement, OldCardsFields.VALUABLE.getValue())));
        oldCard.setWasSend(Boolean.parseBoolean(getElementTextContent(oldCardElement, OldCardsFields.WAS_SEND.getValue())));
        logger.info("Abstract OldCard is parsed");
    }


    private static String getElementTextContent(Element element, String elementName) {
        NodeList nodeList = element.getElementsByTagName(elementName);
        Node node = nodeList.item(0);
        String text = node.getTextContent();
        return text;
    }
}
