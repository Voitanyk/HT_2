import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    public String getValue(String propertyName){
        Properties properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream("/Users/ivoitanyk/IdeaProjects/HT_2/src/main/resources/app.properties");
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            System.err.println("Error reading properties file");
            e.printStackTrace();
        }
        return properties.getProperty(propertyName);
    }
}
