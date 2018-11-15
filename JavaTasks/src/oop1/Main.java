package oop1;

public class Main {
    public static void main(String[] args) {

        MyPoint p1 = new MyPoint(6,1);
        MyPoint p2 = new MyPoint(7,2);
        MyPoint p3 = new MyPoint(6,3);

        MyTriangle triangle = new MyTriangle(p1,p2,p3);
        System.out.println(p1.distance(p2) == p2.distance(p3));
        System.out.println(triangle.getType());

    }
}
