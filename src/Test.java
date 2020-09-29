import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Test {
    public static void main(String[] args) {
        int x = IntStream.rangeClosed(1, 2)
                .mapToObj(String::valueOf)
                .mapToInt(Integer::valueOf)
                .sum();

        System.out.println(x);
    }
}
