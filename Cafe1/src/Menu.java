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
   //Ŭ���� ���(�ʵ�)
   private ArrayList<String>alMenu; // ���๮ ���� ������.
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
    // ������ : ����>����>�����ͺ��̽� 
      try {
         FileReader fr = new FileReader(f);
         BufferedReader br = new BufferedReader(fr);
         try {
            String line=br.readLine();
            while(line!=null) {
               String[] ar=line.split(",");
               this.alMenu.add(ar[0]); //���ڿ� �迭 ����
               this.alPrice.add(Integer.parseInt(ar[1])); //�����迭���� 
               line=br.readLine();
            }
         } catch (IOException e) {
            e.printStackTrace(); 
         }
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }

            //this.alPriceremove(1);
            //������ ���⼭��
       
      
       //�ʱ�
}
   public void display() { //��ȯ���� �����Ƿ� void
      //read
      for(int i=0; i<this.alMenu.size(); i++) {
         System.out.println((i+1)+"."+this.alMenu.get(i)+":"+this.alPrice.get(i));
      }
}
  private void guide() {//�߰���� etc.
      System.out.println("�Ŵ�����(X:����,C:�޴��߰�,U:�޴�����,D:�޴�����)");
   }
   private void add(String menu, int price){ //create
         this.alMenu.add(menu);
         this.alPrice.add(price);
         this.saveMenu(); //���Ͽ� ���� 
         
   }
   private void update(int menu_num, String sch, int price) { //upadte �޴�����
         this.alMenu.set(menu_num-1,sch);
         this.alPrice.set(menu_num-1,price); //�ε��� �ѹ��� �ϱ� ������ -1 ������Ѵ�. 
         this.saveMenu();
         //���Ͽ� ���� 
   }
   private void remove(int menu_num) { //Delete
         this.alMenu.remove(menu_num-1);
         this.alPrice.remove(menu_num-1);
         this.saveMenu();
         //���Ͽ� ����. 
      }
   private void saveMenu() {
      File f = new File("/Users/a000/Temp/menu.txt");
      try {
         FileWriter fw = new FileWriter(f);
         PrintWriter pw = new PrintWriter(fw);  //������ �ҷ��Ȱ� ���ÿ� ���� �� �� �ִ� �ڵ� 
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
            System.out.println("�޴��߰�");
            Scanner ms=new Scanner(System.in);
            System.out.println("�޴����� �Է��ϼ���.");
            Scanner s_price=new Scanner(System.in);
            String menuname=ms.nextLine();
            System.out.println("������ �Է��ϼ���.");
            int price=Integer.parseInt(ms.nextLine());
            this.add(menuname,price);
         }else if(sch.equals("U")) {
            System.out.println("�޴�����");
            Scanner ms=new Scanner(System.in);
            System.out.println("������ �޴����� ��ȣ�� �Է��ϼ���.");
            int menu_num=Integer.parseInt(ms.nextLine());
            System.out.println("������ �޴����� �Է��ϼ���.");
            sch=ms.nextLine();
            System.out.println("�ش� �޴����� ������ �Է��ϼ���.");
            int price=Integer.parseInt(ms.nextLine());
            update(menu_num,sch,price);
         }else if(sch.equals("D")){
            System.out.println("�޴�����");
            Scanner ms=new Scanner(System.in);
            int menu_num=Integer.parseInt(ms.nextLine());
            //�޴�����
             this.remove(menu_num);
         }else {
            System.out.println("��ɾ �ٽ� �Է��ϼ���.");
         }
       this.display(); //<<<<<
       sch=s.nextLine(); 
      }
   }
}