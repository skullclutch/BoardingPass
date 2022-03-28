import java.util.Locale;
import java.util.UUID;

public class GenNumber {
    private String randomUUID;

    public GenNumber(){
        this.randomUUID = UUID.randomUUID().toString().split("-")[0].toUpperCase(Locale.ROOT);
    }

    public String getNumber(){
        return randomUUID;
    }
}
