package com.nagy;

import com.nagy.SalesTransaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class SalesTransactionTest {

    SalesTransaction sale;

    @BeforeEach
    void setUp() {
        sale = new SalesTransaction();
    }

    @Test
    void getTransactionID() {

        assertEquals(SalesTransaction.DEFAULT_transactionID, sale.getTransactionID());
    }


    @Test
    void getSalesPersonID() {

        assertEquals(SalesTransaction.DEFAULT_salesPersonID, sale.getSalesPersonID());
    }

    @Test
    void getTransactionDateTime() {

        assertEquals(SalesTransaction.DEFAULT_transactionDateTime, sale.getTransactionDateTime());
    }

    @Test
    void getItemID() {

        assertEquals(SalesTransaction.DEFAULT_itemID, sale.getItemID());
    }

    @Test
    void getUnitPrice() {

        assertEquals(SalesTransaction.DEFAULT_unitPrice, sale.getUnitPrice());
    }

    @Test
    void getQuantitySold() {

        assertEquals(SalesTransaction.DEFAULT_quanitySold, sale.getQuantitySold());
    }

    @Test
    void testToString(){
        String exepected =
                "SalesTransaction{" +
                "transactionID=" + SalesTransaction.DEFAULT_transactionID +
                ", salesPersonID=" + SalesTransaction.DEFAULT_salesPersonID +
                ", transactionDateTime=" + SalesTransaction.DEFAULT_transactionDateTime +
                ", itemID=" + SalesTransaction.DEFAULT_itemID +
                ", unitPrice=" + SalesTransaction.DEFAULT_unitPrice +
                ", quantitySold=" + SalesTransaction.DEFAULT_quanitySold +
                '}';

        assertEquals(exepected, sale.toString());

    }

    @Test
    void compareToDateSameAsOther(){
        SalesTransaction other = new SalesTransaction();

        // update localtime so that minute differences in time aren't caught
        // accurate to the seconds
        sale.setTransactionDateTime(LocalDateTime.now());
        other.setTransactionDateTime(LocalDateTime.now());



        boolean result = sale.getTransactionDateTime().isEqual(other.getTransactionDateTime());

        assertEquals(true, result);
    }

    @Test
    void setTransactionDateTimeTodayGood(){
        LocalDateTime newDay = SalesTransaction.MIN_TRANSACTIONDATE;
        sale.setTransactionDateTime(newDay);
        assertEquals(newDay, sale.getTransactionDateTime());

    }

    @Test
    void setTransactionDateTime30DaysAgoGood(){
        LocalDateTime newDay = SalesTransaction.MAX_TRANSACTIONDATE;
        sale.setTransactionDateTime(newDay);
        assertEquals(newDay, sale.getTransactionDateTime());

    }

}