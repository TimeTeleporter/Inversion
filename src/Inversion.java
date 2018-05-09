
import java.awt.geom.Point2D;

//radius = 1;

public class Inversion {
    Vector vector = new Vector(0, 0);
    
    
    public Point2D.Double invert(Point2D.Double p, Point2D.Double m){
        Vector vp = new Vector(p);
        Vector vm = new Vector(m);
        
        Vector vpz = vp.to(vm).multiply(-1*
                1/vp.to(vm).absolute()*
                Math.sqrt(1/Math.pow((vp.to(vm)).absolute(), 2)));
        
        return vpz.toPoint();
    }
}
