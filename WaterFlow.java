import java.util.Scanner;

public class WaterFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Fråga efter rad och glas
        System.out.print("Rad: ");
        int r = scanner.nextInt();
        System.out.print("Glas: ");
        int g = scanner.nextInt();

        // Beräkna tiden
        double time = calculateTime(r, g);

        // Skriv ut svaret
        System.out.printf("Det tar %.3f sekunder.\n", time);

        scanner.close();
    }

    public static double calculateTime(int r, int g) {
        // Beräkna antalet glas
        int totalGlasses = (r * (r + 1)) / 2;

        // Beräkna den totala tiden för att fylla glasen
        double totalTime = 10 * totalGlasses;

        // Beräkna den tid som glaset på raden r, glas g börjar rinna över
        // Summan av tiderna för att fylla glasen ovanför
        double aboveTime = 10 * ((g * (g - 1)) / 2);

        // Hantera fyllningshastigheten för glasen på raden r
        // Kantglasen fylls i samma hastighet, medan mittglasen fylls dubbelt så snabbt
        if (g != 1 && g != r) {
            aboveTime += 20 * (g - 1);
        } else if (g == r) {
            aboveTime += 20 * (g - 1) / 2.0;
        }

        return totalTime - aboveTime;
    }
}
