package servercontrolpanel.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import servercontrolpanel.ControlPanelAddition;

public class set_home implements CommandExecutor {
    ControlPanelAddition config;
    public set_home(ControlPanelAddition instance){
        config = instance;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player)sender;
            Location location = player.getLocation();
            config.getConfig().getConfigurationSection(player.getName()).set("x", location.getX());
            config.getConfig().getConfigurationSection(player.getName()).set("y", location.getY());
            config.getConfig().getConfigurationSection(player.getName()).set("z", location.getZ());
            config.saveConfig();
            config.reloadConfig();
            player.sendMessage(ChatColor.WHITE + "Set home completed");
        }
        return true;
    }
}
