package me.Stellrow.TotalWar.arena;

import me.Stellrow.TotalWar.TotalWar;
import me.Stellrow.TotalWar.playermanager.PlayerHandle;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Set;

public class Arena implements Listener {
    private final TotalWar pl;
    private HashMap<String,CapturePoint> capturePoints = new HashMap<String, CapturePoint>();

    public Arena(TotalWar pl) {
        this.pl = pl;
    }

    public void addCapturePoint(String name,Cuboid area){
        capturePoints.put(name,new CapturePoint(area));
    }

    public void checkCapturePoints(Set<PlayerHandle> teamBlue, Set<PlayerHandle> teamRed){
        new BukkitRunnable(){
            @Override
            public void run() {
                for(PlayerHandle p : teamBlue){
                    for(String s : capturePoints.keySet()){
                        if(capturePoints.get(s).getBox().contains(p.getPlayer().getLocation().toVector())){
                            p.getPlayer().sendMessage("Inside:" +s);
                        }
                    }
                }
            }
        }.runTaskTimer(pl,0,20);


    }
}
