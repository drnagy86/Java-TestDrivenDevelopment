import com.nagy.SalesTransaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void setTransactionID() {

        fail();
    }

    @Test
    void getSalesPersonID() {

        assertEquals(SalesTransaction.DEFAULT_salesPersonID, sale.getSalesPersonID());
    }

    @Test
    void setSalesPersonID() {

        fail();
    }

    @Test
    void getTransactionDateTime() {

        fail();
    }

    @Test
    void setTransactionDateTime() {

        fail();
    }

    @Test
    void getItemID() {

        fail();
    }

    @Test
    void setItemID() {

        fail();
    }

    @Test
    void getUnitPrice() {

        fail();
    }

    @Test
    void setUnitPrice() {

        fail();
    }

    @Test
    void getQuantitySold() {

        fail();
    }

    @Test
    void setQuantitySold() {

        fail();
    }


}