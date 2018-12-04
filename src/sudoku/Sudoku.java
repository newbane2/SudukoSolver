/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Allan_PC
 */
public class Sudoku {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File jpegFile = new File("pics/1.jpg");
        try {
            BufferedImage image = ImageIO.read(jpegFile);
            System.out.println(image.getWidth() + " " + image.getHeight());
        } catch(IOException e) {
            System.out.println("Exception reading image : " + e);
        }
    }
    
}
