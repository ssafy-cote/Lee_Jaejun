package p기능개발;
/*
 *  문제
 *  1. 기능이 speeds에 따라서 개발 진행
 *  2. 100이 완료되면 개발이 완료
 *  3. 앞에 기능이 완료되기 전에는 배포 불가능
 *  4. 배포 시점에 몇개가 같이 배포되는지 출력
 *  
 *  풀이
 *  1. 배열 2개 입력 받기 -> list로 변경
 *  2. progresses 리스트에 speeds를 더 해주기
 *  3. 가장 앞의 progress배열이 100이상 이 되면 뒤에 100 이상이 된 배열의 갯수 answer에 추가
 *  4. 100이된 리스트의 값들을 제거
 *  5. 리스트 크기가 0이되면 종료 후 answers출력
 */
import java.io.*;
import java.util.*;

public class Solution {
	public static int[] solution(int[] progresses, int[] speeds) {
		Integer[] temp1 = new Integer[progresses.length];
		Integer[] temp2 = new Integer[speeds.length];
		for(int i = 0;i<temp1.length;i++) {
			temp1[i] = progresses[i];
			temp2[i] = speeds[i];
		}
		List<Integer> progressList = new ArrayList<>(Arrays.asList(temp1));
		List<Integer> speedList = new ArrayList<>(Arrays.asList(temp2));
		List<Integer> answerList = new ArrayList<>();
		while(progressList.size()!=0) {
			for(int  i = 0;i<progressList.size();i++) {
				progressList.set(i, progressList.get(i)+speedList.get(i));
			}
			int count = 0;
			for(int i = 0;i<progressList.size();i++) {
				if(progressList.get(i)<100) break;
				count++;
			}
			for(int i = count-1;i>=0;i--) {
				progressList.remove(i);
				speedList.remove(i);
			}
			if(count!=0) answerList.add(count);
		}
        Integer[] answers = answerList.toArray(new Integer[answerList.size()]);
        int[] answer = new int[answers.length];
        for(int i = 0;i<answer.length;i++) {
        	answer[i] = answers[i];
        }
        return answer;
    }
	public static void main(String[] args) {
		int[] arr = solution(new int[] {93, 30, 55},new int[] {1, 30, 5});
	}
}
