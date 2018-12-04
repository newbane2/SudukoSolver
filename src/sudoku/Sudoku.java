/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;
/**
 *
 * @author Allan_PC
 */
public class Sudoku {
    
    public static void main(String[] args) {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        SudokuBoard board = new SudokuBoard("pics/2.jpg");
        //board.makeGrayScale();
        board.applyBWThreshold(170);
        board.saveImage("pics/2_outBW.jpg");
        System.out.println("done");
    }
}
