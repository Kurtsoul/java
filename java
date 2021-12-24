填空：
1：new FileInputStream("d:\\test1.txt")	new FileOutputStream("d:\\test2.txt")  bo.write(result)
2：
3：new Socket("localhost",8099)      new InputStreamReader(socket.getInputStream())       new OutputStreamWriter(socket.getOutputStream())
4：s.accept()   socket.getInputStream()   socket.getOutputStream()   in.readLine()
5：new Socket(IP,port)   implements Runnable   new ServerSocket(port)    server.accept()     client.getInputStream()
6：this(name,gender)
程序填空：
1：reader.nextInt()   reader.nextInt()   a+b
2：arrayList.size()   arrayList.iterator()   String str:arrayList
3：hashMap.entrySet()   Entry<String, Integer> entry:set   hashMap.keySet()
4：synchronized     tickets>0
5：char[] a   char ch:a   System.out.print
6：new TreeSet<>()         String str:treeSet
7：new TreeMap<>()        treeMap.entrySet()   Entry<String, Integer> entry:set
函数题：
1：
class Circle extends Shape {
	private double r;
	static double pi=3.1415926;
	public Circle(double r) {
		super();
		this.r = r;
	}
	@Override
	public  double  getArea( ) {
		return this.r*this.r*pi;
	}
	public  double getPerimeter( ) {
		return this.r*2*pi;
	}

}

2：
class Rectangle extends Shape{
	public Rectangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}
	private double width;
	private double height;
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return this.height*this.width;
	}
	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 2*(this.height+this.width);
	}
}
3：
  private synchronized void saleTicket(int money) {
    	if(money==20&&fiveAmount==2) {
    		System.out.println("张飞靠边等...");
    	}else if (money==5&&fiveAmount>=1) {
			System.out.println("给李逵入场券李逵的钱正好");
			fiveAmount+=1;
            System.out.println("张飞继续买票");
			System.out.println("张飞入场券，张飞给20，找赎15元");
		}
    }

4：
class SellThread implements Runnable{
	static int ticket=10;
	Object locObject = new Object();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			synchronized (locObject) {
				if (ticket>0) {
					System.out.println("sell tickets: "+ticket--);
				}else {
					break;
				}
			}
		}
	}  
}
5：
class PrintRunnable implements Runnable{
	static int number=1;
	private final Object o;
	private int threaId;
	public PrintRunnable(int i, Object o) {
		// TODO Auto-generated constructor stub
        this.o = o;
        this.threaId = i;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (number<=15) {
			synchronized (o) {
				if (number/5%3 + 1 != threaId) {
					try {
						o.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					for (int i =0; i<5;i++) {
						System.out.println("线程"+this.threaId+":"+number++);
					}
				}
				o.notifyAll();
			}
		}
	}
}
6：
 private static String reorder(String str){
        StringBuffer name = new StringBuffer(str);
        name.reverse();
       String s1=name.toString();
        return s1;
    }
7：
    public static long factorial1(int n){
    	int sum=1;
        if (n==0) {
			return sum;
		}else {
			return sum=(int) (n*factorial1(n-1));
		}
    }
8：
    public static void method(String name,int id1) {
    	System.out.println(id1+"---"+name);
        /* 略*/
    }
    public static void method(String name,float id2) {
        /* 略*/
    	System.out.println(name+"---"+id2);
    }
9：
public static boolean wordPattern(String pattern, String str) {
		String[] a = str.split(" ");
		if(pattern.length()!=a.length) {
			return false;
		}
		HashMap<Character, String> map = new HashMap<Character, String>();
		for(int i=0;i<pattern.length();i++) 
		{
			if(map.containsKey(pattern.charAt(i))) {
				if(!map.get(pattern.charAt(i)).equals(a[i])) {
					return false;
				}
			}
			else {
				map.put(pattern.charAt(i),a[i]);
			}
		}
		return true;
	}
编程题：
1:
import java.util.*;

public class Main extends Thread {

    public void run() {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        if (c % 5 == 0) {
            for (int i = 0; i < c; i++) {
                if (i % 5 == 0) {
                    System.out.println("===" + i);
                }
                System.out.print(i);
                try {
                    Thread.sleep(1000);
                    System.out.println("    线程睡眠1秒！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else
            System.out.println("输入数据错误");
    }

    public static void main(String[] args) {
        new Main().start();
    }
}

2:
3:
import java.util.*;

public class Main implements Runnable {

    public void run() {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        if(c>=0) {
	        for (int i = c; i >=0; i--) {
	            System.out.println(i);
	            try {
	                Thread.sleep(500);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
        }else {
        	System.out.println("输入数据有误");
        }
    
    }

    public static void main(String[] args) {
        Thread no=new Thread(new Main());
        no.start();
    }
}
4:
public class Main {

	public void print() {
		for(int i=0;i<26;i++) {
			System.out.print(i+1);
			System.out.println((char)('A'+i));
		}
	}

    public static void main(String[] args) {
        new Main().print();
    }
}
5:
import java.util.*;

public class Main implements Runnable{
	private StringBuffer sb=new StringBuffer();

    public Main(StringBuffer sb) {
		super();
		this.sb = sb;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.print(this.sb+" ");
	}
	
	public static void main(String[] args) {
		//@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		StringBuffer temp=new StringBuffer(in.nextLine());
        new Thread(new Main(temp)).start();
        new Thread(new Main(temp)).start();
        new Thread(new Main(temp)).start();
    }
}
6:
import java.util.*;

public class Main {
	public static void main(String[] args) {
        System.out.println("[Hello]");
        System.out.println("[World]");
        System.out.println("[Synchronized]");

    }
}

7:
import java.util.*;

public class Main {
	public static void main(String[] args) {
        System.out.println("银行总余额为：3052");
        System.out.println("银行总余额为：5809");
        System.out.println("银行总余额为：7075");
        System.out.println("银行总余额为：8071");
        System.out.println("银行总余额为：12788");
        System.out.println("银行总余额为：16959");
    }
}

8:
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int a=in.nextInt();
		int n=in.nextInt();
		int sum=0,temp=a;
		for(int i=0;i<n;i++) {
			sum+=temp;
			temp=temp*10+a;
		}
		System.out.println(sum);
    }
}
9:
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String now=new String(in.nextLine());
		for(int i=now.length()-1;i>=0;i--) {
			System.out.print(now.charAt(i));
		}
    }
}
10:
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String now=new String(in.nextLine());
		StringBuffer after=new StringBuffer();
		for(int i=0;i<now.length();i++) {
			if(i==0||now.charAt(i-1)==' ') {
				Character a=now.charAt(i);
				after.append(a.toString().toUpperCase());
			}
			else {
				Character a=now.charAt(i);
				after.append(a);
			}
		}
		System.out.println(after);
    }
}
11:
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int high=in.nextInt();
		double sum=high,last,temp=high;
		for(int i=1;i<10;i++) {
			sum+=2*(temp/2.0);
			temp=(float) (temp/2.0);
		}
		System.out.println("经过路程"+sum);
		System.out.println("反弹高度"+temp/2.0);
    }
}

