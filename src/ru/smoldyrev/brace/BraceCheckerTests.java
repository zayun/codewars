package ru.smoldyrev.brace;

/**
 * Created by SBT-Smoldyrev-EI on 02.11.2018.
 */
import static org.junit.Assert.*;
import org.junit.Test;

public class BraceCheckerTests {

    private BraceChecker checker = new BraceChecker();

    @Test
    public void testValid() {
        assertEquals(true, checker.isValid("()"));
    }

    @Test
    public void testInvalid() {
        assertEquals(false, checker.isValid("[(])"));
    }

}