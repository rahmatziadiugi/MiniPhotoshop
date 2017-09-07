/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Function.*;
import View.EditFieldView;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author Someone-PC
 */
//public class EditField implements ActionListener {
public class EditField{
    private String dir1;
    private String dir2;
    private EditFieldView view;
    private BufferedImage img;
    private LoadImg ArrImg;
    private RGBtoGrayscale ArrGray;
    private int width, height;
    
    private Color c;
    private int[][] R, G, B, Grayscale;
    
    public EditField(String dir){
        this.dir1 = dir;
        this.img = null;
        
        try {     
             img = ImageIO.read(new File(dir));
        } catch (IOException e) {

        }
        
        this.height = img.getHeight();
        this.width = img.getWidth();
        
        this.ArrImg = new LoadImg(this.img, this.width, this.height);
        this.R = ArrImg.getRedImg();
        this.G = ArrImg.getGreenImg();
        this.B = ArrImg.getBlueImg();
        
        this.ArrGray = new RGBtoGrayscale(this.R, this.G, this.B, this.width, this.height);
        this.Grayscale = this.ArrGray.getGrayImg();
        
        view = new EditFieldView(this.R, this.G, this.B, this.Grayscale);
        view.setVisible(true);
//        view.addListener(this);        
        view.setTitle("Adobe Photo Corel Draw Gimp Portable X8 CC");
        
        /*        
        you dont have to buy photoshop
        if you can make it by yourself
        *tap head*
        */
    }
    
    public int[][] getR(){
        return this.R;
    }
    
    public int[][] getG(){
        return this.G;
    }
    
    public int[][] getB(){
        return this.B;
    }
    
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        Object source = e.getSource();
////        if(source.equals(view.getPreviewRGB())) {
////            JFrame f = new JFrame("Preview RGB");
////            f.add(new PreviewIMG(this.R, this.G, this.B));
////            f.pack();
////            f.setVisible(true);
////        }else if(source.equals(view.getPreviewRGB())) {
////            JFrame f = new JFrame("Preview Grayscale");
////            f.add(new PreviewIMG(this.Grayscale));
////            f.pack();
////            f.setVisible(true);
////        }
//    }
}
