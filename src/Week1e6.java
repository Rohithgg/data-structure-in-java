import java.util.Scanner;

public class Week1e6 {
    private static String alter(String a, String b){
        var strr = "";
        for (int i = 0; i <= a.length();i++){
            strr += a.charAt(i);
            strr += b.charAt(i);
        }
        return strr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var a = sc.nextLine();
        var b = sc.nextLine();
        System.out.println(alter(a,b));
    }
}
