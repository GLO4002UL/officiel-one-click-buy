package ca.ulaval.glo4002.mockexercise;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProductTest {
    private static final double PRICE = 1.00;
    private static final String NAME = "name";
    private static final String SKU = "SKU";

    @Mock
    private InvoiceFactory invoiceFactory;

    @Mock
    private Product product;

    @Before
    public void setUp(){
        product = new Product(SKU, NAME, PRICE);
    }

    @Test
    public void generateInvoiceLineInALineWithNameAndPrice(){
        product.generateInvoiceLine(invoiceFactory);

        verify(invoiceFactory).createInvoiceLine(NAME, PRICE);
    }
}