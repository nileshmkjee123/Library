package org.project.library.controller;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.project.library.requestmodel.PaymentInfoRequest;
import org.project.library.service.PaymentService;
import org.project.library.utils.ExtractJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("https://localhost:3000")
@RestController
@RequestMapping("/api/payment/secure")
public class PaymentController {
   private PaymentService paymentService;
   @Autowired
    public PaymentController(PaymentService paymentService){
       this.paymentService=paymentService;
   }
   @PostMapping("/payment-intent")
    public ResponseEntity<String> createPaymentIntent(@RequestBody PaymentInfoRequest paymentInfoRequest)throws StripeException {
       PaymentIntent paymentIntent = paymentService.createPaymentIntent(paymentInfoRequest);
       String paymentStr = paymentIntent.toJson();
       return new ResponseEntity<>(paymentStr, HttpStatus.OK);
   }
   @PutMapping("/payment-complete")
   public ResponseEntity<String> stripePaymentComplete(@RequestHeader(value = "Authorization")String token)throws Exception{
       String userEmail = ExtractJWT.payLoadJWTExtraction(token,"\"sub\"");
       if(userEmail == null){
           throw new Exception("User email is missing");
       }
       return paymentService.stripePayment(userEmail);
   }
}
