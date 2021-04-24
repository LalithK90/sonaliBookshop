package lk.sonali_bookshop.asset.invoice.entity.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentMethod {
    CASH("Cash"),
    CREDIT("Cheque");
    private final String paymentMethod;
}
