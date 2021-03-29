package xyz.ultrapixelmon.upbleucounterbug;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class PoseBreakSpawn implements Listener {
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onBlockBreak (BlockBreakEvent event){
		
		Player player = event.getPlayer();

		if (!player.hasPermission("world.buildallow") && player.getWorld().getName().equals("world")){
			event.setCancelled(true);
			player.sendMessage("§c§lHey! §7Vous ne pouvez pas casser de block au spawn.");
		}
		
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onBlockPlace (BlockPlaceEvent event){
		
		Player player = event.getPlayer();
		
		if (!player.hasPermission("world.buildallow") && player.getWorld().getName().equals("world")){
			event.setCancelled(true);
			player.sendMessage("§c§lHey! §7Vous ne pouvez pas poser de block au spawn.");
		}
		
	}

}
