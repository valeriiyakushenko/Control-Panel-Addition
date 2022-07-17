package servercontrolpanel.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import servercontrolpanel.ControlPanelAddition;

public class mining_commands implements CommandExecutor {

    ControlPanelAddition config;
    public mining_commands(ControlPanelAddition instance){
        config = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player)sender;
            if (args[0].equalsIgnoreCase("messages")){
                if (args[1].equalsIgnoreCase("false")){
                    config.getConfig().getConfigurationSection(player.getName()).set("show_messages", false);
                    config.saveConfig();
                    config.reloadConfig();
                    player.sendMessage(ChatColor.WHITE + "Show mining messages " + ChatColor.RED + "DISABLE");
                } else if (args[1].equalsIgnoreCase("true")) {
                    config.getConfig().getConfigurationSection(player.getName()).set("show_messages", true);
                    config.saveConfig();
                    config.reloadConfig();
                    player.sendMessage(ChatColor.WHITE + "Show mining messages " + ChatColor.GREEN + "ENABLE");
                }
            }else if (args[0].equalsIgnoreCase("show")){
                if (args[1].equalsIgnoreCase("server")){
                    player.sendMessage(ChatColor.AQUA + "Diamonds mined on the server: "+ config.getConfig().getInt("Diamond"));
                    player.sendMessage(ChatColor.WHITE + "Iron mined on the server: " + config.getConfig().getInt("Iron"));
                    player.sendMessage(ChatColor.GREEN + "Emerald mined on the server: " + config.getConfig().getInt("Emerald"));
                    player.sendMessage(ChatColor.GRAY + "Coal mined on the server: " + config.getConfig().getInt("Coal"));
                    player.sendMessage(ChatColor.YELLOW + "Gold mined on the server: " + config.getConfig().getInt("Gold"));
                    player.sendMessage(ChatColor.GOLD + "Copper mined on the server: " + config.getConfig().getInt("Copper"));
                    player.sendMessage(ChatColor.RED + "Redstone mined on the server: " + config.getConfig().getInt("Redstone"));
                    player.sendMessage(ChatColor.BLUE + "Lapis mined on the server: " + config.getConfig().getInt("Lapis"));
                } else if (args[1].equalsIgnoreCase("me")) {
                    player.sendMessage(ChatColor.AQUA + "Diamonds you have mined: "+ config.getConfig().getConfigurationSection(player.getName()).getInt("Diamond"));
                    player.sendMessage(ChatColor.WHITE + "Iron you have mined: " + config.getConfig().getConfigurationSection(player.getName()).getInt("Iron"));
                    player.sendMessage(ChatColor.GREEN + "Emerald you have mined: " + config.getConfig().getConfigurationSection(player.getName()).getInt("Emerald"));
                    player.sendMessage(ChatColor.GRAY + "Coal you have mined: " + config.getConfig().getConfigurationSection(player.getName()).getInt("Coal"));
                    player.sendMessage(ChatColor.YELLOW + "Gold you have mined: " + config.getConfig().getConfigurationSection(player.getName()).getInt("Gold"));
                    player.sendMessage(ChatColor.GOLD + "Copper you have mined: " + config.getConfig().getConfigurationSection(player.getName()).getInt("Copper"));
                    player.sendMessage(ChatColor.RED + "Redstone you have mined: " + config.getConfig().getConfigurationSection(player.getName()).getInt("Redstone"));
                    player.sendMessage(ChatColor.BLUE + "Lapis you have mined: " + config.getConfig().getConfigurationSection(player.getName()).getInt("Lapis"));
                }
            }
        }else{
            sender.sendMessage("You can't use this in the terminal");
        }
        return true;
    }
}
