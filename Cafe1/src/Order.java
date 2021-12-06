import java.util.ArrayList;
import java.util.Scanner;
public class Order {

  private ArrayList<String> mobile;
  private ArrayList<String> name;
  private ArrayList<Integer> qty;
  private ArrayList<Integer> sum;
  public Order(){
      mobile = new ArrayList<String>();
      name = new ArrayList<String>();
      sum = new ArrayList<Integer>();
      qty = new ArrayList<Integer>();
   }
  private void add(String new_menu, int new_qty,int new_sum) {
      
      this.name.add(new_menu);
      this.qty.add(new_qty);
      this.sum.add(new_sum);
      }

  private void remove(int menu_num) {
      int st_ndx=this.mobile.size();
      name.remove(menu_num-1+st_ndx);
      qty.remove(menu_num-1+st_ndx);
      sum.remove(menu_num-1+st_ndx);
   }
  private void update(int menu_num,String menu, int qt,int new_sum) {
      int st_ndx=this.mobile.size();
      this.name.set(menu_num-1+st_ndx, menu);
      this.qty.set(menu_num-1+st_ndx, qt);
      this.sum.set(menu_num-1+st_ndx, new_sum);
   }
  public void display1() {
      int st_ndx=this.mobile.size();
      for(int i=st_ndx;i<this.name.size();i++) {
         System.out.println((i+1)+
               " 메뉴명 : "+this.name.get(i)+" 수량 : "+this.qty.get(i)+
               " 총액 : "+this.sum.get(i));
      }int all_sum=0;
      for(int j=st_ndx;j<this.sum.size();j++) {
         all_sum+=this.sum.get(j);
      }
      System.out.println("총 가격 : "+all_sum);
   }
  public void display(String mobile) {
      int start_ndx=this.mobile.size();
      for(int i=this.mobile.size();i<this.name.size();i++) {
         this.mobile.add(mobile);   
      }
      
      for(int i=start_ndx;i<this.name.size();i++) {
         System.out.println((i+1)+" 번호 : " +this.mobile.get(i)+
               " 메뉴명 : "+this.name.get(i)+" 수량 : "+this.qty.get(i)+
               " 총액 : "+this.sum.get(i));
      }int all_sum=0;
      for(int j=start_ndx;j<this.sum.size();j++) {
         all_sum+=this.sum.get(j);
      }
      System.out.println("총 가격 : "+all_sum);
   }
  public void all_display() {
      for(int i=0;i<this.name.size();i++) {
         System.out.println((i+1)+" 번호 : " +this.mobile.get(i)+
               " 메뉴명 : "+this.name.get(i)+" 수량 : "+this.qty.get(i)+
               " 총액 : "+this.sum.get(i));
      }int all_sum=0;
      for(int j=0;j<this.sum.size();j++) {
         all_sum+=this.sum.get(j);
      }
      System.out.println("총 가격 : "+all_sum);
   }
  private void guide() {
      System.out.println("A:주문 추가, R:주문삭제, U:주문수정, T:주문내역 보기 Q:전체 주문내역 보기 G:주문 완료 X:뒤로가기");
   }
  
  public void Handling(Menu menu){
      menu.display();
      this.guide();
      Scanner cafe=new Scanner(System.in);   
      String st=cafe.nextLine();
      while(!st.equals("X")) {
         if(st.equals("A")) {
            Scanner ms=new Scanner(System.in);
            System.out.print("메뉴번호를 입력하시오 : ");
            int new_menu_num=ms.nextInt();
            String menu_name=menu.getAlMenu(new_menu_num-1);
            int menu_price=menu.getAlPrice(new_menu_num-1);
            System.out.print("수량을 입력하시오 : ");
            int new_qty=ms.nextInt();
            int new_sum=menu_price*new_qty;
            this.add(menu_name, new_qty, new_sum);
            System.out.println("현재 주문내역\n"+
                  " 메뉴명 : "+menu_name+" 수량 : "+new_qty+
                  " 총액 : "+new_sum);
         }
         else if(st.equals("R")) {
            Scanner ms=new Scanner(System.in);
            this.display1();
            System.out.print("삭제할 주문번호를 입력하시오 : ");
            int menu_num=ms.nextInt();
            this.remove(menu_num);
         }
         else if(st.equals("U")) {
            this.display1();
            Scanner ms=new Scanner(System.in);
            System.out.print("수정할 주문번호를 입력하시오 : ");
            int menu_num=ms.nextInt();
            menu.display();
            System.out.print("수정할 메뉴번호를 입력하시오 : ");
            int up_menu_num=ms.nextInt();
            String up_menu_name=menu.getAlMenu(up_menu_num-1);
            int up_menu_price=menu.getAlPrice(up_menu_num-1);
            System.out.print("수정할 수량을 입력하시오 : ");
            int up_qty=ms.nextInt();

            
            int up_sum = up_menu_price*up_qty;
            this.update(menu_num, up_menu_name, up_qty,up_sum);
            System.out.println("수정된 주문내역 \n번호 : "+
                  " 메뉴명 : "+up_menu_name+" 수량 : "+up_qty+
                  " 총액 : "+up_sum);
         }
         else if(st.equals("T")) {
            this.display1();
         }
         else if(st.equals("G")) {
            Scanner ms=new Scanner(System.in);
            this.display1();
            System.out.print("모바일 번호를 입력하시오 : ");
            String new_mobile=ms.next();
            this.display(new_mobile);
         }
         else if(st.equals("Q")) {
            this.all_display();
         }
         menu.display();
         this.guide();
         st=cafe.nextLine();
         
      }
   }
}