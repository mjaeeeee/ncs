import java.util.ArrayList;
import java.util.Scanner;

public class CafeControl1 {

	public static void main(String[] args) {
		 Menu menu=new Menu(); //인스턴스 
	      Order order=new Order();
	      Scanner s= new Scanner(System.in);
	      System.out.println("작업을 선택하시오.(X:종료,M:메뉴관리,O:주문관리,S:실적관리)");
	      String str=s.nextLine();
	      while(str.equals("X")==false){
	      if(str.equals("M")){
	         menu.Handling();
	      }else if(str.equals("O")){
	         order.Handling(menu);
	      }else if(str.equals("S")){
	         menu.display();
	      }else {
	         System.out.println("명령어를 다시입력하시오.");
	      }
	      System.out.println("작업을 선택하시오.(X:종료,M:메뉴관리,O:주문관리,S:실적관리)");
	      str=s.nextLine();//입력값을 다시 받아들인다.
	      }
	      System.out.println("프로그램 종료"); 
	   
	   }   
	
	   


	//무한루프 안빠지는법
	//String str=s.nextLine()
	//while(str.equals("X")) {
//	     ~~실행코드
	//str=s.nextLine()
	 
	//}
	      //다시 입력을 받아야한다.
	      //"프로그램 시작"출력
	      // "X"를 입력하면 "프로그램 종료"출력 프로그램 종료.
	      // "X"가 아닌동안, 다음을 반복
	      // "M"를 입력하면 "메뉴관리" 출력.
	      // "O"를 입력하면 "주문 관리" 출력.
	      // "S"를 입력하면 "실적관리" 출력.
	      // 이도저도 아니면, 다시 입력값을 받아들인다.
}



	


