package pskilltree;
/*
 * 문제
 * 1. 스킬이 주어짐 => 정해진 스킬에 따라 배워야함
 * 2. 스킬트리가 주어짐 => 정해진 스킬 순서가 지켜지지 않았으면 false
 * 3. 가능한 스킬트리의 갯수를 출력
 * 
 * 풀이
 * 1. skill입력 받기
 * 2. skill tree입력 받기
 * 3. skill tree를 순회
 * 	3.1. skill의 i~length-1까지 확인 -> 있으면 fail
 * 	3.2. skill의 0를 만나면 i를 증가
 * 4. 끝까지 도달하면 answer ++;
 *  
 */
public class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        A : for(String skillTree : skill_trees) {
        	int start=0;
        	for(int i = 0;i<skillTree.length();i++) {
        		if(skillTree.charAt(i)==skill.charAt(start)) start++;
        		if(start==skill.length()-1) {
        			answer++;
        			continue A;
        		}
        		for(int j = start+1;j<skill.length();j++) {
        			if(skillTree.charAt(i)==skill.charAt(j)) continue A;
        		}
        	}
        	answer++;
        }
        return answer;
    }
}
