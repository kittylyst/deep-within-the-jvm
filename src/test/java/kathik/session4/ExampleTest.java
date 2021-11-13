package kathik.session4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExampleTest {

    @Test
    @Deprecated
    public void test1() {
        System.out.println("In test1()");
        assertTrue(true);
    }

    @Test
    public void test2() {
        System.out.println("In test2()");
        assertTrue(false);
    }
}
