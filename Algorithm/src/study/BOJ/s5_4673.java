package study.BOJ;

//셀프넘버
//생성자가 있는 수는 셀프넘버가 아니고 셀프넘버를 출력하면됨
//셀프 넘버가 아닌 수는 자신과 자신의 구성 숫자들을 1의 자리로 만들어 모두 더한 값
public class s5_4673 {
	public static void main(String[] args) {
	
		//true면 셀프넘버가 아닌 수
		boolean[] non = new boolean[10001];
		
		//1~10000까지 셀프넘버 찾기
		for(int i = 1; i< 10001; i++) {
			int n = selfNumber(i); //함수 불러오기
			
			if(n<10001) {//10000까지 수를 일단 true로 설정
				non[n] = true;
			}
		}
		
		//false인 self 인덱스만 출력
		for(int i = 1; i< 10001; i++) {
			if(!non[i]) {//false면 출력
				System.out.println(i);
			}
		}
		
	}

	private static int selfNumber(int i) {
		int sum = i;
		
		while(i != 0) {//i가 0이 아니면 더 나눠야함
			sum = sum +(i%10); //한단위씩 잘려서 나가는 거 더해주기
			i = i/10; //1의자리 컷
			//System.out.println("sum="+sum+", i="+i);
		}
		return sum;
	}

}
