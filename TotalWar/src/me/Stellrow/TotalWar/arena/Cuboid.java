package me.Stellrow.TotalWar.arena;

import org.bukkit.World;
import org.bukkit.util.BoundingBox;

public class Cuboid {
    private BoundingBox box;
    private World world;
    public Cuboid(World world,double x1, double y1, double z1, double x2, double y2, double z2){
        box = new BoundingBox(x1,y1,z2,x2,y2,z1);
        this.world=world;
    }
    public BoundingBox getBox(){
        return box;
    }
    public World getWorld(){
        return world;
    }
}
