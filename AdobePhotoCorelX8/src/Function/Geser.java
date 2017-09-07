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
public class Geser {
    
    //geser ke kiri
    public int[][] GeserL(int[][] img, int n){
        n = Math.abs(n);
        int w = img.length;
        int h = img[0].length;
        int[][] temp = new int[w][h];
        for(int i=0; i<w-n; i++){
            for(int j=0; j<h; j++){
                temp[i][j] = img[n+i][j];
            }
        }
        return temp;
    }
    
    //geser ke kanan
    public int[][] GeserR(int[][] img, int n){
        int w = img.length;
        int h = img[0].length;
        int[][] temp = new int[w][h];
        for(int i=0; i<w-n; i++){
            for(int j=0; j<h; j++){
                temp[n+i][j] = img[i][j];
            }
        }
        return temp;
    }
    
    //geser ke atas
    public int[][] GeserU(int[][] img, int n){
        int w = img.length;
        int h = img[0].length;
        int[][] temp = new int[w][h];
        for(int i=0; i<w; i++){
            for(int j=0; j<h-n; j++){
                temp[i][j] = img[i][n+j];
            }
        }
        return temp;
    }
    
    //geser ke bawah
    public int[][] GeserD(int[][] img, int n){
        n = Math.abs(n);
        int w = img.length;
        int h = img[0].length;
        int[][] temp = new int[w][h];
        for(int i=0; i<w; i++){
            for(int j=0; j<h-n; j++){
                temp[i][n+j] = img[i][j];
            }
        }
        return temp;
    }
}
