package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Top2493Procedure2 {

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("2493.txt"))));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer stt = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stt.nextToken());
            boolean notFound = true;
            for(int j = i -1; j > 0;j--){
                if(arr[j] >= arr[i]){
                    System.out.print((j+1));
                    notFound = false;
                    break;
                }
            }
            if(notFound)
                System.out.print(0);
        }
    }
}
