import java.util.*;

public class Question1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long budget = sc.nextLong();

        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        Arrays.sort(a);

        int count = 0;

        for (int x : a) {
            if (budget >= x) {
                budget -= x;
                count++;
            } else {
                break;
            }
        }

        System.out.println(count);
    }
}