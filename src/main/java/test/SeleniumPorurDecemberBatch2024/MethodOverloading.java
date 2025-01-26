package test.SeleniumPorurDecemberBatch2024;

public class MethodOverloading {
	
	
	public void add(int a,int b)
	{
		System.out.println(a+b);
	}
	
	public void add(int a,double b)
	{
		System.out.println("double");
		System.out.println(a+b);
	}
	
	public void add(int a,int b,int c)
	{
		System.out.println(a+b+c);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MethodOverloading M = new MethodOverloading();
		M.add(2, 3);
	}

}
