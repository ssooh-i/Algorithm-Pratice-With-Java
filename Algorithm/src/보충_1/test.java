package 보충_1;

public class test
{
    public static int isPrime(int num){
        for(int i=2;i<num;i++){
            if(num%i == 0){
                return 0;
            }
        }
        return 1;
    }
    
	public static void main(String[] args) {
		int num=100, cnt=0;
		for(int i=2;i<num;i++){
			System.out.println("cnt : "+cnt+", isPrime : "+isPrime(i)+", i:"+i);
		    cnt = cnt + isPrime(i);
		    System.out.println("cnt + isPrime("+i+") : "+cnt);
		}
		System.out.println("---결과---");
		System.out.println(cnt);
	}
}