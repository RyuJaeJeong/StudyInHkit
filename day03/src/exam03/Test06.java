package exam03;

public class Test06 {

	public static void main(String[] args) {
		int a = 5;
		if (a%2 == 0) {
			System.out.println("¦���Դϴ�");
		}else {
			System.out.println("Ȧ���Դϴ�.");
		}
		
//���ٴ� ǥ�ô� ��ȣ 2��, =�� ����־��¶�. 
		System.out.println("==���α׷� ����==");
		
		
		int b = 3;
				if(a+b==0) {
					System.out.println("1");
				}else {
					System.out.println("2");
				}
		
				String c = "5";
				if (c.equals("5")) {        //�߿���. 
					System.out.println("3");
				} else { 
					System.out.println("4");
				}  //���ڷ� ó���ϸ� �񱳿����ڸ� ������. 
				
				boolean bo = a>b;
				
				if (bo == true) {
					System.out.println("5");
				} else { 
					System.out.println("6");
				
				}
		
				
				
				if (a>3 && a>9) {
					System.out.println("T");
				} else {
					System.out.println("F");
				}	
				
		
		/*
		 * if (����)
   ���๮ 





if (����)(
  ���๮
)





*���� if�� <--> switch 

if (����) (
   ���๮
)  else(
   ���๮
)


if (����)  (
 ���๮
) else if (����) (
 ���๮
) else if (����) (
 ���๮
) else (
)
		 * */
		
		
		
		

	}

}
