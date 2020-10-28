package com.epam.idea.task.eight.parser;

import com.epam.idea.task.eight.entity.CongratulationOldCard;
import com.epam.idea.task.eight.entity.InformationOldCard;
import com.epam.idea.task.eight.entity.OldCard;
import com.epam.idea.task.eight.entity.enums.OldCardTheme;
import com.epam.idea.task.eight.entity.enums.OldCardType;
import com.epam.idea.task.eight.entity.enums.OldCardValuable;
import com.epam.idea.task.eight.exception.ParserException;
import org.junit.BeforeClass;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTest {
    protected List<OldCard> expectedList;
    protected final static String FILEPATH = "src/test/resources/oldCard.xml";

    @BeforeClass
    public void setUp() {

        expectedList = new ArrayList<>();

        CongratulationOldCard congratulationOldCard_first = new CongratulationOldCard();
        congratulationOldCard_first.setID(1);
        congratulationOldCard_first.setTheme(OldCardTheme.ANIMAL);
        congratulationOldCard_first.setType(OldCardType.HOLIDAY);
        congratulationOldCard_first.setCountry("France");
        congratulationOldCard_first.setYear(2010);
        congratulationOldCard_first.setAuthor("Antonov V.");
        congratulationOldCard_first.setValuable(OldCardValuable.COLLECTION);
        congratulationOldCard_first.setWasSend(false);
        congratulationOldCard_first.setCongratulationText("Happy Bithday");

        CongratulationOldCard congratulationOldCard_second = new CongratulationOldCard();
        congratulationOldCard_second.setID(2);
        congratulationOldCard_second.setTheme(OldCardTheme.CAR);
        congratulationOldCard_second.setType(OldCardType.HOLIDAY);
        congratulationOldCard_second.setCountry("Spain");
        congratulationOldCard_second.setYear(2012);
        congratulationOldCard_second.setAuthor("Gavrilov D.");
        congratulationOldCard_second.setValuable(OldCardValuable.COLLECTION);
        congratulationOldCard_second.setWasSend(false);
        congratulationOldCard_second.setCongratulationText("Happy New Year");

        InformationOldCard informationOldCard_first = new InformationOldCard();
        informationOldCard_first.setID(3);
        informationOldCard_first.setTheme(OldCardTheme.NATURE);
        informationOldCard_first.setType(OldCardType.ADVENTURE);
        informationOldCard_first.setCountry("Belarus");
        informationOldCard_first.setYear(2001);
        informationOldCard_first.setAuthor("Abramova A.");
        informationOldCard_first.setValuable(OldCardValuable.HISTORICAL);
        informationOldCard_first.setWasSend(true);
        informationOldCard_first.setSenderName("Ivanov P.");
        informationOldCard_first.setSenderAddress("BY,Minsk, Lenina str., 1");
        informationOldCard_first.setText("Good Morning");

        InformationOldCard informationOldCard_second = new InformationOldCard();
        informationOldCard_second.setID(4);
        informationOldCard_second.setTheme(OldCardTheme.SPORTS);
        informationOldCard_second.setType(OldCardType.SIMPLE);
        informationOldCard_second.setCountry("Russia");
        informationOldCard_second.setYear(2005);
        informationOldCard_second.setAuthor("Alekseeva K.");
        informationOldCard_second.setValuable(OldCardValuable.COLLECTION);
        informationOldCard_second.setWasSend(true);
        informationOldCard_second.setSenderName("Petrov P.");
        informationOldCard_second.setSenderAddress("BY,Moscow, Marksa str., 5");
        informationOldCard_second.setText("Good Evening");

        expectedList.add(congratulationOldCard_first);
        expectedList.add(congratulationOldCard_second);
        expectedList.add(informationOldCard_first);
        expectedList.add(informationOldCard_second);
    }

    public abstract void testParser() throws ParserException;
}
