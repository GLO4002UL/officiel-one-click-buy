package ca.ulaval.glo4002.mockexercise;

import java.util.ArrayList;
import java.util.Collection;

import ca.ulaval.glo4002.mockexercise.do_not_edit.Invoice;
import ca.ulaval.glo4002.mockexercise.do_not_edit.InvoiceLine;

public class InvoiceFactory {

    public InvoiceLine createInvoiceLine(String lineText, double price) {
        return new InvoiceLine(lineText, price);
    }

    public Invoice createInvoice(String email, Collection<InvoiceLine> lines) {
        return new Invoice(email, new ArrayList<>(lines));
    }
}
