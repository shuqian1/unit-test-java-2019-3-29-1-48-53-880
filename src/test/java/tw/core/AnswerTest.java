package tw.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {
    private Answer answer;

    @Before
    public void setup(){
        answer = new Answer();
    }

    @Test
    public void when_input_format_right_return_no_exception(){
        String input = "1 2 3 4";
        answer = Answer.createAnswer(input);
        try {
            answer.validate();
        }catch (OutOfRangeAnswerException e){
            assertEquals(e.getMessage(),"");
        }
    }

    @Test
    public void when_input_range_wrong_return_exception(){
        String input = "1 2 3 10";
        answer = Answer.createAnswer(input);
        try {
            answer.validate();
        }catch (OutOfRangeAnswerException e){
            assertEquals(e.getMessage(),"Answer format is incorrect");
        }
    }

    @Test
    public void when_input_length_wrong_return_exception(){
        String input = "1 2 3";
        answer = Answer.createAnswer(input);
        try {
            answer.validate();
        }catch (OutOfRangeAnswerException e){
            assertEquals(e.getMessage(),"Answer format is incorrect");
        }

        input = "1 2 3 4 5";
        answer = Answer.createAnswer(input);
        try {
            answer.validate();
        }catch (OutOfRangeAnswerException e){
            assertEquals(e.getMessage(),"Answer format is incorrect");
        }
    }

    @Test
    public void when_input_repeat_return_exception(){
        String input = "1 2 3 3";
        answer = Answer.createAnswer(input);
        try {
            answer.validate();
        }catch (OutOfRangeAnswerException e){
            assertEquals(e.getMessage(),"Answer format is incorrect");
        }
    }

    @Test
    public void test_check(){
        Answer actualAnswer = Answer.createAnswer("1 2 3 4");
        answer = Answer.createAnswer("1 5 6 7");
        assertEquals("1A0B",actualAnswer.check(answer).getValue());
        answer = Answer.createAnswer("2 4 7 8");
        assertEquals("0A2B",actualAnswer.check(answer).getValue());
        answer = Answer.createAnswer("0 3 2 4");
        assertEquals("1A2B",actualAnswer.check(answer).getValue());
        answer = Answer.createAnswer("5 6 7 8");
        assertEquals("0A0B",actualAnswer.check(answer).getValue());
        answer = Answer.createAnswer("4 3 2 1");
        assertEquals("0A4B",actualAnswer.check(answer).getValue());
        answer = Answer.createAnswer("1 2 3 4");
        assertEquals("4A0B",actualAnswer.check(answer).getValue());
    }
}