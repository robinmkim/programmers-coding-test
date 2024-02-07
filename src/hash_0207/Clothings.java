package hash_0207;

import java.util.ArrayList;
import java.util.HashMap;

public class Clothings {
    public static int solution(String[][] clothes){
        HashMap<String, Integer> clothesMap = new HashMap<>();
        ArrayList<String> clothesType = new ArrayList<>();

        int answer = 1;

        for(String[] e: clothes){
            if(!clothesMap.containsKey(e[1])){
                clothesMap.put(e[1], 1);
                clothesType.add(e[1]);
            } else {
                clothesMap.put(e[1], clothesMap.get(e[1]) + 1);
            }
        }

        for(String e: clothesType){
            answer *= clothesMap.get(e) + 1;
        }



        return answer - 1;
    }

    public static void main(String[] args){

    }
}
