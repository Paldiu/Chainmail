package dev.coomware;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.Recipe;
import org.jetbrains.annotations.NotNull;

public class CheaperChains implements Listener {
    //Initializer
    public CheaperChains(@NotNull Chainmail plugin) {
        plugin.server.getPluginManager().registerEvents(this, plugin);
    }

    //This event priority should make the condition guaranteed
    @EventHandler(priority = EventPriority.HIGHEST)
    public void chainCraftEvent(@NotNull PrepareItemCraftEvent e) {
        //Check to make sure the return value isn't just a repaired item
        if (e.isRepair()) { return; }

        final Recipe recipe = e.getRecipe();

        //Check to make sure the recipe actually exists
        if (recipe == null) { return; }

        //If the result of the recipe is chains, set the amount to give to 3
        if (recipe.getResult().getType() == Material.CHAIN) {
            recipe.getResult().setAmount(3);
        }
    }
}
