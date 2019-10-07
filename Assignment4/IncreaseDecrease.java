package AED.Assignment4;

public class IncreaseDecrease {
	
	
	public static int[]  increaseOrDecrease(String s) throws Exception {
		
	int low =0;
	int high = s.length();
	
	int[] arr = new int[high+1];
	for(int i=0;i<arr.length-1;i++) {
		if(s.charAt(i) =='I') {
			arr[i] = low++;
		}
			else if(s.charAt(i)=='D') {
				arr[i] = high--;

				
			}
			else
				throw new Exception("character is other than D and I");
			
		}
	arr[s.length()] = low;
	return arr;
}
	
	public static void main(String[] args) throws Exception {
		int[] res=increaseOrDecrease("IDID");
		for(int i=0;i<res.length;i++) {
			System.out.println(res[i]);
		}
	}

}
