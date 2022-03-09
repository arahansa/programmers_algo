package baekjoon;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;
public class Top2493Solution {

    static class LightHouse{
        int index;
        int height;

        public LightHouse(int index, int height) {
            this.index = index;
            this.height = height;
        }

        @Override
        public String toString() {
            return "LightHouse{" +
                    "index=" + index +
                    ", height=" + height +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception, IOException {
        List<String> strings = new ArrayList<>();
        Stack<LightHouse> st = new Stack<>();
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("2493.txt"))));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer stt = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            int v = Integer.parseInt(stt.nextToken());
            System.out.println("등대값 :"+v);
            while (!st.isEmpty()) {
                if (st.peek().height >= v) {
                    System.out.print(st.peek().index + " ");
                    break;
                }
                st.pop();
            }
            if (st.isEmpty()) {
                System.out.print("0 ");
            }
            st.push(new LightHouse(i, v));
            System.out.println("stack  :"+st);
        }
    }
}
