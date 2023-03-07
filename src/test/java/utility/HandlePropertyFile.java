package utility;

import tests.AmazonHomePageTest;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class HandlePropertyFile {
    public static void main(String[] args) {
        getproperties();
    }
    public static void getproperties(){
        try{
            Properties properties = new Properties();
            String projectPath = System.getProperty("user.dir");

            System.out.println(System.getProperty("user.dir"));
            System.out.println(projectPath +"\\src\\test\\java\\config");

            InputStream input = new FileInputStream(projectPath +"\\src\\test\\java\\config\\config.properties");

            properties.load(input);
            String browser = properties.getProperty("browser");
            System.out.println(browser);

            AmazonHomePageTest.browserName = browser;

        }
        catch (Exception e){
            e.getMessage();
            e.getCause();
            e.getStackTrace();
        }

    }
}
