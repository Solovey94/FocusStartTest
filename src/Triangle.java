import java.util.Comparator;

public class Triangle implements Comparable<Triangle> {

    private int coord_x1;
    private int coord_y1;
    private int coord_x2;
    private int coord_y2;
    private int coord_x3;
    private int coord_y3;
    private double area;

    private double sideFirst;
    private double sideSecond;
    private double sideThird;


    public Triangle(int[] coordinates) {
        this.coord_x1 = coordinates[0];
        this.coord_y1 = coordinates[1];
        this.coord_x2 = coordinates[2];
        this.coord_y2 = coordinates[3];
        this.coord_x3 = coordinates[4];
        this.coord_y3 = coordinates[5];
        sideFirst = Math.sqrt((coord_x1 - coord_x2) * (coord_x1 - coord_x2) + (coord_y1 - coord_y2) * (coord_y1 - coord_y2));
        sideSecond = Math.sqrt((coord_x1 - coord_x3) * (coord_x1 - coord_x3) + (coord_y1 - coord_y3) * (coord_y1 - coord_y3));
        sideThird = Math.sqrt((coord_x2 - coord_x3) * (coord_x2 - coord_x3) + (coord_y2 - coord_y3) * (coord_y2 - coord_y3));
    }

    // isIsoscelesTriangle() - проверка на равнобедренность
    public boolean isIsoscelesTriangle() {
        if (sideFirst == sideSecond || sideSecond == sideThird || sideFirst == sideThird) {
            return true;
        } else {
            return false;
        }
    }

    // getArea() - нахождение площади треугольника
    public double getArea() {
        double perimeter;

        perimeter = (sideFirst + sideSecond + sideThird) / 2;
        area = Math.sqrt(perimeter * (perimeter - sideFirst) * (perimeter - sideSecond) * (perimeter - sideThird));

        return area;
    }

    public int compareTo(Triangle anotherTriangle) {
        if (this.getArea() == anotherTriangle.getArea()) {
            return 0;
        } else if (this.getArea() < anotherTriangle.getArea()) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return Integer.toString(coord_x1) + " " + Integer.toString(coord_y1) + " " + Integer.toString(coord_x2) + " " + Integer.toString(coord_y1) + " " + Integer.toString(coord_x3) + " " + Integer.toString(coord_y3);
    }
    
}
