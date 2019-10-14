package AED.Assignment5;

public class ExceptionDriverClass {
	public static void main(String[] args) 
    { 
		
        int ar[] = {1, 2, 3, 4, 5}; 
      
        for (int i=0; i<=ar.length; i++) {
        	try{
        	if(i>=ar.length)
                throw new MyIndexOutOfBoundException(i, 0, ar.length-1);
        	}
        	catch(MyIndexOutOfBoundException ex) {
        		System.out.println(ex.toString());
        	}
        	/*char[] ch = new char[]{'H','I','l'};
        	for(int i1=0;i1<=ch.length;i1++) {
        		try {
        		if(i1>=ch.length)
        			throw new MyIndexOutOfBoundException(0, ch.length-1, i1);
        		}
        		
        		catch(MyIndexOutOfBoundException ex) {
            		System.out.println(ex.toString());

        	}*/
        
        	}

        
       
        }
}

        
       
     


