package OOP1;

public class MyTriangle {

    private MyPoint v1;
    private MyPoint v2;
    private MyPoint v3;


    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        v1 = new MyPoint(x1, y1);
        v2 = new MyPoint(x2, y2);
        v3 = new MyPoint(x3, y3);

    }

    @Override
    public String toString() {
        return "MyTriangle{" +
                "v1=(" + v1.getX() + "," + v1.getY() + ")," +
                "v2=(" + v2.getX() + "," + v2.getY() + ")," +
                "v3=(" + v3.getX() + "," + v3.getY() + ")" +
                '}';
    }

    public double getPerimeter() {
        return v1.distance(v2) + v1.distance(v3) + v2.distance(v3);
    }

    public String getType() {
        double a = v1.distance(v2);
        double b = v1.distance(v3);
        double c = v2.distance(v3);
        String type;

        if (a == b && b == c) {
            type = "Equilateral";
        } else if (a == b || a == c || b == c) {
            type = "Isosceles";
        } else {
            type = "Scalene";
        }
        return type;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyTriangle)) return false;

        MyTriangle tr = (MyTriangle) o;
        return v1.equals(tr.v1) && v2.equals(tr.v2) && v3.equals(tr.v3);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + v1.hashCode();
        result = 31 * result + v2.hashCode();
        result = 31 * result + v3.hashCode();
        return result;
    }
}
