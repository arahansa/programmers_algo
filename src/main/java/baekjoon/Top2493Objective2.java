package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Top2493Objective2 {

    static class Top {
        private int index;
        private int height;
        private int idxReceive;

        public void processSignals(List<Top> topList) {
            // System.out.println("들어온 top List :"+topList);

            List<Top> willRemoveTop = new LinkedList<>();
            for (Top otherTop : topList) {
                if (lightSignal(otherTop)) {
                    willRemoveTop.add(otherTop);
                }
            }
            topList.removeAll(willRemoveTop);

        }

        public boolean lightSignal(Top otherTop) {
            // System.out.println("other top height :"+otherTop.height+", this top height :"+this.height);
            if (this.height >= otherTop.getHeight()) {
                otherTop.receive(this.index);
                // System.out.println("other top height :"+otherTop.height +", received");
                return true;
            }
            return false;
        }

        public int getHeight() {
            return height;
        }

        public void receive(int index) {
            this.idxReceive = index;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Top top = (Top) o;
            return index == top.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index);
        }

        public Top(int index, int height) {
            this.index = index;
            this.height = height;
        }

        public void showReceiveSignals() {
            System.out.print(idxReceive);
        }

        @Override
        public String toString() {
            return "Top{" +
                    "height=" + height +
                    ", index=" + index +
                    '}';
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer stt = new StringTokenizer(br.readLine());
        // int n = 5;
        List<Top> topList = new ArrayList<>(n);
        for (int index = 1; index <= n; index++) {
            topList.add(new Top(index, Integer.parseInt(stt.nextToken())));
        }

        List<Top> lights = new LinkedList<>();
        for (int i = n - 1; i > 0; i--) {
            Top top = topList.get(i);
            lights.add(top);
            Top leftTop = topList.get(i - 1);
            // System.out.println("current Top :"+top.getHeight()+", left top :"+leftTop.getHeight()+", light : "+lights);
            leftTop.processSignals(lights);
            // System.out.println("===");
        }
        for (int i = 0; i < n; i++) {
            topList.get(i).showReceiveSignals();
            if (i != n - 1) {
                System.out.print(" ");
            }
        }
    }
}
