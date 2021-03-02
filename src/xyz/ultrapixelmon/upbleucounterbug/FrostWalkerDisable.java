package xyz.ultrapixelmon.upbleucounterbug;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.codingforcookies.armorequip.ArmorEquipEvent;

public class FrostWalkerDisable implements Listener {
	
	@EventHandler
	public void equip(ArmorEquipEvent event){
		
		Player player = event.getPlayer();

		if(event.getNewArmorPiece() != null && event.getNewArmorPiece().getType() != Material.AIR){
			if(event.getNewArmorPiece().containsEnchantment(Enchantment.FROST_WALKER)){
				event.getNewArmorPiece().removeEnchantment(Enchantment.FROST_WALKER);
				player.sendMessage("§c§lHey! §7L'enchantement frost-walker n'est pas actif sur le serveur, il vous est donc retiré.");
			}
			if(event.getNewArmorPiece().containsEnchantment(Enchantment.BINDING_CURSE)){
				event.getNewArmorPiece().removeEnchantment(Enchantment.BINDING_CURSE);
				player.sendMessage("§c§lHey! §7L'enchantement malédiction du lien éternel n'est pas actif sur le serveur, il vous est donc retiré.");
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void fireworkelytra(PlayerInteractEvent e){
		
		Player p = e.getPlayer();
		
		if (p.isGliding()){
			if (p.getInventory().getItemInHand().getType() == Material.FIREWORK || p.getInventory().getItemInOffHand().getType() == Material.FIREWORK){
				if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
					e.setCancelled(true);
					p.sendMessage("§c§lHey! §7Il n'est pas possible de se projeter avec des feux d'artifices.");
				}
			}
		}
		
	}

}
