package Assignment2.observer;

import Assignment2.event.Event;

import java.util.ArrayList;
import java.util.List;

public class EventSubject {

    private final List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Event event) {
        System.out.println("[EventSubject] Notifying " + observers.size()
                + " observers for Event " + event.getId());
        for (Observer observer : observers) {
            observer.update(event);
        }
    }
}
