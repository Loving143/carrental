package com.carrental.Payment.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.carrental.enumm.PaymentStatus;
import com.carrental.reservation.model.Reservation;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Payment {

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private BigDecimal amount;

	    private LocalDateTime paymentDate;

	    @Enumerated(EnumType.STRING)
	    private PaymentStatus status; // SUCCESS, FAILED, PENDING, REFUNDED

	    private String paymentMethod; // e.g., UPI, CARD, WALLET

	    private String transactionId; // From payment gateway

	    private String gatewayResponse; // Optional (e.g., Razorpay/Stripe JSON)

	    @ManyToOne
	    @JoinColumn(name = "reservation_id")
	    private Reservation reservation;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public BigDecimal getAmount() {
			return amount;
		}

		public void setAmount(BigDecimal amount) {
			this.amount = amount;
		}

		public LocalDateTime getPaymentDate() {
			return paymentDate;
		}

		public void setPaymentDate(LocalDateTime paymentDate) {
			this.paymentDate = paymentDate;
		}

		public PaymentStatus getStatus() {
			return status;
		}

		public void setStatus(PaymentStatus status) {
			this.status = status;
		}

		public String getPaymentMethod() {
			return paymentMethod;
		}

		public void setPaymentMethod(String paymentMethod) {
			this.paymentMethod = paymentMethod;
		}

		public String getTransactionId() {
			return transactionId;
		}

		public void setTransactionId(String transactionId) {
			this.transactionId = transactionId;
		}

		public String getGatewayResponse() {
			return gatewayResponse;
		}

		public void setGatewayResponse(String gatewayResponse) {
			this.gatewayResponse = gatewayResponse;
		}

		public Reservation getReservation() {
			return reservation;
		}

		public void setReservation(Reservation reservation) {
			this.reservation = reservation;
		}
	    
}
