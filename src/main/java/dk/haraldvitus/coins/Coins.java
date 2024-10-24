package dk.haraldvitus.coins;

import dk.haraldvitus.coins.commands.CoinCommand;
import dk.haraldvitus.coins.utils.Config;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Coins extends JavaPlugin {
    @Getter
    @Setter
    private static Config coinConfig;
    @Getter
    @Setter
    public static FileConfiguration coinConfigYML;
    public static Coins instance;

    @Override
    public void onEnable() {
        instance = this;

        if (!(new File(getDataFolder(), "playerdata.yml")).exists())
            saveResource("playerdata.yml", false);

        coinConfig = new Config(this, null, "playerdata.yml");
        coinConfigYML = coinConfig.getConfig();

        getCommand("coins").setExecutor(new CoinCommand());
    }

    @Override
    public void onDisable() {
    }
}
