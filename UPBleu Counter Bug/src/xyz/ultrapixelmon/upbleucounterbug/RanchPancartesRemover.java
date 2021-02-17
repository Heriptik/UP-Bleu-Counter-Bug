package xyz.ultrapixelmon.upbleucounterbug;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class RanchPancartesRemover implements Listener{
	

	@EventHandler
	public void RanchPancarteRemover (PlayerInteractEvent event){
		
		Player player = event.getPlayer();
		@SuppressWarnings("deprecation")
		ItemStack hand = player.getItemInHand();
		
		if (player.hasPermission("ranchpancarte.moderation") && event.getAction() == Action.RIGHT_CLICK_BLOCK){
			if (hand.getType() == Material.ARROW){
				if (event.getClickedBlock().getType() == Material.WALL_SIGN){
					event.getClickedBlock().setType(Material.AIR);
					player.sendMessage("§7Vous venez de retirer une pancarte lockette.");
				}
			}
			
		}
		
	}

}
