import java.util.List;
import java.util.Date;

class Baguette extends Bun {
    public Baguette(double cost, List<String> ingredients, Date preparationTime) {
        super(cost, ingredients, preparationTime);
    }

    @Override
    void displayInfo() {
        System.out.println("Baguette");
        System.out.println("Cost: " + getCost());
        System.out.println("Ingredients: " + getIngredients());
        System.out.println("Date Created: " + getDateTimeCreated());
        System.out.println("Created " + howLongAgo() + " minutes ago");
    }
}
