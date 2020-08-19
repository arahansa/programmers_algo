package dp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class NExpression {

    public int solution(int N, int number) {
        int answer = 0;
        return answer;
    }

    public int getNumberCipher(int number) {
        int cipher = 2;
        int init = 10;
        while (number / init > 1) {
            cipher++;
            init *= 10;
        }
        return cipher;
    }

    public List<String> getOnes(int number){
        List<String> l = new ArrayList<>();
        String a = "1";
        while(a.length() <= number){
            l.add(a);
            a += "1";
        }
        return l;
    }

    static class Hang {
        int level = 1;
        int number = 0;


        public Hang(int number) {
            this.number = number;
        }

        public Hang(int level, int number) {
            this.level = level;
            this.number = number;
        }

        static List<Hang> getHang(int number, int origin){
            List<Hang> list = new ArrayList<>();
            list.add(new Hang(number));
            list.add(new Hang(2, number*origin));
            list.add(new Hang(2, number/origin));
            list.add(new Hang(2, number+origin));
            if(number-origin != 0){
                list.add(new Hang(2, number-origin));
            }
            return list;
        }

        @Override
        public String toString() {
            return "Hang{" +
                    "level=" + level +
                    ", number=" + number +
                    '}';
        }
    }

    public static void main(String[] args) {
        int origin = 5;
        int target = 12;
        NExpression nExp = new NExpression();
        nExp.solution(origin, target);

        List<String> ones = nExp.getOnes(nExp.getNumberCipher(target));
        List<Hang> collect = ones.stream().map(Integer::parseInt)
                .map(n -> n * origin)
                .map(n -> Hang.getHang(n, origin)).flatMap(Collection::stream).collect(Collectors.toList());

        System.out.println(collect);
        for (int i = 1; i < 9; i++) {

        }
    }
}
