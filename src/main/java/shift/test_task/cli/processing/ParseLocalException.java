package shift.test_task.cli.processing;

import org.apache.commons.cli.ParseException;


public class ParseLocalException extends ParseException {
    private final String message;

    public ParseLocalException(String message) {
        super(message);
        this.message = message;
    }

    private String extractInvalidOption(String message) {
        if (message.contains("Unrecognized option")) {
            return message.replace("Unrecognized option: ", "").trim();
        }
        return "";
    }

    @Override
    public String getLocalizedMessage(){
        return "Неизвестная опция " + extractInvalidOption(message);
    }
}
