package domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import domain.exception.PaymentNonCriticalException;

public interface PaymentRepository {
    Payment save(Payment payment);
    Optional<Payment> findById(UUID id);
    boolean existsById(UUID id);

    default void validatePaymentDoesNotExist(UUID paymentId) {
        if (existsById(paymentId)) {
            try {
                throw new PaymentNonCriticalException(
                    "Payment with ID " + paymentId + " already exists",
                    "PaymentRepository",
                    "DUPLICATE_PAYMENT",
                    PaymentNonCriticalException.Severity.MEDIUM
                );
            } catch (PaymentNonCriticalException e) {
                throw new RuntimeException(e);
            }
        }
    }

    default void validatePaymentCanBeProcessed(Payment payment) {
        if (payment == null) {
            try {
                throw new PaymentNonCriticalException(
                    "Payment cannot be null",
                    "PaymentRepository",
                    "NULL_PAYMENT",
                    PaymentNonCriticalException.Severity.HIGH
                );
            } catch (PaymentNonCriticalException e) {
                throw new RuntimeException(e);
            }
        }

        if (payment.getAmount() == null || payment.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            try {
                throw new PaymentNonCriticalException(
                    "Payment amount must be positive",
                    "PaymentRepository",
                    "INVALID_AMOUNT",
                    PaymentNonCriticalException.Severity.HIGH
                );
            } catch (PaymentNonCriticalException e) {
                throw new RuntimeException(e);
            }
        }

        if (payment.getAccountId() == null || payment.getAccountId().isBlank()) {
            try {
                throw new PaymentNonCriticalException(
                    "Account ID cannot be null or blank",
                    "PaymentRepository",
                    "INVALID_ACCOUNT_ID",
                    PaymentNonCriticalException.Severity.HIGH
                );
            } catch (PaymentNonCriticalException e) {
                throw new RuntimeException(e);
            }
        }

        if (payment.getRecipientAccount() == null || payment.getRecipientAccount().isBlank()) {
            try {
                throw new PaymentNonCriticalException(
                    "Recipient account cannot be null or blank",
                    "PaymentRepository",
                    "INVALID_RECIPIENT",
                    PaymentNonCriticalException.Severity.HIGH
                );
            } catch (PaymentNonCriticalException e) {
                throw new RuntimeException(e);
            }
        }
    }

    default boolean isPaymentPending(Payment payment) {
        return payment != null && payment.getStatus() == Payment.PaymentStatus.PENDING;
    }

    default boolean isPaymentCompleted(Payment payment) {
        return payment != null && payment.getStatus() == Payment.PaymentStatus.PENDING;
    }

    default boolean isPaymentFailed(Payment payment) {
        return payment != null && payment.getStatus() == Payment.PaymentStatus.FAILED;
    }

    default Payment createNewPayment(UUID id, String accountId, BigDecimal amount, 
                                     String currency, String recipientAccount) {
        return new Payment(
            id,
            accountId,
            amount,
            currency,
            recipientAccount,
            LocalDateTime.now(),
            Payment.PaymentStatus.PENDING
        );
    }

    default void markPaymentAsCompleted(Payment payment) {
        if (payment != null) {
            payment.setStatus(Payment.PaymentStatus.PENDING);
        }
    }

    default void markPaymentAsFailed(Payment payment) {
        if (payment != null) {
            payment.setStatus(Payment.PaymentStatus.FAILED);
        }
    }

    default void markPaymentAsPending(Payment payment) {
        if (payment != null) {
            payment.setStatus(Payment.PaymentStatus.PENDING);
        }
    }
}