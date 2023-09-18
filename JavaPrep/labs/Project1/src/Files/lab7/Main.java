package Files.lab7;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Device> devices = new ArrayList<>();
        devices.add(new Device("b1", "m1", 14.66));
        devices.add(new Device("b2", "m2", 54.67));
        devices.add(new Device("b3", "m3", 32.19));

        ArrayList<BrokenDevice> brokenDevices = new ArrayList<>();
        brokenDevices.add(new BrokenDevice("b1", "m1", 14.66, "unknown", 3));
        brokenDevices.add(new BrokenDevice("b2", "m2", 54.67, "broken screen", 1));
        brokenDevices.add(new BrokenDevice("b3", "m3", 32.19, "battery death", 2));

        System.out.println(brokenDevices.get(2).getReason());

        Service service = new Service();
        service.writeToFile(devices, brokenDevices);
        service.getDevicesFromFile();
        System.out.println(service.getDevices());
        System.out.println(service.getBrokenDevices());
    }
}
