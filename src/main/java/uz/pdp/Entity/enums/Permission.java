package uz.pdp.Entity.enums;

import java.util.Arrays;
import java.util.List;

public enum Permission {
    //group
    GROUP_READ("ADMIN"),
    GROUP_CREATE("ADMIN"),
    GROUP_DELETE("ADMIN"),
    GROUP_UPDATE("ADMIN"),

    //module
    MODULE_READ("ADMIN"),
    MODULE_CREATE("ADMIN"),
    MODULE_DELETE("ADMIN"),
    MODULE_UPDATE("ADMIN"),

    // course
    COURSE_READ("ADMIN"),
    COURSE_CREATE("ADMIN"),
    COURSE_DELETE("ADMIN"),
    COURSE_UPDATE("ADMIN"),

    //lesson

    LESSON_READ("ADMIN"),
    LESSON_CREATE("ADMIN"),
    LESSON_DELETE("ADMIN"),
    LESSON_UPDATE("ADMIN"),


    // user
    USER_CREATE("ADMIN"),
    USER_READ("ADMIN"),
    USER_UPDATE("ADMIN"),
    USER_DELETE("ADMIN"),
    //attendance

    ATTENDANCE_READ("MENTOR"),
    ATTENDANCE_CREATE("MENTOR"),
    ATTENDANCE_DELETE("MENTOR"),
    ATTENDANCE_UPDATE("MENTOR");

    private String role;

    Permission(String role) {
        this.role = role;
    }

    public List<Permission> getByRole(String role) {
        return Arrays.stream(Permission.values())
                .filter(permission -> permission.role.equals(role))
                .toList();
    }
}
