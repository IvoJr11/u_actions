package com.myself.u_actions.Utils;

public final class Utils {

    public static <E extends Enum<E>> boolean enumContains(Class<E> enumToCompare, String valueToCompare) {
        for (E enumValue : enumToCompare.getEnumConstants()) {
            if (enumValue.name().equalsIgnoreCase(valueToCompare)) {
                return true;
            }
        }
        return false;
    }
}
