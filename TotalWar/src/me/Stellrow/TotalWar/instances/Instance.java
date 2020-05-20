package me.Stellrow.TotalWar.instances;

import me.Stellrow.TotalWar.arena.Arena;
import me.Stellrow.TotalWar.playermanager.PlayerHandle;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public class Instance {
    private String name;
    private Arena arena;
    private Set<PlayerHandle> blueTeam = new HashSet<PlayerHandle>();
    private Set<PlayerHandle> redTeam = new HashSet<PlayerHandle>();

    public Instance(String name,Arena arena){
        this.name=name;
        this.arena=arena;
    }
    public String getName(){
        return name;
    }
    public Arena getArena(){
        return arena;
    }
    public void addPlayerToBlue(PlayerHandle player){
        blueTeam.add(player);
    }
    public void addPlayerToRed(PlayerHandle player){
        redTeam.add(player);
    }
    public void startChecking(){
        arena.checkCapturePoints(blueTeam,redTeam);
    }

}
