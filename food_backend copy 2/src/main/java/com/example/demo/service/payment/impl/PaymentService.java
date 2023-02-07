package com.example.demo.service.payment.impl;

import com.example.demo.model.payment.Payment;
import com.example.demo.repository.payment.IPaymentRepository;
import com.example.demo.service.payment.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService implements IPaymentService {
    @Autowired
    private IPaymentRepository paymentRepository;
    @Override
    public void save(Payment payment) {
        paymentRepository.save(payment);
    }
}
