import java.util.Scanner;

public class GlassPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Rad? ");
        int r = scanner.nextInt();
        System.out.print("Glas? ");
        int g = scanner.nextInt();

        // Pyramid storlek
        int rows = 50;
        double[][] glasses = new double[rows + 1][rows + 1];

        // Vattenfyllningshastighet
        double fillRate = 1.0 / 10.0;
        double time = 0.0;

        while (glasses[r][g] < 1.0) {
            // Häll vatten i översta glaset
            glasses[1][1] += fillRate;

            // Uppdatera vattenflödet genom pyramiden
            for (int i = 1; i <= rows; i++) {
                for (int j = 1; j <= i; j++) {
                    if (glasses[i][j] > 1.0) {
                        double overflow = glasses[i][j] - 1.0;
                        glasses[i][j] = 1.0;
                        glasses[i + 1][j] += overflow / 2;
                        glasses[i + 1][j + 1] += overflow / 2;
                    }
                }
            }

            // Öka tiden med 0.001 sekunder för noggrannhet
            time += 0.001;
        }

        // Utskriften ska vara korrekt med minst 3 decimalers noggrannhet
        //  System.out.printf("Det tar %.3f sekunder.\n", time);

        // Utskriften ska vara korrekt med minst 3 decimalers noggrannhet
        // Konvertera sekunder till millisekunder för utskrift
        double timeInMilliseconds = time * 1000;
        System.out.printf("Det tar %.0f sekunder.\n", timeInMilliseconds);
    }
}
