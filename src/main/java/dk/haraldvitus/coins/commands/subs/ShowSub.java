package dk.haraldvitus.coins.commands.subs;

import dk.haraldvitus.coins.Coins;
import dk.haraldvitus.coins.utils.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ShowSub extends SubCommand {
    @Override
    public String getName() {
        return "show";
    }

    @Override
    public boolean execute(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;

        if (args.length == 2) {
            int coins = Coins.getCoinConfigYML().getInt("coins." + Bukkit.getOfflinePlayer(args[1]).getUniqueId());
            player.sendMessage(" §a");
            player.sendMessage("§8[ §e§lCOINS §8]");
            player.sendMessage(" §f" + Bukkit.getOfflinePlayer(args[1]).getName() + "§7 har §f" + coins + "§7 coins.");
            player.sendMessage(" §b");
        } else {
            player.sendMessage(" §a");
            player.sendMessage("§8[ §e§lCOINS §8]");
            player.sendMessage(" §7Du skal skrive §f/coins show <spiller>");
            player.sendMessage(" §b");
        }
        return true;
    }
}
