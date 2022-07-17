package servercontrolpanel.events;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import servercontrolpanel.ControlPanelAddition;

public class player_join implements Listener {
    ControlPanelAddition config;
    public player_join(ControlPanelAddition instance){config = instance;}

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        Location location = player.getLocation();
        if(!player.hasPlayedBefore()){
            config.getConfig().createSection(player.getName());
            config.getConfig().getConfigurationSection(player.getName()).set("show_messages", true);
            config.getConfig().getConfigurationSection(player.getName()).set("x", location.getX());
            config.getConfig().getConfigurationSection(player.getName()).set("y", location.getY());
            config.getConfig().getConfigurationSection(player.getName()).set("z", location.getZ());
            config.getConfig().getConfigurationSection(player.getName()).set("Diamond", 0);
            config.getConfig().getConfigurationSection(player.getName()).set("Iron", 0);
            config.getConfig().getConfigurationSection(player.getName()).set("Emerald", 0);
            config.getConfig().getConfigurationSection(player.getName()).set("Coal", 0);
            config.getConfig().getConfigurationSection(player.getName()).set("Gold", 0);
            config.getConfig().getConfigurationSection(player.getName()).set("Copper", 0);
            config.getConfig().getConfigurationSection(player.getName()).set("Redstone", 0);
            config.getConfig().getConfigurationSection(player.getName()).set("Lapis", 0);
            config.getConfig().getConfigurationSection(player.getName()).set("Deaths", 0);
            config.getConfig().getConfigurationSection(player.getName()).set("Killings", 0);
        }else{
            if(config.getConfig().getConfigurationSection(player.getName()) == null){
                config.getConfig().createSection(player.getName());
                config.getConfig().getConfigurationSection(player.getName()).set("show_messages", true);
                config.getConfig().getConfigurationSection(player.getName()).set("x", location.getX());
                config.getConfig().getConfigurationSection(player.getName()).set("y", location.getY());
                config.getConfig().getConfigurationSection(player.getName()).set("z", location.getZ());
                config.getConfig().getConfigurationSection(player.getName()).set("Diamond", 0);
                config.getConfig().getConfigurationSection(player.getName()).set("Iron", 0);
                config.getConfig().getConfigurationSection(player.getName()).set("Emerald", 0);
                config.getConfig().getConfigurationSection(player.getName()).set("Coal", 0);
                config.getConfig().getConfigurationSection(player.getName()).set("Gold", 0);
                config.getConfig().getConfigurationSection(player.getName()).set("Copper", 0);
                config.getConfig().getConfigurationSection(player.getName()).set("Redstone", 0);
                config.getConfig().getConfigurationSection(player.getName()).set("Lapis", 0);
                config.getConfig().getConfigurationSection(player.getName()).set("Deaths", 0);
                config.getConfig().getConfigurationSection(player.getName()).set("Killings", 0);
            }else{
                if(config.getConfig().getConfigurationSection(player.getName()).get("show_messages") == null){
                    config.getConfig().getConfigurationSection(player.getName()).set("show_messages", true);
                }if (config.getConfig().getConfigurationSection(player.getName()).get("x") == null) {
                    config.getConfig().getConfigurationSection(player.getName()).set("x", location.getX());
                }if (config.getConfig().getConfigurationSection(player.getName()).get("y") == null) {
                    config.getConfig().getConfigurationSection(player.getName()).set("y", location.getY());
                }if (config.getConfig().getConfigurationSection(player.getName()).get("z") == null) {
                    config.getConfig().getConfigurationSection(player.getName()).set("z", location.getZ());
                }if (config.getConfig().getConfigurationSection(player.getName()).get("Diamond") == null) {
                    config.getConfig().getConfigurationSection(player.getName()).set("Diamond", 0);
                }if (config.getConfig().getConfigurationSection(player.getName()).get("Iron") == null) {
                    config.getConfig().getConfigurationSection(player.getName()).set("Iron", 0);
                }if (config.getConfig().getConfigurationSection(player.getName()).get("Emerald") == null) {
                    config.getConfig().getConfigurationSection(player.getName()).set("Emerald", 0);
                }if (config.getConfig().getConfigurationSection(player.getName()).get("Coal") == null) {
                    config.getConfig().getConfigurationSection(player.getName()).set("Coal", 0);
                }if (config.getConfig().getConfigurationSection(player.getName()).get("Gold") == null) {
                    config.getConfig().getConfigurationSection(player.getName()).set("Gold", 0);
                }if (config.getConfig().getConfigurationSection(player.getName()).get("Copper") == null) {
                    config.getConfig().getConfigurationSection(player.getName()).set("Copper", 0);
                }if (config.getConfig().getConfigurationSection(player.getName()).get("Redstone") == null) {
                    config.getConfig().getConfigurationSection(player.getName()).set("Redstone", 0);
                }if (config.getConfig().getConfigurationSection(player.getName()).get("Lapis") == null) {
                    config.getConfig().getConfigurationSection(player.getName()).set("Lapis", 0);
                }if (config.getConfig().getConfigurationSection(player.getName()).get("Deaths") == null) {
                    config.getConfig().getConfigurationSection(player.getName()).set("Deaths", 0);
                }if (config.getConfig().getConfigurationSection(player.getName()).get("Killings") == null) {
                    config.getConfig().getConfigurationSection(player.getName()).set("Killings", 0);
                }
            }
        }
        config.saveConfig();
        config.reloadConfig();
    }
}
