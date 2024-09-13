package dev.ayush.PaymentService.Controller;


import com.razorpay.RazorpayException;
import dev.ayush.PaymentService.PaymentRequestDTO;
import dev.ayush.PaymentService.Services.PaymentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    private PaymentServices paymentServices;

    @PostMapping("/payment")
    public ResponseEntity<String> doPayment(@RequestBody PaymentRequestDTO paymentRequestDTO) throws RazorpayException {
        return ResponseEntity.ok(paymentServices.generatePaymentLink(paymentRequestDTO));
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("Hello world, from Ayush Soni.");
    }

}
