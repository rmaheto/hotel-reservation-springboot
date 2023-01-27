package com.codemaniac.hotelsystem.services;

import com.codemaniac.hotelsystem.entities.Payment;
import com.codemaniac.hotelsystem.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PaymentServiceImpl implements PaymentService{


    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment getPayment(long paymentId) {
        return paymentRepository.findById(paymentId).orElse(null);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment updatePayment(long paymentId, Payment payment) {
        Payment existingPayment = paymentRepository.findById(paymentId).orElse(null);
        if(existingPayment != null) {
            existingPayment.setReservation(payment.getReservation());
            existingPayment.setCardNumber(payment.getCardNumber());
            existingPayment.setCardHolderName(payment.getCardHolderName());
            existingPayment.setExpirationDate(payment.getExpirationDate());
            existingPayment.setCvv(payment.getCvv());
            return paymentRepository.save(existingPayment);
        }
        return null;
    }

    @Override
    public void deletePayment(long paymentId) {
        paymentRepository.deleteById(paymentId);
    }
}
