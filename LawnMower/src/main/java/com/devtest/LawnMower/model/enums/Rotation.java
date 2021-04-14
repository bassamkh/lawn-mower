package com.devtest.LawnMower.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Bassam El Khoury
 */
@Getter
@AllArgsConstructor
public enum Rotation {
    GAUCHE("G"), DROITE("D");

    private final String type;

    public static Rotation fromValue(String type) {
        if(GAUCHE.getType().equalsIgnoreCase(type)){
            return GAUCHE;
        } else {
            return DROITE;
        }
    }
}
