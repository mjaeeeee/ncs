import java.util.ArrayList;
import java.util.Scanner;

public class CafeControl1 {

	public static void main(String[] args) {
		 Menu menu=new Menu(); //�ν��Ͻ� 
	      Order order=new Order();
	      Scanner s= new Scanner(System.in);
	      System.out.println("�۾��� �����Ͻÿ�.(X:����,M:�޴�����,O:�ֹ�����,S:��������)");
	      String str=s.nextLine();
	      while(str.equals("X")==false){
	      if(str.equals("M")){
	         menu.Handling();
	      }else if(str.equals("O")){
	         order.Handling(menu);
	      }else if(str.equals("S")){
	         menu.display();
	      }else {
	         System.out.println("��ɾ �ٽ��Է��Ͻÿ�.");
	      }
	      System.out.println("�۾��� �����Ͻÿ�.(X:����,M:�޴�����,O:�ֹ�����,S:��������)");
	      str=s.nextLine();//�Է°��� �ٽ� �޾Ƶ��δ�.
	      }
	      System.out.println("���α׷� ����"); 
	   
	   }   
	
	   


	//���ѷ��� �Ⱥ����¹�
	//String str=s.nextLine()
	//while(str.equals("X")) {
//	     ~~�����ڵ�
	//str=s.nextLine()
	 
	//}
	      //�ٽ� �Է��� �޾ƾ��Ѵ�.
	      //"���α׷� ����"���
	      // "X"�� �Է��ϸ� "���α׷� ����"��� ���α׷� ����.
	      // "X"�� �ƴѵ���, ������ �ݺ�
	      // "M"�� �Է��ϸ� "�޴�����" ���.
	      // "O"�� �Է��ϸ� "�ֹ� ����" ���.
	      // "S"�� �Է��ϸ� "��������" ���.
	      // �̵����� �ƴϸ�, �ٽ� �Է°��� �޾Ƶ��δ�.
}



	


