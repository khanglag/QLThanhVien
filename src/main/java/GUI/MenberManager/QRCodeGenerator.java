///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package GUI.MenberManager;
//
//import com.google.zxing.BarcodeFormat;
//import com.google.zxing.MultiFormatWriter;
//import com.google.zxing.common.BitMatrix;
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.image.BufferedImage;
//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//
///**
// *
// * @author pc
// */
//public class QRCodeGenerator extends JFrame {
//    private static final int WIDTH = 300;
//    private static final int HEIGHT = 300;
//
//    public QRCodeGenerator() {
//        setTitle("QR Code Generator");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(WIDTH, HEIGHT);
//        setLocationRelativeTo(null);
//
//        try {
//            // Tạo một đối tượng BitMatrix từ chuỗi dữ liệu cần mã hóa
//            String data = "https://www.example.com"; // Thay thế bằng dữ liệu bạn muốn mã hóa
//            BitMatrix bitMatrix = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, WIDTH, HEIGHT);
//
//            // Tạo BufferedImage từ BitMatrix
//            int matrixWidth = bitMatrix.getWidth();
//            int matrixHeight = bitMatrix.getHeight();
//            BufferedImage image = new BufferedImage(matrixWidth, matrixHeight, BufferedImage.TYPE_INT_RGB);
//            for (int y = 0; y < matrixHeight; y++) {
//                for (int x = 0; x < matrixWidth; x++) {
//                    image.setRGB(x, y, bitMatrix.get(x, y) ? Color.BLACK.getRGB() : Color.WHITE.getRGB());
//                }
//            }
//
//            // Hiển thị hình ảnh trong JLabel
//            ImageIcon icon = new ImageIcon(image);
//            JLabel label = new JLabel(icon);
//            add(label, BorderLayout.CENTER);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
