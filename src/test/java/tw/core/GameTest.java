package tw.core;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.generator.AnswerGenerator;
import tw.core.generator.RandomIntGenerator;
import tw.core.model.GuessResult;

import static org.junit.Assert.assertEquals;

/**
 * 在GameTest文件中完成Game中对应的单元测试
 */


public class GameTest {
    private Game game;
    private Answer answer;
    private AnswerGenerator answerGenerator;
    private RandomIntGenerator randomIntGenerator;

    @Before
    public void setup(){
        randomIntGenerator = Mockito.mock(RandomIntGenerator.class);
        answerGenerator = new AnswerGenerator(randomIntGenerator);

        answer = new Answer();
    }

    @Test
    public void test_game_guess(){
        String random = "1 2 3 4";
        Mockito.when(randomIntGenerator.generateNums(9,4)).thenReturn(random);

        try {
            game = new Game(answerGenerator);
        }catch (OutOfRangeAnswerException e){
            assertEquals(e.getMessage(),"Answer format is incorrect");
        }

        answer = Answer.createAnswer("1 5 6 7");
        GuessResult guessResult = game.guess(answer);
        assertEquals("1A0B",guessResult.getResult());
        assertEquals(answer,guessResult.getInputAnswer());

        answer = Answer.createAnswer("2 4 7 8");
        guessResult = game.guess(answer);
        assertEquals("0A2B",guessResult.getResult());
        assertEquals(answer,guessResult.getInputAnswer());

        answer = Answer.createAnswer("0 3 2 4");
        guessResult = game.guess(answer);
        assertEquals("1A2B",guessResult.getResult());
        assertEquals(answer,guessResult.getInputAnswer());

        answer = Answer.createAnswer("5 6 7 8");
        guessResult = game.guess(answer);
        assertEquals("0A0B",guessResult.getResult());
        assertEquals(answer,guessResult.getInputAnswer());

        answer = Answer.createAnswer("4 3 2 1");
        guessResult = game.guess(answer);
        assertEquals("0A4B",guessResult.getResult());
        assertEquals(answer,guessResult.getInputAnswer());

        answer = Answer.createAnswer("1 2 3 4");
        guessResult = game.guess(answer);
        assertEquals("4A0B",guessResult.getResult());
        assertEquals(answer,guessResult.getInputAnswer());
    }

}
