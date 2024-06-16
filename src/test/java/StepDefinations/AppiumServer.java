package StepDefinations;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;

public class AppiumServer
{
    static AppiumDriverLocalService server;
     static void setInstance()
    {
        AppiumServiceBuilder builder=new AppiumServiceBuilder();
        builder
                .withAppiumJS(new File("C:\\Users\\Archents\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
                .usingPort(4723)
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                .withLogFile(new File("D:\\_repose\\NewProjectNewBaseStep\\Appiumlog.txt"))
                .withIPAddress("127.0.0.1");
        server=AppiumDriverLocalService.buildService(builder);
    }
    static AppiumDriverLocalService getInstance()
    {
        if(server==null)
        {
            setInstance();
        }
        return server;
    }
    public static void startAppium() throws InterruptedException {
        getInstance().start();
        System.out.println("Server URL is "+server.getUrl());
        System.out.println("Server is Started "+server.isRunning());

    }
    public static void stopAppium()
    {
        if(server != null)
        {
            getInstance().stop();
            System.out.println("Server is stopped");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AppiumServer.startAppium();
        Thread.sleep(3000);
        AppiumServer.stopAppium();
    }
}
