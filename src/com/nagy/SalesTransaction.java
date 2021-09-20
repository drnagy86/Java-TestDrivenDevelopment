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
    public static final int DEFAULT_quantitySold = 3;

    //   Boundary Cases
    // Truncated the time to seconds so that it would test in a more realistic way.
    // Time only accurate to seconds
    public static final LocalDateTime MIN_TRANSACTIONDATE = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
    public static final LocalDateTime MAX_TRANSACTIONDATE = LocalDateTime.now().minusDays(30).truncatedTo(ChronoUnit.SECONDS);

    // Messages
    public static final String MSG_NEGATIVE_NUMBER = "This number must be positive.";
    public static final String MSG_ZERO = "This number can not be zero(0).";
    public static final String MSG_31_DAYS_AGO = "The date can not be more than 31 days ago.";
    public static final String MSG_FUTURE_DATE = "The date can not be in the future.";
    public static final String MSG_NEGATIVE_DOLLARS = "The price can not be less than $0.00";
    public static final String MSG_TOO_MANY_DIGITS = "Too many digits on the price.";


    // Constructors
    public SalesTransaction(){
        this(DEFAULT_transactionID, DEFAULT_salesPersonID, DEFAULT_transactionDateTime, DEFAULT_itemID, DEFAULT_unitPrice, DEFAULT_quantitySold);
    }

    public SalesTransaction(int transactionID, int salesPersonID, LocalDateTime transactionDateTime, int itemID, BigDecimal unitPrice, int quantitySold) {

        validatePositiveIntInput(transactionID, salesPersonID, itemID, quantitySold);
        noZeroIntInput(salesPersonID,itemID,quantitySold);
        validateTransactionDateTime(transactionDateTime);
        validateBigDecimal(unitPrice);

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
        validatePositiveIntInput(transactionID);
        this.transactionID = transactionID;
    }

    public int getSalesPersonID() {
        return salesPersonID;
    }

    public void setSalesPersonID(int salesPersonID) {
        noZeroIntInput(salesPersonID);
        validatePositiveIntInput(salesPersonID);
        this.salesPersonID = salesPersonID;
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
        noZeroIntInput(itemID);
        validatePositiveIntInput(itemID);
        this.itemID = itemID;
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
        noZeroIntInput(quantitySold);
        validatePositiveIntInput(quantitySold);
        this.quantitySold = quantitySold;
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
    private void validatePositiveIntInput(int ... inputList) {
        for (int input:inputList) {
            if (input < 0){
                throw new IllegalArgumentException(MSG_NEGATIVE_NUMBER);
            }
        }
    }

    private void noZeroIntInput(int ... inputList){
        for(int input:inputList){
            if (input == 0){
                throw new IllegalArgumentException(MSG_ZERO);
            }
        }
    }

    private LocalDateTime validateTransactionDateTime(LocalDateTime transactionDateTime) {
        transactionDateTime = transactionDateTime.truncatedTo(ChronoUnit.SECONDS);

        if (transactionDateTime.isBefore(MAX_TRANSACTIONDATE)){
            throw  new IllegalArgumentException(MSG_31_DAYS_AGO);
        }
        if (transactionDateTime.isAfter(MIN_TRANSACTIONDATE)){
            throw new IllegalArgumentException(MSG_FUTURE_DATE);
        }

        return transactionDateTime;

    }

    private BigDecimal validateBigDecimal( BigDecimal unitPrice){
        if(unitPrice.signum() == -1){
            throw new IllegalArgumentException(MSG_NEGATIVE_DOLLARS);
        }
        if (unitPrice.scale() > 2){
            throw new IllegalArgumentException(MSG_TOO_MANY_DIGITS);
        }

        return  unitPrice;
    }

    @Override
    public int compareTo(SalesTransaction o) {
        int result = this.transactionDateTime.compareTo(o.transactionDateTime);
        return result;
    }
}
