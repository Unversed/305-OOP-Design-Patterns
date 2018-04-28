package staticExample;

public class StaticExample {
private int a;
public static int b; 

public StaticExample () {
	a++;
	b++;
}
public int geta() {
	return a;
}

public static void increment () {
	b=b+1;
}
}
