package hash_0206;

import java.util.HashMap;

//문제 설명
//
//수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
//마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
//
//제한사항
//
//마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
//completion의 길이는 participant의 길이보다 1 작습니다.
//참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
//참가자 중에는 동명이인이 있을 수 있습니다.

public class MarathonRunner {

    public static String solution(String[] participant, String[] completion){
        HashMap<String, Integer> participantMap = new HashMap<>();
        String answer = "";

        for (String e:participant){
            if (!participantMap.containsKey(e)){
                participantMap.put(e, 1);
            } else {
                participantMap.put(e, participantMap.get(e) + 1);
            }
        }

        for (String e:completion) {
            System.out.println(e + ": " + participantMap.get(e));

            participantMap.put(e, participantMap.get(e) - 1);
            if (participantMap.containsValue(1)) {
                System.out.println(answer);
            }
        }

        return answer;
    }


    public static void main(String arg[]){
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"kiki", "eden"};
        String answer = MarathonRunner.solution(participant, completion);

        System.out.println(answer);
    }
}
