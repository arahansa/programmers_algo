package baekjoon;

import java.util.Scanner;

public class Top2493Procedure {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        /*int n = 5;
        int[] arr = {6,9,5,7,4};*/


        for (int index = 0; index < n; index++) {
            arr[index] = scanner.nextInt();
        }
        scanner.close();

        for (int i = n - 1; i > 0; i--) {
            for(int j = i -1; j > 0;j--){
                if(arr[j] >= arr[i]){
                    arr[i] = (j+1);
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i != n - 1) {
                System.out.print(" ");
            }
        }
    }
}
