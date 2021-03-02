package xyz.ultrapixelmon.upbleucounterbug;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class LargageCooldownPlayer implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event){

        Player player = event.getPlayer();
        Block block = event.getClickedBlock();

        if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) return;
        if (block == null) return;

        if(player.getWorld().getName().equals("world") && player.hasPermission("randomlootchest.nepeutplusouvrir") == true){
            if(block.getType().equals(Material.CHEST)){
                event.setCancelled(true);
                player.sendMessage("§c§lHey! §7Vous avez déjà ouvert un coffre aujourd'hui. (largage)");
            }
        }
    }

}
