public class AdapterPatternExample {
    public static void main(String[] args) {
        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPal());
        paypalProcessor.processPayment();

        PaymentProcessor stripeProcessor = new StripeAdapter(new Stripe());
        stripeProcessor.processPayment();
    }
}

interface PaymentProcessor {
    void processPayment();
}

class PayPal {
    public void sendPayment() {
        System.out.println("Processing payment with PayPal.");
    }
}

class Stripe {
    public void makePayment() {
        System.out.println("Processing payment with Stripe.");
    }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPal payPal;

    public PayPalAdapter(PayPal payPal) {
        this.payPal = payPal;
    }

    @Override
    public void processPayment() {
        payPal.sendPayment();
    }
}

class StripeAdapter implements PaymentProcessor {
    private Stripe stripe;

    public StripeAdapter(Stripe stripe) {
        this.stripe = stripe;
    }

    @Override
    public void processPayment() {
        stripe.makePayment();
    }
}
