package hash_0207;

import java.util.Arrays;
import java.util.HashMap;

//문제 설명
//
//전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
//전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
//구조대 : 119
//박준영 : 97 674 223
//지영석 : 11 9552 4421
//전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
//
//제한 사항
//
//phone_book의 길이는 1 이상 1,000,000 이하입니다.
//각 전화번호의 길이는 1 이상 20 이하입니다.
//같은 전화번호가 중복해서 들어있지 않습니다.

public class PhoneNumList {
    public static boolean solution(String[] phoneBook){
        boolean answer = true;
        HashMap<String, Boolean> phoneMap = new HashMap<>();

        for (int i=0; i < phoneBook.length; i++){
            for (int j=i+1; j<phoneBook.length; j++){
                if(phoneBook[j].startsWith(phoneBook[i])) {
                    phoneMap.put(phoneBook[i], false);
                    break;
                } else {
                    phoneMap.put(phoneBook[i], true);
                }
            }
        }
        if(phoneMap.containsValue(false)){
            answer = false;
        }

        return answer;
    }

    public static boolean solution2(String[] phoneBook){
        for(int i=0; i<phoneBook.length-1; i++) {
            for(int j=i+1; j<phoneBook.length; j++) {
                if(phoneBook[i].startsWith(phoneBook[j])) {return false;}
                if(phoneBook[j].startsWith(phoneBook[i])) {return false;}
            }
        }
        return true;
    }
    // Array를 통한 정렬 후 다른것만 찾아보는 방법 Good!
    public static boolean solution3(String[] phoneBook){
        Arrays.sort(phoneBook);
        for (int i = 0; i < phoneBook.length -1; i++){
            if(phoneBook[i+1].startsWith(phoneBook[i])){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        String[] input = {"119", "97674223", "1195524421"};
        boolean result = PhoneNumList.solution3(input);
        System.out.println(result);
    }
}
