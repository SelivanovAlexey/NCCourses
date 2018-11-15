package oop2;

public class Main {
    public static void main(String[] args) {

        Ball ball = new Ball(5, 5, 4, 3, -5);
        Container square = new Container(0, 0, 20, 100);

        System.out.println(ball);
        System.out.println(square);
        System.out.println("\nBall in container: " + square.collides(ball));


        ball.move();
        System.out.println("\n" + ball);
        System.out.println("Ball in container: " + square.collides(ball) + "\n");

        ball.move();
        System.out.println("\n" + ball);
        System.out.println("Ball in container: " + square.collides(ball) + "\n");

        ball.move();
        System.out.println("\n" + ball);
        System.out.println("Ball in container: " + square.collides(ball) + "\n");

        ball.move();
        System.out.println("\n" + ball);
        System.out.println("Ball in container: " + square.collides(ball) + "\n");

        System.out.println("Changing parameters...");
        ball.setxDelta(-6);
        ball.setyDelta(20);

        ball.move();
        System.out.println("\n" + ball);
        System.out.println("Ball in container: " + square.collides(ball) + "\n");

        ball.move();
        System.out.println("\n" + ball);
        System.out.println("Ball in container: " + square.collides(ball) + "\n");

        System.out.println("Reflecting X direction");
        ball.reflectHorizontal();

        ball.move();
        System.out.println("\n" + ball);
        System.out.println("Ball in container: " + square.collides(ball) + "\n");

        ball.move();
        System.out.println("\n" + ball);
        System.out.println("Ball in container: " + square.collides(ball) + "\n");

        ball.move();
        System.out.println("\n" + ball);
        System.out.println("Ball in container: " + square.collides(ball) + "\n");

    }
}
