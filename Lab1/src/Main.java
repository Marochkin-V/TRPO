import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Bun> buns = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        Date now = new Date();
        buns.add(new Baguette   (1.0 + (10.0 - 1.0) * Math.random(), Arrays.asList("Flour", "Water", "pepper"), new Date(now.getTime())));
        buns.add(new Croissant  (1.0 + (10.0 - 1.0) * Math.random(), Arrays.asList("Flour", "Salt", "Olive oil"), new Date(now.getTime())));
        buns.add(new Baton      (1.0 + (10.0 - 1.0) * Math.random(), Arrays.asList("Whole wheat flour", "Water", "Honey"), new Date(now.getTime())));

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Добавить булку");
            System.out.println("2. Удалить булку");
            System.out.println("3. Добавить ингредиенты в булку");
            System.out.println("4. Вывести все булки с перцем");
            System.out.println("5. Вывести информацию о всех булках");
            System.out.println("6. Вывести информацию о булках, приготовленных не более 5 минут назад");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Чтобы считать символ новой строки после ввода числа

            switch (choice) {
                case 1:
                    addBun(buns);
                    break;
                case 2:
                    removeBun(buns);
                    break;
                case 3:
                    addIngredientsToBun(buns);
                    break;
                case 4:
                    displayBunsWithPepper(buns);
                    break;
                case 5:
                    displayAllBuns(buns);
                    break;
                case 6:
                    displayRecentBuns(buns);
                    break;
                case 0:
                    System.out.println("Программа завершена.");
                    System.exit(0);
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        }
    }

    private static Date parseDateString(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Некорректный формат даты и времени. Используйте 'yyyy-MM-dd HH:mm:ss'.");
            return null;
        }
    }

    private static void addBun(List<Bun> buns) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите тип булки (1. Baguette, 2. Baton, 3. Croissant): ");
        int bunType = scanner.nextInt();
        scanner.nextLine(); // Чтобы считать символ новой строки после ввода числа

        System.out.println("Введите стоимость: ");
        double cost = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Введите дату и время приготовления (в формате 'yyyy-MM-dd HH:mm:ss'): ");
        String preparedAtString = scanner.nextLine();
        Date preparedAt = parseDateString(preparedAtString);
        if (preparedAt == null)
        {
            addBun(buns);
            return;
        }

        List<String> ingredients = new ArrayList<>();
        System.out.println("Введите ингредиенты (для завершения введите 'done'): ");
        while (true) {
            String ingredient = scanner.nextLine().trim();
            if (ingredient.equalsIgnoreCase("done")) {
                break;
            }
            ingredients.add(ingredient);
        }

        Bun bun;
        switch (bunType) {
            case 1:
                bun = new Baguette(cost, ingredients, preparedAt);
                break;
            case 2:
                bun = new Baton(cost, ingredients, preparedAt);
                break;
            case 3:
                bun = new Croissant(cost, ingredients, preparedAt);
                break;
            default:
                System.out.println("Некорректный выбор типа булки.");
                return;
        }

        buns.add(bun);
        System.out.println("Булка добавлена.");
    }

    private static void removeBun(List<Bun> buns) {
        // Здесь вам нужно добавить код для удаления булки из списка
        // Пример:
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер булки для удаления (от 1 до " + buns.size() + "): ");
        int bunNumber = scanner.nextInt();
        scanner.nextLine(); // Чтобы считать символ новой строки после ввода числа

        if (bunNumber >= 1 && bunNumber <= buns.size()) {
            buns.remove(bunNumber - 1);
            System.out.println("Булка удалена.");
        } else {
            System.out.println("Некорректный номер булки.");
        }
    }

    private static void addIngredientsToBun(List<Bun> buns) {
        // Здесь вам нужно добавить код для добавления ингредиентов в выбранную булку
        // Пример:
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер булки для добавления ингредиентов (от 1 до " + buns.size() + "): ");
        int bunNumber = scanner.nextInt();
        scanner.nextLine(); // Чтобы считать символ новой строки после ввода числа

        if (bunNumber >= 1 && bunNumber <= buns.size()) {
            Bun bun = buns.get(bunNumber - 1);

            List<String> newIngredients = new ArrayList<>();
            System.out.println("Введите новые ингредиенты (для завершения введите 'done'): ");
            bun.addIngredientsFromUser();
            System.out.println("Ингредиенты добавлены.");
        } else {
            System.out.println("Некорректный номер булки.");
        }
    }

    private static void displayBunsWithPepper(List<Bun> buns) {
        // Здесь вам нужно добавить код для вывода информации о булках с перцем
        // Пример:
        System.out.println("Булки с перцем:");
        for (Bun bun : buns) {
            if (bun.getIngredients().contains("pepper")) {
                bun.displayInfo();
            }
        }
    }

    private static void displayAllBuns(List<Bun> buns) {
        // Здесь вам нужно добавить код для вывода информации о всех булках
        // Пример:
        System.out.println("Информация о всех булках:");
        for (Bun bun : buns) {
            bun.displayInfo();
        }
    }

    private static void displayRecentBuns(List<Bun> buns) {
        System.out.println("Булки, приготовленные не более 5 минут назад:");
        for (Bun bun : buns) {
            if (bun.howLongAgo() <= 5) {
                bun.displayInfo();
            }
        }
    }
}
