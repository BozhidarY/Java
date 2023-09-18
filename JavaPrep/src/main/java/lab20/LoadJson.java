package lab20;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lab19.Users.UserDB;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LoadJson {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public void saveUsers(String fileName,DataB userDB){
        try(FileWriter fileWriter = new FileWriter(fileName)){
            gson.toJson(userDB, fileWriter);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public DataB loadUsers(String fileName){
        try(FileReader fileReader = new FileReader(fileName)){
            return gson.fromJson(fileReader, DataB.class);
        }catch (IOException e){
            e.printStackTrace();
            return new DataB();
        }
    }
}
