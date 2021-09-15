package com.nagy;

import java.math.BigDecimal;

/**
 * Represents an item that can be sold.
 * 
 * @author Author Name
 */
public class SaleItem implements Comparable<SaleItem> {

    /**
     * A default value for itemName when one is not supplied.
     */
    private static final String DEFAULT_ITEM_NAME = "UNDEFINED";
    
    /**
     * A default value for description when one if not supplied.
     */
    private static final String DEFAULT_ITEM_DESCRIPTION = "UNDEFINED";
    
    /**
     * A default value for unitPrice when one if not supplied.
     */
    private static final BigDecimal DEFAULT_UNIT_PRICE = new BigDecimal("0.00");
    
    /**
     * The maximum length for an itemName.
     */
    public static final int MAX_ITEM_NAME_LENGTH = 256;
    
    /**
     * The maximum length for a description.
     */
    public static final int MAX_ITEM_DESCRIPTION_LENGTH = 1024;
    
    
    /**
     * The ID of the sale item. An integer not less than zero.
     */
    private int itemId;
    
    /**
     * The name of the  item.  A required String not longer than 256 characters.
     */
    private String itemName;
    
    /**
     * The human-readable description of the item.  A required String not longer
     * than 1024 characters.
     */
    private String description;

    /**
     * The current price for which the item should be sold.  A non-negative 
     * decimal number to two decimal places.
     */
    private BigDecimal unitPrice;

    /**
     * The full constructor requires a value for all the attributes.
     * 
     * @param itemId the ID of the item, not less than zero
     * @param itemName the name of the item, from 1 to 256 characters
     * @param description the description of the item from 1 to 1024 characters
     * @param unitPrice the unit price of the item, not less than zero
     */
    public SaleItem(int itemId, String itemName, String description
            , BigDecimal unitPrice) {
        validateItemId(itemId);
        validateItemName(itemName);
        validateItemDescription(description);
        validateUnitPrice(unitPrice);
        this.itemId = itemId;
        this.itemName = itemName;
        this.description = description;
        this.unitPrice = unitPrice;
    }

    /**
     * The default constructor uses default values.
     */
    public SaleItem() {
        itemName = DEFAULT_ITEM_NAME;
        description = DEFAULT_ITEM_DESCRIPTION;
        unitPrice = DEFAULT_UNIT_PRICE;
    }

    /**
     * An override of the toString() method.
     * 
     * @return ITEM: {itemName} ({unitPrice})
     */
    @Override
    public String toString() {
        return "ITEM: " + itemName + " (" + unitPrice.toPlainString() + ")";
    }
    
    /**
     * An implementation of compareTo() from the Comparable interface.  Used
     * to sort SaleItem objects be name in alphabetical order.
     * 
     * @param other the other SaleItem for comparing
     * @return less than zero, zero, or greater than zero
     */
    @Override
    public int compareTo(SaleItem other) {
        return this.itemName.compareTo(other.getItemName());
    }
        
    /**
     * The ID of the sale item. An integer not less than zero.
     * 
     * @param itemId the ID to set
     */
    public void setItemId(int itemId) {
        validateItemId(itemId);
        this.itemId = itemId;
    }

    /**
     * The ID of the sale item. An integer not less than zero.
     * 
     * @return the current item ID
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * The name of the  item.  A required String not longer than 256 characters.
     * 
     * @param itemName The name to set
     */
    public void setItemName(String itemName) {
        validateItemName(itemName);
        this.itemName = itemName;
    }

    /**
     * The name of the  item.  A required String not longer than 256 characters.
     * 
     * @return the current name
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * The human-readable description of the item.  A required String not longer
     * than 1024 characters.
     * 
     * @param description the new description
     */
    public void setItemDescription(String description) {
        validateItemDescription(description);
        this.description = description;
    }

    /**
     * The human-readable description of the item.  A required String not longer
     * than 1024 characters.
     * 
     * @return the current description
     */
    public String getItemDescription() {
        return description;
    }

    /**
     * The current price for which the item should be sold.  A non-negative 
     * decimal number to two decimal places.
     * 
     * @param unitPrice  the new unit price
     */
    public void setUnitPrice(BigDecimal unitPrice) {
        validateUnitPrice(unitPrice);
        this.unitPrice = unitPrice;
    }

    /**
     * The current price for which the item should be sold.  A non-negative 
     * decimal number to two decimal places.
     * 
     * @return the current unit price
     */
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }
    
    /**
     * A validator method for itemId.  An integer not less than zero.  Throws
     * an IllegalArgumentException if the supplied value is not valid.
     * 
     * @param itemId the value to test for validity 
     */
    private void validateItemId(int itemId){
        if(itemId < 0){
            throw new IllegalArgumentException(
                    "The item ID cannot be less than zero");
        }
    }
    
    /**
     * A validator for itemName.   A required String not longer than 256 
     * characters.
     * 
     * @param itemName the itemName to validate
     */
    private void validateItemName(String itemName){
        if(null == itemName){
            throw new IllegalArgumentException(
                    "The item name cannot be null.");
        } else if(itemName.isBlank()){
            throw new IllegalArgumentException(
                    "The item name cannot be blank.");
        } else if(itemName.length() > MAX_ITEM_NAME_LENGTH){
            throw new IllegalArgumentException(
                    "The item name cannot be more than " 
                            + MAX_ITEM_NAME_LENGTH 
                            + " characters in length.");
        }
    }
    
    /**
     * A validator for description.  A required String not longer than 1024 
     * characters.
     * 
     * @param itemDescription the itemDescription to validate
     */
    private void validateItemDescription(String itemDescription){
        if(null == itemDescription){
            throw new IllegalArgumentException(
                    "The item description cannot be null.");
        } else if(itemDescription.isBlank()){
            throw new IllegalArgumentException(
                    "The item description cannot be blank.");
        } else if(itemDescription.length() > MAX_ITEM_DESCRIPTION_LENGTH){
            throw new IllegalArgumentException(
                    "The item description cannot be more than " 
                            + MAX_ITEM_DESCRIPTION_LENGTH 
                            + " characters in length.");
        }
    }
    
    /**
     * A validator for unitPrice. A non-negative decimal number to two decimal 
     * places.
     * 
     * @param unitPrice the unitPrice to validate
     */
    private void validateUnitPrice(BigDecimal unitPrice){
        if(null == unitPrice){
            throw new IllegalArgumentException(
                    "The unit price cannot be null.");
        }
        if(0 < new BigDecimal("0.00").compareTo(unitPrice)){
            throw new IllegalArgumentException(
                    "The unit price cannot be negative.");
        }
    }
    
    
    
    
    
}
