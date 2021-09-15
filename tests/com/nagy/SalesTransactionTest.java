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
        other.setTransactionDateTime(LocalDateTime.now());

        int result = sale.compareTo(other);
        assertTrue(result == 0);

    }

}