package servercontrolpanel.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import servercontrolpanel.ControlPanelAddition;

public class warp_tp implements CommandExecutor {

    ControlPanelAddition config;
    public warp_tp(ControlPanelAddition instance){
        config = instance;
    }

    int x = 0;
    int y = 0;
    int z = 0;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player)sender;
            config.getConfig().getConfigurationSection("Warps").getName();
            if(config.getConfig().getConfigurationSection("Warps").getConfigurationSection(args[0]) != null){
                x = config.getConfig().getConfigurationSection("Warps").getConfigurationSection(args[0]).getInt("x");
                y = config.getConfig().getConfigurationSection("Warps").getConfigurationSection(args[0]).getInt("y");
                z = config.getConfig().getConfigurationSection("Warps").getConfigurationSection(args[0]).getInt("z");
                Location location = new Location(player.getWorld(), x, y, z);
                player.sendMessage(ChatColor.WHITE + "Teleport to warp: " + args[0]);
                player.teleport(location);
            }else{
                player.sendMessage(ChatColor.RED + "Warp not found");
            }
        }
        return true;
    }
}
