package lab7;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private ArrayList<Device> devices;
    private ArrayList<BrokenDevice> brokenDevices;

    public Service(){
       devices = new ArrayList<>();
       brokenDevices = new ArrayList<>();
    }

    public void saveToFile(String filename) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(devices);
            outputStream.writeObject(brokenDevices);
            System.out.println("Lists saved to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String filename) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            devices = (ArrayList<Device>) inputStream.readObject();
            brokenDevices = (ArrayList<BrokenDevice>) inputStream.readObject();
            System.out.println("Lists loaded from " + filename);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addDevices(Device device){
        devices.add(device);
    }
    public void addBrokenDevices(BrokenDevice brokenDevice){
        brokenDevices.add(brokenDevice);
    }

    public void displayDevices(){
        System.out.println("Healthy devices");
        for(Device device: devices){
            System.out.println(device.toString());
        }
        System.out.println("Broken Devices");
        for(BrokenDevice brokenDevice: brokenDevices){
            System.out.println(brokenDevice.toString());
        }
    }

    public void transferDevice(){
        for(BrokenDevice brokenDevice: brokenDevices){
            if(brokenDevice.getRepairTime().equals("0")) {
                devices.add(brokenDevice);
            }
        }
    }

    public void findDamage(String damage){
        for(BrokenDevice brokenDevice: brokenDevices){
            if(brokenDevice.getDamage().equalsIgnoreCase(damage)){
                System.out.println(brokenDevice.toString());
            }
        }
    }




}
