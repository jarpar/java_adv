package polymorphism;

public class MainPolymorphism {
    public static void main(String[] args) {
        Company openSpace1 = new OpenSpace("X", 13, 11, "A", 110);
        System.out.println(openSpace1);
        Company openSpace2 = new OpenSpace("Y", 123, 21, "AB", 120);
        System.out.println(openSpace2);
    }
}
