package com.spdb.xy.service;

import com.spdb.xy.entities.Payment;

public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
