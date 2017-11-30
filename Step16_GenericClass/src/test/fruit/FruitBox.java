package test.fruit;

public class FruitBox<T> {
	private T item;
	
	public void push(T item) {
		this.item=item;
	}
	
	public T pull() {
		return item;
	}
}
