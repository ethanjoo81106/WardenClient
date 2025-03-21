package me.toot.Warden.config;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class Config {
    public static Configuration config;

    //example config
    public static boolean lobbyTracker;

    public static void init(File configFile){
        config = new Configuration(configFile);
        loadConfig();
    }

    private static void loadConfig(){
        try {
            config.load();

            // Read config values with default settings
            lobbyTracker = config.getBoolean("LobbyTracker", Configuration.CATEGORY_GENERAL, false, "Enable or disable the feature");
        } catch (Exception e) {
            System.out.println("Error reading config" + e);
        } finally {
            if (config.hasChanged()) {
                config.save();
            }
        }
    }
}
