package domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import domain.exception.PaymentValidationException;

public class Payment {
    private final UUID id;
    private final String accountId;
    private final BigDecimal amount;
    private final String currency;
    private final String recipientAccount;
    private final LocalDateTime createdAt;
    private PaymentStatus status;

    public Payment(UUID id, String accountId, BigDecimal amount, String currency,
                  String recipientAccount, LocalDateTime createdAt, PaymentStatus status) {
        this.id = id;
        this.accountId = validateAccountId(accountId);
        this.amount = validateAmount(amount);
        this.currency = validateCurrency(currency);
        this.recipientAccount = validateRecipientAccount(recipientAccount);
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
        this.status = status != null ? status : PaymentStatus.PENDING;
    }

    public UUID getId() {
        return id;
    }

    public String getAccountId() {
        return accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getRecipientAccount() {
        return recipientAccount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    private String validateAccountId(String accountId) {
        if (accountId == null || accountId.trim().isEmpty()) {
            throw new PaymentValidationException("Account ID cannot be null or empty");
        }
        return accountId;
    }

    private BigDecimal validateAmount(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new PaymentValidationException("Amount must be positive");
        }
        return amount;
    }

    private String validateCurrency(String currency) {
        if (currency == null || currency.trim().isEmpty() || currency.trim().length() != 3) {
            throw new PaymentValidationException("Currency must be a 3-letter code");
        }
        return currency.toUpperCase();
    }

    private String validateRecipientAccount(String recipientAccount) {
        if (recipientAccount == null || recipientAccount.trim().isEmpty()) {
            throw new PaymentValidationException("Recipient account cannot be null or empty");
        }
        return recipientAccount;
    }

    public enum PaymentStatus {
        PENDING,
        PROCESSED,
        FAILED,
        REVERSED
    }
}