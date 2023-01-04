package co.com.jsolutions.payments;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PaymentProcessorTest {

    private PaymentGateway paymentGateway;
    private PaymentProcessor paymentProcessor;

    @Before //Execution before @Test
    public void setup(){
        paymentGateway = Mockito.mock(PaymentGateway.class);
        paymentProcessor =  new PaymentProcessor(paymentGateway);
    }

    @Test
    public void paymentIsCorrect(){

        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));

        assertTrue(paymentProcessor.makePayment(5));
    }

    @Test
    public void paymentIsWrong(){
        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));
        assertFalse(paymentProcessor.makePayment(5));
    }
}