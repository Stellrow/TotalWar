package me.Stellrow.TotalWar;

import me.Stellrow.TotalWar.commandsmanager.CommandsManager;
import me.Stellrow.TotalWar.events.EventsManager;
import me.Stellrow.TotalWar.instances.InstanceManager;
import me.Stellrow.TotalWar.playermanager.PlayerManager;
import me.Stellrow.TotalWar.utils.ConfigUtils;
import me.Stellrow.TotalWar.utils.CustomConfig;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class TotalWar extends JavaPlugin {
    public CustomConfig arenas;
    public File playersFolder;
    private PlayerManager playerManager;
    private CommandsManager commandsManager;
    private EventsManager eventsManager;
    private InstanceManager instanceManager;
    private ConfigUtils cu = new ConfigUtils(this);
    private Location pos1,pos2;
    public void onEnable(){
        createConfigs();
        init();
    }

    private void init(){
        playerManager = new PlayerManager(this);
        commandsManager= new CommandsManager(this);
        eventsManager = new EventsManager(this);
        instanceManager = new InstanceManager(this);
    }
    public PlayerManager getPlayerManager(){
        return playerManager;
    }
    ///Config
    public InstanceManager getInstanceManager(){
        return instanceManager;
    }
    public CustomConfig getArenasConfig(){
        return arenas;
    }
    private void createConfigs(){
        loadConfig();
        createPlayerFolder();
        arenas = new CustomConfig(this,"arenas");
    }
    private void loadConfig(){
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
    private void createPlayerFolder(){
            playersFolder = new File("plugins/TotalWar/players/");
            if(!playersFolder.exists()) {
                playersFolder.mkdir();
            }
            getConfig().options().copyDefaults(true);
            saveConfig();
    }
    //Config end


    ///Pos 1/2
    public void setPos1(Location loc){
        pos1=loc;
    }
    public void setPos2(Location loc){
        pos2=loc;
    }
    public Location getPos1(){
        return pos1;
    }
    public Location getPos2(){
        return pos2;
    }

    //Pos 1/2 end
}
