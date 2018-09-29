package ca.ulaval.glo4002.mockexercise;

import ca.ulaval.glo4002.mockexercise.do_not_edit.CartFactory;
import ca.ulaval.glo4002.mockexercise.do_not_edit.Invoice;
import ca.ulaval.glo4002.mockexercise.do_not_edit.ProductRepository;

public class StartByTestingThis {

    private final CartFactory cartFactory;
    private final ProductRepository productRepository;
    private final InvoiceFactory invoiceFactory;

    public StartByTestingThis(
            CartFactory cartFactory,
            ProductRepository productRepository,
            InvoiceFactory invoiceFactory
    ){
        this.cartFactory = cartFactory;
        this.productRepository = productRepository;
        this.invoiceFactory = invoiceFactory;
    }


    public Invoice oneClickBuy(String clientEmail, String productSku) {

        Cart cart = cartFactory.create(clientEmail);
        Product product = productRepository.findBySku(productSku);
        cart.addProduct(product);
        return cart.generateInvoice(invoiceFactory);
    }
}
