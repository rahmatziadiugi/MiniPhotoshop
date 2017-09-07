/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Someone-PC
 */
public class Lossy {
    private BufferedImage imgRGB;
    private BufferedImage imgGray;
    private String filename;
    
    public Lossy(int[][] R, int[][] G, int[][] B, int[][] gray, String filename){
        this.filename = filename;
        
        int w = gray.length;
        int h = gray[0].length;
        
        this.imgRGB = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        this.imgGray = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        
        Color c;
        for(int i=0; i<w; i++){
            for(int j=0; j<h; j++){
                int rVal = findLoss(R[i][j])*5;
                int gVal = findLoss(G[i][j])*5;
                int bVal = findLoss(B[i][j])*5;
                c = new Color(rVal, gVal, bVal);                
                this.imgRGB.setRGB(i,j,c.getRGB());
                int grayColor = findLoss(gray[i][j])*5;                                
                c = new Color(grayColor, grayColor, grayColor);                
                this.imgGray.setRGB(i,j,c.getRGB());
            }
        }
    }
    
    public void save() throws IOException{
            File outputfile = new File(filename+"Gray Lossy.jpg");
            ImageIO.write(imgGray, "jpg", outputfile);
            outputfile = new File(filename+"RGB Lossy.jpg");
            ImageIO.write(imgRGB, "jpg", outputfile);
    }
    
    public int findLoss(int val){
        return val/5;
    }
    
}


