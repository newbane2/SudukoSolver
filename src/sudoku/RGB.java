/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author Allan_PC
 * General purpose wrapper for BufferedImage RGB
 * RGB int = [alpha(8)][red(8)][green(8)][blue(8)]
 */
public class RGB {
    
    private int alpha, r, g, b;
    
    RGB() {
       alpha = 0; r = 0; g = 0; b = 0;
    }
    
    RGB(int rgb) {
        parseRGB(rgb);
    }
    
    RGB(int alpha, int r, int g, int b) {
        this.alpha = alpha;
        this.r = r;
        this.g = g;
        this.b = b;
        
        if(!verifyRGB(alpha, r, g, b)) 
            System.out.println("[WARNING] Invalid RGB vals!");
    }
    
    public int getRGB() {
        int ret = 0;
        ret |= (alpha << 24);
        ret |= (r << 16);
        ret |= (g << 8);
        ret |= b;
        return ret;
    }
    
    public int getAlpha() {
        return alpha;
    }
    
    public void setAlpha(int alpha) {
        this.alpha = alpha;
        if(!verifyAux(alpha))
            System.out.println("Invalid Alpha set " + alpha);
    }
    
    public int getR() {
        return r;
    }
    
    public void setR(int r) {
        this.r = r;
        if(!verifyAux(r))
            System.out.println("Invalid R set " + r);
    }
    
    public int getG() {
        return g;
    }
    
    public void setG(int g) {
        this.g = g;
        if(!verifyAux(g))
            System.out.println("Invalid Alpha set " + g);
    }
    
    public int getB() {
        return b;
    }
    
    public void setB(int b) {
        this.b = b;
        if(!verifyAux(b))
            System.out.println("Invalid Alpha set " + b);
    }
    
    public void reset(int rgb) {
        parseRGB(rgb);
    }
    
    private void parseRGB(int rgb) {
        alpha = (rgb >> 24) & 0xFF;
        r = (rgb >> 16) & 0xFF;
        g = (rgb >> 8) & 0xFF;
        b = (rgb) & 0xFF;
    }
    
    //just makes sure that the inputs are valid
    private boolean verifyRGB(int alpha, int r, int g, int b) {
        return verifyAux(alpha) && verifyAux(r) && verifyAux(g) && verifyAux(b);
    }
    
    private boolean verifyAux(int x) {
        return x < 256 && x >=0;
    }
}
