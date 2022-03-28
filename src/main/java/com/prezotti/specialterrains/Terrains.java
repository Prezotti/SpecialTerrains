package com.prezotti.specialterrains;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.List;

public final class Terrains extends JavaPlugin {

    private static Economy econ = null;

    public static Location locFromString(String path) {
        String[] split = path.split(";");
        double x = Double.parseDouble(split[0]);
        double y = Double.parseDouble(split[1]);
        double z = Double.parseDouble(split[2]);
        World world = Bukkit.getWorld(split[3]);
        return new Location(world, x, y, z);
    }

    public static Terrains instance;

    public static Terrains getInstance() {
        return instance;
    }



    // cache

    public HashMap<String, Terrenos> TerrenosCache = new HashMap<>();

    public SpecialConfig DataFile = new SpecialConfig(this, "armazenamento.yml");

    public SpecialConfig Messages = new SpecialConfig(this, "config.yml");


    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    public static Economy getEconomy() {
        return econ;
    }


    @Override
    public void onEnable() {

        if (!setupEconomy() ) {
            System.out.println("No economy plugin found! Disabling Vault!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }


        instance = this;
        DataFile.saveDefaultConfig();

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getCommand("terrenos").setExecutor(new TerrenosCommand());
        getCommand("terrenos").setTabCompleter(new TerrainsTab());
        Bukkit.getPluginManager().registerEvents(new TerrainsEvents(), this);

        if (DataFile.getConfig().getConfigurationSection("Terrenos") != null) {
            for (String a : DataFile.getConfig().getConfigurationSection("Terrenos").getKeys(false)) {
                Types tipo = Types.valueOf(DataFile.getString("Terrenos." + a + ".Tipo"));
                Location pos1 = Terrenos.desarializeLoc(DataFile.getString("Terrenos." + a + ".Pos1"));
                Location pos2 = Terrenos.desarializeLoc(DataFile.getString("Terrenos." + a + ".Pos2"));
                List<String> amigos = DataFile.getConfig().getStringList("Terrenos." + a + ".Amigos");
                boolean pvp = DataFile.getBoolean("Terrenos." + a + ".Pvp");

                TerrenosCache.put(a, new Terrenos(a, tipo, pos1, pos2, amigos, pvp));
            }
        }

    }

    @Override
    public void onDisable() {
        // save
        if (DataFile.getConfig().getConfigurationSection("Terrenos") != null)
            DataFile.getConfig().set("Terrenos", null);
        Terrenos.getAll().forEach(Terrenos::save);
        DataFile.saveConfig();
    }

}
