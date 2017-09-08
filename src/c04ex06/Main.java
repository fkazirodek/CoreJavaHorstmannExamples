package c04ex06;

public class Main {

	public static void main(String[] args) {
		Item item = new Item("Item1", 100);
		DiscountedItem dItem =  new DiscountedItem("Item1", 100, 10);
		DiscountedItem dItem2 = new DiscountedItem("Item1", 100, 5);
		
		System.out.println(dItem.equals(item)); // x.equals(y)
		System.out.println(item.equals(dItem2)); // y.equals(z)
		System.out.println(dItem.equals(dItem2)); // x.equals(z) - false
	}

}
