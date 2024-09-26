import java.util.Scanner;
class Weeke1e1 {
    static int addlast(int n1, int n2) {
        int a = n1 % 10;
        int b = n2 % 10;
        return a + b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        System.out.println(addlast(n1, n2));
    }
}