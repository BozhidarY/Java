package lab11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tickets {

    private String message;
    private boolean isResolved;

    public Tickets(String message, boolean isResolved) {
        this.message = message;
        this.isResolved = isResolved;
    }

    public void changeStatus(){
        setResolved(true);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isResolved() {
        return isResolved;
    }

    public void setResolved(boolean resolved) {
        isResolved = resolved;
    }
}
