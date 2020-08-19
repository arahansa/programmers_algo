package stackque;

import common.TruckOverBridge;

import java.util.HashMap;
import java.util.Map;

public class SimpleTruckOverBridge implements TruckOverBridge {

    /**
     * 다리가 하는 일
     * 1) 가장 먼저 시간을 +1 초 시킨다
     * 2) 차량을 내보낸다
     * 3) 들어올 수 있는 차량이 있는지 묻는다.
     * 4) 들어올 수 있다면 받는다.
     */
    static class Bridge {
        // 길이
        final private Integer length;
        // 한계 하중
        final private int weight;
        // 시간 모델
        private int second = 1;
        // 현재 하중
        private int currentWeight = 0;
        // 트럭 장부
        final private Map<Integer, Integer> jangbu = new HashMap<>();

        public Bridge(int length, int weight) {
            this.length = length;
            this.weight = weight;
        }

        /**
         * 새로 트럭을 받는다. ( 하중을 올리고 이벤트 기록 )
         */
        public void accept(int truckWeight) {
            if (currentWeight + truckWeight <= weight) {
                System.out.println("truck :"+truckWeight+" , "+second+"초 에 입장합니다.");
                currentWeight += truckWeight;
                jangbu.put(second + length, truckWeight);
                plusTime();
            } else {
                plusTime();
                accept(truckWeight);
            }
        }

        /**
         * 트럭다리의 시간을 1초 흐르게 한다.
         */
        public void plusTime() {
            System.out.println(toString());
            second++;
            leaveTruckIfPossible();
        }

        /**
         * 현재 이벤트 시간에 기록된
         * 트럭나갈 기록이 있는지 묻는다.
         */
        private void leaveTruckIfPossible() {
            if (jangbu.get(second) != null) {
                currentWeight -= jangbu.get(second);
                System.out.println("현재 시간 "+second+",  나간 truck :"+jangbu.get(second));
                jangbu.remove(second);
            }
        }

        // 최종 시간 알기
        public int getSecond() {
            return second;
        }

        public boolean hasTruck(){
            return currentWeight != 0;
        }

        @Override
        public String toString() {
            return "다리의 현재 시간 :"+second+", 현재 무게 :"+currentWeight+", 차량장부 :"+jangbu;
        }
    }

    @Override
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Bridge bridge = new Bridge(bridge_length, weight);
        for(int truck : truck_weights){
            System.out.println("truck :"+truck+" 입장 여부 묻는 중");
            bridge.accept(truck);
        }
        // 마지막 트럭이 있다면 비워라
        while(bridge.hasTruck()){
            System.out.println("마지막 트럭 처리 중입니다.");
            bridge.plusTime();
        }
        return bridge.getSecond();
    }
}
