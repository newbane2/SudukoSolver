/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Allan_PC
 */
public class SudokuBoard {
    
    private BufferedImage oImage = null;
    
    SudokuBoard(String fpath) {
        File jpegFile = new File(fpath);
        try {
            oImage = ImageIO.read(jpegFile);
        } catch(IOException e) {
            System.out.println("Exception reading image : " + fpath + " : " + e);
        }
    }
    
    public int getRGB(int x, int y) {
        return oImage.getRGB(x, y);
    }
    
    public void setRGB(int x, int y, int rgb) {
        oImage.setRGB(rgb, rgb, rgb);
    }
    
    //potentially renders mutators useless, idk if it's a good idea :shrug:
    public BufferedImage getImage() {
        return oImage;
    }
    
    public void applyBWThreshold(int threshold) {
        RGB rgb = new RGB();
        for(int r = 0; r < oImage.getWidth(); r++) {
            for(int c = 0; c < oImage.getHeight(); c++) {
                rgb.reset(oImage.getRGB(r, c));
                int avg = (rgb.getR() + rgb.getG() + rgb.getB()) / 3;
                avg = (avg > threshold) ? 255 : 0;
                rgb.setR(avg); rgb.setG(avg); rgb.setB(avg);
                oImage.setRGB(r, c, rgb.getRGB());
            }
        }
    }
    
    public void findCorners() {
        RGB rgb = new RGB();
        for(int r = 0; r < oImage.getWidth(); r++) {
            for(int c = 0; c < oImage.getHeight(); c++) {
                rgb.reset(oImage.getRGB(r, c));
                int avg = (rgb.getR() + rgb.getG() + rgb.getB()) / 3;
                rgb.setR(avg); rgb.setG(avg); rgb.setB(avg);
                oImage.setRGB(r, c, rgb.getRGB());
            }
        }
    }
    
    public void makeGrayScale() {
        RGB rgb = new RGB();
        for(int r = 0; r < oImage.getWidth(); r++) {
            for(int c = 0; c < oImage.getHeight(); c++) {
                rgb.reset(oImage.getRGB(r, c));
                int avg = (rgb.getR() + rgb.getG() + rgb.getB()) / 3;
                rgb.setR(avg); rgb.setG(avg); rgb.setB(avg);
                oImage.setRGB(r, c, rgb.getRGB());
            }
        }
    }
    
    public void saveImage(String fpath) {
        File jpegFile = new File(fpath);
        try {
            ImageIO.write(oImage, "jpg", jpegFile);
        } catch(IOException e) {
            System.out.println("Error saving file " + fpath + " : " + e);
        }
    }
}
