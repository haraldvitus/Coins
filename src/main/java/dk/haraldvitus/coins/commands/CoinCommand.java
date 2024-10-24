package dk.haraldvitus.coins.commands;

import dk.haraldvitus.coins.Coins;
import dk.haraldvitus.coins.commands.subs.*;
import dk.haraldvitus.coins.utils.SubCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class CoinCommand implements CommandExecutor {
    private final Map<String, SubCommand> subCommands = new HashMap<>();

    public CoinCommand() {
        subCommands.put("show", new ShowSub());
        subCommands.put("set", new SetSub());
        subCommands.put("add", new AddSub());
        subCommands.put("remove", new RemoveSub());
        subCommands.put("reload", new ReloadSub());
        subCommands.put("help", new HelpSub());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cDenne kommando kan kun udføres af en spiller.");
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            int coins = Coins.getCoinConfigYML().getInt("coins." + player.getUniqueId());
            player.sendMessage(" §a");
            player.sendMessage("§8[ §e§lCOINS §8]");
            player.sendMessage(" §7Du har §f" + coins + "§7 coins.");
            player.sendMessage(" §b");
            return true;
        }

        SubCommand subCommand = subCommands.get(args[0].toLowerCase());
        if (subCommand != null) {
            return subCommand.execute(sender, command, label, args);
        } else {
            subCommands.get("help").execute(sender, command, label, args);
            return true;
        }
    }
}
