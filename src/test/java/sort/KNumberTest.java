package sort;

import org.junit.jupiter.api.Test;

class KNumberTest {
    KNumber kNumber = new KNumber();
    int[] a = {1,5,2,6,3,7,4};
    int[][] command = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

    @Test
    void parseTest(){
        int[] ints = kNumber.parseArray(a, 2, 5);
        for(int b : ints){
            System.out.println(b);
        }
    }

    @Test
    void getNumber(){
        int number = kNumber.getNumber(a, 2, 5, 3);
        System.out.println(number);
    }

    @Test
    void solution(){
        int[] solution = kNumber.solution(a, command);
        System.out.println("결과");
        for(int a: solution){
            System.out.print(a);
        }
    }

}