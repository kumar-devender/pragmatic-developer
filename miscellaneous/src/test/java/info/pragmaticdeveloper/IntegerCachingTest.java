package info.pragmaticdeveloper;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class IntegerCachingTest {

    @Test
    public void testIntegerAutoBoxingBetweenRangeMinus128AndPlus127IsCached() {
        Integer i1 = 127;
        Integer i2 = 127;
        assertThat(i1 == i2, is(true));

        i1 = -128;
        i2 = -128;
        assertThat(i1 == i2, is(true));
    }

    @Test
    public void testIntegerAutoBoxingOutsideRangeMinus128AndPlus127IsNotCached() {
        Integer i1 = 128;
        Integer i2 = 128;
        assertThat(i1 == i2, is(false));

        i1 = -129;
        i2 = -129;
        assertThat(i1 == i2, is(false));
    }

    @Test
    public void testIntegerObjectsAreNotCached() {
        Integer i1 = new Integer(10);
        Integer i2 = new Integer(10);
        assertThat(i1 == i2, is(false));
    }

    @Test
    public void testPrimitiveAddress() {
        int i = 10;
        System.out.println(i);
    }
}