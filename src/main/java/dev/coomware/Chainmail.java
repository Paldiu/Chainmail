package dev.coomware;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class Chainmail extends JavaPlugin {
    @Override
    public void onEnable() {
        newRecipes();
        Bukkit.getLogger().info("Successfully added new recipes for chainmail armor.");
        Bukkit.getLogger().info("This plugin was made by CoomWare.");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("[Chainmail] by CoomWare has been disabled.");
    }

    private void newRecipes() {
        //New namespaced keys for identification for each new recipe.
        NamespacedKey key1 = new NamespacedKey(this, "chain_helmet_recipe");
        NamespacedKey key2 = new NamespacedKey(this, "chaim_chest_recipe");
        NamespacedKey key3 = new NamespacedKey(this, "chain_pants_recipe");
        NamespacedKey key4 = new NamespacedKey(this, "chain_boots_recipe");

        //Define the final item to create
        ItemStack helmet = new ItemStack(Material.CHAINMAIL_HELMET);
        ItemStack chest = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        ItemStack pants = new ItemStack(Material.CHAINMAIL_LEGGINGS);
        ItemStack boots = new ItemStack(Material.CHAINMAIL_BOOTS);

        //Initialize new recipe instances
        ShapedRecipe chelm = new ShapedRecipe(key1, helmet);
        ShapedRecipe cchest = new ShapedRecipe(key2, chest);
        ShapedRecipe cpants = new ShapedRecipe(key3, pants);
        ShapedRecipe cboots = new ShapedRecipe(key4, boots);

        //Define the shape of the recipes
        chelm.shape("ccc","cac","aaa");
        cchest.shape("cac","ccc","ccc");
        cpants.shape("ccc","cac","cac");
        cboots.shape("aaa","cac","cac");

        //Helmet
        chelm.setIngredient('c', Material.CHAIN);
        chelm.setIngredient('a', Material.AIR);
        //Chestplate
        cchest.setIngredient('c', Material.CHAIN);
        cchest.setIngredient('a', Material.AIR);
        //Leggings
        cpants.setIngredient('c', Material.CHAIN);
        cpants.setIngredient('a', Material.AIR);
        //Boots
        cboots.setIngredient('c', Material.CHAIN);
        cboots.setIngredient('a', Material.AIR);

        //Add all the new recipes to the server :)
        getServer().addRecipe(chelm);
        getServer().addRecipe(cchest);
        getServer().addRecipe(cpants);
        getServer().addRecipe(cboots);
    }
}
