import java.util.*;

public class Store implements ConsoleMenu {

    private List<Product> list = new ArrayList<>();

    public Store() {
        start();
    }

    @Override
    public void show() {
        if (list.isEmpty()) {
            System.out.println("No products available at the moment.");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose a sorting principle:\nby price (min - max)  - 0\n" +
                "by price (max - min)   - 1\nby adding (from new to old)  - 2");
        int input = scanner.nextInt();
        if (input < 0) {
            System.out.println("Please restart the app.");
            return;
        }
        if (input > 2) {
            System.out.println("Please restart the app.");
            return;
        }
        switch (input) {
            case 0:
                Collections.sort(list);
                System.out.println(list);
                break;

            case 1:
                Collections.sort(list, Collections.reverseOrder());
                System.out.println(list);
                break;

            case 2:
                for (int i = list.size() - 1; i >= 0; i--) {
                    System.out.println(list.get(i));
                }
                break;

        }

    }

    @Override
    public void add() {
        Product product = new Product();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter this product name:");
        product.setName(scanner.nextLine());
        System.out.println("Enter this product ID:");
        int id = scanner.nextInt();
        while (id <= 0) {
            System.out.println("The product ID can be neither zero nor negative. " +
                    "Try to enter the ID again:");
            id = scanner.nextInt();
        }
        product.setId(id);
        System.out.println("Enter the price: ");
        int price = scanner.nextInt();
        while (price <= 0) {
            System.out.println("Try again:");
            price = scanner.nextInt();
        }
        product.setPrice(price);
        /* using equals(Product x)
        boolean found = false;
        for (Product x : list) {
            if (product.equals(x)) {
                found = true;
            }
        }
        if (found) {
            System.out.println("The product of the characteristics " +
                    "you've entered has already been added.");
            return;
        } else {
            list.add(product);
        }
        */
        if (list.contains(product)) {
            System.out.println("The product of the characteristics " +
                    "you've entered has already been added.");
            return;
        } else {
            list.add(product);
        }
    }

    @Override
    public void remove() {
        Scanner scanner = new Scanner(System.in);
        boolean found = false;
        System.out.println("Please enter the ID of the item you would like to remove:");
        int input = scanner.nextInt();
        while (input <= 0) {
            System.out.println("The product ID can be neither zero nor negative. \" +\n" +
                    "                    \"Try to enter the ID again:");
            input = scanner.nextInt();
        }
        int index = 0;
        for (Product x : list) {
            if (x.getId() == input) {
                found = true;
                index = list.indexOf(x);
                break;
            }
        }
        if (found) {
            list.remove(index);
        } else {
            System.out.println("There is no product with this ID.");
        }

    }

    @Override
    public void change() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the ID of the item, " +
                "which characteristics you would like to change:");
        int inputID = scanner.nextInt();
        while (inputID <= 0) {
            System.out.println("The product ID can be neither zero nor negative. \" +\n" +
                    "                    \"Try to enter the ID again:");
            inputID = scanner.nextInt();
        }

        boolean found = false;
        Product productToChange = null;
        for (Product x : list) {
            if (inputID == x.getId()) {
                found = true;
                productToChange = x;
                break;
            }
        }
        if (found == false) {
            System.out.println("The product with this ID was not found.");
            return;
        }
        String inputNewName;
        int inputNewPrice;
        System.out.println("Enter a new name:");
        scanner.nextLine();
        inputNewName = scanner.nextLine();
        System.out.println("Enter a new price:");
        inputNewPrice = scanner.nextInt();
        while (inputNewPrice <= 0) {
            System.out.println("Try again:");
            inputNewPrice = scanner.nextInt();
        }
        if (found) {
            productToChange.setName(inputNewName);
            productToChange.setPrice(inputNewPrice);
        }


    }


    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose what you want to do and enter :\n" +
                "to look through all items - 0\nto add an item - 1\n" +
                "to remove an item - 2\nto change an item's characteristics - 3\nto leave - 4");
        int input = scanner.nextInt();
        if (input < 0 || input > 4) {
            System.out.println("Please restart the app.");
            return;
        }
        if (input == 4) {
            System.out.println("Bye!");
            return;
        }
        while (input >= 0 & input <= 3) {
            switch (input) {
                case 0:
                    this.show();
                    break;
                case 1:
                    this.add();
                    break;
                case 2:
                    this.remove();
                    break;
                case 3:
                    this.change();
                    break;
            }
            System.out.println("Please choose what you want to do and enter :\n" +
                    "to look through all items - 0\nto add an item - 1\n" +
                    "to remove an item - 2\nto change an item's characteristics - 3\nto leave - 4");
            input = scanner.nextInt();

        }
        System.out.println();
        System.out.println();


    }
}
