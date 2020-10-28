package com.epam.idea.task.eight.entity;

import javax.xml.bind.annotation.*;


@XmlSeeAlso({OldCard.class})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "congratulation-old-card")
public class CongratulationOldCard extends OldCard{
    @XmlElement(name ="congratulation-text")
    private String congratulationText;

    public String getCongratulationText() {
        return congratulationText;
    }

    public void setCongratulationText(String congratulationText) {
        this.congratulationText = congratulationText;
    }
}
