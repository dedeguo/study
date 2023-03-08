package cn.dedeguo.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;
import javax.imageio.ImageIO;

public class ImageDemo {

    private static String imagePath="/Users/chende/IdeaProjects/tech-study/util/src/main/resources/aa.jpg";
    private static String imagePath2="/Users/chende/IdeaProjects/tech-study/util/src/main/resources";

    public static void main(String[] args) {
        // 读取图片
        try {
            BufferedImage bufImage = ImageIO.read(new File(imagePath));
            final int width = bufImage.getWidth();
            final int height = bufImage.getHeight();
            // 读取出图片的所有像素
            int[] rgbs = bufImage.getRGB(0, 0, width, height, null, 0, width);

            // 对图片的像素矩阵进行水平镜像
            for (int row = 0; row < height; row++) {
                for (int col = 0; col < width / 2; col++) {
                    int temp = rgbs[row * width + col];
                    rgbs[row * width + col] = rgbs[row * width + (width - 1 - col)];
                    rgbs[row * width + (width - 1 - col)] = temp;
                }
            }

            // 把水平镜像后的像素矩阵设置回 bufImage
            bufImage.setRGB(0, 0, width, height, rgbs, 0, width);

            // 把修改过的 bufImage 保存到本地
            ImageIO.write(bufImage, "JPEG", new File(imagePath2,"bb.jpg"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void test(String[] args) {
        File f = new File(
            "/Users/chende/IdeaProjects/tech-study/util/src/main/resources/base64str6.txt");
        System.out.println(f.exists());
        try {
            InputStream in = new FileInputStream(f);
            byte[] bytes = new byte[in.available()];
            in.read(bytes);
            Base64.Decoder decoder = Base64.getDecoder();
            byte[] imageBytes = decoder.decode(bytes);
            OutputStream out = new FileOutputStream("/Users/chende/IdeaProjects/tech-study/util/src/main/resources/base64str6.jpg");
            out.write(imageBytes);
            out.flush();
            out.close();
            in.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
