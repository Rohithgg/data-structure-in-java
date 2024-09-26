import java.util.Scanner;

class Week1e2 {
    static int check(int num1, int num2){
        if (num1%2 == 0 && num2 == 0 ){
            return 2;
        } else if (num1 == 0 || num2 == 0) {
            return 1;
        } else{
            return 0;
        }
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] nums = input.split(" ");
        var num1 = Integer.parseInt(nums[0]);
        var num2 = Integer.parseInt(nums[1]);
        System.out.println(check(num1, num2));
    }
}