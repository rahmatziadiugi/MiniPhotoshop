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
public class Zoom {
    
    public int[][] zoomIn(int[][] img, int scale){
        int[][] temp;
        
        int w0 = img.length;
        int h0 = img[0].length;
        int w1 = 2*w0-1;
        int h1 = 2*h0-1;
        
        temp = new int[w1][h1];
        
        for(int i=0; i<w0; i++){
            for(int j=0; j<h0; j++){
                temp[i+(i*scale)][j+(j*scale)] = img[i][j];                
                //Row wise zooming
                if(i!=w0-1)temp[i+(i*scale)+1][j+(j*scale)] = (img[i+1][j]+img[i][j])/2;;                
            }
        }        
        //Column wise zooming
        for(int i=0; i<w1; i++){
            for(int j=0; j<h0-1; j++){
                int j1 = j+1;
                temp[i][j+(j*scale)+1] = (temp[i][j1+(j1*scale)] + temp[i][j+(j*scale)])/2;                    
            }
        }
                
        return temp;
    }
    
    public int[][] zoomOut(int[][] img, int scale){
        int[][] temp;
                
        int w0 = img.length;
        int h0 = img[0].length;
        int w1 = w0/2;
        int h1 = h0/2;        
        
        if(w0%2==1)w0--;
        if(h0%2==1)h0--; 
        
        temp = new int[w1][h1];
        
        for(int i=0; i<w0; i+=2){
            for(int j=0; j<h0; j+=2){
                temp[i/2][j/2] = (img[i][j]+img[i+1][j]+img[i][j+1]+img[i+1][j+1])/4;
            }
        }
        
        return temp;
    }
}

