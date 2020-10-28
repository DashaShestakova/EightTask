package com.epam.idea.task.eight.parser.impl.saxparser;

import com.epam.idea.task.eight.entity.*;
import com.epam.idea.task.eight.entity.enums.OldCardTheme;
import com.epam.idea.task.eight.entity.enums.OldCardType;
import com.epam.idea.task.eight.entity.enums.OldCardValuable;
import com.epam.idea.task.eight.entity.enums.OldCardsFields;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class OldCardHandler extends DefaultHandler {
    private static Logger logger = LogManager.getLogger();
    private List<OldCard> oldCardList;
    private OldCard oldCard;
    private OldCardsFields oldCardsFields;

    public OldCardHandler() {
        this.oldCardList = new ArrayList<OldCard>();
    }

    public List<OldCard> getOldCards() {
        return this.oldCardList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        switch (localName) {
            case "congratulation-old-card":
                oldCard = new CongratulationOldCard();
                logger.info("Start creating of CongratulationOldCard");
                break;
            case "information-old-card":
                oldCard = new InformationOldCard();
                logger.info("Start creating of InformationOldCard");
                break;
            default:
                localName = localName.replace('-', '_');
                this.oldCardsFields = OldCardsFields.valueOf(localName.toUpperCase());
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String element = new String(ch, start, length).trim();
        if (oldCardsFields != null && !element.isEmpty()) {
            switch (oldCardsFields) {
                case ID:
                    oldCard.setID(Integer.parseInt(element));
                    break;
                case THEME:
                    oldCard.setTheme(OldCardTheme.valueOf(element.toUpperCase()));
                    break;
                case TYPE:
                    oldCard.setType(OldCardType.valueOf(element.toUpperCase()));
                    break;
                case COUNTRY:
                    oldCard.setCountry(element);
                    break;
                case YEAR:
                    oldCard.setYear(Integer.parseInt(element));
                    break;
                case VALUABLE:
                    oldCard.setValuable(OldCardValuable.valueOf(element.toUpperCase()));
                    break;
                case WAS_SEND:
                    oldCard.setWasSend(Boolean.parseBoolean(element));
                    break;
                default:
                    logger.error(oldCardsFields.getDeclaringClass() + " " + oldCardsFields.name());
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (OldCardsFields.CONGRATULATION_CARD.getValue().equals(localName) || OldCardsFields.INFORMATION_CARD.getValue().equals(localName)) {
            oldCardList.add(oldCard);
            logger.info("OldCard was created");
        }
    }
}
