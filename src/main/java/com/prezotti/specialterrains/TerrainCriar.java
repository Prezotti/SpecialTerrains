package com.prezotti.specialterrains;

import java.util.Arrays;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TerrainCriar {


    public static ItemStack add(Material m, String nome, String[] lore) {
        ItemStack item = new ItemStack(m);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName(nome);
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);
        return item;
    }

}
