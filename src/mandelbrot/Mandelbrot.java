/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mandelbrot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class Mandelbrot extends JFrame{
    
    static ComplexNumber[][] mandelbrot = new ComplexNumber[400][400];
    static ComplexNumber[][] initial = new ComplexNumber[400][400];
    static boolean[][] mandelbrotBoolean = new boolean[400][400];
    int counter = 0;
    private BufferedImage bufferedImage = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);
    
    private void drawToImage() {

        Graphics2D G = (Graphics2D) bufferedImage.getGraphics();
        
        if (counter < 41){
            G.setColor( Color.getHSBColor(counter/(float)63, 1, 1 - counter/(float)42));
            
        }
        else{
            G.setColor(Color.black);
        }
        for (int a = 0; a < 400; a++){
                for (int b = 0; b < 400; b++){
                    if (!mandelbrotBoolean[a][b]) {
                        initial[a][b] = new ComplexNumber(a * 0.01 - 2, b * 0.01 - 2);
                        if (counter == 1) {
                            mandelbrot[a][b] = initial[a][b];
                        }
                        if (2 > mandelbrot[a][b].absValue()) {
                            G.fillRect(100 + a, 100 + b, 1, 1);
                            mandelbrot[a][b] = mandelbrot[a][b].test(initial[a][b]);
                        } else {
                            mandelbrotBoolean[a][b] = true;
                        }
                    }
                }
            }
    }
    
    public Mandelbrot(){
        for (int i = 0; i < 400; i++){
            for (int j = 0; j < 400; j++){
                mandelbrotBoolean[i][j] = false;
            }
        }
    }
    
    public void paint(Graphics g){
        g.drawImage(bufferedImage, 0, 0, this);
        drawToImage();
    }
    
    public static void sleep(int duration){
        try{
            Thread.sleep(duration);
        }
        catch (Exception e){
        }
    }
    
    public static void main(String[] args) {
        
        Mandelbrot myWindow = new Mandelbrot();
        
        myWindow.setTitle("Mandelbrot Set");
        myWindow.setSize(600, 600);
        myWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        myWindow.setVisible(true);
        
        while(myWindow.counter < 42){
            myWindow.repaint();
            myWindow.counter++;
            myWindow.sleep(300);
        }
    }
}
