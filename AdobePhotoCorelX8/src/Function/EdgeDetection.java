/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

/**
 *
 * @author Someone-PC
 */
public class EdgeDetection {
    private int[][] kernel;
    
    public EdgeDetection(){
        this.kernel = new int[3][3];
        this.kernel[0][0] = 0;  this.kernel[1][0] = 1;  this.kernel[2][0] = 0;
        this.kernel[0][1] = 1;  this.kernel[1][1] = -4; this.kernel[2][1] = 1;
        this.kernel[0][2] = 0;  this.kernel[1][2] = 1;  this.kernel[2][2] = 0;
    }
    
    public int[][] getKernel(){
        return this.kernel;
    }
}
