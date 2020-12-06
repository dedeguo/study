package top.chende.spi;

public class ASayServiceImpl implements SayService{
    @Override
    public String say(String word) {
        System.out.println("ASayServiceImpl"+word);
        return "ASayServiceImpl"+word;
    }
}
