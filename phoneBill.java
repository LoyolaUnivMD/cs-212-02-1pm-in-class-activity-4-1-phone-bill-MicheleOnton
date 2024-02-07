
import java.util.Scanner;
import java.text.DecimalFormat;
class phoneBill {
    public static void main(String[] args) {

        System.out.println("Phone Bill Activity!");

        //Define New Objects for imports
        Scanner input = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");

        // Initialize variables
        int discount = 20;
        int data_incl = 0;
        int price_per_GB = 0;
        double price;
        int data_price;

        //Ask the user for the subscription he has
        System.out.print("What subscription do you have? (green,blue,purple): ");
        String sub = input.nextLine();
        String subscription = sub.toLowerCase();

        // Ask the user how many gigabits he used
        System.out.print("How many gigabits of data did you use?: ");
        int data = input.nextInt();

        if (subscription.equals("green") || subscription.equals("blue") || subscription.equals("purple")) {

            if (subscription.equals("green")) {
                data_incl = 2;
                price_per_GB = 15;
                price = 49.99;
                System.out.print("Do you have a coupon? (Enter 'yes' or 'no'): ");
                String coupon = input.next();
                String coupon_formatted = coupon.toLowerCase();
                if (coupon_formatted.equals("yes")) {
                    price -= discount;
                }
            } else if (subscription.equals("blue")) {
                data_incl = 4;
                price_per_GB = 10;
                price = 70;
            } else {
                price = 99.95;
            }

            if (!subscription.equals("purple") && data >= data_incl) {
                data_price = (data - data_incl) * price_per_GB;
                price += data_price;
            }

            // Print out the monthly bill
            System.out.println("Your monthly bill is $" + df.format(price));

        } else {
            System.out.println("This subscription is not valid");
        }

    }
}
