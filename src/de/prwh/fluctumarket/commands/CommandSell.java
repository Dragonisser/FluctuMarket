package de.prwh.fluctumarket.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandSell implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			ItemStack item = player.getInventory().getItemInMainHand();
			if (args[0].equals("all")) {
				player.sendMessage("You sold " + item.getAmount() + " of '" + item.getType().name().toString() + "'");
				player.getInventory().remove(item);
				return true;
			} else if (args[0].matches("^[+-]?\\d+$")) {
				int amount = Integer.parseInt(args[0]);
				if (0 < amount && amount < 65) {
					if (item.getAmount() < amount) {
						player.sendMessage("You sold " + item.getAmount() + " of '" + item.getType().name().toString() + "'");
						player.getInventory().remove(item);
						return true;
					} else {
						player.sendMessage("You sold " + amount + " of '" + item.getType().name().toString() + "'");
						item.setAmount(item.getAmount() - amount);
						return true;
					}
				} else {
					player.sendMessage("No :c " + amount);
					return false;
				}
			} else {
				player.sendMessage("No :c");
				return false;
			}
		}
		return false;
	}
}
