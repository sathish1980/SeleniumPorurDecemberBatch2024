package test.SeleniumPorurDecemberBatch2024;

public class Secondclass extends FristClass{
	
	public void sub()
	{
		System.out.println("sub");
	}
	
	public void Myname()
	{
		System.out.println(name);
	}

	public void add()
	{
		System.out.println("Second class add");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Secondclass S = new Secondclass();
		S.add();
		S.sub();
		S.Myname();

	}

}
