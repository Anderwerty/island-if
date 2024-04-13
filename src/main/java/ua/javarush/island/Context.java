package ua.javarush.island;

public class Context {

    private static final LogLevel LOG_LEVEL = LogLevel.PROD;

    public static LogLevel getLogLevel(){
        return LOG_LEVEL;
    }
}

