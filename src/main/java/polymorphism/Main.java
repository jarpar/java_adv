package polymorphism;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        company.setCompanyName("Firma x");
        company.setRoomsQuantity(100);
        System.out.println(company.getCompanyName() + " posiada " + company.getRoomsQuantity() + " pomieszczeń.");
    }
}
