package com.epam.idea.task.eight.entity;

import com.epam.idea.task.eight.entity.enums.OldCardTheme;
import com.epam.idea.task.eight.entity.enums.OldCardType;
import com.epam.idea.task.eight.entity.enums.OldCardValuable;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "old-card")
public abstract class OldCard {
    @XmlElement(name ="id")
    private int ID;
    @XmlElement(name ="theme")
    private OldCardTheme theme;
    @XmlElement(name ="type")
    private OldCardType type;
    @XmlElement(name ="country")
    private String country;
    @XmlElement(name ="year")
    private int year;
    @XmlElement(name ="author")
    private String author;
    @XmlElement(name ="valuable")
    private OldCardValuable valuable;
    @XmlElement(name ="was-send")
    private boolean wasSend;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public OldCardTheme getTheme() {
        return theme;
    }

    public void setTheme(OldCardTheme theme) {
        this.theme = theme;
    }

    public OldCardType getType() {
        return type;
    }

    public void setType(OldCardType type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public OldCardValuable getValuable() {
        return valuable;
    }

    public void setValuable(OldCardValuable valuable) {
        this.valuable = valuable;
    }

    public boolean getWasSend() {
        return wasSend;
    }

    public void setWasSend(boolean wasSend) {
        this.wasSend = wasSend;
    }
}
