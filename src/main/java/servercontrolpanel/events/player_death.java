package servercontrolpanel.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import servercontrolpanel.ControlPanelAddition;

public class player_death implements Listener {
    ControlPanelAddition config;
    public player_death(ControlPanelAddition instance){config = instance;}

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event){
        Player player = event.getEntity().getPlayer();
        config.getConfig().set("Deaths", config.getConfig().getInt("Deaths") + 1);
        config.getConfig().getConfigurationSection(player.getName()).set("Deaths", config.getConfig().getConfigurationSection(player.getName()).getInt("Deaths") + 1);
        config.saveConfig();
        config.reloadConfig();
    }
}


