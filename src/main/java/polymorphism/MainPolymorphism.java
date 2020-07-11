package polymorphism;

public class MainPolymorphism {
    public static void HasMooreRooms(Company c1, Company c2) {
        if (c1.getRoomsQuantity() > c2.getRoomsQuantity()) {
            System.out.println("Firma " + c1.getCompanyName() + " posiada więcej pokoi");
        } else if (c1.getRoomsQuantity() == c2.getRoomsQuantity()) {
            System.out.println("Firmy posiadają tyle samo pokoi");
        } else {
            System.out.println("Firma " + c2.getCompanyName() + " posiada wiecej pokoi");
        }
    }

    public static void main(String[] args) {
        Company openSpace1 = new OpenSpace("X", 913, 11, "A", 110);
        System.out.println(openSpace1);
        Company openSpace2 = new OpenSpace("Y", 123, 21, "AB", 120);
        System.out.println(openSpace2);
        System.out.println("===========================================================");
        HasMooreRooms(openSpace1, openSpace2);
    }
}
