package sort;

import java.util.Arrays;

public class KNumber {


    public int[] parseArray(int[] arr, int begin, int end){
        int count = 0;
        int resultPos = 0;
        int[] result = new int[end-begin+1];
        for(int a : arr){
            count++;
            if(count >= begin && count <= end){
                result[resultPos] = a;
                resultPos++;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public int getNumber(int[] arr, int begin, int end, int pos){
        int[] result = parseArray(arr, begin, end);
        return result[pos-1];
    }


    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int pos = 0;
        for(int[] command : commands){
            answer[pos] = getNumber(array, command[0], command[1], command[2]);
            pos++;
        }
        return answer;
    }
}
