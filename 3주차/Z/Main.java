package b1074;
/*
 * 문제
 * 1. 판크기(2^N * 2^N)의 N(최대 15) 입력, 찾는 위치 r, c 입력 -> 그냥 배열 입력값과 동일
 * 2. 2*2 z -> 2^2 2^2 z -> ... 순서로 이동
 * 3. r,c에 몇 번째로 오는지
 * 풀이
 * 1. 재귀함수 호출(N,r,c)
 * 재귀->그냥 for문이 빠름
 * 1. r이 2^N의 절반 값(2^N-1)보다 큰지 작은지 계산 -> 크면 + 2^(N*2-1)
 * 2. r이 2^N의 절반 값 보다 큰지 작은지 계산 -> 크면 + 2^(N*2-2)
 * 3. 각 r,c 2^N-1로 나머지 연산
 * 4. 재귀 호출(N-1,r나머지값,c나머지값)
 * 5. N이 0이면 리턴
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count =0 ;
		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		for(int n = N ; n>0;n--) {
			if(r/(int)Math.pow(2, n-1)>0) {
				count+=(int)Math.pow(2, (2*n)-1);
				r= r%(int)Math.pow(2, n-1);
			}
			if(c/(int)Math.pow(2, n-1)>0) {
				count+=(int)Math.pow(2, (2*n)-2);
				c= c%(int)Math.pow(2, n-1);
			}
		}
//		recur(N,r,c);
		System.out.println(count);
	}
	
//	public static void recur(int N, int r, int c) {
//		if(N==0) return;
//		if(r/(int)Math.pow(2, N-1)>0) {
//			count+=(int)Math.pow(2, (2*N)-1);
//			r= r%(int)Math.pow(2, N-1);
//		}
//		if(c/(int)Math.pow(2, N-1)>0) {
//			count+=(int)Math.pow(2, (2*N)-2);
//			c= c%(int)Math.pow(2, N-1);
//		}
//		recur(N-1,r,c);
//	}

}
