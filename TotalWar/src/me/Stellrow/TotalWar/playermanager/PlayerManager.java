package me.Stellrow.TotalWar.playermanager;

import me.Stellrow.TotalWar.TotalWar;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashSet;
import java.util.Set;

public class PlayerManager {
    private final TotalWar pl;
    private PlayerManagerEvents pme;
    private Set<PlayerHandle> playerHandles = new HashSet<PlayerHandle>();

    public PlayerManager(TotalWar pl) {
        this.pl = pl;
        pme = new PlayerManagerEvents(pl);
        saveData();
    }
    public void addPlayerHandle(PlayerHandle ph){
        playerHandles.add(ph);
    }
    public void tryRemovePlayerHandle(PlayerHandle ph){
        if(playerHandles.contains(ph)){
            playerHandles.remove(ph);
        }
    }
    public PlayerHandle tryGetPlayerHandleByPlayer(Player target){
        for(PlayerHandle ph : playerHandles){
            if(ph.getPlayer().equals(target)){
                return ph;
            }
        }
        return null;
    }
    public Set<PlayerHandle> getPlayerHandles(){
        return playerHandles;
    }

    private void saveData(){
        new BukkitRunnable(){

            @Override
            public void run() {
            for(PlayerHandle ph : playerHandles){
                ph.saveStats();
            }
            }
        }.runTaskTimer(pl,0,60*20);
    }
}
