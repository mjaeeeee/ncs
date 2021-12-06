// 선생님이 하신 방법.
public class cmnPrac {
	//필드 선언
/*	int x; 
	int y;
	int gcf;
	int lcf, lcm; //최대공약수와 최소공배수
	
	Common(){}
	Common(int x,int y){
		this.x=x;
		this.y=y;
		this.find2Number();
	}
	void find2Number() {
		int small=0;
		int big=0;
		if(this.x < this.y) {
			small=this.x;
			big=this.y;
		} else {
			small=this.y;
			big=this.x;
		}
// 반복이 여러번
//		for(int n=2; n < small; n++) {
//			if(small % n == 0 && big % n == 0) {
//				this.gcf=n;
//			}
//		}
		
// 반복이 3번
		this.gcf=1;
		for(int n=2; n < small; n++) {
			if(small % n == 0 && big % n == 0) {
				this.gcf=this.gcf*n;
				small=small/n;
				big=big/n;
				n=1;
				continue;
			}
		}
		this.lcm=(this.x*this.y)/this.gcf;
	}
	void showGCF(){
		System.out.println("최대공약수: "+this.gcf);
	}
	void showLCM(){
		System.out.println("최소공배수: "+this.lcm);
	}*/
}
