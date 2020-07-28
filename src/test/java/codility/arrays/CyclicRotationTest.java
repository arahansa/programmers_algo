package codility.arrays;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CyclicRotationTest {

    @Test
    void show(){
        CyclicRotation.Solution solution = new CyclicRotation.Solution();
        int a[] = {3, 8, 9, 7, 6};
        int answwer[] = {9, 7, 6, 3, 8};
        assertThat(solution.solution(a, 3)).isEqualTo(answwer);

        int b[] = {};
        int[] solution1 = solution.solution(b, 1);
        for(int ss: solution1){
            System.out.println(ss);
        }
    }

}