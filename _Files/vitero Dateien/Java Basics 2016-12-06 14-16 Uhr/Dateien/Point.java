
public class Point implements Cloneable{
 
	Integer x;
        
        
	Point(int x) {
		
		this.x = x;
		
	}
 
	
 
	public static void main(String[] args) {
		
            try {
			Point a = new Point(1);
			Point b = (Point) a.clone(); // a.clone gibt Object zurück
                        
                        System.out.println(a);
                        System.out.println(b);
                        System.out.println(a.x);
                        System.out.println(b.x);
                        
                        System.out.println("--------------------------------------------------------------");
                        
                        b.x = 100000;
                        System.out.println(a.x);
                        System.out.println(b.x);
                        
                      
		} catch ( CloneNotSupportedException cnsE) {
			cnsE.printStackTrace();
		}
	}
}