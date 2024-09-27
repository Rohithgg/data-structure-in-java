import java.util.Scanner;

public class Week1e5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var inp = sc.nextInt();
        if (inp != 0 && inp >= 10){
            var res = inp % 100;
            System.out.println(res / 10);
        }
        else{
            System.out.println(-1);
        }
    }
}
