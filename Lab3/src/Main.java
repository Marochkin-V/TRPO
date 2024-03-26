public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 13, 5, 3, 7, 0, 13, 15};
        int target = 7;

        // Используем рекурсивный метод для поиска
        int resultRecursive = BinarySearch.Recursive(arr, target);
        if (resultRecursive != -1) {
            System.out.println("Элемент " + target + " найден (рекурсивный) по индексу: " + resultRecursive);
        } else {
            System.out.println("Элемент " + target + " не найден (рекурсивный)");
        }

        // Используем итеративный метод для поиска
        int resultIterative = BinarySearch.Iterative(arr, target);
        if (resultIterative != -1) {
            System.out.println("Элемент " + target + " найден (итеративный) по индексу: " + resultIterative);
        } else {
            System.out.println("Элемент " + target + " не найден (итеративный)");
        }
    }
}