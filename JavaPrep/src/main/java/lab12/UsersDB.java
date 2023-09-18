package lab12;

import lab12.Constructors.Admin;
import lab12.Constructors.Student;
import lab12.Constructors.Teacher;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UsersDB {

    public static final String filePath = "D:\\Java Prep\\Java\\JavaPrep\\src\\lab12\\users.bin";

    public static List<Admin> admins = Collections.synchronizedList(new ArrayList<>());
    public static List<Student> students = Collections.synchronizedList(new ArrayList<>());
    public static List<Teacher> teachers = Collections.synchronizedList(new ArrayList<>());

    public static void saveToFile(String fileName){
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))){
            objectOutputStream.writeObject(admins);
            objectOutputStream.writeObject(students);
            objectOutputStream.writeObject(teachers);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void loadFromFile(String fileName){
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))){
            admins = (ArrayList<Admin>) objectInputStream.readObject();
            students = (ArrayList<Student>) objectInputStream.readObject();
            teachers = (ArrayList<Teacher>) objectInputStream.readObject();
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }




}
