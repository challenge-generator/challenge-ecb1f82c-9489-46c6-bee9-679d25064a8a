package domain.exception;

import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentCriticalException extends RuntimeException {
    private final UUID errorId;
    private final LocalDateTime timestamp;
    private final String serviceName;
    private final String errorCode;

    public PaymentCriticalException(String message, String serviceName, String errorCode) {
        super(message);
        this.errorId = UUID.randomUUID();
        this.timestamp = LocalDateTime.now();
        this.serviceName = serviceName;
        this.errorCode = errorCode;
    }

    public PaymentCriticalException(String message, Throwable cause, String serviceName, String errorCode) {
        super(message, cause);
        this.errorId = UUID.randomUUID();
        this.timestamp = LocalDateTime.now();
        this.serviceName = serviceName;
        this.errorCode = errorCode;
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

    public String toLogString() {
        return String.format("[CRITICAL] ErrorId=%s, Timestamp=%s, Service=%s, Code=%s, Message=%s",
                errorId, timestamp, serviceName, errorCode, getMessage());
    }

    public static PaymentCriticalException fromExternalServiceFailure(String serviceName, String errorCode, Throwable cause) {
        String message = String.format("Critical failure in external service %s with error code %s", serviceName, errorCode);
        return new PaymentCriticalException(message, cause, serviceName, errorCode);
    }

    public static PaymentCriticalException databaseUnavailable(String serviceName) {
        return new PaymentCriticalException("Database is unavailable", serviceName, "DB_UNAVAILABLE");
    }

    public static PaymentCriticalException auditServiceFailure(String serviceName) {
        return new PaymentCriticalException("Audit service failed to record payment", serviceName, "AUDIT_FAILURE");
    }
}