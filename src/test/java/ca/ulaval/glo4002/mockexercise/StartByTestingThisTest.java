package ca.ulaval.glo4002.mockexercise;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.verify;

import ca.ulaval.glo4002.mockexercise.do_not_edit.CartFactory;
import ca.ulaval.glo4002.mockexercise.do_not_edit.ProductRepository;

@RunWith(MockitoJUnitRunner.class)
public class StartByTestingThisTest {
    public static final String EMAIL = "email";
    public static final String SKU = "SKU";

    @Mock
    private CartFactory cartFactory;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private InvoiceFactory invoiceFactory;

    @Mock
    private Cart cart;

    @Mock
    private Product product;

    @InjectMocks
    private StartByTestingThis service;

    @Before
    public void setUp() {
        willReturn(cart).given(cartFactory).create(EMAIL);
        willReturn(product).given(productRepository).findBySku(SKU);
    }

    @Test
    public void when_OneClickBuy_thenAddsTheItemToTheCart(){
        service.oneClickBuy(EMAIL, SKU);
        verify(cart).addProduct(product);
    }

    @Test
    public void when_OneCluckBuy_ThenCreatesInvoice(){
        service.oneClickBuy(EMAIL,SKU);
        verify(cart).generateInvoice(invoiceFactory);
    }
}