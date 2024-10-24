package dk.haraldvitus.coins.commands.subs;


import dk.haraldvitus.coins.Coins;
import dk.haraldvitus.coins.utils.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AddSub extends SubCommand {
    @Override
    public String getName() {
        return "add";
    }

    @Override
    public boolean execute(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;

        if (player.hasPermission("admin")) {
            if (args.length == 3) {
                int coins = Coins.getCoinConfigYML().getInt("coins." + Bukkit.getOfflinePlayer(args[1]).getUniqueId());
                Integer coinsNy = coins + Integer.parseInt(args[2]);
                Coins.getCoinConfigYML().set("coins." + Bukkit.getOfflinePlayer(args[1]).getUniqueId(), coinsNy);
                Coins.getCoinConfig().saveConfig();
                player.sendMessage(" §a");
                player.sendMessage("§8[ §e§lCOINS §8]");
                player.sendMessage(" §7Du tilføjede §f" + args[2] + " §7til §f" + args[1] + "§f's §7 coins.");
                player.sendMessage(" §b");
            } else {
                player.sendMessage(" §a");
                player.sendMessage("§8[ §e§lCOINS §8]");
                player.sendMessage(" §7Du skal skrive §f/coins add <spiller> <antal>");
                player.sendMessage(" §b");
            }
        }
        return true;
    }
}
