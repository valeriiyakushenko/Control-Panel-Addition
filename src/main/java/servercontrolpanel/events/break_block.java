package servercontrolpanel.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import servercontrolpanel.ControlPanelAddition;

public class break_block implements Listener {

    ControlPanelAddition config;
    public break_block(ControlPanelAddition instance){
        config = instance;
    }

    int score_diamond = 0;
    int score_iron = 0;
    int score_emerald = 0;
    int score_coal = 0;
    int score_gold = 0;
    int score_copper = 0;
    int score_redstone = 0;
    int score_lapis = 0;
    boolean show_messages = true;
    @EventHandler
    public void blockBreak(BlockBreakEvent event){
        Block block = event.getBlock();
        Material material = block.getType();
        Player player = event.getPlayer();
        show_messages = config.getConfig().getConfigurationSection(player.getName()).getBoolean("show_messages");
        if(material.equals(Material.DIAMOND_ORE) | material.equals(Material.DEEPSLATE_DIAMOND_ORE)){
            config.getConfig().set("Diamond", config.getConfig().getInt("Diamond") + 1);
            config.getConfig().getConfigurationSection(player.getName()).set("Diamond", config.getConfig().getConfigurationSection(player.getName()).getInt("Diamond") + 1);
            config.saveConfig();
            config.reloadConfig();
            if(show_messages){
                player.sendMessage(ChatColor.AQUA + "Diamond mined: " + config.getConfig().getConfigurationSection(player.getName()).getInt("Diamond"));
            }
        }
        if(material.equals(Material.IRON_ORE) | material.equals(Material.DEEPSLATE_IRON_ORE)){
            config.getConfig().set("Iron", config.getConfig().getInt("Iron") + 1);
            config.getConfig().getConfigurationSection(player.getName()).set("Iron", config.getConfig().getConfigurationSection(player.getName()).getInt("Iron") + 1);
            config.saveConfig();
            config.reloadConfig();
            if(show_messages){
                player.sendMessage(ChatColor.WHITE + "Iron mined: " + config.getConfig().getConfigurationSection(player.getName()).getInt("Iron"));
            }
        }
        if(material.equals(Material.EMERALD_ORE) | material.equals(Material.DEEPSLATE_EMERALD_ORE)){
            config.getConfig().set("Emerald", config.getConfig().getInt("Emerald") + 1);
            config.getConfig().getConfigurationSection(player.getName()).set("Emerald", config.getConfig().getConfigurationSection(player.getName()).getInt("Emerald") + 1);
            config.saveConfig();
            config.reloadConfig();
            if(show_messages){
                player.sendMessage(ChatColor.GREEN + "Emerald mined: " + config.getConfig().getConfigurationSection(player.getName()).getInt("Emerald"));
            }
        }
        if(material.equals(Material.COAL_ORE) | material.equals(Material.DEEPSLATE_COAL_ORE)){
            config.getConfig().set("Coal", config.getConfig().getInt("Coal") + 1);
            config.getConfig().getConfigurationSection(player.getName()).set("Coal", config.getConfig().getConfigurationSection(player.getName()).getInt("Coal") + 1);
            config.saveConfig();
            config.reloadConfig();
            if(show_messages){
                player.sendMessage(ChatColor.GRAY + "Coal mined: " + config.getConfig().getConfigurationSection(player.getName()).getInt("Coal"));
            }
        }
        if(material.equals(Material.GOLD_ORE) | material.equals(Material.DEEPSLATE_GOLD_ORE)){
            config.getConfig().set("Gold", config.getConfig().getInt("Gold") + 1);
            config.getConfig().getConfigurationSection(player.getName()).set("Gold", config.getConfig().getConfigurationSection(player.getName()).getInt("Gold") + 1);
            config.saveConfig();
            config.reloadConfig();
            if(show_messages){
                player.sendMessage(ChatColor.GOLD + "Gold mined: " + config.getConfig().getConfigurationSection(player.getName()).getInt("Gold"));
            }
        }
        if(material.equals(Material.COPPER_ORE) | material.equals(Material.DEEPSLATE_COPPER_ORE)){
            config.getConfig().set("Copper", config.getConfig().getInt("Copper") + 1);
            config.getConfig().getConfigurationSection(player.getName()).set("Copper", config.getConfig().getConfigurationSection(player.getName()).getInt("Copper") + 1);
            config.saveConfig();
            config.reloadConfig();
            if(show_messages){
                player.sendMessage(ChatColor.GOLD + "Copper mined: " + config.getConfig().getConfigurationSection(player.getName()).getInt("Copper"));
            }
        }
        if(material.equals(Material.REDSTONE_ORE) | material.equals(Material.DEEPSLATE_REDSTONE_ORE)){
            config.getConfig().set("Redstone", config.getConfig().getInt("Redstone") + 1);
            config.getConfig().getConfigurationSection(player.getName()).set("Redstone", config.getConfig().getConfigurationSection(player.getName()).getInt("Redstone") + 1);
            config.saveConfig();
            config.reloadConfig();
            if(show_messages){
                player.sendMessage(ChatColor.RED + "Redstone mined: " + config.getConfig().getConfigurationSection(player.getName()).getInt("Redstone"));
            }
        }
        if(material.equals(Material.LAPIS_ORE) | material.equals(Material.DEEPSLATE_LAPIS_ORE)){
            config.getConfig().set("Lapis", config.getConfig().getInt("Lapis") + 1);
            config.getConfig().getConfigurationSection(player.getName()).set("Lapis", config.getConfig().getConfigurationSection(player.getName()).getInt("Lapis") + 1);
            config.saveConfig();
            config.reloadConfig();
            if(show_messages){
                player.sendMessage(ChatColor.BLUE + "Lapis Lazuli mined: " + config.getConfig().getConfigurationSection(player.getName()).getInt("Lapis"));
            }
        }
    }
}
