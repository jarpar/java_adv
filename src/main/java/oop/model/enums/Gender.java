package oop.model.enums;

public enum Gender {
    MAN("Mężczyzna"), WOMAN("Kobieta");

    private final String genderName;

    Gender(String genderName) { //konstruktor typu wyliczeniowego
        this.genderName = genderName;
    }
}
