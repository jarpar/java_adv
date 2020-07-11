package polymorphism;

public class Main {
    public static void main(String[] args) {
//        Company company = new Company();
//        company.setCompanyName("XCompany");
//        company.setRoomsQuantity(100);
//        System.out.println("Firma " + company.getCompanyName() + " posiada " + company.getRoomsQuantity() + " pomieszczeń.");
//        OpenSpace os1 = new OpenSpace(); // dostęp do wszystkich składowych klasy Openspace i Company
//        os1.setCompanyName("YCompany");
//        os1.setRoomsQuantity(10);
//        os1.setOpenSpaceName("Londyn");
//        os1.setOpenSpaceNo(1);
//        os1.setOpenSpaceCapacity(50);
//        System.out.printf("Firma %s (ilość pomieszczeń: %d) Open space: %d %s (pojemność: %d)",
//                os1.getCompanyName(), os1.getRoomsQuantity(), os1.getOpenSpaceNo(), os1.getOpenSpaceName(), os1.getOpenSpaceCapacity());

        Company company = new Company("ABC", 10);
        OpenSpace os1 = new OpenSpace("company1", 10, 1, "Londyn", 100);
//        System.out.println(company);

        System.out.println(os1);
        OpenSpace os2 = new OpenSpace("company2", 20, 2, "Berlin", 200);
        System.out.println(os2);
    }
}
