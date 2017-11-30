package test.fruit;

public class BananaBox {
	private Banana item;
	public void push(Banana item) {
		this.item=item;
	}
	public Banana pull() {
		return item;
	}
}
