package polymorphism;

public class Company {
    private String companyName;
    private int roomsQuantity; // ilość pomieszczeń/pokoi

    public Company(String companyName, int roomsQuantity) {
        this.companyName = companyName;
        this.roomsQuantity = roomsQuantity;
        System.out.println("Jestem z konstruktora klasy Company");
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getRoomsQuantity() {
        return roomsQuantity;
    }

    public void setRoomsQuantity(int roomsQuantity) {
        this.roomsQuantity = roomsQuantity;
    }
}
