package com.epam.idea.task.eight.entity;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "old-cards", namespace = "http://www.example.com/oldcards")

public class OldCards {
    @XmlElements({
            @XmlElement(name = "information-old-card",type = InformationOldCard.class),
            @XmlElement(name = "congratulation-old-card",type = CongratulationOldCard.class)
    })
    private List<OldCard> oldCardList;

    public List<OldCard> getOldCardList() {
        return oldCardList;
    }

    public void setOldCardList(List<OldCard> oldCardList) {
        this.oldCardList = oldCardList;
    }

}
