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
import java.util.ArrayList;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;

/**
 *
 * @author Someone-PC
 */
public class Lossless {
    private BufferedImage imgRGB;
    private BufferedImage imgGray;
    private String filename;
    private int w;
    private int h;
    
    public Lossless(int[][] R, int[][] G, int[][] B, int[][] gray, String filename){
        this.filename = filename;
        
        this.w = gray.length;
        this.h = gray[0].length;
        
        ArrayList<Integer> compressed = compressThis(gray);
        ArrayList<Integer> compressedR = compressThis(R);
        ArrayList<Integer> compressedG = compressThis(G);
        ArrayList<Integer> compressedB = compressThis(B);
        
        this.imgGray = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        this.imgRGB = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        
        Color c;
        for(int i=0; i<w; i++){
            for(int j=0; j<h; j++){
                
                c = new Color(R[i][j], G[i][j], B[i][j]);
                this.imgRGB.setRGB(i,j,c.getRGB());
                c = new Color(gray[i][j], gray[i][j], gray[i][j]);
                this.imgGray.setRGB(i,j,c.getRGB());
            }
        }
    }
    
    public void save() throws IOException{
            File outputfileRGB = new File(filename+"RGB Lossless.jpg");
            File outputfileGray = new File(filename+"Gray Lossless.jpg");   
            
            ImageWriter writer = ImageIO.getImageWritersByFormatName("JPEG").next();
            JPEGImageWriteParam jpegParams = new JPEGImageWriteParam(null);

            jpegParams.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            jpegParams.setCompressionQuality(1f);

            writer.setOutput(ImageIO.createImageOutputStream(outputfileRGB));
            writer.write(null, new IIOImage(imgRGB,null,null), jpegParams);
            writer.dispose();
            
            writer = ImageIO.getImageWritersByFormatName("JPEG").next();
            jpegParams = new JPEGImageWriteParam(null);
            jpegParams.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            jpegParams.setCompressionQuality(1f);

            writer.setOutput(ImageIO.createImageOutputStream(outputfileGray));
            writer.write(null, new IIOImage(imgGray,null,null), jpegParams);
            writer.dispose();
    }
    
    public ArrayList<Integer> compressThis(int[][] img){
        ArrayList<Integer> temp = new ArrayList<>();
        int v = -1; int n = 0;
        for(int y=0; y<h; y++){
            for(int x=0; x<w; x++){
                if(n==0){
                    v = img[x][y]; n++;
                }else{
                    if(v==img[x][y]){
                        n++;
                    }else{
                        temp.add(v);
                        temp.add(n);
                        v = img[x][y];
                        n = 1;
                    }
                }
            }
        }
        return temp;
    }
}
