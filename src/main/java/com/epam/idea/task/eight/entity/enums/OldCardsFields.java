package com.epam.idea.task.eight.entity.enums;

public enum OldCardsFields {
    ID ("id"),
    THEME ("theme"),
    TYPE("type"),
    COUNTRY("country"),
    YEAR("year"),
    AUTHOR("author"),
    VALUABLE("valuable"),
    WAS_SEND("was-send"),
    SENDER_NAME("sender-name"),
    SENDER_ADDRESS("sender-address"),
    INFORMATION_TEXT("information-text"),
    CONGRATULATION_TEXT("congratulation-text"),
    INFORMATION_CARD("information-old-card"),
    CONGRATULATION_CARD("congratulation-old-card");

    private String value;

    OldCardsFields(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
