import com.api.Logger;

public class LoggerImpl implements Logger {
    public void info(Object msg) {
        System.out.println(msg);
    }
}
