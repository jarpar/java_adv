package anonymousClass;

import javax.swing.text.DateFormatter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface EventController {
    //    1. Polla klasowe
    public static final String eventName = "Mój event";
    LocalDateTime eventDate = LocalDateTime.of(2020, 12, 31, 20, 00, 00);

    // 2. Metdoy abstrakcyje
    public abstract void printEvent();

    // 3. Metody statyczne
    public static void formattedEventDate() {
        System.out.printf("Data wydarzenia: %s w dniu %s", eventName,
                eventDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")));
    }


}
