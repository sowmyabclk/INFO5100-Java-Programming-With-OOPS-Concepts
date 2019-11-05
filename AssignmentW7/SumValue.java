package AED.Assignment7;

import java.util.Random;


public class SumValue  {
	static void generateRandomArray(int[] arr){
		Random rd = new Random();
		for(int i=0;i<arr.length;i++) {
			arr[i] = rd.nextInt();
			System.out.println(arr[i]);
		}
		
		
    }

    /*get sum of an array using 4 threads*/
    static long sum(int[] arr) throws InterruptedException{
    	int sumValues=0;
    	 sumThread[] threads = new sumThread[4];
         for(int i=0;i<4;i++) {
         	threads[i] = new sumThread(arr,i*arr.length/4,(i+1)*arr.length/4);
         	threads[i].start();
         	threads[i].join();
         	sumValues+=threads[i].getResult();
         	System.out.println("s "+sumValues);
         }
         System.out.println(sumValues);
        return sumValues;
    }
    static class sumThread extends Thread {
		private int min;
		private int max;
		private int[] arr;

		public sumThread(int[] arr,int min,int max) {
			this.arr = arr;
			this.min = min;
			this.max = max;
		}
		
		
		int result =0;

		public void run() {
			System.out.println("thread "+ min +" " +max);
			for(int i=min;i<max;i++) {
				result+=arr[i];
			}
		}
		public long getResult() {
			return result;
		}
    }
    public static void main(String[] args) throws InterruptedException{
        int[] arr = new int[4000000];
        generateRandomArray(arr);
       long sum = sum(arr);
       System.out.println("Sum: " + sum);
    
   
    }
}
