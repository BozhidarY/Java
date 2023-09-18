package Files.lab7;

import java.io.*;
import java.util.ArrayList;

public class Service {
    private static final String devicesFilepath = System.getProperty("user.dir") + "\\src\\lab_exercises\\lab_7\\files\\devices.ser";
    private static final String brokenDevicesFilepath = System.getProperty("user.dir") + "\\src\\lab_exercises\\lab_7\\files\\brokenDevices.ser";

    private ArrayList<Device> devices;
    private ArrayList<BrokenDevice> brokenDevices;

    public ArrayList<Device> getDevices() {
        return devices;
    }

    public void setDevices(ArrayList<Device> devices) {
        this.devices = devices;
    }

    public ArrayList<BrokenDevice> getBrokenDevices() {
        return brokenDevices;
    }

    public void setBrokenDevices(ArrayList<BrokenDevice> brokenDevices) {
        this.brokenDevices = brokenDevices;
    }

    public void writeToFile(ArrayList<Device> devices, ArrayList<BrokenDevice> brokenDevices) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(brokenDevicesFilepath);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(brokenDevices);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream(devicesFilepath);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(devices);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void getDevicesFromFile() {
        try (FileInputStream fileInputStream = new FileInputStream(devicesFilepath);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            Object obj = objectInputStream.readObject();
            if (obj instanceof ArrayList<?> list) {
                if (list.get(0) != null && list.get(0) instanceof Device) {
                    setDevices((ArrayList<Device>) list);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }

        try (FileInputStream fileInputStream = new FileInputStream(brokenDevicesFilepath);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            Object obj = objectInputStream.readObject();
            if (obj instanceof ArrayList<?> list) {
                if (list.get(0) != null && list.get(0) instanceof BrokenDevice) {
                    setBrokenDevices((ArrayList<BrokenDevice>) list);

                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    public void addNewDevice(Device newDevice){
        this.devices.add(newDevice);
    }

    public void addNewBrokenDevice(BrokenDevice newBrokenDevice){
        this.brokenDevices.add(newBrokenDevice);
    }

    public void printDevices() {
        System.out.println("devices=" + devices);
    }
    public void printBrokenDevices() {
        System.out.println("broken devices=" + brokenDevices);
    }

    public void moveRepairedDevice(BrokenDevice brokenDevice){
        this.devices.add((Device) brokenDevice);
        this.brokenDevices.remove(brokenDevice);
    }

    public void printAllBrokenWithSameReason(String reason){
        this.brokenDevices.stream().filter(bd -> bd.getReason().equals(reason)).forEach(System.out::println);
    }

    public double subDevicesPrice(){
        double sum = 0;
        for (Device d: this.devices) {
            sum += d.getPrice();
        }

        return sum;
    }

    public double getIncome(double pricePerDay){
        double income = 0;
        for (BrokenDevice brokenDevice: brokenDevices) {
            income = brokenDevice.getPrice()*pricePerDay;
        }
        return income;
    }
}
