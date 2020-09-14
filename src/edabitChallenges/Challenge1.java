package edabitChallenges;

public class Challenge1 {
    static int index = 0;
    static int trues = 0;

    public static int countTrue(boolean[] arr) {
        if (arr.length == 0) return 0;

        if (arr[index++]) trues++;

        if (index >= arr.length && (index -= index) == 0)
            return trues + (trues -= trues);

        return countTrue(arr);
    }
}