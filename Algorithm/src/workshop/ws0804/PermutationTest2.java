package workshop.ws0804;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationTest2 {
	static int N, totalCnt, R;
	static int[] numbers, input;
	static boolean[] isSelected;
	
	//nPn : n개의 입력받은 수 중  n개를 모두 뽑아 순차적으로 나열한 것
	//nPr : n개의 입력받은 수 중 r개를 모두 뽑아 순차적으로 나열한 것(1<=r<=n)
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		//numbers = new int[N];
		numbers = new int[R];
		input = new int[N];
		isSelected = new boolean[N];//각 위치에 사용되는 수를 판별
		
		for(int i =0; i<N; i++ ) {
			input[i] = sc.nextInt();
		}
		
		perm(0);
		System.out.println("총 경우의 수: "+totalCnt);
	}
	
	//cnt+1번째에 해당하는 순열에 포함될 수 뽑기
	private static void perm(int cnt) { //cnt: 직전까지 뽑은 순열에 포함된 수의 개수
		
		if(cnt == R) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		
		//가능한 모든 수에 대해 시도(input 배열의 모든 수 시도
		for(int i = 0; i< N; i++) {//선택지
			//시도하는 수가 선택되었는 지 판단
			if(isSelected[i]) continue;
			//선택되지 않았다면 수를 사용
			numbers[cnt] = input[i];//실제 값이 있는 곳
			isSelected[i] = true;
			//다음수 뽑으러 가기
			perm(cnt+1);
			//사용했던 수에 대한 선택 되돌리기
			isSelected[i] = false;
			
			//numbers[cnt] = ,이런거 안하는 이유는 계속 덮어쓰는 중이라서
			
			
		}
	}

}
