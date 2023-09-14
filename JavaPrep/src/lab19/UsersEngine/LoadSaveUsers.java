package lab19.UsersEngine;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lab19.Users.UserDB;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LoadSaveUsers {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public void saveUsers(String fileName, UserDB userDB){
        try(FileWriter fileWriter = new FileWriter(fileName)){
            UserDBWrapper wrapper = new UserDBWrapper(userDB.getUsersList());

            // Serialize the wrapper to JSON
            String json = gson.toJson(wrapper);

            // Write the JSON data to the file
            fileWriter.write(json);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public UserDB loadUsers(String fileName){
        try(FileReader fileReader = new FileReader(fileName)){
            UserDB userDB = gson.fromJson(fileReader, UserDB.class);
//            System.out.println("True");
            return userDB;
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

}
