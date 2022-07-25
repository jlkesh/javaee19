package uz.jl.javaservlet;

import java.util.Objects;

public class Utils {
    public static boolean isDigit(String data) {
        if (Objects.isNull(data) || data.length() == 0)
            return false;

        for (char c : data.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
