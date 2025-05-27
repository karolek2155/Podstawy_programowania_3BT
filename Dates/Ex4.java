import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Ex4 {
    public static void main(String[] args) {
        ZoneId warsaw = ZoneId.of("Europe/Warsaw");
        ZoneId tokyo = ZoneId.of("Asia/Tokyo");
        ZoneId newYork = ZoneId.of("America/New_York");
        ZoneId sydney = ZoneId.of("Australia/Sydney");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        ZonedDateTime nowWarsaw = ZonedDateTime.now(warsaw);
        ZonedDateTime nowTokyo = ZonedDateTime.now(tokyo);
        ZonedDateTime nowNewYork = ZonedDateTime.now(newYork);
        ZonedDateTime nowSydney = ZonedDateTime.now(sydney);

        System.out.println("Warszawa:   " + nowWarsaw.format(formatter));
        System.out.println("Tokio:      " + nowTokyo.format(formatter));
        System.out.println("Nowy Jork:  " + nowNewYork.format(formatter));
        System.out.println("Sydney:     " + nowSydney.format(formatter));
    }
}