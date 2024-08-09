import java.util.Scanner;

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
        System.out.println("1 - Überprüft, wie oft eine Box in die andere passt");
        System.out.println("2 - Überprüfe, ob n Boxen in einen Container passen");
        System.out.println("\n---");
        System.out.println("0 - Programm Beenden");

        // Get User Input
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        int action = input.nextInt();

        // Switch Case
        switch (action) {
            case 1:
                compareTwoBoxes();
                break;
            case 2:
                compareNBoxes();
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

    public void compareTwoBoxes() {
        // Clear console
        this.clearConsole();

        // Length of Box A
        System.out.println("Bitte gebe die Länge der Box A ein:");
        @SuppressWarnings("resource")
        Scanner boxAlInput = new Scanner(System.in);
        int boxAl = boxAlInput.nextInt();

        // Width of Box A
        System.out.println("Bitte gebe die Breite der Box A ein:");
        @SuppressWarnings("resource")
        Scanner boxAwInput = new Scanner(System.in);
        int boxAw = boxAwInput.nextInt();

        // Height of Box A
        System.out.println("Bitte gebe die Höhe der Box A ein:");
        @SuppressWarnings("resource")
        Scanner boxAhInput = new Scanner(System.in);
        int boxAh = boxAhInput.nextInt();

        // Weight of Box A
        System.out.println("Bitte gebe das Eigengewicht der Box A ein:");
        @SuppressWarnings("resource")
        Scanner boxAWeightInput = new Scanner(System.in);
        int boxAWeight = boxAWeightInput.nextInt();

        // Max Weight of Box A
        System.out.println("Bitte gebe das maximale Beladungsgewicht der Box A ein:");
        @SuppressWarnings("resource")
        Scanner boxAMaxLoadInput = new Scanner(System.in);
        int boxAMaxLoad = boxAMaxLoadInput.nextInt();

        this.clearConsole();

        // Length of Box B
        System.out.println("Bitte gebe die Länge der Box B ein:");
        @SuppressWarnings("resource")
        Scanner boxBlInput = new Scanner(System.in);
        int boxBl = boxBlInput.nextInt();

        // Width of Box B
        System.out.println("Bitte gebe die Breite der Box B ein:");
        @SuppressWarnings("resource")
        Scanner boxBwInput = new Scanner(System.in);
        int boxBw = boxBwInput.nextInt();

        // Height of Box B
        System.out.println("Bitte gebe die Höhe der Box B ein:");
        @SuppressWarnings("resource")
        Scanner boxBhInput = new Scanner(System.in);
        int boxBh = boxBhInput.nextInt();

        // Weight of Box B
        System.out.println("Bitte gebe das Eigengewicht der Box B ein:");
        @SuppressWarnings("resource")
        Scanner boxBWeightInput = new Scanner(System.in);
        int boxBWeight = boxBWeightInput.nextInt();

        // Max Weight of Box B
        System.out.println("Bitte gebe das maximale Beladungsgewicht der Box B ein:");
        @SuppressWarnings("resource")
        Scanner boxBMaxLoadInput = new Scanner(System.in);
        int boxBMaxLoad = boxBMaxLoadInput.nextInt();

        // Calculate cm3 of Boxes
        int boxAcm3 = boxAl * boxAw * boxAh;
        int boxBcm3 = boxBl * boxBw * boxBh;

        // Calculate largest area of each box (3)
        int boxALargestArea = Math.max(boxAl * boxAw, Math.max(boxAl * boxAh, boxAw * boxAh));
        int boxBLargestArea = Math.max(boxBl * boxBw, Math.max(boxBl * boxBh, boxBw * boxBh));

        // Check which box is bigger, weight and biggest bottom area (1/2/3)
        if (boxAcm3 > boxBcm3 && boxALargestArea >= boxBLargestArea && boxBWeight * (boxAcm3 / boxBcm3) <= boxAMaxLoad) {
            System.out.println("Die Box B passt " + (boxAcm3 / boxBcm3) + " mal in die Box A. Es bleibt noch " + (boxAMaxLoad - (boxAWeight * (boxAcm3 / boxBcm3))) + "kg Platz in der Box A");
        } else if (boxAcm3 < boxBcm3 && boxBLargestArea >= boxALargestArea && boxAWeight * (boxBcm3 / boxAcm3) <= boxBMaxLoad) {
            System.out.println("Die Box A passt " + (boxBcm3 / boxAcm3) + " mal in die Box B. Es bleibt noch " + (boxBMaxLoad - (boxBWeight * (boxBcm3 / boxAcm3))) + "kg Platz in der Box B");
        } else {
            System.out.println("Das packen ist nicht möglich, da die Boxen gleich groß sind oder die Gewichtsbeschränkungen nicht eingehalten werden können");
        }

        this.restartProgramm();
    }

    public void compareNBoxes() {
        // Clear console
        this.clearConsole();

        // Length of Main Box
        System.out.println("Bitte gebe die Länge der Hauptbox ein:");
        @SuppressWarnings("resource")
        Scanner mainBoxInput = new Scanner(System.in);
        int mainBoxLength = mainBoxInput.nextInt();

        // Width of Main Box
        System.out.println("Bitte gebe die Breite der Hauptbox ein:");
        int mainBoxWidth = mainBoxInput.nextInt();

        // Height of Main Box
        System.out.println("Bitte gebe die Höhe der Hauptbox ein:");
        int mainBoxHeight = mainBoxInput.nextInt();

        // Calculate cm3 of Main Box
        int mainBoxVolume = mainBoxLength * mainBoxWidth * mainBoxHeight;

                    this.clearConsole();

        // Number of additional boxes
        System.out.println("Bitte gebe die Anzahl der zusätzlichen Boxen ein:");
        int numberOfBoxes = mainBoxInput.nextInt();

        for (int i = 1; i <= numberOfBoxes; i++) {
            this.clearConsole();
            System.out.println("Box " + i + ":");

            // Length of Additional Box
            System.out.println("Bitte gebe die Länge der Box ein:");
            int boxLength = mainBoxInput.nextInt();

            // Width of Additional Box
            System.out.println("Bitte gebe die Breite der Box ein:");
            int boxWidth = mainBoxInput.nextInt();

            // Height of Additional Box
            System.out.println("Bitte gebe die Höhe der Box ein:");
            int boxHeight = mainBoxInput.nextInt();

            // Calculate cm3 of Additional Box
            int boxVolume = boxLength * boxWidth * boxHeight;

            // Check if the additional box fits into the main box
            if (boxVolume <= mainBoxVolume) {
                System.out.println("Die Box " + i + " passt " + mainBoxVolume/boxVolume + "x in die Hauptbox. (Weiter in 2 Sekunden)");
            } else {
                System.out.println("Die Box " + i + " passt nicht in die Hauptbox. (Weiter in 2 Sekunden)");
            }
            
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

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