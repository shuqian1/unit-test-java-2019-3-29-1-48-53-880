package tw.core.generator;

import org.junit.Before;
import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;

import static org.junit.Assert.assertEquals;

/**
 * 在AnswerGeneratorTest文件中完成AnswerGenerator中对应的单元测试
 */
public class AnswerGeneratorTest {
    private AnswerGenerator answerGenerator;
    private RandomIntGenerator randomIntGenerator;

    @Before
    public void setup(){
        randomIntGenerator = new RandomIntGenerator();
        answerGenerator = new AnswerGenerator(randomIntGenerator);
    }

    @Test
    public void test_answer_generator(){
        try {
            answerGenerator.generate();
        } catch (OutOfRangeAnswerException e) {
            assertEquals(e.getMessage(),"Can't ask for more numbers than are available");
        }
    }
}

