package domain.exception;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import domain.Payment;

public class PaymentNonCriticalException extends Exception {
    private final UUID errorId;
    private final LocalDateTime timestamp;
    private final String serviceName;
    private final String errorCode;
    private final Severity severity;

    public enum Severity {
        LOW,
        MEDIUM,
        HIGH
    }

    public PaymentNonCriticalException(String message, String serviceName, String errorCode, Severity severity) {
        super(message);
        this.errorId = UUID.randomUUID();
        this.timestamp = LocalDateTime.now();
        this.serviceName = serviceName;
        this.errorCode = errorCode;
        this.severity = severity;
    }

    public PaymentNonCriticalException(String message, Throwable cause, String serviceName, String errorCode, Severity severity) {
        super(message, cause);
        this.errorId = UUID.randomUUID();
        this.timestamp = LocalDateTime.now();
        this.serviceName = serviceName;
        this.errorCode = errorCode;
        this.severity = severity;
    }

    public UUID getErrorId() {
        return errorId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public Severity getSeverity() {
        return severity;
    }

    public String toLogString() {
        return String.format("[NON_CRITICAL] ErrorId=%s, Timestamp=%s, Service=%s, Code=%s, Severity=%s, Message=%s",
                errorId, timestamp, serviceName, errorCode, severity, getMessage());
    }

    public static PaymentNonCriticalException insufficientFunds(String accountId, BigDecimal amount, String currency) {
        String message = String.format("Insufficient funds in account %s for amount %s %s", accountId, amount, currency);
        return new PaymentNonCriticalException(message, "PaymentService", "INSUFFICIENT_FUNDS", Severity.HIGH);
    }

    public static PaymentNonCriticalException duplicatePayment(String paymentId) {
        String message = String.format("Payment with ID %s already processed", paymentId);
        return new PaymentNonCriticalException(message, "PaymentService", "DUPLICATE_PAYMENT", Severity.MEDIUM);
    }

    public static PaymentNonCriticalException invalidRecipient(String recipientAccount) {
        String message = String.format("Recipient account %s is invalid or blocked", recipientAccount);
        return new PaymentNonCriticalException(message, "PaymentService", "INVALID_RECIPIENT", Severity.MEDIUM);
    }

    public static PaymentNonCriticalException fromExternalServiceWarning(String serviceName, String errorCode, String message) {
        return new PaymentNonCriticalException(message, serviceName, errorCode, Severity.LOW);
    }
}