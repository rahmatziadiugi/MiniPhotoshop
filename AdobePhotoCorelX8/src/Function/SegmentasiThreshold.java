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
public class SegmentasiThreshold {
    
    public int[][] threshold(int[][] img, int tresh){
        int x = img.length;
        int y = img[0].length;
        
        int[][] temp = new int[x][y];        
                
        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                if(img[i][j]<tresh){
                    temp[i][j]=255;
                }                
            }
        }
        return temp;
    }
}
