package lombok;

// klasa modelu
@Data // lombok dodaje gettery, settery , toString, equals, hashCode, bez konstruktora
@AllArgsConstructor // dodaje konstruktory argumentowe
@NoArgsConstructor // dodaje konstruktory bezargumentowe

public class Task {
    private String taskName;
    private String taskDescription;
    private boolean done;
    private User user;

}
