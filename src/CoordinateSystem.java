import java.awt.Point;
import java.awt.geom.Point2D;

public class CoordinateSystem {

    private double minX;
    private double maxX;
    private double diffX;
    private double minY;
    private double maxY;
    private double diffY;

    private int canvasWidth, canvasHeight;
    
    
    public CoordinateSystem(int width, int height) {
    	this(width, height, -1, 1, -1, 1);
    }

    public CoordinateSystem(int width, int height, double minX, double maxX,
                             double minY, double maxY) {
    	this.canvasWidth  = width;
    	this.canvasHeight = height;
    	
        setKS(minX, maxX, minY, maxY);
    }

    public final void setKS(double minX, double maxX, double minY, double maxY) {
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;

        diffX = Math.abs(maxX - minX);
        diffY = Math.abs(maxY - minY);
    }

    public int toJavaX(double userX) {
        double xJava = Math.abs(userX - minX) * canvasWidth / diffX;
        
        return (new Double(xJava)).intValue();
    }

    public int toJavaY(double userY) {
        double yJava = Math.abs(userY - maxY) * canvasHeight / diffY;

        return (new Double(yJava)).intValue();
    }
    
    public Point toJava(Point2D p) {
        return new Point(toJavaX(p.getX()), toJavaY(p.getY()));
    }
    
    public int toJavaLengthX(double userLengthX) {
        return (new Double((canvasWidth * Math.abs(userLengthX)) / diffX)).intValue();
    }
    
    public int toJavaLengthY(double userLengthY) {
        return (new Double((canvasWidth * Math.abs(userLengthY)) / diffY)).intValue();
    }

    public double toUserX(int javaX) {
        double xUser = javaX * diffX / canvasWidth;
        
        return (minX < maxX) ? minX + xUser : minX - xUser;
    }

    public double toUserY(int javaY) {
        double yUser = javaY * diffY / canvasHeight;
        
        return (minY < maxY) ? maxY - yUser : maxY + yUser;
    }
    
    public double toUserLengthX(double javaLengthX) {
        return (diffX * Math.abs(javaLengthX)) / canvasWidth;
    }
    
    public double toUserLengthY(double javaLengthY) {
        return (diffY * Math.abs(javaLengthY)) / canvasWidth;
    }
    
    public Point2D.Double toUser(Point p) {
        return new Point2D.Double(toUserX(p.x), toUserY(p.y));
    }

    public double getStepX() {
        return diffX / canvasWidth;
    }

    public double getStepY() {
        return diffY / canvasHeight;
    }
}