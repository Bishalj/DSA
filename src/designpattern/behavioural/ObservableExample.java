package designpattern.behavioural;

import java.util.List;

public class ObserverExample implements Observable {
	List<Observer> observers;
	Object data;
	@Override
	public <T> void add(Observer<T> observer) {
		observers.add(observer);
	}

	@Override
	public <T> void remove(Observer<T> observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObserver() {
		observers.forEach(Observer::updateData);
	}

	@Override
	public <T> void setData(T data) {
		this.data = data;
		notifyObserver();
	}
}


interface Observable{

	<T> void add(Observer<T> observer);
	<T> void remove(Observer<T> observer);
	void notifyObserver();
	<T> void setData(T data);
}


interface Observer<T>{
	void updateData();
}

