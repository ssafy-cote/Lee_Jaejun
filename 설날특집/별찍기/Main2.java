package b2447;
/*
 * 문제
 * 1. 3의 거듭 제곱의 형태로 수가 주어짐
 * 2. 가운데가 빈형태의 별을 찍어야함 -> 각 3의 거듭 제곱의 가운데 위치 마다 빈칸
 * 
 * 풀이
 * 1. 전체에 별을 찍는다고 가정
 * 2. n입력 받기 -> 3^k => k구하기
 * 3. if((i%3^j) == 3의 제곱 값 사이 && (j%3^j) == 3의 제곱값사이 ) => 가운데 위치이면 빈칸 출력
 * 
 * 시간 복잡도
 * 1. k가 8일 경우 -> 4천만 * 8 =>3억 2천
 */
import java.io.*;
import java.util.*;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = (int) Math.pow(N, 1.0/3.0);
		StringBuilder sb =  new StringBuilder();
		for(int i =0;i<N;i++) {
			A : for(int j = 0;j<N;j++) {
				for(int k = 1;k<=K;k++) {
//					if((i/((int) Math.pow(3, k))) + (i%((int) Math.pow(3, k))) >= (int) Math.pow(3, k-1) && (i/((int) Math.pow(3, k))) + (i%((int) Math.pow(3, k))) < ((int) Math.pow(3, k-1)) *2 && (j/((int) Math.pow(3, k))) + (j%((int) Math.pow(3, k))) >= (int) Math.pow(3, k-1) && (j/((int) Math.pow(3, k))) + (j%((int) Math.pow(3, k))) < ((int) Math.pow(3, k-1)) *2 ) {
					if((i%((int) Math.pow(3, k))) >= (int) Math.pow(3, k-1) && (i%((int) Math.pow(3, k))) < ((int) Math.pow(3, k-1)) *2 && (j%((int) Math.pow(3, k))) >= (int) Math.pow(3, k-1) && (j%((int) Math.pow(3, k))) < ((int) Math.pow(3, k-1)) *2 ) {
						sb.append(" ");
						continue A;
						}
					}
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