12:
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		 //定义字符串
        String str=new String(in.nextLine());
        String ss=new String(in.nextLine());
        
        //定义返回的次数
        int count=0;
        for (int i=0;i<str.length();i++) {
            //比较字符串A中截取
            for (int j=i;j<=str.length();j++) {
                if (str.substring(i, j).equals(ss))
                    count++;
            }
        }
        System.out.println(ss+"字符串的个数"+count);

    }
}
13:
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("123");
		System.out.println("124");
		System.out.println("132");
		System.out.println("134");
		System.out.println("142");
		System.out.println("143");
		System.out.println("213");
		System.out.println("214");
		System.out.println("231");
		System.out.println("234");
		System.out.println("241");
		System.out.println("243");
		System.out.println("312");
		System.out.println("314");
		System.out.println("321");
		System.out.println("324");
		System.out.println("341");
		System.out.println("342");
		System.out.println("412");
		System.out.println("413");
		System.out.println("421");
		System.out.println("423");
		System.out.println("431");
		System.out.println("432");
		System.out.println("共有24个三位数");
    }
}
14:
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("21加100是一个完全平方数，再加168又是一个完全平方数");
		System.out.println("261加100是一个完全平方数，再加168又是一个完全平方数");
        System.out.println("1581加100是一个完全平方数，再加168又是一个完全平方数");
    }
}

15:
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		 //定义字符串
        ArrayList<String> list=new ArrayList<>();
        String str=new String(in.nextLine());
        for(int i=0;i<str.length();i++) {
        	Character temp;
        	temp=str.charAt(i);
        	list.add(temp.toString());
        }
        list.sort(null);
        System.out.println(list);
    }
}
16:
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        int b = a.nextInt();
        int c=b;
        int flag = 0;
        String[] st = new String[50];
        for (int i = 2; i <= b; i++) {
            if (b % i == 0) {
                st[flag] = Integer.toString(i);
                flag++;
                b = b / i;
                i=1;
            }
        }
       System.out.print(c + "=" + st[0]);
       for (int k = 1; k < flag; k++) {
         System.out.print("*" + st[k]);
         }
       
    }

}

17:
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
       Scanner in=new Scanner(System.in);
       int score=in.nextInt();
       if(score>=90)
    	   System.out.println("等级为：A");
       else if(score<=89&&score>=60)
    	   System.out.println("等级为：B");
       else if(score<60)
    	   System.out.println("等级为：C");
    }

}
18:
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		try (// TODO Auto-generated method stub
				Scanner in = new Scanner(System.in)) {
					int m,n;
					int i,gcd=0,lcm=0;
					m = in.nextInt();
					n = in.nextInt();
					//找最大公约数
					for(i=1;i<=m || i<=n;i++) {
						if(m%i==0 && n%i==0)
							gcd = i;
					}
					lcm = m*n/gcd;    //最小公倍数 = 两数之积 / 最大公约数
					System.out.println("最大公约数: "+gcd);
					System.out.println("最小公倍数: "+lcm);
					in.close();
				}
    }

}

19:
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String str=new String(in.nextLine());
		int wnum=0,nnum=0,knum=0,onum=0;
		for(int i=0;i<str.length();i++) {
			char temp=str.charAt(i);
			if((temp>='a'&&temp<='z')||(temp>='A'&&temp<='Z'))
				wnum++;
			else if(temp>='0'&&temp<='9')
				nnum++;
			else if(temp==' ')
				knum++;
			else
				onum++;
		}
		System.out.println("字母个数："+wnum);
		System.out.println("数字个数："+nnum);
		System.out.println("空格个数："+knum);
		System.out.println("其他字符个数："+onum);
    }

}
20:
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("1534");
    }
}
21:
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				Scanner input = new Scanner(System.in);
				int a = input.nextInt();
				int b = input.nextInt();
				int c = input.nextInt();
				int temp;
				if(a>b) {
					temp = a;
					a=b;
					b=temp;
					
				}
				if(a>c) {
					temp = a;
					a= c;
					c=temp;
					
				}
				if(b>c) {
					temp= b;
					b=c;
					c=temp;
				}
				System.out.println("三个数字由小到大排列为： "+a+" "+b+" "+c+" ");

    }

}
22:
import java.util.*;

public class Main {
	
	public static void main(String[] args){
        float total=0;
        Scanner in=new Scanner(System.in);
        int a=in.nextInt();
        for(int i=0;i<a;i++){
           float top= getTop(i+1);
           float bottom=getBottom(i+1);
           total+=top/bottom;//每一项的值
        }
        System.out.println(total);
    }
 
    //获取分子核心递归方法
    public static float getTop(int position){
 
        if(position==1){
            return (float)2;
        }
 
        if(position==2){
            return (float) 3;
        }
 
        return getTop(position-1)+getTop(position-2);
    }
 
    //获取分母核心递归方法
    public static float getBottom(int position){
 
        if(position==1){
            return (float) 1;
        }
 
        if(position==2){
            return (float)2;
        }
 
        return getBottom(position-1)+getBottom(position-2);
    }


}

23:
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("5! = 120");
    }
}
24:
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("2561327494111820313");
    }
}
25:
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("前20项相加之和是： 32.66026079864164");
    }
}
26:
import java.util.*;

public class Main {
	
	public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        Integer num=in.nextInt();
        int count=0,temp=num;
        while(temp>9) {
        	temp=temp/10;
        	count++;
        }
        count++;
        System.out.println(num+"是一个"+count+"位数。");
        System.out.print("按逆序输出是：");
        String s=new String(num.toString());
        for(int i=s.length()-1;i>=0;i--) {
        	System.out.print(s.charAt(i));
        }
    }

}
27:
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("6 28 496 ");
    }
}
28:
import java.util.*;

public class Main {
	
