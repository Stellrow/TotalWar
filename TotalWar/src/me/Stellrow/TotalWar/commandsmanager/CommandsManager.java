package me.Stellrow.TotalWar.commandsmanager;

import me.Stellrow.TotalWar.TotalWar;

public class CommandsManager {
    private final TotalWar pl;

    public CommandsManager(TotalWar pl) {
        this.pl = pl;
        init();
    }
    private void init(){
        pl.getCommand("totalwar").setExecutor(new TotalWarCommands(pl));
    }
}
