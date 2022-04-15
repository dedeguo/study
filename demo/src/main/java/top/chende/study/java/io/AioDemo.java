package top.chende.study.java.io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AioDemo {
    public static void main(String[] args) {

        write();
    }

    public static void write(){
        String filePath="/Users/chende/IdeaProjects/tech-study/demo/src/main/resources/hello.txt";

        CompletionHandler<Integer, Object> handler = new CompletionHandler<Integer, Object>() {

            @Override
            public void completed(Integer result, Object attachment) {

                System.out.println("Attachment: " + attachment + " " + result
                        + " bytes written");
                System.out.println("CompletionHandler Thread ID: "
                        + Thread.currentThread().getId());
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                System.err.println("Attachment: " + attachment + " failed with:");
                exc.printStackTrace();
            }
        };

        try {
            AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(
                    Paths.get(filePath), StandardOpenOption.READ,
                    StandardOpenOption.WRITE, StandardOpenOption.CREATE);
            ByteBuffer bf=ByteBuffer.allocate(1000);
            bf.put("hello world".getBytes(StandardCharsets.UTF_8));
            System.out.println("Main Thread ID: " + Thread.currentThread().getId());
//            fileChannel.write(bf,0,"First Write",handler);
            fileChannel.write(ByteBuffer.wrap("Sample".getBytes()), 0, "First Write",
                    handler);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void read(){
        String filePath="/Users/chende/IdeaProjects/tech-study/demo/src/main/resources/hello.txt";

        Path file = Paths.get(filePath);
        try {
            AsynchronousFileChannel channel=AsynchronousFileChannel.open(file);
            ByteBuffer bf=ByteBuffer.allocate(100);

            Future<Integer> result =channel.read(bf,0);

            while (!result.isDone()){

                System.out.println("not read ready");
            }
            Integer b=result.get();
            System.out.println(new String( bf.array()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
