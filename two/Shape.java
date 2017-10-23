package two;

import java.util.Scanner;
 
public class Shape {
    public static int count;
    public int order;
    public String name;
 
    public Shape() {
        count++;
    }
 
    public static Shape create() {
        Scanner input = new Scanner(System.in);
        System.out.println("1.Rectangle    2.Circle    3.Triangle");
        int type = input.nextInt();
        System.out.println("input the Shape'name");
        String name = input.next();
        Shape shape= null;
        switch (type) {
        case 1:
            shape= new Rectangle(name);
            break;
        case 2:
            shape= new Circle(name);
            break;
        case 3:
            shape= new Triangle(name);
            break;
        }
        System.out.println(name+" create successfully");
        return shape;
    }
 
    public static String judgeType(Shape a) {
        if (a instanceof Rectangle) {
            return "Rectangle";
        } else if (a instanceof Circle) {
            return "Circle";
        } else if (a instanceof Triangle) {
            return "Triangle";
        }
        return null;
    }
    public static void main(String[] args){
        Shape test= create();
        System.out.println(judgeType(test));
    }
}