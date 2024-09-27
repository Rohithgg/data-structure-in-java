import java.util.*;
import java.util.stream.Collectors;

public class Week1e4 {
    static int eveorodd(List<Integer> liss, String type) {
        var even = 0;
        var odd = 0;
        for (var i = 0; i < liss.size(); i++) {
            if (liss.get(i) % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        if (Objects.equals(type, "odd")) {
            return odd;
        }
        return even;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var input = sc.nextLine();
        List<Integer> liss = Arrays.stream(input.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        var oddoreve = sc.nextLine();
        System.out.println(eveorodd(liss, oddoreve));
    }
}