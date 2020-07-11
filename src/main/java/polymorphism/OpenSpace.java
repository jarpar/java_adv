package polymorphism;

public class OpenSpace extends Company {
    private int openSpaceNo; // nr openspace-u
    private String openSpaceName; // nazwa openspac-u
    private int openSpaceCapacity; // liczba pracowników openspac-u

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
