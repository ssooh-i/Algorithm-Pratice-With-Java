//package study.BOJ;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.StringTokenizer;
//
////국영수
//public class s4_10825 {
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//
//		// 국어점수 내림차순 정렬하기
//		// 국어점수가 같으면 영어점수 오름차순으로 정렬하기
//		// 국어,영어 점수가 같으면 수학점수 내림차순으로 정렬하기
//		// 모두 같으면 이름이 사전순으로 오름차순으로 정렬
//
//		String[][] list = new String[N][4];// 사람 수 만큼 성적표
//
//		for (int i = 0; i < N; i++) {// 입력받기
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			list[i][0] = st.nextToken();// 이름
//			list[i][1] = st.nextToken();// 국어
//			list[i][2] = st.nextToken();// 영어
//			list[i][3] = st.nextToken();// 수학
//		}
//		for (int i = 0; i < N; i++) {
//			Arrays.sort(list[i][1], new Comparator<String>() {
//
//				@Override
//				public int compare(String o1, String o2) {
//
//					return Integer.parseInt(o1) - Integer.parseInt(o2);
//				}
//
//			});
//		}
//	}
//}
