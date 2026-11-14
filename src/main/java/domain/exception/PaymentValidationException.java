package domain.exception;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class PaymentValidationException extends RuntimeException {
    private final UUID errorId;
    private final List<ValidationError> validationErrors;

    public static class ValidationError {
        private final String field;
        private final String message;

        public ValidationError(String field, String message) {
            this.field = field;
            this.message = message;
        }

        public String getField() {
            return field;
        }

        public String getMessage() {
            return message;
        }
    }

    public PaymentValidationException(String message) {
        super(message);
        this.errorId = UUID.randomUUID();
        this.validationErrors = Collections.emptyList();
    }

    public PaymentValidationException(String message, List<ValidationError> validationErrors) {
        super(message);
        this.errorId = UUID.randomUUID();
        this.validationErrors = Collections.unmodifiableList(validationErrors);
    }

    public UUID getErrorId() {
        return errorId;
    }

    public List<ValidationError> getValidationErrors() {
        return validationErrors;
    }

    public String toLogString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[VALIDATION] ErrorId=").append(errorId)
          .append(", Message=").append(getMessage());

        if (!validationErrors.isEmpty()) {
            sb.append(", Errors=[");
            for (int i = 0; i < validationErrors.size(); i++) {
                ValidationError error = validationErrors.get(i);
                sb.append("{field=").append(error.getField())
                  .append(", message=").append(error.getMessage())
                  .append("}");
                if (i < validationErrors.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
        }
        return sb.toString();
    }

    public static PaymentValidationException forSingleField(String field, String message) {
        return new PaymentValidationException("Validation failed for field: " + field,
                List.of(new ValidationError(field, message)));
    }

    public static PaymentValidationException forMultipleFields(List<ValidationError> errors) {
        String message = String.format("Validation failed for %d fields", errors.size());
        return new PaymentValidationException(message, errors);
    }
}