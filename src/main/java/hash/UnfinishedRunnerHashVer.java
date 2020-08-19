package hash;

import common.UnfinishedSolution;

import java.util.HashMap;
import java.util.Map;

public class UnfinishedRunnerHashVer implements UnfinishedSolution {


    enum Action {
        UP(1), DOWN(-1);
        Integer number;
        Action(Integer num) {
            this.number = num;
        }
    }

    void handleMap(Map<String, Integer> result, String key, Action action) {
        Integer value = result.get(key);
        if (value == null) {
            result.put(key, action.number);
            return;
        }
        Integer processed = value + action.number;
        if (processed == 0) {
            result.remove(key);
        } else {
            result.put(key, processed);
        }
    }

    @Override
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> result = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            handleMap(result, participant[i], Action.UP);
            if (i < participant.length - 1)
                handleMap(result, completion[i], Action.DOWN);
        }
        return result.keySet().iterator().next();
    }
}
