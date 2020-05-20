package me.Stellrow.TotalWar.playermanager;

import me.Stellrow.TotalWar.TotalWar;
import me.Stellrow.TotalWar.utils.PlayerConfig;
import org.bukkit.entity.Player;

public class PlayerHandle {
    private PlayerConfig config;
    private Player player;
    //TODO Hold stats instead of accesing/saving to config each time
    private int kills = 0;
    private int deaths = 0;
    private int coins = 0;
    public PlayerHandle(Player p, TotalWar pl){
        config = new PlayerConfig(p.getUniqueId().toString(),pl);
        this.player=p;
        initValues();
    }
    public PlayerConfig getConfig(){
        return config;
    }
    public Player getPlayer(){
        return player;
    }
    private void initValues(){
        kills = config.getCfg().getInt("TotalWar.Stats.Kills");
        deaths = config.getCfg().getInt("TotalWar.Stats.Deaths");
        coins = config.getCfg().getInt("TotalWar.Stats.Coins");
    }


    ///Kills
    public int getKills(){
        return kills;
    }
    public void setKills(Integer killsToSet){
        kills = killsToSet;
    }
    public void incrementKills(){
        kills++;
    }
    //Kills end


    ///Deaths
    public int getDeaths(){
        return deaths;
    }
    //Not for use
    public void setDeaths(Integer deathsToSet){
        deaths=deathsToSet;
    }
    public void incrementDeaths(){
        deaths++;
    }
    //Deaths end


    ///Coins Start
    //TODO Possible api
    public int getCoins(){
        return coins;
    }
    public void setCoins(Integer coinsToSet){
        coins = coinsToSet;
    }
    public void addCoins(Integer coinsToAdd){
       coins+=coinsToAdd;
    }
    //Coins end
    public void saveStats(){
        config.getCfg().set("TotalWar.Stats.Kills",kills);
        config.getCfg().set("TotalWar.Stats.Deaths",deaths);
        config.getCfg().set("TotalWar.Stats.Coins",coins);
        config.save();
    }


}
