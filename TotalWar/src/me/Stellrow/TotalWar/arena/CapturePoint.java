package me.Stellrow.TotalWar.arena;

import org.bukkit.util.BoundingBox;

public class CapturePoint {
    private Cuboid area;

    public CapturePoint(Cuboid area){
    this.area=area;
    }
    public BoundingBox getBox(){
        return area.getBox();
    }
}
