
import java.awt.geom.Point2D;

/**
 *
 * @author immanuel.albrecht
 */
public class Vector {
    private double x;
    private double y;
    
    public Vector(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public Vector(Point2D.Double p){
        this(p.x, p.y);
    }
    
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public double scalarproduct(Vector w){
        return (w.x * x + w.y * y);
    }
    public double absolute(){
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
    public Vector multiply(double k){
        return new Vector(x*k, y*k);
    }
    public Vector to(Vector w){
        return new Vector(w.x - x, w.y - y);
    }
    public Point2D.Double toPoint(){
        return new Point2D.Double(x, y);
    }
}
