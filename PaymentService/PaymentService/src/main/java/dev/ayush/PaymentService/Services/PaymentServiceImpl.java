package dev.ayush.PaymentService.Services;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import dev.ayush.PaymentService.Config.RazorpayClientConfig;
import dev.ayush.PaymentService.PaymentRequestDTO;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;

@Service
public class PaymentServiceImpl implements PaymentServices{

    @Autowired
    private RazorpayClientConfig razorpayClientConfig;

    @Override
    public String generatePaymentLink(PaymentRequestDTO paymentRequestDTO) throws RazorpayException {


        RazorpayClient razorpay = razorpayClientConfig.getRazorpayClient();
        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",paymentRequestDTO.getAmount());
        paymentLinkRequest.put("currency","INR");
        paymentLinkRequest.put("accept_partial",false);
        paymentLinkRequest.put("expire_by", Instant.now().toEpochMilli() + 600000);
        paymentLinkRequest.put("reference_id", paymentRequestDTO.getOrderId());
        paymentLinkRequest.put("description", paymentRequestDTO.getDescription());
        JSONObject customer = new JSONObject();
        customer.put("name", paymentRequestDTO.getCustomerName());
        customer.put("contact", paymentRequestDTO.getCustomerPhone());
        customer.put("email", paymentRequestDTO.getCustomerEmail());
        paymentLinkRequest.put("customer",customer);
        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("notify",notify);
        paymentLinkRequest.put("reminder_enable",true);

        PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);
        return payment.toString();
    }
}