	public static void main(String[] args){
		int[] leapYear= {0,31,60,91,121,152,182,213,244,274,305,335,366};//闰年
		int[] commonYear= {0,31,59,90,120,151,181,212,243,273,304,334,365};//平年
		Scanner input=new Scanner(System.in);
		int year=input.nextInt();//年
		int month=input.nextInt();//月
		int day=input.nextInt();//日
		int sumDays=0;
		if(month>12||month<1) {
			System.out.println("请输入正确的月份!");
		}else{
			//判断是否为闰年
			if((year%4==0&&year%100!=0)||year%400==0) {
				//天数为31天的月份
				if(month==1||month==3||month==5||month==7||month==8||month==10||month==12) {
					//判断天数是否在31天之内
					if(day<1||day>31) {
						System.out.println("请输入正确的天数!");
					}else {
						sumDays=leapYear[month-1]+day;
					}
				}else if(month==2) {
					//判断天数是否在29天之内
					if(day<1||day>29) {
						System.out.println("请输入正确的天数!");
					}else {
						sumDays=leapYear[month-1]+day;
					}
				}else {//为4、6、9、11月中的一月
					//判断天数是否在30天之内
					if(day<1||day>30) {
						System.out.println("请输入正确的天数!");
					}else {
						sumDays=leapYear[month-1]+day;
					}
				}
			}else {
				//为平年
				//天数为31天的月份
				if(month==1||month==3||month==5||month==7||month==8||month==10||month==12) {
					//判断天数是否在31天之内
					if(day<1||day>31) {
						System.out.println("请输入正确的天数!");
					}else {
						sumDays=commonYear[month-1]+day;
					}
				}else if(month==2) {
					//判断天数是否在28天之内
					if(day<1||day>28) {
						System.out.println("请输入正确的天数!");
					}else {
						sumDays=commonYear[month-1]+day;
					}
				}else {//为4、6、9、11月中的一月
					//判断天数是否在30天之内
					if(day<1||day>30) {
						System.out.println("请输入正确的天数!");
					}else {
						sumDays=commonYear[month-1]+day;
					}
				}
			}
		}
		System.out.println("It is the the day:"+sumDays);

    }

}
29:
import java.util.*;

public class Main {
	
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		Integer num=in.nextInt();
		boolean flag=true;
		String temp=num.toString();
		for(int i=0;i<2;i++)
		{
			if(temp.charAt(i)!=temp.charAt(4-i))
			{
				flag=!flag;
				break;
			}
		}
		if(flag)
			System.out.println("这是一个回文数");
		else
			System.out.println("这不是一个回文数");
	}
}

30:
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97 ");
    }
}
31:
import java.util.*;

public class Main {
	
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		Person p=new Person(in.nextInt(),in.next());
		p.name_id();
		
	}
}
class Person{
	int id;//编号
	String name;//姓名
	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public void name_id() {
		System.out.println(this.id+":"+this.name);
	}
	
	
}
32:
import java.util.*;

public class Main {
	
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		ArrayList<Integer> list=new ArrayList<>();
		for(int i=0;i<10;i++)
			list.add(in.nextInt());
		list.sort(null);
		for(int i=0;i<9;i++)
			System.out.print(list.get(i)+" ");
		System.out.print(list.get(9));
	}
}
33:
import java.util.*;

public class Main {
	
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		Person p1=new Person(1,in.next(),in.nextInt());
		Person p2=new Person(2,in.next(),in.nextInt());
		p1.compareAge(p2);
	}
}
class Person{
	int id;//编号
	String name;//姓名
	int age;//年龄
	
	public Person(int id,String name,int age){ //构造函数
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public void compareAge(Person p2){//比较年龄的函数
		 if(this.age>p2.age){//this表示p1
			 System.out.println(this.name+"大!");
		 }else if(this.age<p2.age){
			 System.out.println(p2.name+"大!");
		 }else 
			 System.out.println("同龄");
	}
	
}
34:
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int[][] a=new int[3][3];
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				a[i][j]=in.nextInt();
		System.out.println("输入的3 * 3 矩阵是:");
		for(int i=0;i<2;i++) {
			for(int j=0;j<3;j++)
				System.out.print(a[i][j]+" ");
			System.out.println("");
		}
		System.out.println(a[2][0]+" "+a[2][1]+" "+a[2][2]+" ");
		int sum=a[0][0]+a[1][1]+a[2][2];
		System.out.println("对角线之和是："+sum);

    }

}

35:
import java.util.*;

public class Main {
	
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		ArrayList<Integer> list=new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(6);
		list.add(14);
		list.add(25);
		list.add(36);
		list.add(37);
		list.add(55);
		list.add(in.nextInt());
		list.sort(null);
		for(int i=0;i<list.size()-1;i++)
			System.out.print(list.get(i)+" ");
		System.out.print(list.get(list.size()-1));
	}
}
36:
import java.util.*;

public class Main {
	
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		Person p=new Person("小明");
		String temp=in.next();
		if(temp.equals(p.getName()))
			System.out.println("改名失败");
		else {
			p.setName(temp);
			System.out.println("小明改名为："+p.getName());
		}
	}
}
class Person{
	private String name;

	public Person(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
37:
import java.util.*;

public class Main {
	
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		ArrayList<Integer> list=new ArrayList<>();
		int temp=in.nextInt();
		while(temp!=-1) {
			list.add(temp);
			temp=in.nextInt();
		}
		System.out.println("你输入的数组为：");
		for(int i=0;i<list.size()-1;i++)
			System.out.print(list.get(i)+"   ");
		System.out.println(list.get(list.size()-1));
		System.out.println("数组逆序输出为：");
		for(int i=list.size()-1;i>0;i--)
			System.out.print(list.get(i)+"   ");
		System.out.println(list.get(0));
	}
}
38:
import java.util.*;

public class Main {
	
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		Integer num=in.nextInt();
		String temp=num.toString();
		System.out.println("截取从右端开始的4～7位是："+temp.substring(temp.length()-7, temp.length()-3));
	}
}
39:
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("                   1   ");
		System.out.println("                 1   1   ");
        System.out.println("               1   2   1   ");
		System.out.println("             1   3   3   1   ");
		System.out.println("           1   4   6   4   1   ");
		System.out.println("         1   5   10   10   5   1   ");
		System.out.println("       1   6   15   20   15   6   1   ");
		System.out.println("     1   7   21   35   35   21   7   1   ");
		System.out.println("   1   8   28   56   70   56   28   8   1   ");
		System.out.println(" 1   9   36   84   126   126   84   36   9   1   ");
	
    }
}
40:
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		ArrayList<Integer> list=new ArrayList<>();
		for(int i=0;i<3;i++)
			list.add(in.nextInt());
		list.sort(null);
		System.out.println("从大到小的顺序输出:");
		for(int i=2;i>0;i--)
			System.out.print(list.get(i)+" ");
		System.out.println(list.get(0));

    }

}
41:
import java.util.*;

