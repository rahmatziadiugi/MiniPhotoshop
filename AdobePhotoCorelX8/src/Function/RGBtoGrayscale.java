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
public class RGBtoGrayscale {
    
    private int[][] Grayscale;
    
    public RGBtoGrayscale(int[][] R, int[][] G, int[][] B, int w, int h){
        this.Grayscale = new int[w][h];
        for(int i=0; i<w; i++){
            for(int j=0; j<h; j++){
                this.Grayscale[i][j] = calcGray(R[i][j], G[i][j], B[i][j]);   
            }
        }        
        
    }
    
    public int calcGray(int r, int g, int b){
        return ((r+g+b)/3);
    }
    
    public int[][] getGrayImg(){
        return this.Grayscale;
    }
}
