
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     System.out.println(binaryGap(64));
     
     int[] A = {1,2,3,4,5,6};
     int[] B = {1};
     int[] hasil = cyclicRotation(A,0);
     for(int i:hasil)
     {
       System.out.print(i);
     }
	}
	
	
	public static int binaryGap(int input)
	{
		int count = 0, result = 0;
		boolean flag=false;
		if (input <= 0) return 0;
		while(input > 0)
		{			
			if(input%2 == 1)
			{
				if(!flag) flag = true;
				if(flag && input > 0)
				{
					if(result == 0)
					{	
					 result = count;
					 count = 0;
					}else
					{
						result = result>count? result:count;
					}
				}
			}
			
			if(flag && input%2==0) count++;
			
			input = input/2;
		}
		
		return result;
	}
	
	/*
	 * A = array yang akan dirotasi
	 * k = besar rotasi ke kanan
	 */
	
	public static int[] cyclicRotation(int[] A, int k)
	{
		if(A.length<=1) return A;
		int[] temp = new int[A.length];
		int rot = (k/A.length) > 0 ? k%A.length: k;
		for(int i=0; i<A.length; i++)
		{
			if(A.length - i > rot) temp[rot+i] = A[i];
			else temp[rot-(A.length-i)] = A[i];
		}
		return temp;
	}

}
