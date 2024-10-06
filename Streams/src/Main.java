import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        // 1. Streams don't change the original collection
        // 2. Streams can only be used once
        // 3. parallelStreams can be used to process large amounts of data in multiple threads


         List<Integer> nums = Arrays.asList(5,8,2,3,1,9);
         int res = nums.stream() // 1st stream
                 .filter(n -> n%2 == 1) // 2nd stream
                 .map(n -> n*2) // 3rd stream
                 .reduce(0, (c, e) -> c + e); // 4th stream

        System.out.println(res);

    }
}