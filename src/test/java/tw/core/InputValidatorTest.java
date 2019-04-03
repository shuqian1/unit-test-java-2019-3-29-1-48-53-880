package tw.core;

import org.junit.Before;
import org.junit.Test;
import tw.validator.InputValidator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {

    private InputValidator inputValidator;

    @Before
    public void setup(){
        inputValidator = new InputValidator();
    }

    @Test
    public void when_input_right_return_true(){
        assertTrue(inputValidator.validate("1 2 3 4"));
    }

    @Test
    public void when_input_length_wrong_return_false(){
        assertFalse(inputValidator.validate("1 2 3"));
        assertFalse(inputValidator.validate("1 2 3 4 5"));
    }

    @Test
    public void when_input_range_wrong_return_false(){
        assertFalse(inputValidator.validate("1 2 3 12"));
    }

    @Test
    public void when_input_repeat_return_wrong(){
        assertFalse(inputValidator.validate("1 2 3 1"));
    }
}
