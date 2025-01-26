package test.SeleniumPorurDecemberBatch2024;

public class Interfaceimplementation extends FristClass implements Interface1,Interface2 {
	
	@Override
	public void add() {
		// TODO Auto-generated method stub
		System.out.println("add test");
	}

	@Override
	public void sub() {
		// TODO Auto-generated method stub
		System.out.println("sub test");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interface1 I = new Interfaceimplementation();
		Interface2 I1 = new Interfaceimplementation();
		I1.add();
		I.sub();
	}

	

}
