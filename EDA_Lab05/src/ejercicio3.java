
public class ejercicio3 {
	public static void main(String[] args) {
		AVL<Integer> b=new AVL<Integer>();
		try {
			b.insert(30);
			System.out.println(b);
			b.insert(25);
			System.out.println(b);
			b.insert(50);
			System.out.println(b);
			b.insert(35);
			System.out.println(b);
			b.insert(700);
			System.out.println(b);
		}
		catch(ItemDuplicated x) {
			System.out.println(x.getMessage());
		}
	}

}
