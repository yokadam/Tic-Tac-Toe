package com.game.component;

import java.util.Scanner;

/**
 * Abstract Player class
 *
 * @author yogesh.kadam
 */
public abstract class Player {

    private String name;
    private String sign;

    public abstract void makeMove(Scanner sc);

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
