package servercontrolpanel.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import servercontrolpanel.ControlPanelAddition;

public class set_warp implements CommandExecutor {

    ControlPanelAddition config;
    public set_warp(ControlPanelAddition instance){
        config = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if(config.getConfig().getConfigurationSection("Warps").getConfigurationSection(args[0]) == null) {
                Location location = player.getLocation();
                config.getConfig().getConfigurationSection("Warps").createSection(args[0]);
                config.getConfig().getConfigurationSection("Warps").getConfigurationSection(args[0]).set("x", location.getX());
                config.getConfig().getConfigurationSection("Warps").getConfigurationSection(args[0]).set("y", location.getY());
                config.getConfig().getConfigurationSection("Warps").getConfigurationSection(args[0]).set("z", location.getZ());
                config.saveConfig();
                config.reloadConfig();
                player.sendMessage(ChatColor.WHITE + "Set warp " + ChatColor.GREEN + args[0] + ChatColor.WHITE + " completed");
            }else{
                player.sendMessage(ChatColor.RED + "The warp already exists");
            }
        }
        return true;
    }
}
