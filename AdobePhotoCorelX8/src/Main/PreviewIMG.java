/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Someone-PC
 */
public class PreviewIMG extends Component{
    private BufferedImage img;
    
    public PreviewIMG(BufferedImage img){
        this.img = img;
    }
    
    public PreviewIMG(int[][] R, int[][] G, int[][] B){
        int width = R.length;
        int height = R[0].length;
        this.img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); 
        
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                Color c = new Color(R[j][i], G[j][i], B[j][i]);                
                this.img.setRGB(j,i,c.getRGB());
            }
        }
    }
    
    public PreviewIMG(int[][] Gray){
        int width = Gray.length;
        int height = Gray[0].length;
        this.img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); 
        
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                Color c = new Color(Gray[j][i], Gray[j][i], Gray[j][i]);
                this.img.setRGB(j,i,c.getRGB());
            }
        }
    }
    
    public void paint(Graphics g) {
        g.drawImage(this.img, 0, 0, null);        
    }
    
    public Dimension getPreferredSize() {
        if (img == null) {
             return new Dimension(640,640);
        } else {
           return new Dimension(img.getWidth(null), img.getHeight(null));
       }
    }
}
