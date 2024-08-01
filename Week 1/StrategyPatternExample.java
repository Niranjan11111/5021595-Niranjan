public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setPaymentStrategy(new CreditCardPayment());
        context.pay();

        context.setPaymentStrategy(new PayPalPayment());
        context.pay();
    }
}

interface PaymentStrategy {
    void pay();
}

class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay() {
        System.out.println("Paying with Credit Card.");
    }
}

class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay() {
        System.out.println("Paying with PayPal.");
    }
}

class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay() {
        paymentStrategy.pay();
    }
}
