package lambda_stream_optional;

import oop.model.User;
import oop.model.enums.Role;

import java.util.*;
import java.util.stream.Collectors;

public class StreamApiWithModel {
    // metoda wypisująca zawartość listy users z inmemorydata
    public void getAllUsers() {
        InMemoryData.users.forEach(user -> System.out.println(user));
    }

    //metoda wypisująca użytkowników posortowanych po dacie rejestracji malejąco
    public void getDAllUsersOrderByRegistrationDateDesc() {
        InMemoryData.users.stream()
                .sorted(Comparator.comparing(User::getRegistrationDateTime).reversed())
                .forEach(user -> System.out.println(user));
    }

    //metoda do logowania -> loguje gdy email i password się zgadzają oraz status jest true i removed jest false
    public boolean loginUser(String email, String password) {
        return InMemoryData.users.stream()
                .anyMatch(user -> user.getEmail().equals(email) &&
                        user.getPassword().equals(password) &&
                        user.isStatus() && !user.isRemoved());
    }

    // metdoa zwracająca listę użytkowników zawierającą rolę podaną w argumencie metody
    public List getAllUsersWithRole(Role role) {
        return InMemoryData.users.stream()
                .filter(user -> user.getRoles().contains(role))
                .collect(Collectors.toList());
    }

    // metoda grupująca użytkwoników po roli
    public Map<Set<Role>, List<User>> groupUsersByRoleSet() {
        return InMemoryData.users.stream().collect(Collectors.groupingBy(user -> user.getRoles()));
    }

    // metoda grupująca użytkowników po rolach występujacych w zbiorach ról
    public Map<Role, List<User>> userRoleMapper() {
        Map<Role, List<User>> userRoleMap = new HashMap<>();
        for (Role role : Role.values()) {
            List<User> groupingUsers = new ArrayList<>();
            for (User user : InMemoryData.users) {
                if (user.getRoles().contains(role)) {
                    groupingUsers.add(user);
                    userRoleMap.put(role, groupingUsers);
                }
            }
        }
        return userRoleMap;
    }

    public static void main(String[] args) {
        StreamApiWithModel sapi = new StreamApiWithModel();
//        sapi.getAllUsers();
//        sapi.getDAllUsersOrderByRegistrationDateDesc();
//        System.out.println(sapi.loginUser("al@al.pl", "al"));
//        System.out.println(sapi.loginUser("jn@jn.pl", "jn"));
//        System.out.println(sapi.getAllUsersWithRole(Role.ROLE_ADMIN));
        //sapi.groupUsersByRoleSet().forEach(((roles, users) -> System.out.printf("%30s | %30s\n", roles, users)));
        System.out.println(sapi.userRoleMapper().get(Role.ROLE_VIEWER));
        System.out.println(sapi.userRoleMapper().get(Role.ROLE_ADMIN));
        System.out.println(sapi.userRoleMapper().get(Role.ROLE_USER));
    }
}