package basic;

public class Calc 
{
	
	public int div(int i, int j)
	{
		
		if(j==0)
		{
			return 0;
		}
		
		if(i<0||j<0)
		{
			return 0;
		}
		int k=i/j;
		
		return k;
		
	}

}
