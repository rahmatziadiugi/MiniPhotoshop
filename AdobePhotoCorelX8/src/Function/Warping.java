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
public class Warping {
    //twirl effect
    private int[][] img;
    
    
    public int[][] twirlEffect(int[][] img){
        this.img = img;
        int x = img.length/2;
        int y = img[0].length/2;
        
        int[][] temp = img;
        
               
        
        return temp;
    }
    
    protected void transformInverse(int x, int y, float[] out) {
        float icentreX = img.length * Math.round(0.5f);
        float icentreY = img[0].length * Math.round(0.5f);
        
        float dx = x-icentreX;
        float dy = y-icentreY;
        float distance = dx*dx + dy*dy;
        
        float radius = Math.min(icentreX, icentreY);
        float radius2 = radius * radius;
        
        if (distance > radius2) {
                out[0] = x;
                out[1] = y;
        } else {
                distance = (float)Math.sqrt(distance);
//                float a = (float)Math.atan2(dy, dx) + angle * (radius-distance) / radius;
//                out[0] = icentreX + distance*(float)Math.cos(a);
//                out[1] = icentreY + distance*(float)Math.sin(a);
        }
    }
    
}
