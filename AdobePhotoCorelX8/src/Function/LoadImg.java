/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author Someone-PC
 */
public class LoadImg {
    private Color c;
    private int[][] R, G, B;
    
    public LoadImg(BufferedImage img, int w, int h){
        this.R = new int[w][h];
        this.G = new int[w][h];
        this.B = new int[w][h];
                
        for(int i=0; i<w; i++){
            for(int j=0; j<h; j++){
                c = new Color(img.getRGB(i, j));
                this.R[i][j] = c.getRed();
                this.G[i][j] = c.getGreen();
                this.B[i][j] = c.getBlue();                
            }
        }
    }
    
    public int[][] getRedImg(){
        return this.R;
    }
    
    public int[][] getGreenImg(){
        return this.G;
    }
    
    public int[][] getBlueImg(){
        return this.B;
    }
}
