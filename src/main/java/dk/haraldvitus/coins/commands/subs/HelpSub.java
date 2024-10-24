package dk.haraldvitus.coins.commands.subs;

import dk.haraldvitus.coins.utils.SubCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpSub extends SubCommand {
    @Override
    public String getName() {
        return "help";
    }

    @Override
    public boolean execute(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;

        player.sendMessage(" §a");
        player.sendMessage("§8[ §e§lCOINS §8]");
        player.sendMessage(" §7Du kan gøre brug af følgende kommandoer:");
        player.sendMessage(" §a");
        player.sendMessage(" §8» §7/coins");
        player.sendMessage(" §8» §7/coins show <spiller>");
        if (player.hasPermission("admin")) {
            player.sendMessage(" §8» §7/coins add <spiller> <antal>");
            player.sendMessage(" §8» §7/coins remove <spiller> <antal>");
            player.sendMessage(" §8» §7/coins set <spiller> <antal>");
            player.sendMessage(" §8» §7/coins reload");
        }
        player.sendMessage(" §b");

        return true;
    }
}
