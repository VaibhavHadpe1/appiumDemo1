package StepDefinations;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LaunchEmulator {

    public static void main(String[] args) throws InterruptedException {
        startEmulator();
    }
//    public static void startEmulator() throws InterruptedException {Thread.sleep(3000);
//        String androidSdkPath = "C:\\Users\\Archents\\AppData\\Local\\Android\\Sdk";
//        String emulatorName = "Pixel_6a_API_33"; // Replace with your emulator name
//
//        try {
//            ProcessBuilder processBuilder = new ProcessBuilder(androidSdkPath + "/emulator/emulator", "-avd", emulatorName);
//            Process process = processBuilder.start();
//
//            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//            }
//
//            int exitCode = process.waitFor();
//            System.out.println("\nEmulator started with exit code: " + exitCode);
//            Thread.sleep(10000);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    public static void startEmulator() throws InterruptedException {
        Thread.sleep(3000);
        String androidSdkPath = "C:\\Users\\Archents\\AppData\\Local\\Android\\Sdk";
        String emulatorName = "Pixel_6_API_33";
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(androidSdkPath + "/emulator/emulator", "-avd", emulatorName);
            Process process = processBuilder.start();
            Thread.sleep(5000);
            System.out.println("Emulator launched");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

