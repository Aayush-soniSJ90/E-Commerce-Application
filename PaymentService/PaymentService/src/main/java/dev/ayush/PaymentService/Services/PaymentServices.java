package dev.ayush.PaymentService.Services;

import com.razorpay.RazorpayException;
import dev.ayush.PaymentService.PaymentRequestDTO;

public interface PaymentServices {
    String generatePaymentLink(PaymentRequestDTO paymentRequestDTO) throws RazorpayException;
}
