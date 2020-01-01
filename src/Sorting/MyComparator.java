package Sorting;

import java.util.Arrays;
import java.util.Comparator;

public class MyComparator implements Comparator<Point> {
    @Override
    public int compare(Point o1, Point o2) {
        return o2.getX() - o1.getY() ;
    }
}


class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
class Test {

    public static void main(String[] args) {
        Point[] points = {
                new Point(1,5),
                new Point(6,4),
                new Point(5,3)
        };

        Arrays.sort(points, new MyComparator());
        displayArray(points);
    }

    private static void displayArray(Point[] points) {
        for (Point aPoint: points)
            System.out.println("X - Y: " + aPoint.getX() + "-"+ aPoint.getY());
    }
}
