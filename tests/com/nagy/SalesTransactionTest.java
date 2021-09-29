package com.nagy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.math.BigDecimal;
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

        assertEquals(SalesTransaction.DEFAULT_quantitySold, sale.getQuantitySold());
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
                ", quantitySold=" + SalesTransaction.DEFAULT_quantitySold +
                '}';

        assertEquals(exepected, sale.toString());

    }
    @Test
    void compareToDateBeforeOther(){
        // setting today first because the min date is updated when a new object is created.
        // So, the default time setting shouldn't case an error
        LocalDateTime today = LocalDateTime.now();
        SalesTransaction other = new SalesTransaction();

        sale.setTransactionDateTime(today.minusDays(10));
        other.setTransactionDateTime(today);
        boolean result = sale.getTransactionDateTime().isBefore(other.getTransactionDateTime());

        assertEquals(true, result);
    }

    @Test
    void compareToDateSameAsOther(){
        LocalDateTime today = LocalDateTime.now();
        SalesTransaction other = new SalesTransaction();

        sale.setTransactionDateTime(today);
        other.setTransactionDateTime(today);
        boolean result = sale.getTransactionDateTime().isEqual(other.getTransactionDateTime());

        assertEquals(true, result);
    }

    @Test
    void compareToDateAfterOther(){

        LocalDateTime today = LocalDateTime.now();
        SalesTransaction other = new SalesTransaction();

        sale.setTransactionDateTime(today);
        other.setTransactionDateTime(today.minusDays(10));
        boolean result = sale.getTransactionDateTime().isAfter(other.getTransactionDateTime());

        assertEquals(true, result);
    }

    @Test
    void setTransactionIdZeroGood() {
        sale.setTransactionID(0);
        assertEquals(0,sale.getTransactionID());

    }

    @Test
    void setTransactionIdPositiveGood() {
        sale.setTransactionID(666);
        assertEquals(666, sale.getTransactionID());
    }

    @Test
    void setTransactionIdNegativeBad() {

        int newTransactionID = -1;
//        Exception exception = assertThrows(IllegalArgumentException.class, new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                sale.setTransactionID(newTransactionID);
//            }
//        });
//
        Exception exception1 = assertThrows(IllegalArgumentException.class, () -> sale.setTransactionID(newTransactionID));

        String expected = SalesTransaction.MSG_NEGATIVE_NUMBER;
        String actual = exception1.getMessage();
        assertEquals(expected,actual);
    }

    @Test
    void setSalesPersonIdPositiveGood() {
        sale.setSalesPersonID(666);
        assertEquals(666,sale.getSalesPersonID());
    }

    @Test
    void setSalesPersonIdZeroBad() {
        int newSalesPersonId = 0;
//        Exception exception = assertThrows(IllegalArgumentException.class, new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                sale.setSalesPersonID(newSalesPersonId);
//            }
//        });

        Exception exception1 = assertThrows(IllegalArgumentException.class, () -> sale.setSalesPersonID(newSalesPersonId));

        String expected =SalesTransaction.MSG_ZERO;
        String actual = exception1.getMessage();
        assertEquals(expected, actual);
    }

    @Test
    void setSalesPersonIdNegativeBad() {
        int newSalesPersonID = -1;
        Exception exception = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                sale.setSalesPersonID(newSalesPersonID);
            }
        });
        assertEquals(SalesTransaction.MSG_NEGATIVE_NUMBER, exception.getMessage());
    }

    @Test
    void setTransactionDateTimeTodayGood(){
        LocalDateTime newDay = SalesTransaction.getMin_Transaction_Date_Realtime();
        sale.setTransactionDateTime(newDay);
        assertEquals(newDay, sale.getTransactionDateTime());
    }

    @Test
    void setTransactionDateTime30DaysAgoGood(){
        LocalDateTime newDay = SalesTransaction.MAX_TRANSACTION_DATE;
        sale.setTransactionDateTime(newDay);
        assertEquals(newDay, sale.getTransactionDateTime());
    }

    @Test
    void setTransactionDateTime31DaysAgoBad() {
        LocalDateTime newDateTime = LocalDateTime.now().minusDays(31);
        Exception exception = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                sale.setTransactionDateTime(newDateTime);
            }
        });
        String expected = SalesTransaction.MSG_31_DAYS_AGO;
        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }

    @Test
    void setTransactionDateTimeTomorrowBad() {
        LocalDateTime newDateTime = LocalDateTime.now().plusDays(1);
//        Exception exception = assertThrows(IllegalArgumentException.class, new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                sale.setTransactionDateTime(newDateTime);
//            }
//        });

//        Executable result = () -> sale.setTransactionDateTime(newDateTime);
//        Exception exception1 = assertThrows(IllegalArgumentException.class, result.execute();)

        Exception exception1 = assertThrows(IllegalArgumentException.class, () -> sale.setTransactionDateTime(newDateTime));

        assertEquals(SalesTransaction.MSG_FUTURE_DATE, exception1.getMessage());
    }

    @Test
    void setItemIdPositiveGood() {
        sale.setItemID(1);
        assertEquals(1, sale.getItemID());
    }

    @Test
    void setItemIdZeroBad() {
        int newItemID = 0;
        Exception exception = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                sale.setSalesPersonID(newItemID);
            }
        });
        String expected =SalesTransaction.MSG_ZERO;
        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }

    @Test
    void setItemIdNegativeBad() {
        int newItemID = -1;
        Exception exception = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                sale.setSalesPersonID(newItemID);
            }
        });
        assertEquals(SalesTransaction.MSG_NEGATIVE_NUMBER, exception.getMessage());
    }

    @Test
    void setUnitPricePositiveGood() {
        BigDecimal newUnitPrice = new BigDecimal("22.22");
        sale.setUnitPrice(newUnitPrice);
        assertEquals(newUnitPrice, sale.getUnitPrice());
    }

    @Test
    void setUnitPriceZeroGood() {
        BigDecimal newUnitPrice = new BigDecimal("0.00");
        sale.setUnitPrice(newUnitPrice);
        assertEquals(newUnitPrice, sale.getUnitPrice());
    }

    @Test
    void setUnitPriceNegativeBad() {
        BigDecimal newUnitPrice = new BigDecimal("-1.11");
        Exception exception = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                sale.setUnitPrice(newUnitPrice);
            }
        });
        String expected = SalesTransaction.MSG_NEGATIVE_DOLLARS;
        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }

    @Test
    void setUnitPriceDigitsBad() {
        BigDecimal newUnitPrice = new BigDecimal("1.111");
        Exception exception = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                sale.setUnitPrice(newUnitPrice);
            }
        });
        assertEquals(SalesTransaction.MSG_TOO_MANY_DIGITS, exception.getMessage());
    }

    @Test
    void setQuantitySoldPositiveGood() {
        sale.setQuantitySold(4);
        assertEquals(4, sale.getQuantitySold());
    }

    @Test
    void setQuantitySoldZeroBad() {
        int newQuantity = 0;
        Exception exception = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                sale.setSalesPersonID(newQuantity);
            }
        });
        String expected =SalesTransaction.MSG_ZERO;
        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }

    @Test
    void setQuantitySoldNegativeBad() {
        int newQuantity = -1;
        Exception exception = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                sale.setSalesPersonID(newQuantity);
            }
        });
        assertEquals(SalesTransaction.MSG_NEGATIVE_NUMBER, exception.getMessage());
    }


}