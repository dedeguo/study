package top.chende;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import top.chende.spi.SayService;

import java.util.ServiceLoader;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
       ServiceLoader<SayService> services= ServiceLoader.load(SayService.class);

       for (SayService sayService:services){
           sayService.say("hello");
       }
    }


}
