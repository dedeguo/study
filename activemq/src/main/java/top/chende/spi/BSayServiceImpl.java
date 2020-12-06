package top.chende.spi;

public class BSayServiceImpl implements SayService{
    @Override
    public String say(String word) {
        System.out.println("BSayServiceImpl"+word);
        return "BSayServiceImpl"+word;
    }
}
