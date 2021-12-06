import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner; //Java\\Utll\\Scanner.class JDK<<

public class Menu {
   //클래스 멤버(필드)
   private ArrayList<String>alMenu; // 실행문 적지 않을것.
   private ArrayList<Integer>alPrice;

   public String getAlMenu(int ndx) {
	   return this.alMenu.get(ndx);
   }
   public int getAlPrice(int ndx) {
	   return this.alPrice.get(ndx);
   }
   
   
  public Menu(){
    this.alMenu=new ArrayList<String>();
    this.alPrice=new ArrayList<Integer>();

      
    File f = new File("/Users/a000/Temp/menu.txt");
    // 데이터 : 변수>파일>데이터베이스 
      try {
         FileReader fr = new FileReader(f);
         BufferedReader br = new BufferedReader(fr);
         try {
            String line=br.readLine();
            while(line!=null) {
               String[] ar=line.split(",");
               this.alMenu.add(ar[0]); //문자열 배열 선언
               this.alPrice.add(Integer.parseInt(ar[1])); //정수배열선언 
               line=br.readLine();
            }
         } catch (IOException e) {
            e.printStackTrace(); 
         }
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }

            //this.alPriceremove(1);
            //실행은 여기서만
       
      
       //초기
}
   public void display() { //반환값이 없으므로 void
      //read
      for(int i=0; i<this.alMenu.size(); i++) {
         System.out.println((i+1)+"."+this.alMenu.get(i)+":"+this.alPrice.get(i));
      }
}
  private void guide() {//추가기능 etc.
      System.out.println("매뉴관리(X:종료,C:메뉴추가,U:메뉴수정,D:메뉴삭제)");
   }
   private void add(String menu, int price){ //create
         this.alMenu.add(menu);
         this.alPrice.add(price);
         this.saveMenu(); //파일에 쓰기 
         
   }
   private void update(int menu_num, String sch, int price) { //upadte 메뉴수정
         this.alMenu.set(menu_num-1,sch);
         this.alPrice.set(menu_num-1,price); //인덱스 넘버로 하기 때문에 -1 해줘야한다. 
         this.saveMenu();
         //파일에 쓰기 
   }
   private void remove(int menu_num) { //Delete
         this.alMenu.remove(menu_num-1);
         this.alPrice.remove(menu_num-1);
         this.saveMenu();
         //파일에 쓰기. 
      }
   private void saveMenu() {
      File f = new File("/Users/a000/Temp/menu.txt");
      try {
         FileWriter fw = new FileWriter(f);
         PrintWriter pw = new PrintWriter(fw);  //파일을 불러옴과 동시에 쓰게 할 수 있는 코드 
         for(int i=0; i<this.alMenu.size(); i++) {
            pw.print(this.alMenu.get(i)+","+this.alPrice.get(i)+"\n");
         }
         pw.close();
      } catch (IOException e) { 
         e.printStackTrace();
      }
   }
  public void Handling() {//
      Scanner s= new Scanner(System.in);
      this.display(); // <<<<<<<<<<<<<<<<<<<
      this.guide();
      String sch=s.nextLine(); 
      while(sch.equals("X")==false){
         if(sch.equals("C")){
            System.out.println("메뉴추가");
            Scanner ms=new Scanner(System.in);
            System.out.println("메뉴명을 입력하세요.");
            Scanner s_price=new Scanner(System.in);
            String menuname=ms.nextLine();
            System.out.println("가격을 입력하세요.");
            int price=Integer.parseInt(ms.nextLine());
            this.add(menuname,price);
         }else if(sch.equals("U")) {
            System.out.println("메뉴수정");
            Scanner ms=new Scanner(System.in);
            System.out.println("수정할 메뉴명의 번호를 입력하세요.");
            int menu_num=Integer.parseInt(ms.nextLine());
            System.out.println("변경할 메뉴명을 입력하세요.");
            sch=ms.nextLine();
            System.out.println("해당 메뉴명의 가격을 입력하세요.");
            int price=Integer.parseInt(ms.nextLine());
            update(menu_num,sch,price);
         }else if(sch.equals("D")){
            System.out.println("메뉴삭제");
            Scanner ms=new Scanner(System.in);
            int menu_num=Integer.parseInt(ms.nextLine());
            //메뉴삭제
             this.remove(menu_num);
         }else {
            System.out.println("명령어를 다시 입력하세요.");
         }
       this.display(); //<<<<<
       sch=s.nextLine(); 
      }
   }
}