package com.seminar2.observer;

// Observable (the subject's side): an object that observers can subscribe to.
// Order implements it - like WeatherStation implements Observable in the handout.
public interface OrderObservable {
    void addObserver(OrderObserver observer);

    void removeObserver(OrderObserver observer);

    void notifyObservers();
}
