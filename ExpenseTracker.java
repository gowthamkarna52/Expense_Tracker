import java.util.*;

class ExpenseTracker {
    static double balance = 0;
    static Scanner sc = new Scanner(System.in);
    static List<String> records = new ArrayList<>();

    public static void main(String[] args) {
        int choice=0;
        System.out.println("=====  SIMPLE EXPENSE TRACKER  =====");
        do {
            try{
            System.out.println("\n1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Balance");
            System.out.println("4. View History");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addIncome();
                case 2 -> addExpense();
                case 3 -> viewBalance();
                case 4 -> viewHistory();
                case 5 -> {System.out.println("Thanks for using Expense Tracker!");System.out.println(" ===================  PROGRAM ENDED  =================== ");}
                default -> System.out.println("Invalid choice!");
            }
            }catch(InputMismatchException e){
                System.out.println("Please enter a valid number...");
                sc.nextLine();
            }
        } while (choice != 5);
    }

    static void addIncome(){
        try{
        System.out.print("Enter income amount: Rs.");
        double amt = sc.nextDouble(); sc.nextLine();
        System.out.print("Enter source: ");
        String src = sc.nextLine();
        balance += amt;
        records.add("Income  | " + src + " | Rs." + amt);
        System.out.println("Income added.");
        }catch(InputMismatchException e){
            System.out.println("Invalid amount entered.");
            sc.nextLine();
        }
    }
    static void addExpense() {
        try{
        System.out.print("Enter expense amount: Rs.");
        double amt = sc.nextDouble(); sc.nextLine();
        System.out.print("Enter category: ");
        String cat = sc.nextLine();
        if (amt > balance) System.out.println("Not enough balance!");
        else {
            balance -= amt;
            records.add("Expense | " + cat + " | Rs." + amt);
            System.out.println("Expense added.");
        }
        }catch(InputMismatchException e){
            System.out.println("Invalid amount entered.");
            sc.nextLine();
        }
    }

    static void viewBalance() {
        System.out.println("Current Balance: Rs." + balance);
    }

    static void viewHistory() {
        if (records.isEmpty()) System.out.println("No records yet.");
        else {
            System.out.println("\n===== Transaction History =====");
            records.forEach(System.out::println);
        }
    }

}
