package b2447;
/*
 * 문제
 * 1. 3의 거듭 제곱의 형태로 수가 주어짐
 * 2. 가운데가 빈형태의 별을 찍어야함 -> 각 3의 거듭 제곱의 가운데 위치 마다 빈칸
 * 
 * 풀이
 * 1. 별찍기 판을 String Builder에 담기
 * 	1.1. 3 * 3 짜리 판을 짜기 -> 가운데가 비도록 설계
 * 	1.2. 3^k * 3^k 짜리 판을 짜기 -> sb에 담아 놓은 것을 3*3처럼
 * 	1.3. 계속 반복하기
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = (int) Math.pow(N, 1.0/3.0);
		StringBuilder answersb = new StringBuilder();
		answersb.append("*");
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		for(int k = 0;k<K;k++) {
			for(int l = 0;l<k;l++) {
				for(int m = 0;m<k;m++) {
					sb2.append(" ");
				}
				if(l!=k-1) sb2.append("\n");
			}
			
			for(int i = 0;i<3;i++) {
				for(int j = 0;j<3;j++) {
					if(i==1 && j==1) {
						sb1.append(sb2);
						continue;
					}
				sb1.append(answersb);
			}
				if(i!=2) sb1.append("\n");
		}
			answersb = sb1;
		}
		System.out.println(answersb);
	}
}
