package me.Stellrow.TotalWar.commandsmanager;

import me.Stellrow.TotalWar.TotalWar;
import me.Stellrow.TotalWar.arena.Arena;
import me.Stellrow.TotalWar.arena.Cuboid;
import me.Stellrow.TotalWar.instances.Instance;
import me.Stellrow.TotalWar.playermanager.PlayerHandle;
import me.Stellrow.TotalWar.utils.ConfigUtils;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TotalWarCommands implements CommandExecutor {
    private final TotalWar pl;

    public TotalWarCommands(TotalWar pl) {
        this.pl = pl;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String sa, String[] args) {
        if(sender instanceof Player){
        Player p = (Player) sender;

        if(args.length==1&&args[0].equalsIgnoreCase("debug")){
            Instance i = pl.getInstanceManager().getInstanceByName("primaarena");
            i.addPlayerToBlue(pl.getPlayerManager().tryGetPlayerHandleByPlayer(p));
            i.startChecking();
            return true;
        }
        if(args.length==3&&args[0].equalsIgnoreCase("arena")){
            if(args[1].equalsIgnoreCase("create")){
            pl.getInstanceManager().addInstance(new Instance(args[2],new Arena(pl)));
                ConfigUtils.saveNewInstance(args[2]);
            p.sendMessage("Created arena");
            }
            return true;
        }
        if(args.length==4&&args[0].equalsIgnoreCase("cappoint")&&args[1].equalsIgnoreCase("create")){
            Instance i = pl.getInstanceManager().getInstanceByName(args[2]);
            if(i==null){
                p.sendMessage("No arena found with that name!");
                return true;
            }
            if(pl.getPos1()==null||pl.getPos2()==null){
                p.sendMessage("No pos1 or pos2 selected to create the capture point!");
                return true;
            }
            if(!pl.getPos1().getWorld().equals(pl.getPos2().getWorld())){
                p.sendMessage("Pos1 is not in the same world as pos2!");
                return true;
            }
            Location pos1 = pl.getPos1();
            Location pos2 = pl.getPos2();
            Cuboid cuboid = new Cuboid(pos1.getWorld(),pos1.getX(),pos1.getY(),pos1.getZ(),pos2.getX(),pos2.getY(),pos2.getZ());
            i.getArena().addCapturePoint(args[3],cuboid);
            ConfigUtils.addCapturePointToArena(args[2],args[3],cuboid);
            p.sendMessage("Added the capture point successfully!");
            return true;
        }


        if(args.length==1&&args[0].equalsIgnoreCase("stats")){
            PlayerHandle ph = pl.getPlayerManager().tryGetPlayerHandleByPlayer((Player) sender);
        sender.sendMessage("Kills: "+ph.getKills()+" Deaths: "+ph.getDeaths()+" Coins: "+ph.getCoins());
        return true;
        }
        }
        return true;
    }
}
