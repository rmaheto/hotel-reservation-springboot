package com.codemaniac.hotelsystem.services;

import com.codemaniac.hotelsystem.entities.Payment;

import java.util.List;

public interface PaymentService {
    public Payment getPayment(long paymentId);
    public List<Payment> getAllPayments();
    public Payment createPayment(Payment payment);
    public Payment updatePayment(long paymentId, Payment payment);
    public void deletePayment(long paymentId);
}
