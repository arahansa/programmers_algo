package hash;

import common.UnfinishedSolution;

import java.util.*;

public class UnfinishedRunner implements UnfinishedSolution {
    public void showArray(String msg, String[] participant){
        System.out.print(msg);
        for(int i=0;i<participant.length;i++){
            System.out.print(participant[i]+", ");
        }
        System.out.println("");
    }


    public String solution(String[] participant, String[] completion) {
        List<String> participantList = new ArrayList<>(Arrays.asList(participant));

        for (int i = 0; i < completion.length; i++) {
            participantList.remove(completion[i]);
        }
        String answer = participantList.get(0);
        return answer;
    }
}
