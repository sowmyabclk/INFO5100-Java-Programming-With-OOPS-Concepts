package AED.Assignment4;

class MoodyClass{

public static void main(String[] args) {
	 Moody happy = new Happy();
	 Moody sad = new Sad();
		psychiatrist s = new psychiatrist();
		s.examine(happy);
		s.Observe(happy);
		s.examine(sad);
		s.Observe(sad);
		
	}
}

abstract class Moody {

 protected abstract String getMood();
 protected abstract void expressFeelings();
 public void queryMood() {
	 System.out.println("I Feel "+this.getMood() +" today");
 }
}
 
 class Sad extends Moody{

	@Override
	protected String getMood() {
		// TODO Auto-generated method stub
		return "sad";
	}

	@Override
	protected void expressFeelings() {
		System.out.println("'wah' 'boo woo'  'weep' 'sob' 'weep'");
		
	}
	
	public String toString() {
		return "Subject Cries a lot";
	}
	 
 }
 class Happy extends Moody{

	@Override
	protected String getMood() {
		// TODO Auto-generated method stub
		return "happy";
		
	}

	@Override
	protected void expressFeelings() {
		System.out.println("hehehehe...hahahaha...HAHAHAHAHA!");
	}
		public String toString() {
			return "Subject Laughs a lot";
				
	}
	 
 }
 
 class psychiatrist {
	 public void examine(Moody a) {
		System.out.println("How are you feeling today?");
		a.queryMood();
		a.expressFeelings();
	 }
	 public void Observe(Moody a) {
System.out.println("Observation :"+a.toString());
	 }
}
 


