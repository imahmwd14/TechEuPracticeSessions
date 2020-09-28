import java.util.stream.LongStream;

public class Test {
    public static void main(String[] args) {
        LongStream.range(-10, 0).map(Math::abs).mapToObj(String::valueOf).forEach(System.out::print);
    }
}
