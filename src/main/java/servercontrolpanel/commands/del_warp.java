package servercontrolpanel.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import servercontrolpanel.ControlPanelAddition;

public class del_warp implements CommandExecutor {

    ControlPanelAddition config;
    public del_warp(ControlPanelAddition instance){
        config = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player)sender;
            if(config.getConfig().getConfigurationSection("Warps").getConfigurationSection(args[0]) != null){
                config.getConfig().getConfigurationSection("Warps").set(args[0], null);
                config.saveConfig();
                config.reloadConfig();
                player.sendMessage(ChatColor.RED + "Warp deleted");
            }else{
                player.sendMessage(ChatColor.RED + "Warp not found");
            }
        }

        return true;
    }
}
