package exam02;

public class TotalMoney { public static void main(String[] args) {
	String name = "������";
	   int pay = 1000000;
       int bonus = pay*5;
       int total = pay*12 + bonus;
       
//      System.out.println(pay +bonus,total);
//       System.out.println(bonus);
//       System.out.println(total);

       
      String msg = "";
      msg = msg + "===============================\n";
      msg = msg + "�̸�\t";
      msg = msg + "����\t";	  
      msg = msg + "���ʽ�\t";
      msg = msg + "�ѿ�����\t\n";
      msg = msg + "===============================\n";
      msg = msg + name + "\t";
      msg = msg + pay + "\t";
      msg = msg + bonus + "\t";
      msg = msg + total + "\t\n";
      msg = msg + "===============================\n";
      
      System.out.println(msg);
      










			}

}
