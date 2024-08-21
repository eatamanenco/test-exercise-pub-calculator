package com.griddynamics.test;

public class Pub {
    public static final String ONE_BEER = "hansa";
    public static final String A_PROPER_CIDER = "strongbow";
    public static final String GT = "gt";
    public static final String BACARDI_SPECIAL = "bacardi_special";

    public int computeCost(String drink, int amount) {
        if (amount > 2 && (drink == GT)) {
            throw new RuntimeException("Too many drinks, max 2.");
        }
        int price;
        if (drink.equals(ONE_BEER)) {
            price = 74;
        }
        else if (drink.equals(A_PROPER_CIDER)) price = 110;
        else if (drink.equals(GT)) {
            price = ingredient3() + ingredient2() + ingredient1();
        }
        else if (drink.equals(BACARDI_SPECIAL)) {
            price = ingredient2()/2 + ingredient3();
        }
        else {
            throw new RuntimeException("No such drink exists");
        }
        return price*amount;
    }
    
    //one unit of green stuff
    private int ingredient1() {
        return 10;
    }

    //one unit of tonic water
    private int ingredient2() {
        return 20;
    }

    //one unit of gin
    private int ingredient3() {
        return 85;
    }
}
