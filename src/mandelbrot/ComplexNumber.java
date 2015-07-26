
package mandelbrot;

public class ComplexNumber{
    
    //FIELDS
    double a, b; 
    
    public ComplexNumber(double x, double y){
        this.a = x;
        this.b = y;
    }
    
    public void display(){
        System.out.println( a + " + " + b + "i");
    }
    
    public ComplexNumber add(ComplexNumber c){
        double real = this.a + c.a;
        double image = this.b + c.b;
       
        return new ComplexNumber(real, image); 
    }
    
    public ComplexNumber sub(ComplexNumber c){
        double real = this.a - c.a;
        double image = this.b - c.b;
        
        return new ComplexNumber(real, image);
    }
    
    public ComplexNumber multCN(ComplexNumber c){
        double real = (this.a * c.a) - (this.b * c.b);
        double image = (this.a * c.b) + (this.b * c.a);
        
        return new ComplexNumber(real, image);
    }
    
    public double absValue(){
        double abs = Math.sqrt(Math.pow(this.a, 2) + Math.pow(this.b, 2));
        
        return abs;
    }
    
    public ComplexNumber conjugate(){
        return new ComplexNumber(this.a, -this.b);
    }
    
    public ComplexNumber multByScal(double d){
        double real = this.a * d;
        double image = this.b * d;
        
        return new ComplexNumber(real, image);
    }
    
    public ComplexNumber div(ComplexNumber c){
        ComplexNumber wBar = c.conjugate();
        double wAbs = c.absValue();
        
        ComplexNumber num = this.multCN(wBar);
        double denom = Math.pow(wAbs, 2);
        
        ComplexNumber ans = num.multByScal(1/denom);
        
        return ans;
    }
    
    public void printCN(ComplexNumber c){
        System.out.println(c.a + "+" + c.b + "i");
    }
    
    public ComplexNumber test(ComplexNumber c){
        ComplexNumber ans = (this.multCN(this)).add(c);
        return ans;
    }
}
