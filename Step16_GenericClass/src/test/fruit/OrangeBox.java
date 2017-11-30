package test.fruit;

public class OrangeBox {
	private Orange item;
	public void push(Orange item) {
		this.item=item;
	}
	public Orange pull() {
		return item;
	}
}
