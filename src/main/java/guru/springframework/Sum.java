package guru.springframework;

public class Sum implements Expression {
    private final Money augmend;
    private final Money addend;

    public Sum(Money augmend, Money addend) {
        this.augmend = augmend;
        this.addend = addend;
    }

    public Money reduce(String toCurrency) {
        long amount= this.getAugmend().getAmount() + this.getAddend().getAmount();
        return new Money(amount, toCurrency);
    }

    public Money getAugmend() {
        return augmend;
    }

    public Money getAddend() {
        return addend;
    }
}
