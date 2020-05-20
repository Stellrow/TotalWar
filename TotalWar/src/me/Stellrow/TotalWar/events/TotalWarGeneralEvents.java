package me.Stellrow.TotalWar.events;

import me.Stellrow.TotalWar.TotalWar;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class TotalWarGeneralEvents implements Listener {
    private final TotalWar pl;

    public TotalWarGeneralEvents(TotalWar pl) {
        this.pl = pl;
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e){


        ///Arrow check
        if(e.getEntity().getLastDamageCause() instanceof Arrow){
        Arrow arrow = (Arrow) e.getEntity().getLastDamageCause();
        if(arrow.getShooter() instanceof Player){
            Player shooter = (Player) arrow.getShooter();
            pl.getPlayerManager().tryGetPlayerHandleByPlayer(shooter).incrementKills();
            return;
        }
        }
        //Arrow check end


        pl.getPlayerManager().tryGetPlayerHandleByPlayer(e.getEntity()).incrementDeaths();
    }
    //Arena creator
    @EventHandler
    public void onUse(PlayerInteractEvent e){
        if(e.getItem()!=null&&e.getItem().getType()== Material.BLAZE_POWDER){
            e.setCancelled(true);
        if(e.getAction()== Action.LEFT_CLICK_BLOCK){
                pl.setPos1(e.getPlayer().getLocation());
                e.getPlayer().sendMessage("Pos1 set");
                return;
            }
            if(e.getAction()== Action.RIGHT_CLICK_BLOCK){
                pl.setPos2(e.getPlayer().getLocation());
                e.getPlayer().sendMessage("Pos2 set");
                return;
            }
        }
    }

}
