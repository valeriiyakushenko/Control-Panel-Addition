package servercontrolpanel.crafts;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class crafts_recipe {
    public static void craft_saddle(){
        ItemStack saddle = new ItemStack(Material.SADDLE);
        ShapedRecipe saddle_craft = new ShapedRecipe(saddle);
        saddle_craft.shape("LLL",
                           "L L",
                           "I I");
        saddle_craft.setIngredient('L', Material.LEATHER);
        saddle_craft.setIngredient('I', Material.IRON_INGOT);
        Bukkit.getServer().addRecipe(saddle_craft);
    }
    public static void craft_bundle(){
        ItemStack bundle = new ItemStack(Material.BUNDLE);
        ShapedRecipe bundle_craft = new ShapedRecipe(bundle);
        bundle_craft.shape("SRS",
                           "R R",
                           "RRR");
        bundle_craft.setIngredient('R', Material.RABBIT_HIDE);
        bundle_craft.setIngredient('S', Material.STRING);
        Bukkit.getServer().addRecipe(bundle_craft);
    }
}
