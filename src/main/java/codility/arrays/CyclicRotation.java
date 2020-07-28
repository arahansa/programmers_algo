package codility.arrays;

import java.util.LinkedList;
import java.util.List;

public class CyclicRotation {

    static class Node{
        static Node NONE = new Node();
        private Node left;
        private Node right;
        private int num;
    }

    static class ListHolder {
        final private List<Integer> list= new LinkedList<>();

        public ListHolder(int[] A) {
            for(int elem : A){
                list.add(elem);
            }
        }

        public void process(){
            int last = list.size()-1;
            if(last > 0){
                Integer integer = list.get(last);
                list.remove(last);
                list.add(0, integer);
            }
        }

        public int[] getArray(){
            return list.stream().mapToInt(i->i).toArray();
        }

    }

    static class Solution {
        public int[] solution(int[] A, int K){
            ListHolder listHolder = new ListHolder(A);
            for(int i=0;i<K;i++){
                listHolder.process();
            }
            return listHolder.getArray();
        }
    }
}
