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
public class Brightness1 {
    // untuk penjumlahan dan pengurangan
    
    public int[][] BrightnessInc(int[][] img, int n){
        int[][] temp = img;
        for(int i=0; i<img.length; i++){
            for(int j=0; j<img[0].length; j++){
                temp[i][j] = setVal(img[i][j] + n);
            }
        }
        return temp;
    }
    
    public int[][] BrightnessDec(int[][] img, int n){
        int[][] temp = img;
        for(int i=0; i<img.length; i++){
            for(int j=0; j<img[0].length; j++){
                temp[i][j] = setVal(img[i][j] - n);
            }
        }
        return temp;
    }
    
    
    public int setVal(int value){
        if(value < 0) return 0;
        if(value > 255) return 255;
        return value;
    }    
}
