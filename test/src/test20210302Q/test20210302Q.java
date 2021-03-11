package test20210302Q;

public class test20210302Q {
	public static char[] keys = {'A', 'B','C','D','E'};
		public static void main(String[] args) {
			String example1 = getChangeString("A3D3D2B1C3A4"); //A3D3D2B1C3A4
			System.out.println(example1);
	}
		
	public static String getChangeString(String target) {
		char[]keys = {'A', 'B','C','D','E','A', 'B','C','D','E','A', 'B','C','D','E'};
		String imsi = "ABCDE";
		String result = "";
		String temp = "";
		//System.out.println(target.length());
		for (int i = 0; i <= target.length()-1; i+=2) {
			temp = target.substring(i, i+2);
			//System.out.println(temp);
			String gubun_char = temp.substring(0,1); 	//A3 의 A에 해당하는 부분
			String gubun_num_ = temp.substring(1);		//A3 의 3에 해당하는 부분
			//System.out.println(gubun_char+"/"+gubun_num_);
			int gubun_num = Integer.parseInt(gubun_num_);	//정수형으로 형변환 처리
			int k =imsi.indexOf(gubun_char);		//배열 속 gubun_char의 인덱스
			//System.out.println(keys[k+gubun_num]);
			result+=keys[k+gubun_num];			//문자열 연산 처리
			
		}
		
		
		return result;
		
		
		
		
		
		
	}
		
}
