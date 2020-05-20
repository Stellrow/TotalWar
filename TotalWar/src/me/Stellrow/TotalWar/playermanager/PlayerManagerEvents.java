package me.Stellrow.TotalWar.playermanager;

import me.Stellrow.TotalWar.TotalWar;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerManagerEvents implements Listener {
    private final TotalWar pl;

    public PlayerManagerEvents(TotalWar pl) {
        this.pl = pl;
        pl.getServer().getPluginManager().registerEvents(this,pl);
    }
    @EventHandler
    private void onJoin(PlayerJoinEvent event){
    pl.getPlayerManager().addPlayerHandle(new PlayerHandle(event.getPlayer(),pl));
    }
    @EventHandler
    private void onQuit(PlayerQuitEvent event){
        PlayerHandle ph = pl.getPlayerManager().tryGetPlayerHandleByPlayer(event.getPlayer());
        if(ph!=null){
            ph.saveStats();
            pl.getPlayerManager().tryRemovePlayerHandle(ph);
        }
    }

}
