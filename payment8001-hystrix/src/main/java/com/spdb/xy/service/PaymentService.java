package com.spdb.xy.service;

import com.spdb.xy.entities.Payment;

public interface PaymentService {

    int create(Payment payment);

    String getPaymentById(Long id);

    String paymentTimeout();

    String paymentCircuitBreaker(Integer id);

}
