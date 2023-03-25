public class Vertex{
    public double x;
    public double y;
    public double z;
    public Vertex(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public void calculateRotation(String orientation, double radians){
        double sin = Math.sin(radians);
        double cos = Math.cos(radians);
        double temp; //have to do this to prevent cube from shrinking due to sin and cos rounding
        if (orientation.equals("xy")){ //only x and y values will change
            temp = (cos*x) + (sin*y);
            y = (-sin*x) + (cos*y); 
            x = temp;
        }
        else if (orientation.equals("xz")){ //only x and z values will change
            temp = (cos*x) + (sin*z);
            z = (-sin*x) + (cos*z);
            x = temp;
        }
        else if (orientation.equals("yz")){ //only y and z values will change
            temp = (cos*y) + (sin*z);
            z = (-sin*y) + (cos*z);
            y = temp;
        }
    }
}