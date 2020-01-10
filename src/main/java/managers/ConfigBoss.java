package managers;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.ConfigDto;

import java.io.File;
import java.io.IOException;

public class ConfigBoss {

    public static String url;
    public static int timeout;
    public static String user;
    public static String password;

    static {
        url = getConfigData().getUrl();
        timeout = getConfigData().getTimeout();
        user = getConfigData().getUser();
        password = getConfigData().getPassword();
    }

    private static ConfigDto getConfigData(){
        ConfigDto config = new ConfigDto(); //nowy obiekt
        try {
            File file = new File(
                    ConfigBoss.class
                    .getClassLoader()
                    .getResource("config.json")
                    .getFile());
            config = new ObjectMapper().readValue(file, ConfigDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return config;
    }
}
