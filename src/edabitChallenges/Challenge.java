package edabitChallenges;

public class Challenge {

    public static int[] MultiplyByLength(int[] arr) {
        return getInts(arr, 0);
    }

    private static int[] getInts(int[] arr, int i) {
        arr[i++] *= arr.length;
        return (i < arr.length) ? getInts(arr, i) : arr;
    }
}