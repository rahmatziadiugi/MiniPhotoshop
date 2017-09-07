/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import java.awt.Paint;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Someone-PC
 */
public class Histogram {
    private int[][] R;
    private int[][] G;
    private int[][] B;
    private int[][] Grays;
    private int w;
    private int h;
    private BufferedImage img;
    private BufferedImage imgGray;
    private int[][] rgbEq=new int[3][256];
    private int[] grayEq=new int[256];
    
    public Histogram(int[][] R, int[][] G, int[][] B, int[][] Gray){
        this.R = R;
        this.G = G;
        this.B = B;
        this.Grays = Gray;
        this.w = R.length;
        this.h = R[0].length;
        
        int[][] arrRGB = new int[4][w*h];
        int[][] sumRGB = new int[4][256];
        float[][] cdfRGB = new float[4][256];
        
        arrRGB = getRGB();
        sumRGB = sumRGB(arrRGB);
        cdfRGB = cdfRGB(sumRGB);
        this.img = histEq(cdfRGB);
        this.imgGray = histEqGray();
        //print Histogram RGB
        writeHistogram(sumRGB);        
    }
    
    public BufferedImage getImgHist(){
        return this.img;
    }
    
    public BufferedImage getImgHistGray() {
        return this.imgGray;
    }
    
    public int[][] getRGB(){
        int[][] arrRGB = new int[4][w*h];
        
        int k = 0;
        for(int i=0; i<w; i++){
            for(int j=0; j<h; j++){
                arrRGB[0][k]=this.R[i][j];
                arrRGB[1][k]=this.G[i][j];
                arrRGB[2][k]=this.B[i][j];
                arrRGB[3][k]=this.Grays[i][j];
                k++;
            }
        }
        
        return arrRGB;
    }
    
    public int[][] sumRGB(int[][] arrRGB){
        int[][] rgbSum = new int[4][256]; int size = this.w*this.h;
        for(int k=0; k<256; k++){
            int sumR = 0; int sumG = 0; int sumB = 0; int sumGray = 0;
            for(int i=0; i<size; i++){if(arrRGB[0][i]==k)sumR++;}
            rgbSum[0][k]=sumR;
            for(int i=0; i<size; i++){if(arrRGB[1][i]==k)sumG++;}
            rgbSum[1][k]=sumG;
            for(int i=0; i<size; i++){if(arrRGB[2][i]==k)sumB++;}
            rgbSum[2][k]=sumB;
            for(int i=0; i<size; i++){if(arrRGB[3][i]==k)sumGray++;}
            rgbSum[3][k]=sumGray;
        }
        return rgbSum;        
    }
    
    public float[][] cdfRGB(int[][] rgbSum){
        float size = (w*h);
        float[][] rgbProb=new float [4][256];
        float[][] rgbCDF=new float [4][256];
        for(int i=0; i<256; i++){
            rgbProb[0][i]=(float)rgbSum[0][i]/size;
            rgbProb[1][i]=(float)rgbSum[1][i]/size;
            rgbProb[2][i]=(float)rgbSum[2][i]/size;
            rgbProb[3][i]=(float)rgbSum[2][i]/size;
        }
        float sumR=0,sumG=0,sumB=0,sumGray=0;
        for(int i=0; i<256; i++){
            sumR=sumR+rgbProb[0][i]; rgbCDF[0][i]=sumR;            
            sumG=sumG+rgbProb[1][i]; rgbCDF[1][i]=sumG;            
            sumB=sumB+rgbProb[2][i]; rgbCDF[2][i]=sumB;            
            sumGray=sumGray+rgbProb[3][i]; rgbCDF[2][i]=sumGray;            
        }
        return rgbCDF;        
    }
    
    public BufferedImage histEq(float[][] rgbCDF){
        BufferedImage imgEq=new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);        
        for(int i=0; i<256; i++){
            rgbEq[0][i]=Math.round(255*rgbCDF[0][i]);
            rgbEq[1][i]=Math.round(255*rgbCDF[1][i]);
            rgbEq[2][i]=Math.round(255*rgbCDF[2][i]);
            grayEq[i]=Math.round(255*rgbCDF[3][i]);
        }        
        int r=0; int g=0; int b=0; int gray=0;
        for(int i=0; i<w; i++){
            for(int j=0; j<h; j++){                
                r=this.R[i][j]; g=this.G[i][j]; b=this.B[i][j];
                
                r=rgbEq[0][r]; g=rgbEq[1][g]; b=rgbEq[2][b];
                
                Color c1= new Color(r,g,b);
                imgEq.setRGB(i, j, c1.getRGB());
            }
        }
        return imgEq;        
    }  
    
    public BufferedImage histEqGray(){
        BufferedImage imgEq=new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        int k = 0;
        for(int i=0; i<w; i++){
            for(int j=0; j<h; j++){                
                int gray=this.Grays[i][j];
                gray = grayEq[gray];
                                
                Color c1= new Color(gray, gray, gray);
                imgEq.setRGB(i, j, c1.getRGB());
            }
        }
        return imgEq;        
    }
    
    public void writeHistogram(int[][] sumRGB){
        BufferedWriter bw = null;
        FileWriter fw = null;
        
        try {
            fw = new FileWriter("HistogramResult.txt");
            bw = new BufferedWriter(fw);            
            
            for(int i=0; i<256; i++){
                String content = ("level "+i+
                        ":\tRed="+sumRGB[0][i]+
                        "\tGreen="+sumRGB[1][i]+
                        "\tBlue="+sumRGB[2][i]+
                        "\tGray="+sumRGB[3][i]+"\n");
                bw.write(content);
            }            
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)bw.close();
                if (fw != null)fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }	
    }
}
