package oop.model.enums;

public enum Gender {
    MAN("Mężczyzna"), WOMAN("Kobieta");

    public String getGenderName() {
        return genderName;
    }

    private final String genderName;

    Gender(String genderName) { //konstruktor typu wyliczeniowego
        this.genderName = genderName;
    }
}
