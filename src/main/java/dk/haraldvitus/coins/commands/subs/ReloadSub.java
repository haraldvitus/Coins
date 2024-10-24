package dk.haraldvitus.coins.commands.subs;


import dk.haraldvitus.coins.Coins;
import dk.haraldvitus.coins.utils.SubCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadSub extends SubCommand {
    @Override
    public String getName() {
        return "reload";
    }

    @Override
    public boolean execute(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;

        if (player.hasPermission("admin")) {
            Coins.coinConfigYML = Coins.getCoinConfig().getConfig();
            player.sendMessage(" §a");
            player.sendMessage("§8[ §e§lCOINS §8]");
            player.sendMessage(" §7Du reloadede playerdataen.");
            player.sendMessage(" §b");
        } else {
            player.sendMessage(" §a");
            player.sendMessage(" §4Fejl: §cDu har ikke adgang til denne kommando!");
            player.sendMessage(" §b");
        }
        return true;
    }
}
