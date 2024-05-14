import model.entities.Account;
import model.exceptions.DomainException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("\n-- Enter account data --");
            System.out.print("\nNumber: ");
            int number = sc.nextInt();
            sc.nextLine();

            System.out.print("Holder: ");
            String holder = sc.nextLine();

            System.out.print("Inicial balance: ");
            double initialBalance = sc.nextDouble();

            System.out.print("Withdraw limit: ");
            double withdrawLimit = sc.nextDouble();

            Account account = new Account(number, holder, initialBalance, withdrawLimit);

            System.out.print("\nEnter amount for withdraw: ");
            double withdrawAmount = sc.nextDouble();
            account.withdraw(withdrawAmount);

            System.out.println("New balance: " + account.getBalance());
        }
        catch (InputMismatchException e){
            System.out.println("Value not allowed");
        }
        catch (DomainException e){
            System.out.println(e.getMessage());
        }


        sc.close();
    }
}