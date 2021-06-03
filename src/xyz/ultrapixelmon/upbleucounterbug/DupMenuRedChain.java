package xyz.ultrapixelmon.upbleucounterbug;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class DupMenuRedChain implements Listener {


    @EventHandler (priority = EventPriority.HIGHEST)
    public void onInteract(PlayerInteractEvent event){

        Player player = event.getPlayer();
        ItemStack it = event.getItem();

        if(player.isOp()) return;
        if(it != null){
            if(event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_AIR) {
                    if(CraftItemStack.asNMSCopy(it).hasTag()){
                        if(CraftItemStack.asNMSCopy(it).getTag().hasKey("DeluxeMenu")){
                            event.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                            event.setCancelled(true);
                            player.sendMessage(ChatColor.GRAY + "Erreur ... impossible d'utiliser cet objet.");
                        }
                    }
            }
        }

    }

    @EventHandler (priority = EventPriority.HIGHEST)
    public void onItemDrop(PlayerDropItemEvent event){

        Player player = event.getPlayer();
        ItemStack it = event.getItemDrop().getItemStack();

        if(player.isOp()) return;
        if(it != null){
            if(CraftItemStack.asNMSCopy(it).hasTag()){
                if(CraftItemStack.asNMSCopy(it).getTag().hasKey("DeluxeMenu")){
                    event.getItemDrop().remove();
                    player.sendMessage(ChatColor.GRAY + "Erreur ... impossible de jetter cet objet.");

                }
            }
        }
    }

    @EventHandler (priority = EventPriority.HIGHEST)
    public void onClickInventoryEvent(InventoryClickEvent event){

        Player player = (Player) event.getWhoClicked();
        ItemStack it = event.getCurrentItem();

        if(player.isOp()) return;
        //if(event.getClickedInventory().getTitle().contains("RTP Liste")) return;
        if(event.getClickedInventory() != null){
            if(event.getClickedInventory().getType() == InventoryType.PLAYER){
                if (it != null){
                    if(CraftItemStack.asNMSCopy(it).hasTag()){
                        if(CraftItemStack.asNMSCopy(it).getTag().hasKey("DeluxeMenu")){
                            event.getClickedInventory().setItem(event.getSlot(), new ItemStack(Material.AIR));
                            event.setCurrentItem(new ItemStack(Material.AIR));
                            player.sendMessage(ChatColor.GRAY + "Erreur ... impossible d'interagir avec cet objet.");
                            if(event.getClick().isShiftClick()){
                                it.setType(Material.AIR);
                            }
                        }
                    }
                }
            }
        }
    }

}
