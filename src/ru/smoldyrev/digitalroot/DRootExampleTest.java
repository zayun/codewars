package ru.smoldyrev.digitalroot;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by SBT-Smoldyrev-EI on 02.11.2018.
 */
public class DRootExampleTest {
    @Test
    public void Tests() {
        assertEquals( "Nope!" , 7, DRoot.digital_root(16));
        assertEquals( "Nope!" , 6, DRoot.digital_root(456));
    }
}