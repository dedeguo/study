package top.chende.kafka.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class FileChannelDemo {
    public static void main(String[] args) throws IOException {
       // FileChannel fileChannel=new FileChannel()
        File file = new File("test.zip");
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        FileChannel fileChannel = raf.getChannel();
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("", 1234));
        // 直接使用了transferTo()进行通道间的数据传输
        fileChannel.transferTo(0, fileChannel.size(), socketChannel);
    }
}
