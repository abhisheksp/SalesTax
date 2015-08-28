package com.thoughtworks.tax;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class TestProduct {

    @Test
    public void shouldApplyTaxGivenTaxPercent() {
        Product product = new Product(12.49, "Book", "Book", false);
        int taxPercent = 10;

        assertEquals(12.49 * taxPercent / 100, product.tax(taxPercent), 0.0001);
    }

    @Test
    public void shouldBeExemptedIfItIsBook() {
        Product product = new Product(12.49, "Book", "Book", false);
        Set<String> exemptedCategory = new HashSet<String>();
        exemptedCategory.add("Food");
        exemptedCategory.add("Medical");
        exemptedCategory.add("Book");

        assertTrue(product.isExempted(exemptedCategory));
    }

    @Test
    public void shouldNotBeExemptedIfItIsNotBookOrFoodOrMedical() {
        Product product = new Product(12.49, "Music CD", "CD", false);
        Set<String> exemptedCategory = new HashSet<String>();
        exemptedCategory.add("Food");
        exemptedCategory.add("Medical");
        exemptedCategory.add("Book");

        assertFalse(product.isExempted(exemptedCategory));
    }

    @Test
    public void shouldBeExemptedIfItIsFood() {
        Product product = new Product(12.49, "Chocolate", "Food", false);
        Set<String> exemptedCategory = new HashSet<String>();
        exemptedCategory.add("Food");
        exemptedCategory.add("Medical");
        exemptedCategory.add("Book");

        assertTrue(product.isExempted(exemptedCategory));
    }

    @Test
    public void shouldBeExemptedIfItIsMedical() {
        Product product = new Product(12.49, "Headache Pills", "Medical", false);
        Set<String> exemptedCategory = new HashSet<String>();
        exemptedCategory.add("Food");
        exemptedCategory.add("Medical");
        exemptedCategory.add("Book");

        assertTrue(product.isExempted(exemptedCategory));
    }
}
