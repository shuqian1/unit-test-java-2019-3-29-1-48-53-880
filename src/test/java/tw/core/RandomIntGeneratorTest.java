package tw.core;


import org.junit.Before;
import org.junit.Test;
import tw.core.generator.RandomIntGenerator;

import static org.junit.Assert.assertEquals;

/**
 * 在RandomIntGeneratorTest文件中完成RandomIntGenerator中对应的单元测试
 */
public class RandomIntGeneratorTest {
    private RandomIntGenerator randomIntGenerator;

    @Before
    public void setup(){
        randomIntGenerator = new RandomIntGenerator();
    }

    @Test
    public void when_nums_illegal(){
        try {
            randomIntGenerator.generateNums(2,9);
        }catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Can't ask for more numbers than are available");
        }

    }

}