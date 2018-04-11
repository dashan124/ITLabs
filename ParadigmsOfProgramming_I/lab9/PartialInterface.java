interface ExInterface {
	public void methoda();
	public void methodb();
}

abstract class PartialImplementation implements ExInterface {
	public void methoda() {
		//System.out.println("This is method a");
	}

	public void methodb() {
		//System.out.println("This is method b");
	}
}

class PartialInterface extends PartialImplementation {
	public void methoda() {
		System.out.println("This is methoda in partial implementation");
	}

	public static void main(String[] args) {
		PartialInterface p = new PartialInterface();

		p.methoda();
	}
}