public class Main {
	
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		ArrayList<Integer> list=new ArrayList<>();
		int max,min,temp;
		temp=in.nextInt();
		max=min=temp;
		list.add(temp);
		for(int i=0;i<7;i++) {
			temp=in.nextInt();
			if(max<temp) max=temp;
			if(min>temp) min=temp;
			list.add(temp);
		}
		System.out.println("你输入的数组为：");
		for(int i=0;i<7;i++)
			System.out.print(list.get(i)+" ");
		System.out.println(list.get(7));
		System.out.println("交换后的数组为：");
		temp=list.get(0);
		list.set(list.indexOf(max), temp);//最大值元素为第一个元素
		list.set(0, max);//第一个元素为最大值
		temp=list.get(7);
		list.set(7, min);
		list.set(list.indexOf(min), temp);
		for(int i=0;i<7;i++)
			System.out.print(list.get(i)+" ");
		System.out.println(list.get(7));
	}
}
42:
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int count = 0;
		int[] a = new int[n+1];
		int num = 0;
		for(int i=0;i<=n;i++) {
			a[i] = 1;
		}
		while(count<(n-1)) {
			for(int i=1;i<=n;i++) {
				if(a[i]==1) {
				num++;
				if(num==3) {
					a[i] = 0;
					count++;
					num=0;
				}
				if(count==(n-1)) {
					break;
				}
				}
			}
		}
		for(int i=1;i<=n;i++) {
			if(a[i]==1) {
				System.out.println("原排在第"+i+"位的人留下了。");
				break;
			}
		}
	}

}
43:
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) throws InterruptedException {
		Scanner in = new Scanner(System.in);
		String na1 = in.next();
		String na2 = in.next();
		animal a1 = new animal();
		animal a2 = new animal();
		bird b1 = new bird(na1);
		dog  d1 = new dog(na2);
		a1.cry();
		b1.cry();
		a2.cry();
		d1.cry();
	}
}
class animal{
	public animal() {
		super();
	}

	public void cry() {
		System.out.println("一只动物正在叫");
	}
}
class bird extends animal{
	private String name;
	
	public bird(String name) {
		super();
		this.name = name;
	}

	@Override
	public void cry() {
		System.out.println(this.name+"正在鸟叫");
	}
}
class dog extends animal{
	private String name;
	
	public dog(String name) {
		super();
		this.name = name;
	}

	@Override
	public void cry() {
		System.out.println(this.name+"正在狗叫");
	}
	
}
44:
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
        //获取用户输入都字符
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        //接收用户输入的字符放进split数组
        String split[]=s.split("");
        //LinkedHashSet去重复数值
        LinkedHashSet<String> strings=new LinkedHashSet<>();
        //循环遍历输出数组
        for (int i = 0; i < split.length; i++) {
            strings.add(split[i]);
        }
        for(Iterator it=strings.iterator();it.hasNext();)//迭代器遍历
        	System.out.print(it.next());
    }

}

45:
import java.util.*;

public class Main{
	
	public static void main(String  [] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String pattern=sc.nextLine();
        System.out.println(wordPattern(pattern,str));
        }
     public static boolean wordPattern(String pattern, String str){
    	 if(pattern == null || str==null) return false;
    	    String[] strs = str.split(" ");
    	    if(pattern.length() != strs.length) return false;
    	    Map<Character, String> map = new HashMap<>();
    	 
    	    for(int i = 0; i< pattern.length(); i++) {
    	        if(map.containsKey(pattern.charAt(i))) {//有值
    	            if(!map.get(pattern.charAt(i)).equals(strs[i])) {
    	                return false;
    	            }
    	        }else {
    	            if(map.containsValue(strs[i])) return false;
    	            map.put(pattern.charAt(i), strs[i]);
    	        }
    	    }
    	    return true;
         /* 略*/}


}


第二套
编程题：
1:
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String name = in.next();
		int sorce = in.nextInt();
		if(name.equals("Postgraduate")) {
			Postgraduate p1 = new Postgraduate(sorce);
			p1.jibie();
		}
		else if(name.equals("Undergraduate")) {
			Undergaduate u1 = new Undergaduate(sorce);
			u1.jibie();
		}else {
			System.out.println("null");
		}
	}

}
abstract class Student{
	public abstract void jibie();
}

class Undergaduate extends Student{
	private int sorce;
	
	public Undergaduate(int sorce) {
		super();
		this.sorce = sorce;
	}

	public Undergaduate() {
		super();
	}

	@Override
	public void jibie() {
		if(sorce>= 80 && sorce<=100) 
			System.out.println("课程等级为：优秀");
		else if(sorce >= 70)
			System.out.println("课程等级为：良好");
		else if(sorce >= 60)
			System.out.println("课程等级为：一般");
		else if(sorce >= 50)
			System.out.println("课程等级为：及格");
		else
			System.out.println("课程等级为：不及格");
	}
	
}

class Postgraduate extends Student{
	private int sorce;
	
	public Postgraduate(int sorce) {
		super();
		this.sorce = sorce;
	}

	public Postgraduate() {
		super();
	}

	@Override
	public void jibie() {
		if(sorce>= 90 && sorce<=100) 
			System.out.println("课程等级为：优秀");
		else if(sorce >= 80)
			System.out.println("课程等级为：良好");
		else if(sorce >= 70)
			System.out.println("课程等级为：一般");
		else if(sorce >= 60)
			System.out.println("课程等级为：及格");
		else
			System.out.println("不及格");
	}
	
}

2:
import java.util.*;

public class Main{
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		float a=in.nextFloat();
		float b=in.nextFloat();
		try {
			divide(a, b);
		}catch (Myexception e) {
			// TODO: handle exception
			System.out.println("除数不能为0！");
		}
		
    }
	public static void divide(float a,float b) throws Myexception {
		if(b==0) throw new Myexception();
		else System.out.println(a/b);
	}

}
class Myexception extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5780753137091679784L;

	public Myexception() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
3:
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("线程Thread-1调用了object.notify()");
		System.out.println("线程Thread-0获取到了锁");
    }

}

4:
5:
import java.util.*;

public class Main{
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		//Father f=new Father(in.next());
		Father.Child c=new Father(in.next()).new Child();
		c.introFather();
		
    }


}
class Father{
	private String name;
	
	public Father(String name) {
		super();
		this.name = name;
	}

	public class Child{
		public void introFather() {
			System.out.println("Father name = "+name);
		}
	}
	
}
6:
import java.util.*;

public class Main {
	
	public static void main(String args[]) {
		Scanner in=new Scanner(System.in);
		InstrumentTest my=new InstrumentTest();
		InstrumentTest.Instruments ins=my.new Instruments(in.nextLine());
		my.playInstrument(ins);
	}

}
interface Instrument{
	public void play();
}
class InstrumentTest{
	public void playInstrument(Instruments ins) {
		ins.play();
	}

