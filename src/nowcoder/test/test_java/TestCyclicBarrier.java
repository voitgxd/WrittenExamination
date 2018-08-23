package nowcoder.test.test_java;

import java.util.concurrent.CyclicBarrier;

public class TestCyclicBarrier {

    public static void main(String[] args) {
        CyclicBarrier cyclic = new CyclicBarrier(2);
        cyclic.reset();
    }
}
