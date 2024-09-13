package dev.ayush.PaymentService.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RazorpayWebhookController {

    @PostMapping("/rzp/webhook")
    public ResponseEntity<String> webhook(){
        System.out.println("Razorpay webhook called.");
        return ResponseEntity.ok("Ok.");
    }
}
