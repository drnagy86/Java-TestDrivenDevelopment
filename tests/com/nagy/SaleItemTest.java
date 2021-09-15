/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nagy;

import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Bob Trapp
 */
public class SaleItemTest {

    /**
     * An arbitrary good value for itemId for testing constructors.
     */
    private static final int GOOD_ITEM_ID = 10;

    /**
     * An arbitrary good value for itemName for testing constructors.
     */
    private static final String GOOD_ITEM_NAME = "Item Name";

    /**
     * An arbitrary good value for description for testing constructors.
     */
    private static final String GOOD_ITEM_DESCRIPTION = "Item Description";

    /**
     * An arbitrary good value for unitPrice for testing constructors.
     */
    private static final BigDecimal GOOD_UNIT_PRICE = new BigDecimal("12.50");

    public SaleItemTest() {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    /*
    @BeforeEach
    public void setUp() {
    }
     */

    /**
     * Builds and returns a String of characters of the length specified.
     *
     * @param length The desired length of the String
     * @return the String
     */
    private String buildString(int length) {
        char[] chars = new char[length];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = 'X';
        }
        return new String(chars);
    }

    /**
     * Test of toString method, of class SaleItem. Expects a String in the form
     * of ITEM: {itemName} ({unitPrice})
     *
     */
    @org.junit.jupiter.api.Test
    public void testToString() {
        System.out.println("toString");
        String itemName = "Test";
        BigDecimal unitPrice = new BigDecimal("1.00");
        SaleItem instance = new SaleItem(GOOD_ITEM_ID, itemName,
                 GOOD_ITEM_DESCRIPTION, unitPrice);
        String expResult = "ITEM: " + itemName + " ("
                + unitPrice.toPlainString() + ")";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class SaleItem. instance before other
     */
    @org.junit.jupiter.api.Test
    public void testCompareToInstanceBeforeOther() {
        System.out.println("compareTo instance before other");
        SaleItem other = new SaleItem(GOOD_ITEM_ID, "alpha",
                 GOOD_ITEM_DESCRIPTION, GOOD_UNIT_PRICE);
        SaleItem instance = new SaleItem(GOOD_ITEM_ID, "beta",
                 GOOD_ITEM_DESCRIPTION, GOOD_UNIT_PRICE);
        int result = instance.compareTo(other);
        assertTrue(result > 0, "instance before other failed");
    }

    /**
     * Test of compareTo method, of class SaleItem. other before instance
     */
    @org.junit.jupiter.api.Test
    public void testCompareToOtherBeforeInstance() {
        System.out.println("compareTo other before instance");
        SaleItem other = new SaleItem(GOOD_ITEM_ID, "alpha",
                 GOOD_ITEM_DESCRIPTION, GOOD_UNIT_PRICE);
        SaleItem instance = new SaleItem(GOOD_ITEM_ID, "alpha",
                 GOOD_ITEM_DESCRIPTION, GOOD_UNIT_PRICE);
        int result = instance.compareTo(other);
        assertEquals(result, 0);
    }

    /**
     * Test of compareTo method, of class SaleItem. other wrong class This
     * doesn't work and the IDE prevents the test. This is acceptable.
     */
    /*
    @org.junit.jupiter.api.Test
    public void testCompareToOtherWrongClass() {
        System.out.println("compareTo other before instance");
        String other = "";
        SaleItem instance = new SaleItem(GOOD_ITEM_ID, "alpha"
                , GOOD_ITEM_DESCRIPTION, GOOD_UNIT_PRICE);
        try{
            int result = instance.compareTo(other);
        } catch(ClassCastException cce){
        }
    }
     */
    /**
     * Test of compareTo method, of class SaleItem. other before instance
     */
    @org.junit.jupiter.api.Test
    public void testCompareToInstanceEqualsOther() {
        System.out.println("compareTo instance equals other");
        SaleItem other = new SaleItem(GOOD_ITEM_ID, "alpha",
                 GOOD_ITEM_DESCRIPTION, GOOD_UNIT_PRICE);
        SaleItem instance = new SaleItem(GOOD_ITEM_ID, "alpha",
                 GOOD_ITEM_DESCRIPTION, GOOD_UNIT_PRICE);
        int result = instance.compareTo(other);
        assertTrue(result == 0, "other before instance failed");
    }

    /**
     * Test of setItemId method, of class SaleItem.
     */
    @org.junit.jupiter.api.Test
    public void testSetItemIdBad() {
        System.out.println("setItemId bad");
        int itemId = -1;
        SaleItem instance = new SaleItem();
        int original = instance.getItemId();
        try {
            instance.setItemId(itemId);
            fail("Allowed to set an invalid itemId.");
        } catch (IllegalArgumentException iae) {
            assertEquals(original, instance.getItemId());
        }
    }

    /**
     * Test of setItemId method, of class SaleItem.
     */
    @org.junit.jupiter.api.Test
    public void testSetItemIdGoodZero() {
        System.out.println("setItemId good zero");
        int itemId = 0;
        SaleItem instance = new SaleItem();
        instance.setItemId(itemId);
        assertEquals(itemId, instance.getItemId());
    }

    /**
     * Test of setItemId method, of class SaleItem.
     */
    @org.junit.jupiter.api.Test
    public void testSetItemIdGoodPostive() {
        System.out.println("setItemId good positive");
        int itemId = 100;
        SaleItem instance = new SaleItem();
        instance.setItemId(itemId);
        assertEquals(itemId, instance.getItemId());
    }

    /**
     * Test of getItemId method, of class SaleItem.
     */
    @org.junit.jupiter.api.Test
    public void testGetItemId() {
        System.out.println("getItemId");
        SaleItem instance = new SaleItem();
        int expResult = 0;
        int result = instance.getItemId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setItemName method, of class SaleItem.
     */
    @org.junit.jupiter.api.Test
    public void testSetItemNameNull() {
        System.out.println("setItemName null");
        String name = null;
        SaleItem instance = new SaleItem();
        String original = instance.getItemName();
        try {
            instance.setItemName(name);
            fail("Allowed to set null item name");
        } catch (IllegalArgumentException iae) {
            assertEquals(original, instance.getItemName());
        }
    }

    /**
     * Test of setItemName method, of class SaleItem.
     */
    @org.junit.jupiter.api.Test
    public void testSetItemNameBlank() {
        System.out.println("setItemName blank");
        String name = " ";
        SaleItem instance = new SaleItem();
        String original = instance.getItemName();
        try {
            instance.setItemName(name);
            fail("Allowed to set blank item name");
        } catch (IllegalArgumentException iae) {
            assertEquals(original, instance.getItemName());
        }
    }

    /**
     * Test of setItemName method, of class SaleItem.
     */
    @org.junit.jupiter.api.Test
    public void testSetItemNameGoodShort1() {
        System.out.println("setItemName short 1");
        String name = buildString(1);
        SaleItem instance = new SaleItem();
        instance.setItemName(name);
        assertEquals(name, instance.getItemName());
    }

    /**
     * Test of setItemName method, of class SaleItem.
     */
    @org.junit.jupiter.api.Test
    public void testSetItemNameGoodLong256() {
        System.out.println("setItemName long 256");
        String name = buildString(256);
        SaleItem instance = new SaleItem();
        instance.setItemName(name);
        assertEquals(name, instance.getItemName());
    }

    /**
     * Test of setItemName method, of class SaleItem.
     */
    @org.junit.jupiter.api.Test
    public void testSetItemNameBadLong257() {
        System.out.println("setItemName long 257");
        String name = buildString(257);
        SaleItem instance = new SaleItem();
        String original = instance.getItemName();
        try {
            instance.setItemName(name);
            fail("Allowed to set long item name");
        } catch (IllegalArgumentException iae) {
            assertEquals(original, instance.getItemName());
        }
    }

    /**
     * Test of getItemName method, of class SaleItem.
     */
    @org.junit.jupiter.api.Test
    public void testGetItemName() {
        System.out.println("getItemName");
        SaleItem instance = new SaleItem();
        String expResult = "UNDEFINED";
        String result = instance.getItemName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setItemDescription method, of class SaleItem.
     */
    @org.junit.jupiter.api.Test
    public void testSetItemDescriptionNull() {
        System.out.println("setItemDescription null");
        String description = null;
        SaleItem instance = new SaleItem();
        String original = instance.getItemDescription();
        try{
            instance.setItemDescription(description);
            fail("Allowed to set null description");
        } catch(IllegalArgumentException iae){
            assertEquals(original, instance.getItemDescription());
        }
    }

    /**
     * Test of setItemDescription method, of class SaleItem.
     */
    @org.junit.jupiter.api.Test
    public void testSetItemDescriptionBlank() {
        System.out.println("setItemDescription blank");
        String description = " ";
        SaleItem instance = new SaleItem();
        String original = instance.getItemDescription();
        try{
            instance.setItemDescription(description);
            fail("Allowed to set blank description");
        } catch(IllegalArgumentException iae){
            assertEquals(original, instance.getItemDescription());
        }
    }

    /**
     * Test of setItemDescription method, of class SaleItem.
     */
    @org.junit.jupiter.api.Test
    public void testSetItemDescriptionGoodShort1() {
        System.out.println("setItemDescription short 1");
        String description = buildString(1);
        SaleItem instance = new SaleItem();
        instance.setItemDescription(description);
        assertEquals(description, instance.getItemDescription());
    }

    /**
     * Test of setItemDescription method, of class SaleItem.
     */
    @org.junit.jupiter.api.Test
    public void testSetItemDescriptionGoodLong1024() {
        System.out.println("setItemDescription long 1024");
        String description = buildString(1024);
        SaleItem instance = new SaleItem();
        instance.setItemDescription(description);
        assertEquals(description, instance.getItemDescription());
    }

    /**
     * Test of setItemDescription method, of class SaleItem.
     */
    @org.junit.jupiter.api.Test
    public void testSetItemDescriptionBadLong1025() {
        System.out.println("setItemDescription  too long 1025");
        String description = buildString(1025);
        SaleItem instance = new SaleItem();
        String original = instance.getItemDescription();
        try{
            instance.setItemDescription(description);
            fail("Allowed to set too long description");
        } catch(IllegalArgumentException iae){
            assertEquals(original, instance.getItemDescription());
        }
    }

    /**
     * Test of getItemDescription method, of class SaleItem.
     */
    @org.junit.jupiter.api.Test
    public void testGetItemDescription() {
        System.out.println("getItemDescription");
        SaleItem instance = new SaleItem();
        String expResult = "UNDEFINED";
        String result = instance.getItemDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUnitPrice method, of class SaleItem.
     */
    @org.junit.jupiter.api.Test
    public void testSetUnitPriceBadNull() {
        System.out.println("setUnitPrice null");
        BigDecimal unitPrice = null;
        SaleItem instance = new SaleItem();
        try{
            instance.setUnitPrice(unitPrice);
            fail("Allowed to set null unit price");
        } catch(IllegalArgumentException iae){
            // nothing to do here
        }
    }

    /**
     * Test of setUnitPrice method, of class SaleItem.
     */
    @org.junit.jupiter.api.Test
    public void testSetUnitPriceBadNegativeOne() {
        System.out.println("setUnitPrice negative");
        BigDecimal unitPrice = new BigDecimal("-0.01");
        SaleItem instance = new SaleItem();
        try{
            instance.setUnitPrice(unitPrice);
            fail("Allowed to set negative unit price");
        } catch(IllegalArgumentException iae){
            // nothing to do here
        }
    }

    /**
     * Test of setUnitPrice method, of class SaleItem.
     */
    @org.junit.jupiter.api.Test
    public void testSetUnitPriceGoodZero() {
        System.out.println("setUnitPrice zero");
        BigDecimal unitPrice = new BigDecimal("0.00");
        SaleItem instance = new SaleItem();
        instance.setUnitPrice(unitPrice);
        assertEquals(unitPrice, instance.getUnitPrice());
    }

    /**
     * Test of setUnitPrice method, of class SaleItem.
     */
    @org.junit.jupiter.api.Test
    public void testSetUnitPriceGoodZeroPointOne() {
        System.out.println("setUnitPrice 0.01");
        BigDecimal unitPrice = new BigDecimal("0.01");
        SaleItem instance = new SaleItem();
        instance.setUnitPrice(unitPrice);
        assertEquals(unitPrice, instance.getUnitPrice());
    }

    /**
     * Test of setUnitPrice method, of class SaleItem.
     */
    @org.junit.jupiter.api.Test
    public void testSetUnitPriceGoodPositive() {
        System.out.println("setUnitPrice 147.25");
        BigDecimal unitPrice = new BigDecimal("147.25");
        SaleItem instance = new SaleItem();
        instance.setUnitPrice(unitPrice);
        assertEquals(unitPrice, instance.getUnitPrice());
    }

    /**
     * Test of getUnitPrice method, of class SaleItem.
     */
    @org.junit.jupiter.api.Test
    public void testGetUnitPrice() {
        System.out.println("getUnitPrice");
        SaleItem instance = new SaleItem();
        BigDecimal expResult = new BigDecimal("0.00");
        BigDecimal result = instance.getUnitPrice();
        assertEquals(expResult, result);
    }

    /**
     * Test of the full constructor with itemID = 0.
     */
    @org.junit.jupiter.api.Test
    public void testConstructorItemID0() {
        System.out.println("SaleItem() itemId 0");
        int setValue = 0;
        SaleItem instance = new SaleItem(setValue, GOOD_ITEM_NAME,
                 GOOD_ITEM_DESCRIPTION, GOOD_UNIT_PRICE);
        int result = instance.getItemId();
        assertEquals(setValue, result);
    }

    /**
     * Test of the full constructor with itemID = -1.
     */
    @org.junit.jupiter.api.Test
    public void testConstructorItemIDNegOne() {
        System.out.println("SaleItem() itemId -1");
        int setValue = -1;
        try {
            SaleItem instance = new SaleItem(setValue, GOOD_ITEM_NAME,
                     GOOD_ITEM_DESCRIPTION, GOOD_UNIT_PRICE);
            fail("Constructed with bad itemId -1");
        } catch (IllegalArgumentException iae) {
            // doing nothing here allows the test to pass
        }
    }

    /**
     * Test of the full constructor with itemID = 5000.
     */
    @org.junit.jupiter.api.Test
    public void testConstructorItemID500() {
        System.out.println("SaleItem() itemId 500  good");
        int setValue = 500;
        SaleItem instance = new SaleItem(setValue, GOOD_ITEM_NAME,
                 GOOD_ITEM_DESCRIPTION, GOOD_UNIT_PRICE);
        int result = instance.getItemId();
        assertEquals(setValue, result);
    }

    /**
     * Test of the full constructor with itemName = null.
     */
    @org.junit.jupiter.api.Test
    public void testConstructorItemNameNull() {
        System.out.println("SaleItem() itemName null");
        String itemName = null;
        try {
            SaleItem instance = new SaleItem(GOOD_ITEM_ID, itemName,
                     GOOD_ITEM_DESCRIPTION, GOOD_UNIT_PRICE);
            fail("Allowed to set null item name.");
        } catch (IllegalArgumentException iae) {
            // This will pass
        }
    }

    /**
     * Test of the full constructor with itemName = blank.
     */
    @org.junit.jupiter.api.Test
    public void testConstructorItemNameBlank() {
        System.out.println("SaleItem() itemName blank (spaces)");
        String itemName = " ";
        try {
            SaleItem instance = new SaleItem(GOOD_ITEM_ID, itemName,
                     GOOD_ITEM_DESCRIPTION, GOOD_UNIT_PRICE);
            fail("Allowed to set blank item name.");
        } catch (IllegalArgumentException iae) {
            // This will pass
        }
    }

    /**
     * Test of the full constructor with itemName = too long.
     */
    @org.junit.jupiter.api.Test
    public void testConstructorItemNameTooLong257() {
        System.out.println("SaleItem() itemName too long 257");
        String itemName = buildString(257);
        try {
            SaleItem instance = new SaleItem(GOOD_ITEM_ID, itemName,
                     GOOD_ITEM_DESCRIPTION, GOOD_UNIT_PRICE);
            fail("Allowed to set blank item name.");
        } catch (IllegalArgumentException iae) {
            // This will pass
        }
    }

    /**
     * Test of the full constructor with itemName = too long.
     */
    @org.junit.jupiter.api.Test
    public void testConstructorItemNameGoodLong() {
        System.out.println("SaleItem() itemName good long");
        String itemName = buildString(256);
        SaleItem instance = new SaleItem(GOOD_ITEM_ID, itemName,
                 GOOD_ITEM_DESCRIPTION, GOOD_UNIT_PRICE);
        assertEquals(itemName, instance.getItemName());
    }

    /**
     * Test of the full constructor with itemName = too long.
     */
    @org.junit.jupiter.api.Test
    public void testConstructorItemNameGoodShort() {
        System.out.println("SaleItem() itemName good short");
        String itemName = buildString(1);
        SaleItem instance = new SaleItem(GOOD_ITEM_ID, itemName,
                 GOOD_ITEM_DESCRIPTION, GOOD_UNIT_PRICE);
        assertEquals(itemName, instance.getItemName());
    }

    /**
     * Test of the full constructor with description = null.
     */
    @org.junit.jupiter.api.Test
    public void testConstructorDescriptionNull() {
        System.out.println("SaleItem() description null");
        String description = null;
        try {
            SaleItem instance = new SaleItem(GOOD_ITEM_ID, GOOD_ITEM_NAME,
                     description, GOOD_UNIT_PRICE);
            fail("Allowed to set null description.");
        } catch (IllegalArgumentException iae) {
            // This will pass
        }
    }

    /**
     * Test of the full constructor with description = blank.
     */
    @org.junit.jupiter.api.Test
    public void testConstructorDescriptionBlank() {
        System.out.println("SaleItem() description blank");
        String description = " ";
        try {
            SaleItem instance = new SaleItem(GOOD_ITEM_ID, GOOD_ITEM_NAME,
                     description, GOOD_UNIT_PRICE);
            fail("Allowed to set blank description.");
        } catch (IllegalArgumentException iae) {
            // This will pass
        }
    }

    /**
     * Test of the full constructor with description = long 1025.
     */
    @org.junit.jupiter.api.Test
    public void testConstructorDescriptionTooLong1025() {
        System.out.println("SaleItem() description too long 1025");
        String description = buildString(1025);
        try {
            SaleItem instance = new SaleItem(GOOD_ITEM_ID, GOOD_ITEM_NAME,
                     description, GOOD_UNIT_PRICE);
            fail("Allowed to set too long description.");
        } catch (IllegalArgumentException iae) {
            // This will pass
        }
    }

    /**
     * Test of the full constructor with description = long 1024.
     */
    @org.junit.jupiter.api.Test
    public void testConstructorDescriptionGoodLong1024() {
        System.out.println("SaleItem() description good long 1024");
        String description = buildString(1024);
        SaleItem instance = new SaleItem(GOOD_ITEM_ID, GOOD_ITEM_NAME,
                 description, GOOD_UNIT_PRICE);
        assertEquals(description, instance.getItemDescription());
    }

    /**
     * Test of the full constructor with description = short 1.
     */
    @org.junit.jupiter.api.Test
    public void testConstructorDescriptionGoodShort1() {
        System.out.println("SaleItem() description good short 1");
        String description = buildString(1);
        SaleItem instance = new SaleItem(GOOD_ITEM_ID, GOOD_ITEM_NAME,
                 description, GOOD_UNIT_PRICE);
        assertEquals(description, instance.getItemDescription());
    }

    /**
     * Test of the full constructor with unitPrice = long 1025.
     */
    @org.junit.jupiter.api.Test
    public void testConstructorUnitPriceTooLow() {
        System.out.println("SaleItem() unitPrice too low");
        BigDecimal unitPrice = new BigDecimal("-0.01");
        try {
            SaleItem instance = new SaleItem(GOOD_ITEM_ID, GOOD_ITEM_NAME,
                     GOOD_ITEM_DESCRIPTION, unitPrice);
            fail("Allowed to set too low unitPrice.");
        } catch (IllegalArgumentException iae) {
            // This will pass
        }
    }

    /**
     * Test of the full constructor with unitPrice = 0.00.
     */
    @org.junit.jupiter.api.Test
    public void testConstructorUnitPriceZero() {
        System.out.println("SaleItem() unitPrice zero");
        BigDecimal unitPrice = new BigDecimal("0.00");
        SaleItem instance = new SaleItem(GOOD_ITEM_ID, GOOD_ITEM_NAME,
                 GOOD_ITEM_DESCRIPTION, unitPrice);
        assertEquals(unitPrice, instance.getUnitPrice());
    }

    /**
     * Test of the full constructor with unitPrice = 100.00.
     */
    @org.junit.jupiter.api.Test
    public void testConstructorUnitPriceHundred() {
        System.out.println("SaleItem() unitPrice 100");
        BigDecimal unitPrice = new BigDecimal("100.00");
        SaleItem instance = new SaleItem(GOOD_ITEM_ID, GOOD_ITEM_NAME,
                 GOOD_ITEM_DESCRIPTION, unitPrice);
        assertEquals(unitPrice, instance.getUnitPrice());
    }

}
