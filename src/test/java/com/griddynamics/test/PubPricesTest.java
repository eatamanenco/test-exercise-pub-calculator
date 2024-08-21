package com.griddynamics.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Pub spec")
public class PubPricesTest {

    private Pub pub;

    @BeforeEach
    public void setUp() throws Exception {
        pub = new Pub();
    }

    @Test
    @DisplayName("When we order one beer, then the price is 74")
    public void oneBeerTest() {
        int actualPrice = pub.computeCost(Pub.ONE_BEER, 1);
        assertEquals(74, actualPrice);
    }

    @Test
    @DisplayName("When we order a proper cider, then the price is 110")
    public void testProperCidersAreEvenMoreExpensive() throws Exception {
        int actualPrice = pub.computeCost(Pub.A_PROPER_CIDER, 1);
        assertEquals(110, actualPrice);
    }

    @Test
    @DisplayName("When we order a gin and tonic, then the price is 115")
    public void testACocktail() throws Exception {
        int actualPrice = pub.computeCost(Pub.GT, 1);
        assertEquals(115, actualPrice);
    }

    @Test
    @DisplayName("When we order a bacardi special, then the price is 95")
    public void testBacardiSpecial() throws Exception {
        int actualPrice = pub.computeCost(Pub.BACARDI_SPECIAL, 1);
        assertEquals(95, actualPrice);
    }

    @Test
    @DisplayName("When they order a drink which is not on the menu, then they are refused.")
    public void testThatADrinkNotInTheSortimentGivesError() throws Exception {
        assertThrows(RuntimeException.class, () -> pub.computeCost("sanfranciscosling", 1));
    }
}