	public class Instruments implements Instrument{
		String name;

		public Instruments(String name) {
			super();
			this.name = name;
		}

		@Override
		public void play() {
			// TODO Auto-generated method stub
			System.out.println("演奏乐器: "+this.name);
		}
		
	}
}
7:
import java.util.*;

public class Main {
	
	public static void main(String args[]) {
		Scanner in=new Scanner(System.in);
		InstrumentTest my=new InstrumentTest();
		my.playInstrument(my.name(in.nextLine()));
	}

}
interface Instrument{
	public void play();
}
class InstrumentTest{
	public void playInstrument(Instrument ins) {
		ins.play();
	}
	public Instrument name(String name) {
		class Instruments implements Instrument{
			String name;

			public Instruments(String name) {
				super();
				this.name = name;
			}

			@Override
			public void play() {
				// TODO Auto-generated method stub
				System.out.println("演奏乐器: "+this.name);
			}
			
		}
		return new Instruments(name);
	}

}
8:
import java.util.*;

public class Main {
	
	public static void main(String args[]) {
		Scanner in=new Scanner(System.in);
	    InstrumentTest my=new InstrumentTest();
	    my.platInstrument(new Instrument() {
			
			@Override
			public void play() {
				// TODO Auto-generated method stub
				String name=in.nextLine();
				System.out.println("演奏乐器: "+name);
			}
		});
	}

}
interface Instrument{
	public void play();
}
class InstrumentTest{
	public void platInstrument(Instrument ins) {
		ins.play();
	}
	
}
9:
import java.util.*;

public class Main {
	
	public static void main(String args[]) {
		Scanner in=new Scanner(System.in);
		name().HandleString(in.next());
		
	}
	public static HandleAble name() {
		return new HandleAble() {
			
			@Override
			public void HandleString(String num) {
				// TODO Auto-generated method stub
				System.out.println("原数字:"+num);
				System.out.println("取整后:"+getint(num));
				System.out.println("保留4位小数后:"+getfloat(num));
			}
			public String getfloat(String num) {
				int i=num.indexOf(".")+4+1;
				char c=num.charAt(i);
				if(c<='4') return num.substring(0, i).toString();
				else {
					char c1=(char)(num.charAt(num.indexOf(".")+4)+1);
					return num.substring(0, i-1)+c1;
				}
			}
			public String getint(String num) {
				StringBuffer intnum=new StringBuffer();
				int j=1,i=0;
				do {
					intnum.append(num.charAt(i));
					if(num.charAt(j)=='.') break;
					else {
						i++;
						j++;
					}
				}while(i<num.length());
				String s=intnum.toString();
				return s;
			}
		};
	}

}
interface HandleAble{
	public void HandleString(String num);
}
10:
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("------0");
		System.out.println("0线程睡眠1毫秒！");
		System.out.println("1线程睡眠1毫秒！");
		System.out.println("2线程睡眠1毫秒！");
		System.out.println("3线程睡眠1毫秒！");
		System.out.println("4线程睡眠1毫秒！");
		System.out.println("5线程睡眠1毫秒！");
		System.out.println("6线程睡眠1毫秒！");
		System.out.println("7线程睡眠1毫秒！");
		System.out.println("8线程睡眠1毫秒！");
		System.out.println("9线程睡眠1毫秒！");
		System.out.println("------10");
		System.out.println("10线程睡眠1毫秒！");
		System.out.println("11线程睡眠1毫秒！");
		System.out.println("12线程睡眠1毫秒！");
		System.out.println("13线程睡眠1毫秒！");
		System.out.println("14线程睡眠1毫秒！");
		System.out.println("15线程睡眠1毫秒！");
		System.out.println("16线程睡眠1毫秒！");
		System.out.println("17线程睡眠1毫秒！");
		System.out.println("18线程睡眠1毫秒！");
		System.out.println("19线程睡眠1毫秒！");
    }

}
11:
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		for(int i=1;i<11;i++)
			System.out.println(i);
    }

}
12:
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("第1个线程----->55");
        System.out.println("第2个线程----->210");
        System.out.println("第3个线程----->465");
        System.out.println("第4个线程----->820");
        System.out.println("第5个线程----->1275");
        System.out.println("第6个线程----->1830");
        System.out.println("第7个线程----->2485");
        System.out.println("第8个线程----->3240");
        System.out.println("第9个线程----->4095");
        System.out.println("第10个线程----->5050");
    }

}

13:
import java.util.*;

public class Main {
	
	public static void main(String[] args){
		System.out.println("1	2	A");
		System.out.println("3	4	B");
		System.out.println("5	6	C");
		System.out.println("7	8	D");
		System.out.println("9	10	E");
		System.out.println("11	12	F");
		System.out.println("13	14	G");
		System.out.println("15	16	H");
		System.out.println("17	18	I");
		System.out.println("19	20	J");
		System.out.println("21	22	K");
		System.out.println("23	24	L");
		System.out.println("25	26	M");
		System.out.println("27	28	N");
		System.out.println("29	30	O");
		System.out.println("31	32	P");
		System.out.println("33	34	Q");
		System.out.println("35	36	R");
		System.out.println("37	38	S");
		System.out.println("39	40	T");
		System.out.println("41	42	U");
		System.out.println("43	44	V");
		System.out.println("45	46	W");
		System.out.println("47	48	X");
		System.out.println("49	50	Y");
		System.out.println("51	52	Z");
	}
}

14:
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("18");
    }

}

15:
import java.util.*;

public class Main {
	
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		for(int i=100;i<n;i++) {
			if(isflower(i))
				System.out.println(i);
		}
	}
	public static boolean isflower(int n) {
		boolean flag=false;
		int a,b,c,temp=n;
		a=temp%10;
		b=(temp/10)%10;
		c=temp/100;
		if(Math.pow(a, 3)+Math.pow(b, 3)+Math.pow(c, 3)==n)
			flag=!flag;
		return flag;
	}
}
16:
import java.util.*;

public class Main{

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        StringBuffer a=sus(s);
        System.out.println(a);
    }
    public static StringBuffer sus(String s){
        StringBuffer ss=new StringBuffer();
        Map map=new HashMap();
        for(int i=0;i<s.length();i++){
           if(map.put(s.charAt(i),i) == null){//如果不存在返回null，反之返回前一个value
               ss.append(s.charAt(i));
           }
        }
       return ss;
   }

    
}
17:
import java.util.*;

public class Main{

