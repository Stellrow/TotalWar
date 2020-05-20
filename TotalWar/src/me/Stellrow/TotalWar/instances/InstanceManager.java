package me.Stellrow.TotalWar.instances;

import me.Stellrow.TotalWar.TotalWar;
import me.Stellrow.TotalWar.arena.Arena;
import me.Stellrow.TotalWar.utils.ConfigUtils;
import me.Stellrow.TotalWar.utils.CustomConfig;

import java.util.HashSet;
import java.util.Set;

public class InstanceManager {
    private Set<Instance> instances = new HashSet<Instance>();
    private final TotalWar pl;

    public InstanceManager(TotalWar pl) {
        this.pl = pl;
        init();
    }
    private void init(){
        CustomConfig cc = pl.getArenasConfig();
    if(cc.getCfg().contains("Arenas")){
        for(String arena : cc.getCfg().getConfigurationSection("Arenas").getKeys(false)){
            Instance instanceFromConfig = new Instance(arena,new Arena(pl));
            if(cc.getCfg().contains("Arenas."+arena+".CapturePoints")){
                for(String capturePoint : cc.getCfg().getConfigurationSection("Arenas."+arena+".CapturePoints").getKeys(false)){
                    instanceFromConfig.getArena().addCapturePoint(capturePoint, ConfigUtils.stringToCuboid(cc.getCfg().getString("Arenas."+arena+".CapturePoints."+capturePoint)));
                }
            }
            instances.add(instanceFromConfig);
        }
    }
    }

    public void addInstance(Instance instance){
        instances.add(instance);
    }
    public Instance getInstanceByName(String instanceName){
        for(Instance i : instances){
            if(i.getName().equals(instanceName)){
                return i;
            }
        }
        return null;
    }
    public Set<Instance> returnInstances(){
        return instances;
    }

}
