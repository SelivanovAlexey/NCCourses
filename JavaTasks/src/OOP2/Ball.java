package OOP2;

public class Ball {

    private float x;
    private float y;
    private int radius;
    private float xDelta;
    private float yDelta;

    public Ball(float x, float y, int radius, int speed, int direction) {
        if (!(direction >= -180 && direction <= 180)) {
            throw new IllegalArgumentException("Direction must be more than -180 and less than 180");
        }
        this.x = x;
        this.y = y;
        this.radius = radius;
        xDelta = speed * (float) Math.cos(Math.toRadians(direction));
        yDelta = -speed * (float) Math.sin(Math.toRadians(direction));
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public float getxDelta() {
        return xDelta;
    }

    public void setxDelta(float xDelta) {
        this.xDelta = xDelta;
    }

    public float getyDelta() {
        return yDelta;
    }

    public void setyDelta(float yDelta) {
        this.yDelta = yDelta;
    }

    public void move() {
        x += xDelta;
        y += yDelta;
    }

    public void reflectHorizontal() {
        xDelta *= -1;
    }

    public void reflectVertical() {
        yDelta *= -1;
    }

    @Override
    public String toString() {
        return "Ball\t[(" + x +
                "," + y +
                "),radius = " + radius +
                ",speed=(" + xDelta +
                "," + yDelta +
                ")]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ball)) return false;

        Ball ball = (Ball) o;
        return x == ball.x && y == ball.y && radius == ball.radius
                && xDelta == ball.xDelta && yDelta == ball.yDelta;
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + Float.floatToIntBits(x);
        result = 31 * result + Float.floatToIntBits(y);
        result = 31 * result + radius;
        result = 31 * result + Float.floatToIntBits(xDelta);
        result = 31 * result + Float.floatToIntBits(yDelta);
        return result;
    }
}