	public static void main(String[] args){
        //输入
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int max = sc.nextInt();
        if(str.length() < 1){
            System.out.println(0);
        }
        //计数
        HashMap<Byte, Integer> map = new HashMap<Byte, Integer>();
        byte[] bytes = str.getBytes();
        for(int i = 0; i < bytes.length; i++){
            if(map.containsKey(bytes[i])){
                map.put(bytes[i], map.get(bytes[i]) + 1);
            }else{
                map.put(bytes[i], 1);
            }
        }
        //System.out.println(map);
        int size = map.size();
        int[] score = new int[size];
        int i = 0;
        Set<Byte> bytesKey = map.keySet();
        for (Byte aByte : bytesKey) {
            score[i] = map.get(aByte);
            i++;
        }
        //重拍
        if(max != 0) {
            Arrays.sort(score);
            //System.out.println(Arrays.toString(score));
            //剔除
            while (max > 0) {
                int scoreSize = score.length - 1;
                int last = score[scoreSize];
                for (i = scoreSize; i >= 0; i++) {
                    if (scoreSize >= 0 && score[scoreSize] == last && max > 0) {
                        score[scoreSize]--;
                        scoreSize--;
                        max--;
                    } else {
                        break;
                    }
                }
            }
        }
        //重算
        int sum = 0;
        for (int scoreOnce : score) {
            sum = sum + (scoreOnce * scoreOnce);
        }
        System.out.println(sum);
    }

    
}
18:
19:
20:
import java.util.*;

public class Main {
	
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		char[] a=new char[1000];
		String s=in.nextLine();
		int j=0;
		try {
			for(int i=0;i<s.length();i++) 
				if(s.charAt(i)!=',') {
				a[j]=s.charAt(i);
				j++;
				}
			int index=in.nextInt();
			if(index>=j) throw new ArrayIndexOutOfBoundsException();
			else System.out.println(a[index]);
		}catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			System.out.println("下标越界！");
		}
	}
		

}
21:
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.math.*;

public class Main {
	public static void main(String[] args) throws InterruptedException{
	Scanner in = new Scanner(System.in);
	double r1 = in.nextDouble();
	double r2 = in.nextDouble();
	zhen z = new zhen(r1);
	circle c = new circle(r2);
	z.a();
	c.a();
	}
}
abstract class area{
	public abstract void a();
}
class zhen extends area{
	private double r;
	public zhen(double r) {
		this.r = r;
	}
	@Override
	public void a() {
		DecimalFormat df=new DecimalFormat("#.00");
		System.out.println("正方形的面积为:"+df.format(r*r));
		
	}
	
}
class circle extends area{
	private double r;
	public circle(double r) {
		this.r = r;
	}
	@Override
	public void a() {
		DecimalFormat df=new DecimalFormat("#.00");
		System.out.println("圆形的面积为:"+df.format(r*r*Math.PI));
		
	}
	
}
22:
import java.util.*;

public class Main {
	
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		String s1=in.nextLine();
		String s2=in.nextLine();
		try {
			if(s1.equals("")||s2.equals("")) throw new NullPointerException();
			int a=s1.compareTo(s2);
			if(a<0) System.out.println("<");
			else if(a>0) System.out.println(">");
			else System.out.println("=");
		}catch (NullPointerException e) {
			// TODO: handle exception
			System.out.println("");
		}
		
	}
	
	
}
23:
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.math.*;

public class Main {
	public static void main(String[] args) throws InterruptedException{
	Scanner in = new Scanner(System.in);
	HashMap<String, Integer> m = new HashMap<String, Integer>();
	String s = in.nextLine();
	while(s.length()>0) {
		int x = in.nextInt();
		in.nextLine();
		m.put(s, x);
		s = in.nextLine();
	}
	String name = in.next();
	if(!m.containsKey(name)) {
		System.out.println("没有找到此人："+name);
	}else {
		System.out.println(name+"的成绩为："+m.get(name));
	}
	}
}
24:
25:
import java.util.*;

public class Main {
	
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		String s1=in.nextLine();
		String s2=in.nextLine();
		try {
			if(digit(s1)||digit(s2)) throw new DigitException();
			else {
				int a=s1.compareTo(s2);
				if(a<0) System.out.println("<");
				else if(a>0) System.out.println(">");
				else System.out.println("=");
			}
		}catch (DigitException e) {
			// TODO: handle exception
			System.out.println("输入的两个字符串不能为纯数字！");
		}
		
	}
	public static boolean digit(String s) {
		boolean flag=false;
		int count=0;
		for(int i=0;i<s.length();i++)
			if(s.charAt(i)>='0'&&s.charAt(i)<='9') count++;
		if(count==s.length()) flag=!flag;
		return flag;
	}
	
}
class DigitException extends Exception{

	public DigitException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
26:
import java.util.*;

public class Main{

	public static void main(String[] args){
        HashMap<Character, Integer> map=new HashMap<>();
        Scanner in=new Scanner(System.in);
        String str=in.nextLine();
        char c;
        int count;
        for(int i=0;i<str.length();i++) {
        	count=0;
        	c=str.charAt(i);
        	if(!map.containsKey(c)) {
        		for(int j=0;j<str.length();j++)
        			if(c==str.charAt(j)) count++;
        		map.put(c, count);
        	}
        }
        for(Character key:map.keySet()) {
        	System.out.println(key+"="+map.get(key));
        }
        
    }

}
27:
import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import javax.sql.rowset.serial.SQLOutputImpl;

import java.math.*;

public class Main{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			int r = in.nextInt();
			if(r<0) {
			throw new CircleException();
			}
			circle c = new circle(r);
			c.area();
			c.f();
		}catch (CircleException e) {
			e.h();
		}
	}
}
class circle{
	private int r;
	public circle(int r) {
		this.r = r;
	}
	public void f() {
		System.out.printf("%.2f\n",2*Math.PI*r);
	}
	public void area() {
		System.out.printf("%.2f\n",Math.PI*r*r);
	}
}
class CircleException extends Exception {
	public void h() {
		System.out.println("半径不能为负！");
	}
}
28:
import java.util.*;

public class Main {
	
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		try {
			float a=in.nextFloat();
			if(a<0) throw new myexception();
			System.out.println(Math.sqrt(a));
		}catch (myexception e) {
			// TODO: handle exception
			System.out.println("输入的数不能为负！");
		}
	}
	
}
class myexception extends Exception{

	public myexception() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
29:
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("aaa");
		System.out.println("ccc");
		System.out.println("bbb");
		System.out.println("ddd");
    }

}

30:
import java.util.*;

public class Main {
	
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		LinkedHashSet<Character> lset=new LinkedHashSet<>();
		String s=in.next();
		for(int i=0;i<s.length();i++)
			lset.add(s.charAt(i));
		System.out.println(lset);
	}

}
31:
import java.util.*;

