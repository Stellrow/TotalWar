package me.Stellrow.TotalWar.events;

import me.Stellrow.TotalWar.TotalWar;

public class EventsManager {
    private final TotalWar pl;

    public EventsManager(TotalWar pl) {
        this.pl = pl;
        init();
    }
    private void init(){
        pl.getServer().getPluginManager().registerEvents(new TotalWarGeneralEvents(pl),pl);
    }
}
