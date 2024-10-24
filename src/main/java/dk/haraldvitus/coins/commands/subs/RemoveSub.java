package dk.haraldvitus.coins.commands.subs;


import dk.haraldvitus.coins.Coins;
import dk.haraldvitus.coins.utils.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RemoveSub extends SubCommand {
    @Override
    public String getName() {
        return "remove";
    }

    @Override
    public boolean execute(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;

        if (player.hasPermission("admin")) {
            if (args.length == 3) {
                int coins = Coins.getCoinConfigYML().getInt("coins." + Bukkit.getOfflinePlayer(args[1]).getUniqueId());
                Integer coinsNy = coins - Integer.parseInt(args[2]);
                Coins.getCoinConfigYML().set("coins." + Bukkit.getOfflinePlayer(args[1]).getUniqueId(), coinsNy);
                Coins.getCoinConfig().saveConfig();
                player.sendMessage(" §a");
                player.sendMessage("§8[ §e§lCOINS §8]");
                player.sendMessage(" §7Du fjernede §f" + args[2] + "§7 coins fra §f" + args[1] + "§7.");
                player.sendMessage(" §b");
            } else {
                player.sendMessage(" §a");
                player.sendMessage("§8[ §e§lCOINS §8]");
                player.sendMessage(" §7Du skal skrive §f/coins remove <spiller> <antal>");
                player.sendMessage(" §b");
            }
        }
        return true;
    }
}
