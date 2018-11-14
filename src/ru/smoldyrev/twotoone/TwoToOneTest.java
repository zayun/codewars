package ru.smoldyrev.twotoone;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by SBT-Smoldyrev-EI on 14.11.2018.
 */
public class TwoToOneTest {
    @Test
    public void test() {
        System.out.println("longest Fixed Tests");
        assertEquals("aehrsty", TwoToOne.longest("aretheyhere", "yestheyarehere"));
        assertEquals("abcdefghilnoprstu", TwoToOne.longest("loopingisfunbutdangerous", "lessdangerousthancoding"));
        assertEquals("acefghilmnoprstuy", TwoToOne.longest("inmanylanguages", "theresapairoffunctions"));
    }
}
