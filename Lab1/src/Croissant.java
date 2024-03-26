import java.util.List;
import java.util.Date;

class Croissant extends Bun {
    public Croissant(double cost, List<String> ingredients, Date preparationDate) {
        super(cost, ingredients, preparationDate);
    }

    @Override
    void displayInfo() {
        System.out.println("Croissant");
        System.out.println("Cost: " + getCost());
        System.out.println("Ingredients: " + getIngredients());
        System.out.println("Date Created: " + getDateTimeCreated());
        System.out.println("CreCated " + howLongAgo() + " minutes ago");
    }
}