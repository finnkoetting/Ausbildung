import java.util.Scanner;

// Demo ISBN: 3-464-54105-3

public class App {
    public static void main(String[] args) throws Exception {
        App app = new App();
        app.newAction();
    }

    public void newAction() {
        // Clear console
        this.clearConsole();

        // Print Menu
        System.out.println("Bitte Wähle eine Aktion aus, die du Tätigen willst:");
        System.out.println("1 - Prüfziffer Generieren");
        System.out.println("2 - ISBN Prüfen");
        System.out.println("\n---");
        System.out.println("0 - Programm Beenden");

        // Get User Input
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        int action = input.nextInt();

        // Switch Case
        switch (action) {
            case 1:
                generateCheck();
                break;
            case 2:
                checkISBN();
                break;
            case 0:
                System.out.println("Programm wird beendet...");
                System.exit(0);
                break;
            default:
                System.out.println("Ungültige Eingabe");
                this.newAction();
                break;
        }
    }

    public void generateCheck() {
        // Clear console
        this.clearConsole();

        // Print Menu
        System.out.println("Bitte gebe die ISBN ein:");

        // Get User Input
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        String isbn = input.nextLine();
        isbn = isbn.replaceAll("-", "");

        // Multiply numbers
        double sum = 0.0;
        int index = 0;

        for(int i = 10; index <= isbn.length() - 1; i--) {
            int currentNumber = Integer.parseInt("" + isbn.charAt(index));
            sum += currentNumber * i;
            index++;
        }

        // Calculate Check Digit
        long nearestEleven = Math.round(sum / 11.0) * 11;
        int checkDigit = (int) (nearestEleven - sum);

        // Print Check Digit
        System.out.println("Die Prüfziffer ist: " + checkDigit);
        
        // Restart Programm
        this.restartProgramm();
    }

    public void checkISBN() {
        // Clear console
        this.clearConsole();

        // Print Menu
        System.out.println("Bitte gebe die ISBN ein:");

        // Get User Input
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        String isbn = input.nextLine();
        isbn = isbn.replaceAll("-", "");

        int checkDigitProvided = Integer.parseInt("" + isbn.charAt(isbn.length() - 1));

        // Multiply numbers
        double sum = 0.0;
        int index = 0;

        for(int i = 10; index <= isbn.length() - 2; i--) {
            int currentNumber = Integer.parseInt("" + isbn.charAt(index));
            sum += currentNumber * i;
            index++;
        }

        // Calculate Check Digit
        long nearestEleven = Math.round(sum / 11.0) * 11;
        int checkDigit = (int) (nearestEleven - sum);

        // Check if Check Digit is correct
        if(checkDigit == checkDigitProvided) {
            System.out.println("Die ISBN ist Korrekt");
        } else {
            System.out.println("Die ISBN ist Falsch");
        }

        // Restart Programm
        this.restartProgramm();
    }

    public void restartProgramm() {
        System.out.println("\n\n\nWillst du eine Weitere Aktion Tätigen? (J/N)");
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        String restart = input.nextLine();

        switch (restart) {
            case "J":
                this.newAction();
                break;

            case "N":
                this.clearConsole();
                System.out.println("Programm wird beendet...");
                System.exit(0);
        
            default:
                this.restartProgramm();
                break;
        }
    }

    public void clearConsole() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }
}
