package core.logger;

public class DefaultLogger implements Logger {

    public void info(Object msg) {
        System.out.println(msg);
    }
}
