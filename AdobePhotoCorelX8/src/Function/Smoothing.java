/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Someone-PC
 */
public class Smoothing {
    public int[][] smoothMean(int[][] img){
        int w = img.length;
        int h = img[0].length;
        
        int[][] temp = new int[w][h];
        
        for(int i=0; i<w; i++){
            for(int j=0; j<h; j++){
                int sum = 0;
                
                for(int a=0; a<3; a++){
                    for(int b=0; b<3; b++){
                        if((i-1)>=0 && (j-1)>=0 && (i+1)<w && (j+1)<h)
                            sum += img[i+a-1][j+b-1];
                    }
                }
                
                temp[i][j] = sum/9;
            }
        }
        
        return temp;
    }
    
    public int[][] smoothMedian(int[][] img){
        int w = img.length;
        int h = img[0].length;
        
        int[][] temp = new int[w][h];
        
        for(int i=0; i<w; i++){
            for(int j=0; j<h; j++){
                int[] bil = new int[9];
                int x = 0;
                
                for(int a=0; a<3; a++){
                    for(int b=0; b<3; b++){
                        if((i-1)>=0 && (j-1)>=0 && (i+1)<w && (j+1)<h){
                            bil[x] += img[i+a-1][j+b-1];
                        }else{
                            bil[x] = 0;
                        }
                        x++;
                    }
                }
                Arrays.sort(bil);
                temp[i][j] = bil[4];
            }
        }
        
        return temp;
    }
    
    public int[][] smoothModus(int[][] img){
        int w = img.length;
        int h = img[0].length;
        
        int[][] temp = new int[w][h];
        
        for(int i=0; i<w; i++){
            for(int j=0; j<h; j++){
                int sum = 0;
                
                int[] bil = new int[9];
                int x = 0;
                
                for(int a=0; a<3; a++){
                    for(int b=0; b<3; b++){
                        if((i-1)>=0 && (j-1)>=0 && (i+1)<w && (j+1)<h){
                            bil[x] += img[i+a-1][j+b-1];
                        }else{
                            bil[x] = 0;
                        }
                        x++;
                    }
                }
                
                x = -1; int max=-1;          
                for(int a=0; a<9; a++){
                    int n = 0;
                    for(int b=0; b<9; b++){
                        if(bil[a]==bil[b])n++;
                    }
                    if(n>x && n>1){
                        max = n;
                        x=a;
                    }
                }
                
                if(max<0){
                    temp[i][j] = bil[4];
                }else{
                    temp[i][j] = bil[x];
                }
            }
        }
        return temp;
    }
    
    public int findPos(int n, ArrayList<Integer> arr){
        int x = -1;
        for(int i=0; i<arr.size(); i++ ){
            if(arr.get(i).equals(n)){
                x = i;
            }
        }
        return x;
    }
}
