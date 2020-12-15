package xyz.ultrapixelmon.upbleucounterbug;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class TerreBattuSpawn implements Listener {
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event){
		
		Player player = event.getPlayer();
		ItemStack it = event.getItem();
		
		if (it != null && player.isOp() != true && player.getWorld().getName().equals("world")){
			if (it.getType() == Material.DIAMOND_SPADE || 
				it.getType() == Material.IRON_SPADE || 
				it.getType() == Material.WOOD_SPADE || 
				it.getType() == Material.STONE_SPADE || 
				it.getType() == Material.GOLD_SPADE || 
				it.getType() == Material.STONE_SPADE || 
				it.getType() == Material.WATER_BUCKET || 
				it.getType() == Material.LAVA_BUCKET || 
				it.getType() == Material.valueOf("PIXELMON_FIRE_STONE_SHOVEL") || 
				it.getType() == Material.valueOf("PIXELMON_RUBY_SHOVEL") || 
				it.getType() == Material.valueOf("PIXELMON_SAPPHIRE_SHOVEL") || 
				it.getType() == Material.valueOf("PIXELMON_AMETHYST_SHOVEL") || 
				it.getType() == Material.valueOf("PIXELMON_CRYSTAL_SHOVEL") || 
				it.getType() == Material.valueOf("PIXELMON_WATER_STONE_SHOVEL") || 
				it.getType() == Material.valueOf("PIXELMON_LEAF_STONE_SHOVEL") || 
				it.getType() == Material.valueOf("PIXELMON_THUNDER_STONE_SHOVEL") || 
				it.getType() == Material.valueOf("PIXELMON_SUN_STONE_SHOVEL") || 
				it.getType() == Material.valueOf("PIXELMON_MOON_STONE_SHOVEL") || 
				it.getType() == Material.valueOf("PIXELMON_DAWN_STONE_SHOVEL") || 
				it.getType() == Material.valueOf("PIXELMON_DUSK_STONE_SHOVEL") || 
				it.getType() == Material.valueOf("PIXELMON_ALUMINIUM_SPADE") || 
				it.getType() == Material.valueOf("FORGE_BUCKETFILLED")){
				player.sendMessage("§c§lHey! §7Il n'est pas possible d'interagir avec cet objet dans la main.");
				event.setCancelled(true);		
			}
		
		}
		
	}
}
