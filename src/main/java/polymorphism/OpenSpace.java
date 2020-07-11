package polymorphism;

public class OpenSpace extends Company {
    private int openSpaceNo; // nr openspace-u
    private String openSpaceName; // nazwa openspac-u
    private int openSpaceCapacity; // liczba pracowników openspac-u

    @Override
    public String toString() {
        return "OpenSpace{" +
                "openSpaceNo=" + openSpaceNo +
                ", openSpaceName='" + openSpaceName + '\'' +
                ", openSpaceCapacity=" + openSpaceCapacity +
                "} " + super.toString();
    }

    public OpenSpace(String companyName, int roomsQuantity, int openSpaceNo, String openSpaceName, int openSpaceCapacity) {
        super(companyName, roomsQuantity);
        this.openSpaceNo = openSpaceNo;
        this.openSpaceName = openSpaceName;
        this.openSpaceCapacity = openSpaceCapacity;
        System.out.println("Jestem z konstruktora klasy OpenSpace");
    }

    public int getOpenSpaceNo() {
        return openSpaceNo;
    }

    public void setOpenSpaceNo(int openSpaceNo) {
        this.openSpaceNo = openSpaceNo;
    }

    public String getOpenSpaceName() {
        return openSpaceName;
    }

    public void setOpenSpaceName(String openSpaceName) {
        this.openSpaceName = openSpaceName;
    }

    public int getOpenSpaceCapacity() {
        return openSpaceCapacity;
    }

    public void setOpenSpaceCapacity(int openSpaceCapacity) {
        this.openSpaceCapacity = openSpaceCapacity;
    }
}
