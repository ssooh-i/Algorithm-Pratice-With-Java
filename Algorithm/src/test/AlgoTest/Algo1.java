package test.AlgoTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//SSAFY 알고리즘 스마트클럽
public class Algo1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());//신청한 동아리의 수
		int S = Integer.parseInt(st.nextToken());//팀원 3명의 능력합에 대한 스마트클럽 가입조건
		int M = Integer.parseInt(st.nextToken());//개인 능력치에 대한 스마트클럽 가입조건
		
		int[][] dong = new int[N][3];//신청한 동아리원 입력받을 배열
		ArrayList<Integer> club = new ArrayList<>();//조건에 만족하는 동아리원 추가할 리스트
		int cnt = 0; //스마트 클럽에 가입이 가능한 동아리 수 
		
		for(int i = 0; i<N; i++) { //스마트클럽에 신청한 동아리원 입력받기
			st = new StringTokenizer(br.readLine());//한줄 불러와서
			dong[i][0] = Integer.parseInt(st.nextToken());//하나씩 칸에 맞춰 값 대입하기
			dong[i][1] = Integer.parseInt(st.nextToken());
			dong[i][2] = Integer.parseInt(st.nextToken());
			
			int team = dong[i][0] + dong[i][1] + dong[i][2];//신청한 동아리원들의 합 
			if(team >= S) {//팀원3명의 능력합이 클럽 조건에 맞는 지 판단
				if(dong[i][0]>= M && dong[i][1]>= M && dong[i][2]>= M ) {//개인의 능력이 클럽 조건에 맞는지 판단
					club.add(dong[i][0]);
					club.add(dong[i][1]);
					club.add(dong[i][2]);
					cnt++;//가입 가능한 동아리수++
				}
			}
			//조건에 부합하지 않으면 pass
			continue;
		}
		
		//출력하기
		System.out.println(cnt);
		for(int a : club) {
			System.out.print(a+" ");
		}
		
	}
}

