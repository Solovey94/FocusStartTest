import java.util.Comparator;

public class TriangleComparator implements Comparator<Triangle> {

    public int compare(Triangle t1, Triangle t2) {
        if (t1.getArea() == t2.getArea()) {
            return 0;
        }
        if (t1.getArea() > t2.getArea()) {
            return 1;
        } else {
            return -1;
        }
    }
}