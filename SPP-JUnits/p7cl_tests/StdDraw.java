// fake
public class StdDraw {
    public static final int BLACK = -1;
    public static final int RED = -1;
    public static void polygon(double[] x, double[] y) {
        for (int i = 0; i < x.length; i++) System.out.println("(" + x[i] + ", " + y[i]+ ")");
    }
    public static void filledPolygon(double[] x, double[] y) {
        for (int i = 0; i < x.length; i++) System.out.println("(" + x[i] + ", " + y[i]+ ")");
    }
    public static void setXscale(int x, int y) {
        return;
    }
    public static void setYscale(int x, int y) {
        return;
    }
    public static void setPenRadius(double x) {
        return;
    }
    public static void setPenRadius() {
        return;
    }
    public static void setPenColor(int x) {
        return;
    }
}
