import java.util.Scanner;
// concate two strings
public class Week1e3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        var lena = a.length();
        var lenb = b.length();
        if (lena < lenb){
            System.out.println(a+b+a);
        }
        else{
            System.out.println(b+a+b);
        }
    }
}

