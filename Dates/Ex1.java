import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ex1 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedNow = now.format(formatter);
        System.out.println("Aktualna data i czas: " + formattedNow);
    }
}