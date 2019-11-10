package guru.springframework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MoneyTest {
    @Test
    void testMultiplicationDollar() {
        Money five = Money.dollar(5);

        Money product = five.times(2);
        assertEquals(10, product.getAmount());

        product = five.times(3);
        assertEquals(15, product.getAmount());
    }

    @Test
    void testEqualityDollar() {
        assertEquals(Money.dollar(5), Money.dollar(5));
        assertNotEquals(Money.dollar(5), Money.dollar(15));
        assertNotEquals(Money.dollar(5), Money.franc(5));
    }

    @Test
    void testMultiplicationFranc() {
        Money five = Money.franc(5);

        Money product = five.times(2);
        assertEquals(10, product.getAmount());

        product = five.times(3);
        assertEquals(15, product.getAmount());
    }

    @Test
    void testEqualityFranc() {
        assertEquals(Money.franc(5), Money.franc(5));
        assertNotEquals(Money.franc(5), Money.franc(10));
        assertNotEquals(Money.franc(5), Money.dollar(5));
    }

    @Test
    void testSimpleAddition() {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, Money.USD);
        assertEquals(Money.dollar(10), reduced);
    }

    @Test
    void testPlusReturnSum() {
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        assertEquals(five, sum.getAugmend());
        assertEquals(five, sum.getAddend());
    }

    @Test
    void testReduceSum() {
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, Money.USD);
        assertEquals(Money.dollar(7), result);
    }

    @Test
    void testReduceMoney() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), Money.USD);
        assertEquals(Money.dollar(1), result);
    }
}
