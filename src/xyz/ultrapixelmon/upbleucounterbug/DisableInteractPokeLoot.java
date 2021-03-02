package xyz.ultrapixelmon.upbleucounterbug;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class DisableInteractPokeLoot implements Listener {

    @EventHandler
    public void onIneteract(PlayerInteractEvent event){

        Player player = event.getPlayer();
        Block block = event.getClickedBlock();

        if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) return;
        if (block == null) return;

        if(player.getWorld().getName().equals("world") && player.hasPermission("world.buildallow") == false){
                if( block.getType().name().equals("PIXELMON_POKE_CHEST") ||
                    block.getType().name().equals("PIXELMON_ULTRA_CHEST") ||
                    block.getType().name().equals("PIXELMON_MASTER_CHEST") ||
                    block.getType().name().equals("PIXELMON_BEAST_CHEST")){

                    event.setCancelled(true);
                    player.sendMessage("§c§lHey! §7Vous ne pouvez pas ouvrir de PokéButin dans ce monde.");
                }
        }
    }

}
