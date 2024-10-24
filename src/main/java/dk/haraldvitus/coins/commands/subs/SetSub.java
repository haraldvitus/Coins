package dk.haraldvitus.coins.commands.subs;


import dk.haraldvitus.coins.Coins;
import dk.haraldvitus.coins.utils.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSub extends SubCommand {
    @Override
    public String getName() {
        return "set";
    }

    @Override
    public boolean execute(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;

        if (player.hasPermission("admin")) {
            if (args.length == 3) {
                Coins.getCoinConfigYML().set("coins." + Bukkit.getOfflinePlayer(args[1]).getUniqueId(), Integer.valueOf(args[2]));
                Coins.getCoinConfig().saveConfig();
                player.sendMessage(" §a");
                player.sendMessage("§8[ §e§lCOINS §8]");
                player.sendMessage(" §7Du satte §f" + args[1] + "§fs §7coins til §f" + args[2] + "§f.");
                player.sendMessage(" §b");
            } else {
                player.sendMessage(" §a");
                player.sendMessage("§8[ §e§lCOINS §8]");
                player.sendMessage(" §7Du skal skrive §f/coins set <spiller> <antal>");
                player.sendMessage(" §b");
            }
        }
        return true;
    }
}
