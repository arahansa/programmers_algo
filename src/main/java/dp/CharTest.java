package dp;

public class CharTest {

    public static int countNumber(Character originChar){
        String cal = "(5555+55)";
        int count = 0;
        for (int i = 0; i < cal.length(); i++) {
            if (cal.charAt(i) == originChar) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {

        int a = 5;
        char c = (char)(a+'0');
        System.out.println(c);
        System.out.println(countNumber(c));
    }
}
