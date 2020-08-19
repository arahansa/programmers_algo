package bruteforce;

import java.util.*;
import java.util.stream.Collectors;

public class PrimeNumber {



    static List<Integer> removeSpecificNum(List<Integer> l, int index) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < l.size(); i++) {
            if (i != index) {
                result.add(l.get(i));
            }
        }
        return result;
    }


    public static List<String> addList(List<Integer> list, boolean zeroCheck, int cipher) {
        if(cipher == 1 && list.size() == 1){
            return Arrays.asList(list.get(0).toString());
        }
        if(cipher < 1){
            return Collections.emptyList();
        }
        // System.out.println(zeroCheck+") 자릿수 : "+cipher+"를 다음의 숫자들과 만들어야함 :"+list);

        StringBuilder builder = new StringBuilder();
        List<String> result = new ArrayList<>();
        for (int j = 0; j < list.size(); j++) {
            Integer integer = list.get(j);
            if (zeroCheck && j == 0 && integer == 0) {
                continue;
            }
            List<Integer> integers = removeSpecificNum(list, j);
            // System.out.println("현재 숫자 :"+integer+", 나머지 숫자들 :"+integers);
            if (cipher == 2) {
                for (Integer ri : integers) {
                    builder.append(integer);
                    builder.append(ri);
                    result.add(builder.toString());
                    builder.setLength(0);
                }
            } else {
                List<String> strings = addList(integers, false, cipher-1);
                for (String s : strings) {
                    builder.append(integer);
                    builder.append(s);
                    result.add(builder.toString());
                    builder.setLength(0);
                }
            }
        }
        return result;
    }

    public static boolean isPrime2(int num) {

        if(num<=1){
            return false;
        }
        boolean result = true;
        int end = num/2;
        for(int i = 2; i <= end; i++) {
            if( num%i == 0) {
                result = false;
                break;
            } else {
                result = true;
            }
        }
        return result;
    }

    public int solution(String numbers) {
        char[] chars = numbers.toCharArray();

        List<Integer> list = new ArrayList<>();
        List<Integer> resultInt = new ArrayList<>();

        // 리스트로 변환
        for (char c : chars) {
            int i = Integer.parseInt(String.valueOf(c));
            list.add(i);
        }

        for (int i = 1; i <= list.size(); i++) {
            if (i == 1) {
                for (int j = 0; j < list.size(); j++) {
                    resultInt.add(list.get(j));
                }
            }

            if (i > 1){
                List<String> strings = addList(list, true, i);
                resultInt.addAll(strings.stream().map(Integer::parseInt).collect(Collectors.toList()));
            }


        }
        List<Integer> collect = resultInt.stream().distinct().filter(n -> isPrime2(n)).collect(Collectors.toList());
        // System.out.println("collect: "+collect);
        return collect.size();
    }

    public static void main(String[] args) {
        // 7843
        String s = "7843";
        char[] chars = s.toCharArray();

        List<Integer> list = new ArrayList<>();
        List<Integer> resultInt = new ArrayList<>();

        // 리스트로 변환
        for (char c : chars) {
            int i = Integer.parseInt(String.valueOf(c));
            list.add(i);
        }

        for (int i = 1; i <= list.size(); i++) {
            if (i == 1) {
                for (int j = 0; j < list.size(); j++) {
                    resultInt.add(list.get(j));
                }
            }

            if (i > 1){
                List<String> strings = addList(list, true, i);
                resultInt.addAll(strings.stream().map(Integer::parseInt).collect(Collectors.toList()));
            }


        }
        List<Integer> collect = resultInt.stream().distinct().filter(n -> isPrime2(n)).collect(Collectors.toList());
        // System.out.println("collect: "+collect);
        // System.out.println(collect.size());
        // System.out.println("resultInt");
        // System.out.println(resultInt);
    }
}
