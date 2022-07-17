package servercontrolpanel.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import servercontrolpanel.ControlPanelAddition;

public class home_tp implements CommandExecutor {
    ControlPanelAddition config;
    public home_tp(ControlPanelAddition instance){
        config = instance;
    }

    int x = 0;
    int y = 0;
    int z = 0;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player)sender;
            x = config.getConfig().getConfigurationSection(player.getName()).getInt("x");
            y = config.getConfig().getConfigurationSection(player.getName()).getInt("y");
            z = config.getConfig().getConfigurationSection(player.getName()).getInt("z");
            Location location = new Location(player.getWorld(), x, y, z);
            player.sendMessage(ChatColor.WHITE + "Teleport at home...");
            player.teleport(location);
        }
        return true;
    }
}
