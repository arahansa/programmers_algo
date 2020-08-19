package stackque;

import common.TruckOverBridge;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleTruckOverBridgeTest {

    @Test
    void truck() {
        TruckOverBridge bridge = new SimpleTruckOverBridge();

        int[] a = {7,4,5,6};
        assertThat(bridge.solution(2, 10, a)).isEqualTo(8);
        int[] b = {10};
        assertThat(bridge.solution(100, 100, b)).isEqualTo(101);
        int[] c=  {10,10,10,10,10,10,10,10,10,10};
        assertThat(bridge.solution(100, 100, c)).isEqualTo(110);
    }

}