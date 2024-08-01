import java.util.ArrayList;
import java.util.List;

public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setStockPrice(100);
        stockMarket.setStockPrice(150);
    }
}

interface Observer {
    void update(int price);
}

class MobileApp implements Observer {
    @Override
    public void update(int price) {
        System.out.println("MobileApp: Stock price updated to " + price);
    }
}

class WebApp implements Observer {
    @Override
    public void update(int price) {
        System.out.println("WebApp: Stock price updated to " + price);
    }
}

interface Stock {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
}

class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private int stockPrice;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockPrice);
        }
    }

    public void setStockPrice(int stockPrice) {
        this.stockPrice = stockPrice;
        notifyObservers();
    }
}
