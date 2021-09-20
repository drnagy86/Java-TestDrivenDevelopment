package com.nagy;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class SalesTransaction implements Comparable<SalesTransaction> {

    private int transactionID;
    private int salesPersonID;
    private LocalDateTime transactionDateTime;
    private int itemID;
    private BigDecimal unitPrice;
    private int quantitySold;

    // set up default, public and static for access, static so it can not be changed
    public static final int DEFAULT_transactionID = 1000;
    public static final int DEFAULT_salesPersonID = 1;
    public static final LocalDateTime DEFAULT_transactionDateTime = LocalDateTime.now();
    public static final int DEFAULT_itemID = 2;
    public static final BigDecimal DEFAULT_unitPrice = new BigDecimal("9.99");
    public static final int DEFAULT_quanitySold = 3;

    //   Boundary Cases

    public static final LocalDateTime MIN_TRANSACTIONDATE = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
    public static final LocalDateTime MAX_TRANSACTIONDATE = LocalDateTime.now().minusDays(30);


    // Constructors

    public SalesTransaction(){
        this(DEFAULT_transactionID, DEFAULT_salesPersonID, DEFAULT_transactionDateTime, DEFAULT_itemID, DEFAULT_unitPrice, DEFAULT_quanitySold);
    }

    public SalesTransaction(int transactionID, int salesPersonID, LocalDateTime transactionDateTime, int itemID, BigDecimal unitPrice, int quantitySold) {
        this.transactionID = transactionID;
        this.salesPersonID = salesPersonID;
        this.transactionDateTime = transactionDateTime;
        this.itemID = itemID;
        this.unitPrice = unitPrice;
        this.quantitySold = quantitySold;
    }

    // Begin Getters and Setters
    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = positiveIntInput(transactionID);
    }

    public int getSalesPersonID() {
        return salesPersonID;
    }

    public void setSalesPersonID(int salesPersonID) {

        this.salesPersonID = positiveIntInput(salesPersonID);
    }

    public LocalDateTime getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setTransactionDateTime(LocalDateTime transactionDateTime) {
        this.transactionDateTime = validateTransactionDateTime(transactionDateTime);
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = positiveIntInput(itemID);
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = validateBigDecimal(unitPrice);

    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = positiveIntInput(quantitySold);
    }


    @Override
    public String toString() {
        return "SalesTransaction{" +
                "transactionID=" + transactionID +
                ", salesPersonID=" + salesPersonID +
                ", transactionDateTime=" + transactionDateTime +
                ", itemID=" + itemID +
                ", unitPrice=" + unitPrice +
                ", quantitySold=" + quantitySold +
                '}';
    }

    //    start private methods
    private int positiveIntInput(int input) {
        if (input < 0){
            throw new IllegalArgumentException("This input must be a positive number");
        }
        return input;
    }

    private LocalDateTime validateTransactionDateTime(LocalDateTime transactionDateTime) {
        transactionDateTime = transactionDateTime.truncatedTo(ChronoUnit.SECONDS);

        if (transactionDateTime.isAfter(MIN_TRANSACTIONDATE) ||
            transactionDateTime.isBefore(MAX_TRANSACTIONDATE)){
            throw new IllegalArgumentException("The date cannot be in the future or more than 30 days in the past.");
        }

        return transactionDateTime;

    }

    private BigDecimal validateBigDecimal( BigDecimal unitPrice){
        if(unitPrice.signum() == -1){
            throw new IllegalArgumentException("Unit Price must be a positive number.");
        }
        if (unitPrice.scale() > 2){
            throw new IllegalArgumentException("Unit Price can not have more than two decimals.");
        }

        return  unitPrice;
    }

    @Override
    public int compareTo(SalesTransaction o) {
        int result = this.transactionDateTime.compareTo(o.transactionDateTime);

        return result;
    }
}
