package AED.Assignment5;

public class MyIndexOutOfBoundException extends IndexOutOfBoundsException {

	int lowerBound;
	int upperBound;
	int index;
	
	public MyIndexOutOfBoundException(int index,int lowerBound,int upperBound) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		this.index = index;
	}

	@Override
	public String toString() {
		return "Error Message: Index: "+index+","+" "+"but Lower Bound: "+lowerBound+","+" "+"Upper Bound: "+upperBound;
	}
	
}
