package lombok;

import java.time.LocalDateTime;

/* JavaBeans
 1. Pola statyczne
 2. gettery
 3.settery
 4. konstruktory
 5.toString
 */

public class User {
    private int userId;
    private String email;
    private String password;
    private LocalDateTime registrationDateTime;
    private boolean status;

}
