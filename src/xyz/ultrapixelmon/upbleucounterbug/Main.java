package xyz.ultrapixelmon.upbleucounterbug;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {

		System.out.println("[UP] Activation du debug serveur bleu !");
		getServer().getPluginManager().registerEvents(new TerreBattuSpawn(), this);
		getServer().getPluginManager().registerEvents(new FrostWalkerDisable(), this);
		getServer().getPluginManager().registerEvents(new PoseBreakSpawn(), this);
		getServer().getPluginManager().registerEvents(new RanchPancartesRemover(), this);
		getServer().getPluginManager().registerEvents(new LargageCooldownPlayer(), this);
		getServer().getPluginManager().registerEvents(new DisableInteractPokeLoot(), this);
		getServer().getPluginManager().registerEvents(new DupMenuRedChain(), this);
	}
	
	@Override
	public void onDisable() {
	}

}