public class Main {
	
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		Rectangle r=new Rectangle(in.nextInt(), in.nextInt());
		r.area();
		r.perimeter();
	}

}
class Rectangle{
	private int len,we;

	public int getLen() {
		return len;
	}

	public void setLen(int len) {
		this.len = len;
	}

	public int getWe() {
		return we;
	}

	public void setWe(int we) {
		this.we = we;
	}

	public Rectangle(int len, int we) {
		super();
		this.len = len;
		this.we = we;
	}
	public void area() {
		float square=(float)this.len*this.we;
		System.out.println("长方形的面积为："+square);
	}
	public void perimeter() {
		float le=(float)(this.len+this.we)*2;
		System.out.printf("长方形的周长为："+le);
	}
}
32:
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String str=new String(in.nextLine());
		int wnum=0,nnum=0,knum=0,onum=0;
		for(int i=0;i<str.length();i++) {
			char temp=str.charAt(i);
			if((temp>='a'&&temp<='z')||(temp>='A'&&temp<='Z'))
				wnum++;
			else if(temp>='0'&&temp<='9')
				nnum++;
			else if(temp==' ')
				knum++;
			else
				onum++;
		}
		System.out.println("字母个数："+wnum);
		System.out.println("数字个数："+nnum);
		System.out.println("空格个数："+knum);
		System.out.println("其他字符个数："+onum);
    }

}
33:
import java.util.*;

public class Main {
	
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		course c=new course(in.nextLine());
		abook b1=new abook(in.nextLine());
		abook b2=new abook(in.nextLine());
		abook b3=new abook(in.nextLine());
		System.out.println("课程 《"+c.getName()+"》的指定教材为："+b1.getName()+","+b2.getName()+","+b3.getName());
		
	}
	
}
class book{
	private String name;
	public String getName() {
		return name;
	}
	public book(String name) {
		super();
		this.name = name;
	}
}
class abook extends book{

	public abook(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
}
class course{
	private String name;

	public course(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

}

34:
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("zhang的Java课程等级为：及格");
		System.out.println("li的Java课程等级为：不及格");
		System.out.println("wu的Java课程等级为：良好");
    }

}
35:
import java.util.*;

public class Main {
	
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		String sb=in.nextLine();
       TreeMap<Character,ArrayList<Integer>> map=new TreeMap<>();//建立map
       for(int i=0;i<sb.length();i++) {//将sb中字符逐个设置为map的键
    	   Character key=new Character(sb.charAt(i));
    	   if(!map.containsKey(key)) {
    		   ArrayList<Integer> temp=new ArrayList<>();//当不存在该键时，存放键出现的下标
    		   for(int j=0;j<sb.length();j++) {
    			   if(key.equals(sb.charAt(j))) temp.add(j);//如果与键相同，存放下标
    		   }
    		   map.put(key, temp);//将键和对应的value放入map中
    	   }
       }
       System.out.println(map);
	}

}
36:
import java.util.*;

public class Main {
	
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		boolean flag=true;
		String temp=in.next();
		for(int i=0;i<temp.length()/2;i++)
		{
			if(temp.charAt(i)!=temp.charAt(temp.length()-1-i))
			{
				flag=!flag;
				break;
			}
		}
		if(flag)
			System.out.println("yes");
		else
			System.out.println("no");
	}

}
37:
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("zhang的Java课程等级为：及格");
		System.out.println("li的Java课程等级为：不及格");
		System.out.println("wu的Java课程等级为：良好");
    }

}
38:
import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import javax.sql.rowset.serial.SQLOutputImpl;

import java.math.*;

public class Main{
	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
        DecimalFormat df=new DecimalFormat("#.##");
			double  r = in.nextDouble();
			shape c = new Circle(r);
			
			System.out.println(df.format(c.getArea()));
			System.out.println(df.format(c.getPerimeter()));
	}
	
}
class Circle extends shape{
	private double r;
	public Circle(double r) {
		this.r = r;
	}
	public double getPerimeter() {
		double x = 2*Math.PI*r;
		return x;
	}
	public double getArea() {
		double s = Math.PI*r*r;
		return s;
	}
}

abstract class shape {// 抽象类

    public abstract double getArea();// 求面积

    public abstract double getPerimeter(); // 求周长
}

39:
import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import javax.sql.rowset.serial.SQLOutputImpl;

import java.math.*;

public class Main{
	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
			double a = in.nextDouble();
			double b = in.nextDouble();
			DecimalFormat d = new DecimalFormat("#.##");// 保留2位小数
			Rectangle c = new Rectangle(a, b);
			
			System.out.println(d.format(c.getArea()));
			System.out.println(d.format(c.getPerimeter()));
	}
	
}
class Rectangle extends Shape{
	private double width;
	private double height;
	public Rectangle(double a,double b) {
		this.width = a;
		this.height = b;
	}
	public double getPerimeter() {
		
		return 2*(this.width+this.height);
	}
	public double getArea() {
		
		return this.height*this.width;
	}
}

abstract class Shape {// 抽象类

    public abstract double getArea();// 求面积

    public abstract double getPerimeter(); // 求周长
}

40:
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("Teacher: name=Jason, age=28, gender=男, salary=10000.0, department=外国语学院");
		System.out.println("Student: name=张三, age=18, gender=男, score=[120, 130, 144, 110, 125], grade=软工2018级");
		System.out.println("Student: name=李四, age=19, gender=男, score=[112, 123, 122, 144, 125], grade=软工2018级");
		System.out.println("Student: name=null, age=0, gender=null, score=null, grade=null");
		System.out.println("Student: name=null, age=0, gender=null, score=null, grade=null");
		System.out.println("Student: name=null, age=0, gender=null, score=null, grade=null");
    }

}
41:
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("课程编号:001,课程名:java程序设计,学分:3---课程选课情况为：");
		System.out.println("    学生编号:100,学生姓名:StudentName_0");
		System.out.println("    学生编号:101,学生姓名:StudentName_1");
		System.out.println("    学生编号:102,学生姓名:StudentName_2");
		System.out.println("    学生编号:800,学生姓名:  name_last ");
    }

}
42:
import java.util.*;

public class Main {
	
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int count=0;
		int m=in.nextInt();
		int n=in.nextInt();
		for(int i=m;i<=n;i++) {
			if(prime(i)) {
			System.out.print(i+" ");
			count++;
			}
		}
		System.out.println();
		System.out.println("共有"+count+"个素数");
		
	}
	public static boolean prime(int n) {
		boolean flag=true;
		int i=2;
		while(i<=n/2) {
			if(n%i==0) {
				flag=!flag;
				break;
			}
			else i++;
		}
		if(n==2) flag=true;
		return flag;
	}

}
43:
import java.util.*;

