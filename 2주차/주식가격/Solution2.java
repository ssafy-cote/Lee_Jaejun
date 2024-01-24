package 주식가격;
/*
 * 1.배열 입력
 * 2.배열 돌기
 *  2.1. list가 비어있으면 list에 인덱스 넣기 + temp값 업데이트
 *  2.2. temp값 보다 작으면 list에 있는 값의 길이+1 -index 만큼 할당
 * 	2.2. temp값 보다 크면 list에 넣기 + temp값 업데이트
 * 3. 배열 리턴
 */
import java.io.*;
import java.util.*;

class Solution2 {
    static public int[] solution(int[] prices) {
    	int[] answer = new int[prices.length];
    	List<Integer> tempList = new ArrayList();
    	int temp = -1;
    	int answerTemp = 0;
    	for(int i=0;i<prices.length;i++) {
    		if(tempList.size()==0) {
    			tempList.add(prices[i]);
    			temp = prices[i];
    			answerTemp = i;
    		}else {
    			if(temp<prices[i]) {
    				temp = prices[i];
    				tempList.add(temp);
    			}else {
    				for(int j =0 ;j<tempList.size();j++) {
    					answer[answerTemp+j] = (tempList.size()-j);
    				}
    				temp = prices[i];
    				tempList.clear();
    				tempList.add(temp);
    				answerTemp = i;
    			}
    		}
    	}
    	if(tempList.size()!=0) {
    		for(int j =0 ;j<tempList.size();j++) {
				answer[answerTemp+j] = (tempList.size()-j);
			}
    	}
        return answer;
    }
    public static void main(String[] args) {
    	int[] arr = {1, 2, 3, 2, 3};
		System.out.println(Arrays.toString(solution(arr)));
	}
}