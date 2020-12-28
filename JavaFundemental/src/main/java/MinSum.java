import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinSum {
    public static int minSum(List<Integer> num, int k) {
        int size = num.size();
        PriorityQueue<Integer> pq = new PriorityQueue<>(size, (o1, o2) -> o2 - o1);
        for(Integer n : num) {
            pq.offer(n);
        }
        for(int i = 0; i < k; i++) {
            int picked = pq.poll();
            pq.offer((picked + 1) / 2);
        }
        int sum = 0;
        while(!pq.isEmpty()) {
            sum += pq.poll();
        }
        return sum;
    }
    public static void main(String[] args)
    {

        int k = 4;
        List a = new ArrayList();
        a.add(10);
        a.add(20);
        a.add(7);
        System.out.println(minSum(a, k));
    }
}
