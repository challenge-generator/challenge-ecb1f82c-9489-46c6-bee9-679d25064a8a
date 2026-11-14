package application.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

public record PaymentRequest(
    @NotNull(message = "Account ID cannot be null")
    @Size(min = 1, message = "Account ID cannot be empty")
    String accountId,

    @NotNull(message = "Amount cannot be null")
    @Positive(message = "Amount must be positive")
    BigDecimal amount,

    @NotNull(message = "Currency cannot be null")
    @Size(min = 3, max = 3, message = "Currency must be a 3-letter code")
    String currency,

    @NotNull(message = "Recipient account cannot be null")
    @Size(min = 1, message = "Recipient account cannot be empty")
    String recipientAccount
) {
}