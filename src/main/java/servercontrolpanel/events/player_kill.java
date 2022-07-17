package servercontrolpanel.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import servercontrolpanel.ControlPanelAddition;

public class player_kill implements Listener {
    ControlPanelAddition config;
    public player_kill(ControlPanelAddition instance){config = instance;}

    @EventHandler
    public void onPlayerKill(PlayerDeathEvent event) {
        if(event.getEntity().getKiller() != null){
            Player player = event.getEntity().getKiller();
            config.getConfig().set("Killings", config.getConfig().getInt("Killings") + 1);
            config.getConfig().getConfigurationSection(player.getName()).set("Killings", config.getConfig().getConfigurationSection(player.getName()).getInt("Killings") + 1);
            config.saveConfig();
            config.reloadConfig();
        }
    }
}
