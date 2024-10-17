class Main{
    public static void main(String[] args) {
        //forward serach
        int x = 4;
        int n = 3;
        int[] arr = {1,2,3,4};
        for (int i = 0; i <= n; i++){
            if (arr[i] == x){
                System.out.println("got");
            }
            System.out.println(n + 1);
        }
    }
}