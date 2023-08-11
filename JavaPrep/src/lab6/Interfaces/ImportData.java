package lab6.Interfaces;

import java.io.IOException;

public interface ImportData {
    Object[] importDataFromFile() throws IOException;
    int getNumberOfRows() throws IOException;
}
