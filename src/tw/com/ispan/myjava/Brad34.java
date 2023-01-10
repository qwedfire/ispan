package tw.com.ispan.myjava;

public class Brad34 {

	public static void main(String[] args) {
		Shape s1=new Rectangle(10,4);
		Shape s2=new Circle(10);
		System.out.println(s1.getArea());
		System.out.println(s2.getArea());
	}
}
interface Shape{
	double getperimeter();
	double getArea();
}
class Rectangle implements Shape{
	double w,h;
	public Rectangle(double w,double h) {
		this.w=w;
		this.h=h;
	}
	@Override
	public double getperimeter() {
		return (w+h)*2;
	}
	@Override
	public double getArea() {
		return w*h;
	}
	
}
class Circle implements Shape{
	public final static double PI=3.14;
	double r;
	public Circle(double r) {
		this.r=r;
	}
	@Override
	public double getperimeter() {
		return (r*2)*PI;
	}
	@Override
	public double getArea() {
		return r*r*PI;
	}
	
}
