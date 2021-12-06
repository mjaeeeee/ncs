import java.util.ArrayList;
//236 Page 까지 그 이후 public
public class Common {
	//필드선언
	int x; //12
	int y; //18
	int z; //2
	int max; //18
	int min; //12
	int SaveNum;

	Common(){}
	Common(int a,int b){
		x=a;
		y=b;
		z=2;
		if(x > y) {
			max=x;
			min=y;
		}else if(x < y) {
			max=y;
			min=x;
		}
		
//		while( z < min-1) {
//			if(min % z == 0 && max % z == 0) {
//				SaveNum=z;
//				x=max/z;
//				y=min/z;
//			}
//			z++;
//		}
		for(; z < min-1; z++) {
			if(max % z == 0 && min % z == 0) {
				SaveNum=z;
			}
		}
	}
	

	void showGCF(){ //최대공약수	
		System.out.println("최대공약수: "+SaveNum);
	}
	void showLCM(){ //최소공배수
		System.out.println("최소공배수: "+(min*max)/SaveNum);
	}
}

// 다른 방법.
//for(i = 2; i < q; i++) {
//    if(q % i == 0 && s % i == 0) {
//         a = i;
//      }
//   }