package xyz.ultrapixelmon.upbleucounterbug;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class DisableInteractPokeLoot implements Listener {

    @EventHandler
    public void onIneteract(PlayerInteractEvent event){

        Player player = event.getPlayer();
        Block block = event.getClickedBlock();
        Inventory anvilInventory = Bukkit.createInventory(player, InventoryType.ANVIL);

        if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) return;
        if (block == null) return;

        if(player.getWorld().getName().equals("world") && !player.hasPermission("world.buildallow")){
                if( block.getType().name().equals("PIXELMON_POKE_CHEST") ||
                    block.getType().name().equals("PIXELMON_ULTRA_CHEST") ||
                    block.getType().name().equals("PIXELMON_MASTER_CHEST") ||
                    block.getType().name().equals("PIXELMON_BEAST_CHEST")){

                    event.setCancelled(true);
                    player.sendMessage("§c§lHey! §7Vous ne pouvez pas ouvrir de PokéButin dans ce monde.");
                }
                if(block.getType().equals(Material.TRAP_DOOR)){

                    event.setCancelled(true);
                    player.sendMessage("§c§lHey! §7Vous ne pouvez pas intéragir avec une trappe.");
                }
                if(block.getType().equals(Material.ANVIL)){
                    player.openInventory(anvilInventory); // Ouvre une interface anvil pour ne pas casser celle du spawn
                }
        }
    }

}
