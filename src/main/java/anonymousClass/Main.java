package anonymousClass;

public class Main {
    public static void main(String[] args) {
        Object object = new EventController() {
            @Override
            public void printEvent() {
                System.out.println("Nowe wydarzenie");
                EventController.formattedEventDate();

            }
        };
        ((EventController) object).printEvent();
    }
}
