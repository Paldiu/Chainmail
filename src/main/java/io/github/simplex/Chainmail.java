package io.github.simplex;

import org.bstats.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Server;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class Chainmail extends JavaPlugin {
    public static Chainmail plugin;
    public Server server;

    @Override
    public void onLoad() {
        plugin = this;
        server = getServer();
    }

    @Override
    public void onEnable() {
        Metrics metrics = new Metrics(this, 8177);
        Bukkit.getLogger().info("[Chainmail] Successfully loaded bStats plugin metrics.");

        new CheaperChains(this);
        newRecipes();
        Bukkit.getLogger().info("[Chainmail] Successfully added new recipes for chainmail armor.");
        Bukkit.getLogger().info("[Chainmail] This plugin was made by CoomWare.");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("[Chainmail] by CoomWare has been disabled.");
    }

    private void newRecipes() {
        //New namespaced keys for identification for each new recipe.
        NamespacedKey key1 = new NamespacedKey(this, "chain_helmet_recipe");
        NamespacedKey key1a = new NamespacedKey(this, "chain_helmet_alternate");
        NamespacedKey key2 = new NamespacedKey(this, "chaim_chest_recipe");
        NamespacedKey key3 = new NamespacedKey(this, "chain_pants_recipe");
        NamespacedKey key4 = new NamespacedKey(this, "chain_boots_recipe");
        NamespacedKey key4a = new NamespacedKey(this, "chain_boots_alternate");

        //Define the final item to create
        ItemStack helmet = new ItemStack(Material.CHAINMAIL_HELMET);
        ItemStack chest = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        ItemStack pants = new ItemStack(Material.CHAINMAIL_LEGGINGS);
        ItemStack boots = new ItemStack(Material.CHAINMAIL_BOOTS);

        //Initialize new recipe instances
        ShapedRecipe chelm = new ShapedRecipe(key1, helmet);
        ShapedRecipe chelmA = new ShapedRecipe(key1a, helmet);
        ShapedRecipe cchest = new ShapedRecipe(key2, chest);
        ShapedRecipe cpants = new ShapedRecipe(key3, pants);
        ShapedRecipe cboots = new ShapedRecipe(key4, boots);
        ShapedRecipe cbootsA = new ShapedRecipe(key4a, boots);

        //Define the shape of the recipes
        chelm.shape("ccc","cac","aaa");
        chelmA.shape("aaa","ccc","cac");
        cchest.shape("cac","ccc","ccc");
        cpants.shape("ccc","cac","cac");
        cboots.shape("aaa","cac","cac");
        cbootsA.shape("cac","cac","aaa");

        //Helmet
        chelm.setIngredient('c', Material.CHAIN);
        chelm.setIngredient('a', Material.AIR);
        chelmA.setIngredient('c', Material.CHAIN);
        chelmA.setIngredient('a', Material.AIR);
        //Chestplate
        cchest.setIngredient('c', Material.CHAIN);
        cchest.setIngredient('a', Material.AIR);
        //Leggings
        cpants.setIngredient('c', Material.CHAIN);
        cpants.setIngredient('a', Material.AIR);
        //Boots
        cboots.setIngredient('c', Material.CHAIN);
        cboots.setIngredient('a', Material.AIR);
        cbootsA.setIngredient('c', Material.CHAIN);
        cbootsA.setIngredient('a', Material.AIR);

        //Add all the new recipes to the server :)
        server.addRecipe(chelm);
        server.addRecipe(chelmA);
        server.addRecipe(cchest);
        server.addRecipe(cpants);
        server.addRecipe(cboots);
        server.addRecipe(cbootsA);
    }
}
