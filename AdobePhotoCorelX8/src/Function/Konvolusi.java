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
public class Konvolusi {
    
    public int[][] konvolusiResul(int[][] img, int[][] kernel){
        int[][] temp = img;
        int w=img.length;
        int h=img[0].length;
        int wk=kernel.length;
        int hk=kernel[0].length;
        int x = wk/2;
        int y = hk/2;
        
        for(int i=0; i<w; i++){
            for(int j=0; j<h; j++){
                int sum=0;                
                for(int a=0; a<wk; a++){
                    for(int b=0; b<hk; b++){
                        try{
                            sum += (img[i+a-x][j+b-y] * kernel[a][b]);
                        }catch(Exception e){
                            
                        }
                    }
                }
                temp[i][j]= setVal(sum);
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
