package boj;

import java.util.Scanner;

public class Recursive_17478 {
	/*static String recu(int n) {
		String str;
		for(int i =0; i<n; i++) {
			str = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\r\n" + 
					"\"재귀함수가 뭔가요?\"\r\n" + 
					"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\r\n" + 
					"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\r\n" + 
					"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
		}
		return str;*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		
		for(int i = 0; i<n; i++) {
			for(int k = 0; k<n;k++) {
				String add = "----";
				if(k == 0) {
					System.out.println("\"재귀함수가 뭔가요?\"\r\n" + 
							"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\r\n" + 
							"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\r\n" + 
							"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
				}if(k != 0) {
					for(int j = 1; j<n; j++) {
						add = add;
						System.out.println((add+"\"재귀함수가 뭔가요?\""));
						System.out.println(add+"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
						System.out.println(add+"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
						System.out.println(add+"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
					}
				}
				
			}
		}
		
			
		
	}
}
