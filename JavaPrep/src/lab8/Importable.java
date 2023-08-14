package lab8;

import lab8.Exceptions.UnrecognisedRowException;

import java.io.IOException;

public interface Importable {
    public Object[] importDateFromFile() throws IOException;
}
