package codility;

public class BinaryGap {

    // 넘 대충했나
    static class StrHolder {
        private int gap = 0;
        private String rest;

        public StrHolder(String rest) {
            this.rest = rest;
        }

        public boolean isRemainStr(){
            int begin = rest.indexOf("10");
            int end = rest.indexOf("01", begin);
            if(begin == -1 || end == -1){
                return false;
            }
            // System.out.println("첫 begin :"+begin+", end :"+end);
            int calculgap = end - begin;

            if(calculgap > gap){
                gap = calculgap;
            }
            rest = rest.substring(end+2);
            return true;
        }

    }



    public int solution(int N) {
        String paramStr = Integer.toBinaryString(N);
        System.out.println(N +" 에 대한 param Str :"+paramStr);
        StrHolder strHolder = new StrHolder(paramStr);
        while(strHolder.isRemainStr()){}

        return strHolder.gap;
    }

    public static void main(String[] args) {
        BinaryGap binaryGap = new BinaryGap();
        int solution = binaryGap.solution(9);
        System.out.println("솔루션 ::");
        System.out.println(solution);

    }
}
