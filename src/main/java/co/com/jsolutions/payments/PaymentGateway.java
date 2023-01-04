package co.com.jsolutions.payments;

public interface PaymentGateway {

    PaymentResponse requestPayment(PaymentRequest paymentRequest);

}
