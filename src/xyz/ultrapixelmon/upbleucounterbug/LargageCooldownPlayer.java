package xyz.ultrapixelmon.upbleucounterbug;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;

public class LargageCooldownPlayer implements Listener {

    @EventHandler
    public void onLargageChestOpen(InventoryOpenEvent event){
        if(event.getPlayer().getWorld().getName().equals("world") && event.getPlayer().hasPermission("randomlootchest.nepeutplusouvrir") == true){
            if(event.getInventory().getTitle().equals("Largage")){
                event.getPlayer().sendMessage("§c§lHey! §7Vous avez déjà ouvert un largage aujourd'hui. Celui-ci est donc perdu.");
                event.setCancelled(true);
            }
        }

    }
}
