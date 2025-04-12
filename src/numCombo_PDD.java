import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class numCombo_PDD {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int target = 0;
        while (in.hasNextInt()) {
            target = in.nextInt();

            if (target > 45) System.out.println(-1);

            List<Integer> subs = new ArrayList<>();
            for (int i = 1; i < 10; i++) {
                subs.addLast(i);
            }

            List<Integer> used = new ArrayList<>();

            while (!subs.contains(target) && target > 0) {
                target = target - subs.getLast();
                used.addFirst(subs.getLast());
                subs.removeLast();
            }

            int sum = target;
            for (int i : used) {
                sum = sum * 10 + i;
            }


            System.out.println(sum);
        }
    }

}
