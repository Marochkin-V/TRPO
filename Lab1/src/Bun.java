import java.util.Date;
import java.util.List;
import java.util.Scanner;

abstract class Bun {
    private double cost;
    private List<String> ingredients;
    private Date dateTimeCreated;

    public Bun(double cost, List<String> ingredients, Date preparationDate) {
        this.cost = cost;
        this.ingredients = ingredients;
        this.dateTimeCreated = preparationDate;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public Date getDateTimeCreated() {
        return dateTimeCreated;
    }

    public void setDateTimeCreated(Date dateTimeCreated) {
        this.dateTimeCreated = dateTimeCreated;
    }

    abstract void displayInfo();

    public int howLongAgo() {
        Date now = new Date();
        long diffInMillis = now.getTime() - dateTimeCreated.getTime();
        return (int) (diffInMillis / (60 * 1000)); // разница в минутах
    }

    public void addIngredientsFromUser() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String ingredient = scanner.nextLine().trim();

            if (ingredient.equalsIgnoreCase("done")) {
                break;
            }

            ingredients.add(ingredient);
        }
    }
}