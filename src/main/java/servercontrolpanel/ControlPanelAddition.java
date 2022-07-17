package servercontrolpanel;

import org.bukkit.plugin.java.JavaPlugin;
import servercontrolpanel.commands.*;
import servercontrolpanel.crafts.crafts_recipe;
import servercontrolpanel.events.break_block;
import servercontrolpanel.events.player_death;
import servercontrolpanel.events.player_join;
import servercontrolpanel.events.player_kill;

import java.io.File;

public final class ControlPanelAddition extends JavaPlugin {

    @Override
    public void onEnable() {
        File file = new File(getDataFolder() + File.separator + "config.yml");
        if (!file.exists()){
            getConfig().addDefault("Diamond", 0);
            getConfig().addDefault("Iron", 0);
            getConfig().addDefault("Emerald", 0);
            getConfig().addDefault("Coal", 0);
            getConfig().addDefault("Gold", 0);
            getConfig().addDefault("Copper", 0);
            getConfig().addDefault("Redstone", 0);
            getConfig().addDefault("Lapis", 0);
            getConfig().addDefault("Deaths", 0);
            getConfig().addDefault("Killings", 0);
            getConfig().createSection("Warps");
            getConfig().options().copyDefaults(true);
            saveConfig();
        } else {
            CheckConfig();
            saveConfig();
            reloadConfig();
        }
        crafts_recipe.craft_saddle();
        crafts_recipe.craft_bundle();
        getServer().getPluginManager().registerEvents(new player_join(this), this);
        getServer().getPluginManager().registerEvents(new player_death(this), this);
        getServer().getPluginManager().registerEvents(new player_kill(this), this);
        this.getServer().getPluginManager().registerEvents(new break_block(this), this);
        this.getCommand("mining").setExecutor(new mining_commands(this));
        this.getCommand("sethome").setExecutor(new set_home(this));
        this.getCommand("home").setExecutor(new home_tp(this));
        this.getCommand("setwarp").setExecutor(new set_warp(this));
        this.getCommand("warp").setExecutor(new warp_tp(this));
        this.getCommand("delwarp").setExecutor(new del_warp(this));
    }


    public void CheckConfig() {

        if(getConfig().get("Diamond") == null){
            getConfig().set("Diamond", 0);
        }
        if(getConfig().get("Iron") == null){
            getConfig().set("Iron", 0);
        }
        if(getConfig().get("Emerald") == null){
            getConfig().set("Emerald", 0);
        }
        if(getConfig().get("Coal") == null){
            getConfig().set("Coal", 0);
        }
        if(getConfig().get("Gold") == null){
            getConfig().set("Gold", 0);
        }
        if(getConfig().get("Copper") == null){
            getConfig().set("Copper", 0);
        }
        if(getConfig().get("Redstone") == null){
            getConfig().set("Redstone", 0);
        }
        if(getConfig().get("Lapis") == null){
            getConfig().set("Lapis", 0);
        }
        if(getConfig().get("Deaths") == null){
            getConfig().set("Deaths", 0);
        }
        if(getConfig().get("Killings") == null){
            getConfig().set("Killings", 0);
        }
        if(getConfig().getConfigurationSection("Warps") == null){
            getConfig().createSection("Warps");
        }
        saveConfig();
        reloadConfig();
    }

    @Override
    public void onDisable() {

    }
}