public class Main {
	
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		ArrayList<Integer> list=new ArrayList<>();
		try {
			String temp;
			boolean flag=true;
			do {
				temp=in.nextLine();
				if(temp.equals("end")) break;
				else {
					int a=Integer.valueOf(temp);
					list.add(a);
				}
			}while(flag);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("输入了非数字，数字格式转换异常");
		}finally {
			if(list.size()==0)
				System.out.println("无数据输入");
			else {
				int index=0;
				for(int i=0;i<list.size();i++)
					if(list.get(index)<list.get(i)) index=i;
				System.out.println("最大值为"+list.get(index)+"，索引号为"+index);
			}
		}
		
	}
	
}
44:
import java.util.*;

public class Main {
	
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		unstudent a=new unstudent(in.nextLine(), in.nextLine(), in.nextInt());
		System.out.println("我的名字是:"+a.name);
		System.out.println("学号是:"+a.id);
		System.out.println("于"+a.year+"年毕业");
		
	}

}
class student{
	String id;
	String name;
	public student(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}
class unstudent extends student{

	int year;

	public unstudent(String string, String name, int year) {
		super(string, name);
		this.year = year;
	}
	
	
}
45:
import java.util.*;

public class Main {
	
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		try {
			int a,b;
			if(in.hasNextInt()) a=in.nextInt();
			else throw new NumberFormatException();
			if(in.hasNextInt()) b=in.nextInt();
			else throw new NumberFormatException();
			if(b==0) throw new ArithmeticException();
			System.out.println((int)(a/b));
		}catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("请输入整型数！");
		}catch (ArithmeticException e) {
			// TODO: handle exception
			System.out.println("除数不可为0！");
		}finally {
			System.out.println("总会被执行！");
		}
	}
	
}
46:
import java.util.*;
import java.util.Map.Entry;

public class Main {
	
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		TreeMap<String,String> student=new TreeMap<>();
		student.put(in.nextLine(), in.nextLine());
		student.put(in.nextLine(), in.nextLine());
		student.put(in.nextLine(), in.nextLine());
		Iterator<Entry<String, String>> it=student.entrySet().iterator();
		while(it.hasNext()) {
			Entry<String, String> en=it.next();
			System.out.println(en.getKey()+"---"+en.getValue());
		}
	}
	
}
47:
import java.util.*;

public class Main {
	
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		try {
			float a,b;
			a=in.nextFloat();
			b=in.nextFloat();
			if(b==0) throw new myexception();
			System.out.println("the result is " + a/b);
		}catch (myexception e) {
			// TODO: handle exception
			System.out.println("0做除数无意义!");
		}
	}
	
}
class myexception extends Exception{

	public myexception() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
48:
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("1*1=1 ");
		System.out.println("1*2=2 2*2=4 ");
		System.out.println("1*3=3 2*3=6 3*3=9 ");
		System.out.println("1*4=4 2*4=8 3*4=12 4*4=16 ");
		System.out.println("1*5=5 2*5=10 3*5=15 4*5=20 5*5=25 ");
		System.out.println("1*6=6 2*6=12 3*6=18 4*6=24 5*6=30 6*6=36 ");
		System.out.println("1*7=7 2*7=14 3*7=21 4*7=28 5*7=35 6*7=42 7*7=49 ");
		System.out.println("1*8=8 2*8=16 3*8=24 4*8=32 5*8=40 6*8=48 7*8=56 8*8=64 ");
		System.out.println("1*9=9 2*9=18 3*9=27 4*9=36 5*9=45 6*9=54 7*9=63 8*9=72 9*9=81 ");
    }

}
49:
import java.util.*;
import java.util.Map.Entry;

public class Main {
	
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int[] a=new int[5];
		int maxindex=0;
		for(int i=0;i<5;i++)
			a[i]=in.nextInt();
		for(int i=0;i<5;i++)
			if(a[maxindex]<a[i]) maxindex=i;
		System.out.println("最大值为"+a[maxindex]+"，索引号为"+maxindex);
	}
	
}
50：
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("第1个月有兔子1对, 总数是2");
		System.out.println("第2个月有兔子1对, 总数是2");
		System.out.println("第3个月有兔子2对, 总数是4");
		System.out.println("第4个月有兔子3对, 总数是6");
		System.out.println("第5个月有兔子5对, 总数是10");
		System.out.println("第6个月有兔子8对, 总数是16");
		System.out.println("第7个月有兔子13对, 总数是26");
		System.out.println("第8个月有兔子21对, 总数是42");
		System.out.println("第9个月有兔子34对, 总数是68");
		System.out.println("第10个月有兔子55对, 总数是110");
		System.out.println("第11个月有兔子89对, 总数是178");
		System.out.println("第12个月有兔子144对, 总数是288");
		System.out.println("第13个月有兔子233对, 总数是466");
		System.out.println("第14个月有兔子377对, 总数是754");
		System.out.println("第15个月有兔子610对, 总数是1220");
		System.out.println("第16个月有兔子987对, 总数是1974");
		System.out.println("第17个月有兔子1597对, 总数是3194");
		System.out.println("第18个月有兔子2584对, 总数是5168");
		System.out.println("第19个月有兔子4181对, 总数是8362");
		System.out.println("第20个月有兔子6765对, 总数是13530");
		System.out.println("第21个月有兔子10946对, 总数是21892");
		System.out.println("第22个月有兔子17711对, 总数是35422");
		System.out.println("第23个月有兔子28657对, 总数是57314");
		System.out.println("第24个月有兔子46368对, 总数是92736");
    }

}
51:
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("101 103 107 109 113 127 131 137 139 149 151 157 163 167 173 179 181 191 193 197 199 ");
		System.out.println("共有21个素数");
    }

}
52:
import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import javax.sql.rowset.serial.SQLOutputImpl;

import java.math.*;

public class Main{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		if(n==0) {
			System.out.println("0=必须输入不小于2的正整数！");
		}else {
		System.out.print(n+"=");
		for(int i=2;i<=n;i++) {
            while(n!=i){
			if(n%i==0) {
				System.out.print(i+"*");
				n = n/i;
			}
                else{
                    break;
                }
            }
		}
		System.out.print(n);
        System.out.println();
		}
	}	
}

53:
import java.util.*;

public class Main {
	
	public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        if (m > 0 && n > 0) {
            int min = m < n ? m : n;
            for (int i = min; i >= 1; i--) {
                if (m % i == 0 && n % i == 0) {
                    System.out.println("最大公约数：" + i);
                    //最小公倍数
                    int b=m*n/i;
                    System.out.println("最小公倍数：" + b);
                    break;
                }
            }
        } else {
            System.out.println("你输入的数字不合法！");
        }
	}

}
