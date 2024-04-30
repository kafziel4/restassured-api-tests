package Data;

import Models.Users.UserData;
import Models.Users.UserList;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private static final UserList USER_LIST;

    static {
        List<UserData> users = new ArrayList<>();
        users.add(
                new UserData(
                        7,
                        "michael.lawson@reqres.in",
                        "Michael",
                        "Lawson",
                        "https://reqres.in/img/faces/7-image.jpg"
                )
        );
        users.add(
                new UserData(
                        8,
                        "lindsay.ferguson@reqres.in",
                        "Lindsay",
                        "Ferguson",
                        "https://reqres.in/img/faces/8-image.jpg"
                )
        );
        users.add(
                new UserData(
                        9,
                        "tobias.funke@reqres.in",
                        "Tobias",
                        "Funke",
                        "https://reqres.in/img/faces/9-image.jpg"
                )
        );
        users.add(
                new UserData(
                        10,
                        "byron.fields@reqres.in",
                        "Byron",
                        "Fields",
                        "https://reqres.in/img/faces/10-image.jpg"
                )
        );
        users.add(
                new UserData(
                        11,
                        "george.edwards@reqres.in",
                        "George",
                        "Edwards",
                        "https://reqres.in/img/faces/11-image.jpg"
                )
        );
        users.add(
                new UserData(
                        12,
                        "rachel.howell@reqres.in",
                        "Rachel",
                        "Howell",
                        "https://reqres.in/img/faces/12-image.jpg"
                )
        );

        USER_LIST = new UserList(2, 6, 12, 2, users);
    }

    public static UserList getUserList() {
        return USER_LIST;
    }
}
