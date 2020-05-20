package me.Stellrow.TotalWar.utils;

import me.Stellrow.TotalWar.TotalWar;
import me.Stellrow.TotalWar.arena.Cuboid;
import org.bukkit.Bukkit;

public class ConfigUtils {
    private static TotalWar pl;
    public ConfigUtils(TotalWar pl){
        this.pl=pl;
    }

    public static void saveNewInstance(String name){
        CustomConfig cc = pl.getArenasConfig();
        cc.getCfg().set("Arenas."+name+".AreaName",name);
        cc.save();
    }
    public static void addCapturePointToArena(String instanceName, String capturePointName, Cuboid cuboid){
        CustomConfig cc = pl.getArenasConfig();
        cc.getCfg().set("Arenas."+instanceName+".CapturePoints."+capturePointName,cuboidToString(cuboid));
        cc.save();
    }
    public static String cuboidToString(Cuboid cuboid){
        return ""+cuboid.getWorld().getName()+" "+cuboid.getBox().getMinX()+" "+cuboid.getBox().getMinY()+" "+cuboid.getBox().getMinZ()+" "+cuboid.getBox().getMaxX()+" "+cuboid.getBox().getMaxY()+" "+cuboid.getBox().getMaxZ();
    }
    public static Cuboid stringToCuboid(String toTranslate){
        String[] raw = toTranslate.split(" ");
        Cuboid toReturn = new Cuboid(Bukkit.getWorld(raw[0]),asDouble(raw[1]),asDouble(raw[2]),asDouble(raw[3]),asDouble(raw[4]),asDouble(raw[5]),asDouble(raw[6]));
        return toReturn;
    }
    public static Double asDouble(String s){
        return Double.parseDouble(s);
    }
}
