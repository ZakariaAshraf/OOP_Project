import java.util.*;
public class UserMain extends BurgerMasr {
    ArrayList<String> orders = new ArrayList<String>();
    ArrayList<String> additions = new ArrayList<String>();

    HashMap<String, Integer> receiptPrices = new HashMap<String, Integer>();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void viewMenu() {
        System.out.println("Menu : \n 1 - Beef Burger \n 2 - Chicken Burger \n 3 - Cheese Burger ");
        System.out.println("please select an option ");
        int type = scanner.nextInt();
        selectBurgerType(type);
        System.out.println("Do you like to add any additions : ");
        System.out.println("1 - Yes \n2 - No");
        int opinion = scanner.nextInt();
        selectOption(opinion);
        int prices = calculateTotalPrice();
        System.out.println("\nTotal    "+prices);


    }

    @Override
    protected void viewAditions() {
        System.out.println("Please Select options (like this 1,2)");
        System.out.println("Additions : \n 1 - Catchup \n 2 - Mayonnaise \n 3 - Tomatoes \n 4- Cheese  \n 5- i've had enough");
        int additionType = scanner.nextInt();
            if (additionType == 1) {
                additions.add("Catchup");
                receiptPrices.put("Catchup",Data.Catchup);
                viewAditions();
            } else if (additionType == 2) {
                additions.add("Mayonnaise");
                receiptPrices.put("Mayonnaise",Data.Mayonnaise);
                viewAditions();
            } else if (additionType == 3) {
                additions.add("Tomatoes");
                receiptPrices.put("Tomatoes",Data.Tomatoes);
                viewAditions();
            } else if (additionType == 4) {
                additions.add("Cheese");
                receiptPrices.put("Cheese",Data.Cheese);
                viewAditions();
            }else
                return;


    }

    @Override
    int selectBurgerType(int type) {
        if (type == 1) {
            orders.add("Beef Burger");
            receiptPrices.put("Beef Burger",Data.beefBurgerPrice);

        } else if (type == 2) {
            orders.add("Chicken Burger");
            receiptPrices.put("Chicken Burger",Data.chickenBurgerPrice);
        }else if (type == 3) {
            orders.add("Cheese Burger");
            receiptPrices.put("Cheese Burger",Data.cheeseBurgerPrice);
        }
        return type;
    }

    private int selectOption(int opinion) {

        if (opinion == 1 )
        {
            viewAditions();

            System.out.println("your order is :\n "+orders+"\n"+additions);
        }
        if (opinion == 2)
        {
            System.out.println("your order is : \n "+orders);
        }
        System.out.println("1 - Confirm \n2 - Back to menu");
        int confirmation = scanner.nextInt();
        showReceipt(confirmation);
        return opinion;
    }

    public void showReceipt(int confirmation){
        if (confirmation==1)
        {
            for (String i : receiptPrices.keySet()) {
                System.out.println( i + "\t" + "\t" + receiptPrices.get(i));
            }
        }else
            viewMenu();

    }
    private int calculateTotalPrice(){
            int price = 0;
        for (int i : receiptPrices.values()) {
           receiptPrices.get(i);
           price+=i;
        }
        return price;
    }
}