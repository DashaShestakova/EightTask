package com.epam.idea.task.eight.entity;

import javax.xml.bind.annotation.*;

@XmlSeeAlso({OldCard.class})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "information-old-card")
public class InformationOldCard extends OldCard{
    @XmlElement(name ="sender-name")
    private String senderName;
    @XmlElement(name ="sender-address")
    private String senderAddress;
    @XmlElement(name ="text")
    private String text;

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
