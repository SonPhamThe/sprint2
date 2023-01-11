package com.example.demo.controller.payment;

import com.example.demo.service.payment.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/payments")
public class PaymentRestController {
    @Autowired
    private IPaymentService paymentService;
}
