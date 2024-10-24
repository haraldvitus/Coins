package dk.haraldvitus.coins.api;

import dk.haraldvitus.coins.Coins;
import org.bukkit.OfflinePlayer;

public class CoinsAPI {

    public static int getCoins(OfflinePlayer p) {
        return Coins.getCoinConfigYML().getInt("coins." + p.getUniqueId());
    }

    public static void addCoins(OfflinePlayer p, Integer amount) {
        int coins = Coins.getCoinConfigYML().getInt("coins." + p.getUniqueId());
        Integer coinsNy = coins + amount;
        Coins.getCoinConfigYML().set("coins." + p.getUniqueId(), coinsNy);
        Coins.getCoinConfig().saveConfig();
    }


    public static void removeCoins(OfflinePlayer p, Integer amount) {
        int coins = Coins.getCoinConfigYML().getInt("coins." + p.getUniqueId());
        int coinsNy = coins - amount;
        if (coinsNy >= 0) {
            Coins.getCoinConfigYML().set("coins." + p.getUniqueId(), coinsNy);
        } else {
            Coins.getCoinConfigYML().set("coins." + p.getUniqueId(), 0);
        }
        Coins.getCoinConfig().saveConfig();
    }

    public static void setCoins(OfflinePlayer p, Integer amount) {
        Coins.getCoinConfigYML().set("coins." + p.getUniqueId(), amount);
        Coins.getCoinConfig().saveConfig();
    }
}
