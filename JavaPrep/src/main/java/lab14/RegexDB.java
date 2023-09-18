package lab14;

import lab14.Consctructors.Regex;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RegexDB {

    public static List<Regex> regexs = Collections.synchronizedList(new ArrayList<>());

    public static void saveRegexs(String filename){
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))){
            objectOutputStream.writeObject(regexs);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static List<Regex> loadFromFile(String fileName){
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))){
            regexs  = (List<Regex>) objectInputStream.readObject();
        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return regexs;
    }


}
