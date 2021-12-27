package validation;

/**
 * Class which is describing the structure of validation message printing after each validation
 * @author Nikita Safonov, student of AMM VSU, 3rd year, 3rd group
 * @see Validator
 * @see Status
 */
public class ValidationMessage {

    /** Status field */
    private Status status;

    /** Message field */
    private String message;

    public ValidationMessage() {
        this.status = Status.OK;
        this.message = "Валидация пройдена!";
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return
                "\nСтатус: " + status +
                "\nСообщение: " + message + '\n';
    }
}
