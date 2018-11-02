package ru.smoldyrev.kata.phone;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by SBT-Smoldyrev-EI on 02.11.2018.
 */
public class PhoneExampleTests {
    @Test
    public void tests() {
        assertEquals("(123) 456-7890", Kata.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }
}
