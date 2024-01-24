package 주식가격;
/*
 * 1.배열 입력
 * 2. 정답 배열 생성 + 리스트 생성
 * 3. 첫번째 값 리스트에 넣기
 * 2.배열 돌기
 * 	2.1. 리스트에 있는 값들과 비교하면서 더 작은 경우 해당 리스트의 인덱스 값에 정답 배열 값 ++
 * 	2.2. 더 큰경우 해당 리스트 값 10001로 변경
 * 3. 정답 배열 출력
 */
import java.io.*;
import java.util.*;

class Solution4 {
    static public int[] solution(int[] prices) {
    	int[] answer = new int[prices.length];
    	for(int i=1;i<prices.length;i++) {
    		for(int j = 0;j<i;j++) {
    			if(prices[j]>prices[i]) {
    				if(prices[j]!=10001) answer[j]++;
    				prices[j] =  10001;
    			}else {
    				answer[j]++;
    			}
    		}
    	}
        return answer;
    }
    public static void main(String[] args) {
    	int[] arr = {1, 2, 3, 2, 3, 1 };
		System.out.println(Arrays.toString(solution(arr)));
	}
}