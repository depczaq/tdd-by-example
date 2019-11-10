package guru.springframework;

import java.util.Objects;

public class Money implements Expression {
    private final long amount;
    private final String currency;

    public static final String USD = "USD";
    public static final String CHF = "CHF";

    public static Money dollar(long amount) {
        return new Money(amount, USD);
    }

    public static Money franc(long amount) {
        return new Money(amount, CHF);
    }

    public Money(long amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public long getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public Money times(int multiplier) {
        return new Money(getAmount() * multiplier, getCurrency());
    }

    public Expression plus(Money addend) {
        return new Sum(this, addend);
    }

    @Override
    public Money reduce(String toCurrency) {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount &&
                Objects.equals(currency, money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }
}
