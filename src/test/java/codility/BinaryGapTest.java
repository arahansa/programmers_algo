package codility;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BinaryGapTest {

    @Test
    void gap(){
        BinaryGap binaryGap= new BinaryGap();
        assertThat(binaryGap.solution(9)).isEqualTo(2);
        assertThat(binaryGap.solution(529)).isEqualTo(4);
        assertThat(binaryGap.solution(1041)).isEqualTo(5);
        assertThat(binaryGap.solution(15)).isEqualTo(0);
        assertThat(binaryGap.solution(32)).isEqualTo(0);
        assertThat(binaryGap.solution(328)).isEqualTo(2);
    }

}