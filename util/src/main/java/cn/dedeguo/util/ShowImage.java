package cn.dedeguo.util;


import java.awt.BorderLayout;
import java.net.URL;

import javax.swing.ImageIcon;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JPanel;

public class ShowImage extends JFrame {

    private static final long serialVersionUID = -6736454674070258636L;


    public ShowImage() {

        JPanel panel = new JPanel(new BorderLayout());

        JPanel panel2 = new JPanel(new BorderLayout());

        JPanel panel3 = new JPanel(new BorderLayout());

        String urlString = "D://MyEclipse 6.0//新建文件夹//Exam//bin//images//winter.jpg";

        JLabel label = new JLabel(new ImageIcon(urlString));

        URL url = getClass().getResource("/images/orz2.jpg");

        JLabel label2 = new JLabel(new ImageIcon(url));

        URL url2 = getClass().getResource("/images/orz.jpg");

        JLabel label3 = new JLabel(new ImageIcon(url2));

        panel.add(label, BorderLayout.CENTER);

        panel2.add(label2, BorderLayout.CENTER);

        panel3.add(label3, BorderLayout.CENTER);

        this.getContentPane().setLayout(new BorderLayout());

        this.getContentPane().add(panel, BorderLayout.CENTER);

        this.getContentPane().add(panel2, BorderLayout.SOUTH);

        this.getContentPane().add(panel3, BorderLayout.EAST);

        this.setSize(400, 300);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setTitle("显示图像");

        this.setVisible(true);

    }

    /**

     * @param args

     */

    public static void main(String[] args) {

// TODO Auto-generated method stub

        new ShowImage();

    }

}