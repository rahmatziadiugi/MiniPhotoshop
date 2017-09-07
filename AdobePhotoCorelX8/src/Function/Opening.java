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
public class Opening {
//    imgErosion();
//    imgDilation();
    public int[][] OpeningRes(int[][] img){
        Dilasi dilasi = new Dilasi();
        Erosi erosi = new Erosi();        
        
        return dilasi.DilasiRes(erosi.ErosiRes(img));
    }
}
