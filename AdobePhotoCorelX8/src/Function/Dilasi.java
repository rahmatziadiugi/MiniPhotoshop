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
public class Dilasi {
    public int[][] DilasiRes(int[][] img){
        int w=img.length;
        int h=img[0].length;
        
        int[][] temp = new int[w+2][h+2];
        
        for(int i=0; i<w; i++){
            for(int j=0; j<h; j++){
                temp[i+1][j+1] = img[i][j];
            }
        }
        
        int[][] temp2 = new int[w+2][h+2];
        
        for(int i=1; i<=w; i++){
            for(int j=1; j<=h; j++){
                if(temp[i][j]==255){
                    temp2[i][j]=255;
                    temp2[i-1][j]=255;
                    temp2[i][j-1]=255;
                    temp2[i][j+1]=255;
                    temp2[i+1][j]=255;
                }
            }
        }
        
        return temp2;
    }
}
