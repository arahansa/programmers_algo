package dp;

import java.util.*;
import java.util.stream.Collectors;

public class NExpression {

    public static int getNumberCipher(int number) {
        int cipher = 2;
        int init = 10;
        while (number / init > 1) {
            cipher++;
            init *= 10;
        }
        return cipher;
    }

    public static List<String> getOnes(int number){
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
        int number;
        String cal;
        int calSize;
        int origin;

        public Hang(int origin, int number) {
            this.number = number;
            this.cal = number+"";
            this.origin =origin;
            char c = ((char)(origin+'0'));
            this.calSize = countNumber(c);
        }

        public Hang(int origin, int level, int number, String cal) {
            this.origin = origin;
            this.level = level;
            this.number = number;
            this.cal = "("+cal+")";
            char c = ((char)(origin+'0'));
            this.calSize = countNumber(c);
        }


        public int countNumber(char originChar){
            int count = 0;
            for (int i = 0; i < cal.length(); i++) {
                if (cal.charAt(i) == originChar) {
                    count++;
                }
            }
            return count;
        }

        public boolean computable(Hang otherHang){
            return this.calSize + otherHang.calSize < 9;
        }

        public boolean joinAble(int target){
            boolean joinAble = true;
            if (this.calSize == 8 && this.number != target) {
                joinAble = false;
            }
            if(this.calSize == 7 && !getRecentHang(target)){
                joinAble = false;
            }
            return joinAble;
        }

        public boolean getRecentHang(int target){
            List<Hang> hangs = Arrays.asList(
                    new Hang(origin, this.level++, this.number + this.origin, this.cal + "+" + this.origin),
                    new Hang(origin, this.level++, this.number - this.origin, this.cal + "-" + this.origin),
                    new Hang(origin, this.level++, this.number * this.origin, this.cal + "*" + this.origin),
                    new Hang(origin, this.level++, this.number / this.origin, this.cal + "/" + this.origin)
            );
            return hangs.stream().filter(e->e.number == target).findAny().isPresent();
        }


        public List<Hang> compute(Hang otherHang){
            if(!this.computable(otherHang)){
                return Collections.emptyList();
            }
            List<Hang> list = new ArrayList<>();
            if(this.number + otherHang.number > 0){
                Hang hang = new Hang(origin, this.level + 1, this.number + otherHang.number, this.cal + "+" + otherHang.cal);
                list.add(hang);
            }
            if( (this.number * otherHang.number) > 0){
                Hang hang = new Hang(origin, this.level+1, this.number * otherHang.number, this.cal +"*"+otherHang.cal);
                list.add(hang);
            }
            if(this.number / otherHang.number > 0){
                Hang hang = new Hang(origin, this.level+1, this.number / otherHang.number, this.cal +"/"+otherHang.cal);
                list.add(hang);

            }
            if (number - otherHang.number != 0) {
                Hang hang = new Hang(origin, this.level + 1, number - otherHang.number, this.cal + "-" + otherHang.cal);
                list.add(hang);
            }
            return list;
        }

        @Override
        public String toString() {
            return "Hang{" +
                    "level=" + level +
                    ", number=" + number +
                    ", cal='" + cal + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Hang hang = (Hang) o;
            return level == hang.level &&
                    number == hang.number;
        }

        @Override
        public int hashCode() {
            return Objects.hash(level, number);
        }
    }

    static class HangHolder {
        private int origin;
        private int target;
        private List<Hang> hangs;
        private int level = 1;
        private boolean found = false;
        private Map<Integer, Hang> hangMap = new HashMap<>();


        public boolean isFound(){
            return this.found;
        }

        public HangHolder(int origin, int target) {
            this.origin = origin;
            this.target = target;
            List<String> ones = getOnes(getNumberCipher(target));
            this.hangs = ones.stream()
                    .map(Integer::parseInt)
                    .map(n -> n * origin).map(n-> new Hang(origin, n)).collect(Collectors.toList());
        }

        public List<Hang> getTargets(){
            return hangs.stream().filter(n -> n.number == target).collect(Collectors.toList());
        }

        public void breeding(){
            level++;
            List<Hang> addHang = new ArrayList<>();
            List<Hang> refinedHangs = new ArrayList<>();
            for(int i=0;i<hangs.size();i++){
                for(int j=0;j<hangs.size();j++){
                    Hang left = hangs.get(i);
                    Hang rightHang = hangs.get(j);
                    addHang.addAll(left.compute(rightHang));
                }
            }

            for(Hang hang : addHang){
                Hang mapHang = hangMap.get(hang.number);
                if(mapHang == null){
                    hangMap.put(hang.number, hang);
                    refinedHangs.add(hang);
                }else{
                    if(mapHang.calSize > hang.calSize){
                        hangMap.put(hang.number, hang);
                        refinedHangs.add(hang);
                        if(mapHang.level <= hang.level){
                            this.hangs.remove(mapHang);
                        }
                    }
                }
            }
            this.hangs.addAll(refinedHangs);
            this.found = refinedHangs.stream().filter(n-> n.number == target).findAny().isPresent();
        }

        @Override
        public String toString() {
            return "HangHolder{" +
                    "origin=" + origin +
                    ", target=" + target +
                    ", level=" + level +
                    ", hangSize=" + hangs.size() +
                    ", hangs=" + hangs +
                    '}';
        }

    }

    public int solution(int N, int number) {
        int answer = -1;

        HangHolder hangHolder = new HangHolder(N, number);
        while((!hangHolder.isFound()) && hangHolder.level < 9){
            hangHolder.breeding();
            // System.out.println(hangHolder);
        }
        List<Hang> targets = hangHolder.getTargets();
        if(targets.size() > 0){
            char c = (char)(N+'0');
            Optional<Hang> min = targets.stream().min(Comparator.comparing(e -> e.countNumber(c)));
            return min.get().countNumber(c);
        }
        return answer;
    }

    public static void main(String[] args) {
        int N = 4;
        int number = 17;

        NExpression nExpression = new NExpression();
        System.out.println(nExpression.solution(N, number));
    }
}

