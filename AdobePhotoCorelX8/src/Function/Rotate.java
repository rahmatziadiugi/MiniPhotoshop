/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import java.util.Arrays;

/**
 *
 * @author Someone-PC
 */
public class Rotate {
    
    public int[][] rotate90CW(int[][] img){
        int w = img.length;
        int h = img[0].length;
        
        int[][] temp = new int[h][w];
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){                
                temp[i][j] = img[j][h-i-1];                
            }
        }
        
        return temp;
    }
    
    public int[][] rotate90CCW(int[][] img){
        int w = img.length;
        int h = img[0].length;
        
        int[][] temp = new int[h][w];
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){                
                temp[i][j] = img[w-j-1][i];
            }
        }
        
        return temp;
    }
    
    
    public int[][] rotateCW(int[][] img, int n){
        int[][] imgRot = img;
        int p = n/90;
        
        for(int i=0; i<p; i++){
            imgRot = rotate90CW(imgRot);
            n-=90;            
        }
        
        if(n==0){
            return imgRot;
        }else{
            int w0 = imgRot.length;
            int h0 = imgRot[0].length;

            int w1 = (int)Math.floor((Math.cos(Math.toRadians(n))*w0)+(Math.sin(Math.toRadians(n))*h0));
            int h1 = (int)Math.floor((Math.sin(Math.toRadians(n))*w0)+(Math.cos(Math.toRadians(n))*h0));
            
            int[][] temp = new int[w1][h1];
            
            double sinA = Math.sin(Math.toRadians(n));
            double cosA = Math.cos(Math.toRadians(n));
            int a, b, x, y;
            int xmin=0, ymin=0;
            
            int[][][] dest = new int[w0][h0][2];

            for(int i=0; i<w0; i++){
                for(int j=0; j<h0; j++){
                    
                    a = (int)((i*cosA)-(j*sinA));
                    b = (int)((i*sinA)+(j*cosA));
                    
                    dest[i][j][0]=a;
                    dest[i][j][1]=b;
                    
                    if(a<xmin)xmin=a;
                    if(b<ymin)ymin=b;
                    
                }
            }
            
            for(int i=0; i<w0; i++){
                for(int j=0; j<h0; j++){
                    x = dest[i][j][0] - xmin;
                    y = dest[i][j][1] - ymin;
                    temp[x][y] = imgRot[i][j];
                }
            }
            
            return temp;
        }            
    }
    
    public int[][] rotateCCW(int[][] img, int n){
        int[][] imgRot = img;
        int p = n/90;
        
        for(int i=0; i<p; i++){
            imgRot = rotate90CCW(imgRot);
            n-=90;
        }
        
        if(n==0){
            return imgRot;
        }else{
            int w0 = imgRot.length;
            int h0 = imgRot[0].length;

            int w1 = (int)Math.floor((Math.cos(Math.toRadians(n))*w0)+(Math.sin(Math.toRadians(n))*h0));
            int h1 = (int)Math.floor((Math.sin(Math.toRadians(n))*w0)+(Math.cos(Math.toRadians(n))*h0));

            int[][] temp = new int[w1][h1];
            
            double sinA = Math.sin(Math.toRadians(n));
            double cosA = Math.cos(Math.toRadians(n));
            int a, b, x, y;
            int xmin=0, ymin=0;
            
            int[][][] dest = new int[w0][h0][2];

            for(int i=0; i<w0; i++){
                for(int j=0; j<h0; j++){
                    
                    a = (int)((i*cosA)+(j*sinA));
                    b = (int)(-(i*sinA)+(j*cosA));
                    
                    dest[i][j][0]=a;
                    dest[i][j][1]=b;
                    
                    if(a<xmin)xmin=a;
                    if(b<ymin)ymin=b;
                    
                }
            }
            
            for(int i=0; i<w0; i++){
                for(int j=0; j<h0; j++){
                    x = dest[i][j][0] - xmin;
                    y = dest[i][j][1] - ymin;
                    temp[x][y] = imgRot[i][j];
                }
            }
            
            return temp;
        }
        
    }    
}
