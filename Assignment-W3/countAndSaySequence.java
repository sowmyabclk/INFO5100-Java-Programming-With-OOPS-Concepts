package AED.Assignment3;

public class countAndSaySequence {
	 public static void main(String[] args) 
	    { 
	        int value = 22;
	        			 
	        String sequence = (countAndSay(value)); 
	        System.out.println("sequence is "+sequence);
	    } 
	public static String countAndSay(int n) {
if(n<=0||n>30)
	throw new IllegalArgumentException();
    if (n == 1)     
    	return "1"; 
    if (n == 2)     
    	return "11"; 
  
 
      
    // Initialize previous term 
    String str = "11";  
    int i=3;
    while( i <= n)
    { 
        str += '@'; //to compare the last character
        System.out.println("String is "+str);
        int len = str.length(); 
  
        int cnt = 1; 
    
        String x = ""; 
                         
        char []arr = str.toCharArray(); 
        System.out.println("Character is "+arr);
          
        
      
        int j=1;
        while(j < len)
        {   
        	System.out.println("current chracter and the previous character "+arr[j] +arr[j-1]);
            if (arr[j] != arr[j - 1]) 
            { 
                // Append count of  
                // str[j-1] to temp 
                x += cnt + 0; 
  
                // Append str[j-1] 
                x += arr[j - 1]; 
  
                // Reset count 
                cnt = 1; 
                j++;
            } 
  
            // If matches, then increment  
            // count of matching characters 
            else {cnt++; 
            j++;
            }
        } 
  
        i++;
        str = x; 
    } 
  
    return str; 

}
}
