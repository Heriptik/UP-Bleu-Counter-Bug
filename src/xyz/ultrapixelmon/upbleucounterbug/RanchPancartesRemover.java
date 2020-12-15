package xyz.ultrapixelmon.upbleucounterbug;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class RanchPancartesRemover implements Listener{


	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event){

		Player player = event.getPlayer();
		Block clickedBlock = event.getClickedBlock();

		if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) return;
		if (clickedBlock == null) return;

		if (player.hasPermission("ranchpancarte.moderation")) {
			ItemStack heldItem = player.getItemInHand();

			if (heldItem.getType().name().equals("PIXELMON_RUBY_HAMMER")) { // Marteau en ruby
				if (clickedBlock.getType() == Material.WALL_SIGN) {
					player.sendMessage("§7Vous venez de retirer une pancarte lockette.");
					clickedBlock.setType(Material.AIR);
				}
				if(clickedBlock.getType().name().equals("PIXELMON_RANCH")) {
					player.sendMessage("§7Vous venez de retirer un ranch block.");
					clickedBlock.setType(Material.AIR);
					if(clickedBlock.getLocation().add(0,+1,0).getBlock().getType().name().equals("PIXELMON_RANCH")){
						clickedBlock.getLocation().add(0,+1,0).getBlock().setType(Material.AIR);
					}
					if(clickedBlock.getLocation().add(0,-1,0).getBlock().getType().name().equals("PIXELMON_RANCH")){
						clickedBlock.getLocation().add(0,-1,0).getBlock().setType(Material.AIR);
					}
				}
			}
		}
	}

}
