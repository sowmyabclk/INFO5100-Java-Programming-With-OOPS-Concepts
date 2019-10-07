package AED.Assignment4;

public class Shape {
	
	String name;
	double Perimeter;
	double area;
	
	public void draw() {
		System.out.println("Drawing "+ getName());
	}
	public String getName() {
		return getClass().getSimpleName();
	}
	
	public double getPerimeter() {
		return Perimeter;
	}
	
	
	public double getArea() {
		return area;
	}
	
}
	class Rectangle extends Shape {
		
		
		
		double width;
		double height;
		
	 Rectangle(double width,double height){
			this.width = width;
			this.height = height;
		}
	 public double getArea() {
			System.out.println(this.width*this.height);
			return this.width*this.height;
		}
	 public double getPerimeter() {
			System.out.println(2*(this.width+this.height));
			return 2*(this.width+this.height);
		}
	
	}
	
	class Circle extends Shape {
		
		double radius;
		
		Circle(double radius){
			this.radius = radius;
		}
		public double getArea() {
			System.out.println(Math.PI*this.radius*this.radius);
			return Math.PI*this.radius*this.radius;
		}
		public double getPerimeter() {
			System.out.println(2*Math.PI*this.radius);
			return 2*Math.PI*this.radius;
		}
		
		
	}
		
		class Square extends Shape {
			double side;
			
			Square(double side){
				this.side = side;
			}
			public double getArea() {
				System.out.println(this.side*this.side);
				return this.side*this.side;
			}
			public double getPerimeter() {
				System.out.println(4*this.side);
				return 4*this.side;
			}
			
		}

