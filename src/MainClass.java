import java.util.Arrays;

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
     
     int[] data = {3,4,4,6,1,4,4};
     int[] data2 = {3,3,3,6,3,3,3};
     int[] maxC = solution100(5,data2);
     
     System.out.println("\n");
     for(int i:maxC)
     {
       System.out.print(i+" ");
     }
	}
	
	 public static int[] solution100(int N, int[] A) {
	        // write your code in Java SE 8
	        int[] result = new int[N];
	        int max = 0, save_max = 0;
	        
	        for(int el = 0; el<A.length; el++)
			{
				if(A[el] == N+1)
				{
					save_max = max;
				}else
				{
					if(result[A[el]-1] < save_max) result[A[el]-1] = save_max+1;
					else result[A[el]-1] += 1;
					max = result[A[el]-1]>max? result[A[el]-1]:max;
				}	
			
			}
	        
	        for(int l=0; l<result.length; l++)
	        {
	        	if(result[l]<save_max) result[l] = save_max;
	        }
	        
			return result;
	        
	    }
	
	
	
	 public int[] solution80(int N, int[] A) {
	        // write your code in Java SE 8
	        int[] result = new int[N];
	        int max = 0;
	        for(int el = 0; el<A.length; el++)
			{
				if(A[el] == N+1)
				{
					for(int i = 0; i<N; i++)
					{
						result[i] = max;
					}
				}else
				{
					result[A[el]-1] += 1;
					max = result[A[el]-1]>max? result[A[el]-1]:max;
				}	
			
			}
			return result;
	        
	    }
	
	class Solution {
	    public int[] solution(int N, int[] A) {
	        // write your code in Java SE 8
	        int[] result = new int[N];
	        int max = 0;
	        for(int el:A)
			{
				if(el == N+1)
				{
					for(int i = 0; i<N; i++)
					{
						result[i] = max;
					}
				}else
				{
					result[el-1] += 1;
					max = result[el-1]>max? result[el-1]:max;
				}	
			
			}
			return result;
	        
	    }
	}
	
	
	public static int[] maxCount(int N, int[] A)
	{
		int[] result = new int[N];
		//Inisialisasi semua element ke nool
		for(int i = 0; i<N; i++)
		{
			result[i] = 0;
		}
		
		for(int el:A)
		{
			if(el == N+1)
			{
				int max = findMaxArr(result);
				for(int i = 0; i<N; i++)
				{
					result[i] = max;
				}
			}else
			{
				result[el] += 1;
			}
			
		displayArray(result);
		}
		return result;
		
	}
	
	
	public static int findMaxArr(int[]A)
	{
		Arrays.sort(A);
		return A[A.length-1];
	}
	
	public static void displayArray(int[] A)
	{
		for (int a: A)
		{
			System.out.print(a+" ");
		}
		System.out.print("\n");
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
