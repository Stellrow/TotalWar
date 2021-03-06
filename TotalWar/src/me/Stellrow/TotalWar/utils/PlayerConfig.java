package me.Stellrow.TotalWar.utils;

import me.Stellrow.TotalWar.TotalWar;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class PlayerConfig {
    private final TotalWar pl;
    private File file;
    private FileConfiguration filecfg;
    public PlayerConfig(String name, TotalWar pl) {
        this.pl = pl;
        createConfig(name);
    }
    private void createConfig(String name) {
        file = new File(pl.playersFolder,name+".yml");
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        loadConfig();
    }
    private void loadConfig() {
        filecfg = YamlConfiguration.loadConfiguration(file);
    }
    public FileConfiguration getCfg() {
        return filecfg;
    }
    public void save() {
        try {
            filecfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
