import java.util.Arrays;

public class BinarySearch {
    // Рекурсивная реализация алгоритма двоичного поиска
    public static int Recursive(int[] arr, int target) {
        Arrays.sort(arr);
        return Recursive(arr, target, arr[0], arr.length - 1);
    }

    private static int Recursive(int[] arr, int target, int low, int high) {
        if (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                return Recursive(arr, target, mid + 1, high);
            else
                return Recursive(arr, target, low, mid - 1);
        }

        return -1; // Элемент не найден
    }

    // Итеративная реализация алгоритма двоичного поиска
    public static int Iterative(int[] arr, int target) {
        Arrays.sort(arr);
        int low = arr[0];
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1; // Элемент не найден
    }
}
