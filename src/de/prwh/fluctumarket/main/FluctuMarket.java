package de.prwh.fluctumarket.main;


import org.bukkit.plugin.java.JavaPlugin;

import de.prwh.fluctumarket.commands.CommandSell;

public class FluctuMarket extends JavaPlugin {

	@Override
	public void onEnable() {
		this.getCommand("sell").setExecutor(new CommandSell());
	}

	@Override
	public void onDisable() {

	}
}