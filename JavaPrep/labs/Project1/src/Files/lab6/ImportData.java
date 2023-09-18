package Files.lab6;

import Files.lab6.validation.WrongPhoneNumberException;

import java.io.IOException;

public interface ImportData {
    Object[] importDataFromFile() throws IOException, WrongPhoneNumberException;
}
