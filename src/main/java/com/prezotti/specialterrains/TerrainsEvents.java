package com.prezotti.specialterrains;


import net.milkbowl.vault.economy.Economy;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import com.prezotti.specialterrains.Cuboid.CuboidDirection;

import java.util.Objects;

public class TerrainsEvents implements Listener {

    Economy MoedasAPI = Terrains.getEconomy();

    public static void comprarTerreno(Player p, Types tipo) {
        if (tipo == Types.MINI) {
            int x1 = (int) p.getLocation().getBlock().getLocation().getX() + 5;
            int z1 = (int) p.getLocation().getBlock().getLocation().getZ() + 5;
            int x2 = (int) p.getLocation().getBlock().getLocation().getX() - 5;
            int z2 = (int) p.getLocation().getBlock().getLocation().getZ() - 5;
            Cuboid cb = new Cuboid(p.getWorld(),
                    x1, (int) p.getLocation().getY(), z1,
                    x2, (int) p.getLocation().getY(), z2);
            cb.getFace(CuboidDirection.East).forEach(a -> a.setType(Material.OAK_FENCE));
            cb.getFace(CuboidDirection.West).forEach(a -> a.setType(Material.OAK_FENCE));
            cb.getFace(CuboidDirection.North).forEach(a -> a.setType(Material.OAK_FENCE));
            cb.getFace(CuboidDirection.South).forEach(a -> a.setType(Material.OAK_FENCE));
            Location pos1 = new Location(p.getWorld(), x1, 320, z1);
            Location pos2 = new Location(p.getWorld(), x2, -64, z2);
            Terrenos t = new Terrenos(p.getName(), tipo, pos1, pos2, null, false);
            Terrains.instance.TerrenosCache.put(p.getName(), t);
            return;
        } else if (tipo == Types.PEQUENO) {
            int x1 = (int) p.getLocation().getBlock().getLocation().getX() + 7;
            int z1 = (int) p.getLocation().getBlock().getLocation().getZ() + 7;
            int x2 = (int) p.getLocation().getBlock().getLocation().getX() - 7;
            int z2 = (int) p.getLocation().getBlock().getLocation().getZ() - 7;
            Cuboid cb = new Cuboid(p.getWorld(),
                    x1, (int) p.getLocation().getY(), z1,
                    x2, (int) p.getLocation().getY(), z2);
            cb.getFace(CuboidDirection.East).forEach(a -> a.setType(Material.OAK_FENCE));
            cb.getFace(CuboidDirection.West).forEach(a -> a.setType(Material.OAK_FENCE));
            cb.getFace(CuboidDirection.North).forEach(a -> a.setType(Material.OAK_FENCE));
            cb.getFace(CuboidDirection.South).forEach(a -> a.setType(Material.OAK_FENCE));
            Location pos1 = new Location(p.getWorld(), x1, 320, z1);
            Location pos2 = new Location(p.getWorld(), x2, -64, z2);
            Terrenos t = new Terrenos(p.getName(), tipo, pos1, pos2, null, false);
            Terrains.instance.TerrenosCache.put(p.getName(), t);
            return;
        } else if (tipo == Types.MEDIO) {
            int x1 = (int) p.getLocation().getBlock().getLocation().getX() + 10;
            int z1 = (int) p.getLocation().getBlock().getLocation().getZ() + 10;
            int x2 = (int) p.getLocation().getBlock().getLocation().getX() - 10;
            int z2 = (int) p.getLocation().getBlock().getLocation().getZ() - 10;
            Cuboid cb = new Cuboid(p.getWorld(),
                    x1, (int) p.getLocation().getY(), z1,
                    x2, (int) p.getLocation().getY(), z2);
            cb.getFace(CuboidDirection.East).forEach(a -> a.setType(Material.OAK_FENCE));
            cb.getFace(CuboidDirection.West).forEach(a -> a.setType(Material.OAK_FENCE));
            cb.getFace(CuboidDirection.North).forEach(a -> a.setType(Material.OAK_FENCE));
            cb.getFace(CuboidDirection.South).forEach(a -> a.setType(Material.OAK_FENCE));
            Location pos1 = new Location(p.getWorld(), x1, 320, z1);
            Location pos2 = new Location(p.getWorld(), x2, -64, z2);
            Terrenos t = new Terrenos(p.getName(), tipo, pos1, pos2, null, false);
            Terrains.instance.TerrenosCache.put(p.getName(), t);
            return;
        } else if (tipo == Types.GRANDE) {
            int x1 = (int) p.getLocation().getBlock().getLocation().getX() + 12;
            int z1 = (int) p.getLocation().getBlock().getLocation().getZ() + 12;
            int x2 = (int) p.getLocation().getBlock().getLocation().getX() - 12;
            int z2 = (int) p.getLocation().getBlock().getLocation().getZ() - 12;
            Cuboid cb = new Cuboid(p.getWorld(),
                    x1, (int) p.getLocation().getY(), z1,
                    x2, (int) p.getLocation().getY(), z2);
            cb.getFace(CuboidDirection.East).forEach(a -> a.setType(Material.OAK_FENCE));
            cb.getFace(CuboidDirection.West).forEach(a -> a.setType(Material.OAK_FENCE));
            cb.getFace(CuboidDirection.North).forEach(a -> a.setType(Material.OAK_FENCE));
            cb.getFace(CuboidDirection.South).forEach(a -> a.setType(Material.OAK_FENCE));
            Location pos1 = new Location(p.getWorld(), x1, 320, z1);
            Location pos2 = new Location(p.getWorld(), x2, -64, z2);
            Terrenos t = new Terrenos(p.getName(), tipo, pos1, pos2, null, false);
            Terrains.instance.TerrenosCache.put(p.getName(), t);
            return;
        } else if (tipo == Types.GIGANTE) {
            int x1 = (int) p.getLocation().getBlock().getLocation().getX() + 15;
            int z1 = (int) p.getLocation().getBlock().getLocation().getZ() + 15;
            int x2 = (int) p.getLocation().getBlock().getLocation().getX() - 15;
            int z2 = (int) p.getLocation().getBlock().getLocation().getZ() - 15;
            Cuboid cb = new Cuboid(p.getWorld(),
                    x1, (int) p.getLocation().getY(), z1,
                    x2, (int) p.getLocation().getY(), z2);
            cb.getFace(CuboidDirection.East).forEach(a -> a.setType(Material.OAK_FENCE));
            cb.getFace(CuboidDirection.West).forEach(a -> a.setType(Material.OAK_FENCE));
            cb.getFace(CuboidDirection.North).forEach(a -> a.setType(Material.OAK_FENCE));
            cb.getFace(CuboidDirection.South).forEach(a -> a.setType(Material.OAK_FENCE));
            Location pos1 = new Location(p.getWorld(), x1, 320, z1);
            Location pos2 = new Location(p.getWorld(), x2, -64, z2);
            Terrenos t = new Terrenos(p.getName(), tipo, pos1, pos2, null, false);
            Terrains.instance.TerrenosCache.put(p.getName(), t);
        }
    }

    public static void upgradeTerreno(Player p, Types tipoFrom, Types tipoTo) {

        int terrenoX = 0;
        int terrenoZ = 0;

        if (tipoFrom == Types.MINI) {
            terrenoX = (int) Objects.requireNonNull(Terrenos.terrenosNaLoc(p.getLocation())).getPos1().getX() - 5;
            terrenoZ = (int) Objects.requireNonNull(Terrenos.terrenosNaLoc(p.getLocation())).getPos1().getZ() - 5;
        } else if (tipoFrom == Types.PEQUENO) {
            terrenoX = (int) Objects.requireNonNull(Terrenos.terrenosNaLoc(p.getLocation())).getPos1().getX() - 7;
            terrenoZ = (int) Objects.requireNonNull(Terrenos.terrenosNaLoc(p.getLocation())).getPos1().getZ() - 7;
        } else if (tipoFrom == Types.MEDIO) {
            terrenoX = (int) Objects.requireNonNull(Terrenos.terrenosNaLoc(p.getLocation())).getPos1().getX() - 10;
            terrenoZ = (int) Objects.requireNonNull(Terrenos.terrenosNaLoc(p.getLocation())).getPos1().getZ() - 10;
        } else if (tipoFrom == Types.GRANDE) {
            terrenoX = (int) Objects.requireNonNull(Terrenos.terrenosNaLoc(p.getLocation())).getPos1().getX() - 12;
            terrenoZ = (int) Objects.requireNonNull(Terrenos.terrenosNaLoc(p.getLocation())).getPos1().getZ() - 12;
        }

        if (tipoTo == Types.PEQUENO) {
            Cuboid cb = new Cuboid(p.getWorld(),
                    terrenoX + 7, (int) p.getLocation().getY(),
                    terrenoZ + 7,
                    terrenoX - 7, (int) p.getLocation().getY(),
                    terrenoZ - 7);
            cb.getFace(CuboidDirection.East).forEach(a -> a.setType(Material.OAK_FENCE));
            cb.getFace(CuboidDirection.West).forEach(a -> a.setType(Material.OAK_FENCE));
            cb.getFace(CuboidDirection.North).forEach(a -> a.setType(Material.OAK_FENCE));
            cb.getFace(CuboidDirection.South).forEach(a -> a.setType(Material.OAK_FENCE));

            Location pos1 = new Location(p.getWorld(), terrenoX + 7, 320, terrenoZ + 7);
            Location pos2 = new Location(p.getWorld(), terrenoX - 7, -64, terrenoZ - 7);
            Terrenos t = new Terrenos(p.getName(), tipoTo, pos1, pos2, null, false);
            Terrains.instance.TerrenosCache.replace(p.getName(), t);
            return;
        } else if (tipoTo == Types.MEDIO) {
            Cuboid cb = new Cuboid(p.getWorld(),
                    terrenoX + 10, (int) p.getLocation().getY(),
                    terrenoZ + 10,
                    terrenoX - 10, (int) p.getLocation().getY(),
                    terrenoZ - 10);
            cb.getFace(CuboidDirection.East).forEach(a -> a.setType(Material.OAK_FENCE));
            cb.getFace(CuboidDirection.West).forEach(a -> a.setType(Material.OAK_FENCE));
            cb.getFace(CuboidDirection.North).forEach(a -> a.setType(Material.OAK_FENCE));
            cb.getFace(CuboidDirection.South).forEach(a -> a.setType(Material.OAK_FENCE));

            Location pos1 = new Location(p.getWorld(), terrenoX + 10, 320, terrenoZ + 10);
            Location pos2 = new Location(p.getWorld(), terrenoX - 10, -64, terrenoZ - 10);
            Terrenos t = new Terrenos(p.getName(), tipoTo, pos1, pos2, null, false);
            Terrains.instance.TerrenosCache.replace(p.getName(), t);
            return;
        } else if (tipoTo == Types.GRANDE) {
            Cuboid cb = new Cuboid(p.getWorld(),
                    terrenoX + 12, (int) p.getLocation().getY(),
                    terrenoZ + 12,
                    terrenoX - 12, (int) p.getLocation().getY(),
                    terrenoZ - 12);
            cb.getFace(CuboidDirection.East).forEach(a -> a.setType(Material.OAK_FENCE));
            cb.getFace(CuboidDirection.West).forEach(a -> a.setType(Material.OAK_FENCE));
            cb.getFace(CuboidDirection.North).forEach(a -> a.setType(Material.OAK_FENCE));
            cb.getFace(CuboidDirection.South).forEach(a -> a.setType(Material.OAK_FENCE));

            Location pos1 = new Location(p.getWorld(), terrenoX + 12, 320, terrenoZ + 12);
            Location pos2 = new Location(p.getWorld(), terrenoX - 12, -64, terrenoZ - 12);
            Terrenos t = new Terrenos(p.getName(), tipoTo, pos1, pos2, null, false);
            Terrains.instance.TerrenosCache.replace(p.getName(), t);
            return;
        } else if (tipoTo == Types.GIGANTE) {
            Cuboid cb = new Cuboid(p.getWorld(),
                    terrenoX + 15, (int) p.getLocation().getY(),
                    terrenoZ + 15,
                    terrenoX - 15, (int) p.getLocation().getY(),
                    terrenoZ - 15);
            cb.getFace(CuboidDirection.East).forEach(a -> a.setType(Material.OAK_FENCE));
            cb.getFace(CuboidDirection.West).forEach(a -> a.setType(Material.OAK_FENCE));
            cb.getFace(CuboidDirection.North).forEach(a -> a.setType(Material.OAK_FENCE));
            cb.getFace(CuboidDirection.South).forEach(a -> a.setType(Material.OAK_FENCE));

            Location pos1 = new Location(p.getWorld(), terrenoX + 15, 320, terrenoZ + 15);
            Location pos2 = new Location(p.getWorld(), terrenoX - 15, -64, terrenoZ - 15);
            Terrenos t = new Terrenos(p.getName(), tipoTo, pos1, pos2, null, false);
            Terrains.instance.TerrenosCache.replace(p.getName(), t);
            return;
        }


    }

    @EventHandler
    public void invBuy(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (ChatColor.translateAlternateColorCodes('&', e.getView().getTitle()).equals(ChatColor.BLUE + "Adquira seu terreno")) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null)
                return;
            if (!e.getCurrentItem().hasItemMeta())
                return;
            if (e.getRawSlot() == 0) {
                p.closeInventory();
                return;
            }
            if (e.getRawSlot() == 11) {
                if (Terrenos.terrenosNaLoc(p.getLocation()) != null) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Comprar.you-are-on-exisisting-terrain")));
                    p.closeInventory();
                    return;
                }
                if (Terrenos.terrenosPorPerto(p.getLocation(), 25).size() >= 1) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Comprar.close-to-a-terrain")));
                    p.closeInventory();
                    return;
                }
                if (MoedasAPI.getBalance(p) < 10000) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Comprar.you-dont-have-money")));
                    return;
                }
                MoedasAPI.withdrawPlayer(p, 10000);
                comprarTerreno(p, Types.MINI);
                p.closeInventory();
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Comprar.mini-successful-buy-message")));

                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
                return;
            }

            if (e.getRawSlot() == 12) {
                if (Terrenos.terrenosNaLoc(p.getLocation()) != null) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Comprar.you-are-on-exisisting-terrain")));

                    p.closeInventory();
                    return;
                }
                if (Terrenos.terrenosPorPerto(p.getLocation(), 25).size() >= 1) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Comprar.close-to-a-terrain")));
                    p.closeInventory();
                    return;
                }
                if (MoedasAPI.getBalance(p) < 25000) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Comprar.you-dont-have-money")));
                    return;
                }
                MoedasAPI.withdrawPlayer(p, 25000);
                comprarTerreno(p, Types.PEQUENO);
                p.closeInventory();
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Comprar.pequeno-successful-buy-message")));
                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
                return;
            }

            if (e.getRawSlot() == 13) {
                if (Terrenos.terrenosNaLoc(p.getLocation()) != null) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Comprar.you-are-on-exisisting-terrain")));
                    p.closeInventory();
                    return;
                }
                if (Terrenos.terrenosPorPerto(p.getLocation(), 25).size() >= 1) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Comprar.close-to-a-terrain")));
                    p.closeInventory();
                    return;
                }
                if (MoedasAPI.getBalance(p) < 50000) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Comprar.you-dont-have-money")));
                    return;
                }
                MoedasAPI.withdrawPlayer(p, 50000);
                comprarTerreno(p, Types.MEDIO);
                p.closeInventory();
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Comprar.medio-successful-buy-message")));
                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
                return;
            }

            if (e.getRawSlot() == 14) {
                if (Terrenos.terrenosNaLoc(p.getLocation()) != null) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Comprar.you-are-on-exisisting-terrain")));
                    p.closeInventory();
                    return;
                }
                if (Terrenos.terrenosPorPerto(p.getLocation(), 25).size() >= 1) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Comprar.close-to-a-terrain")));
                    p.closeInventory();
                    return;
                }
                if (MoedasAPI.getBalance(p) < 75000) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Comprar.you-dont-have-money")));
                    return;
                }
                MoedasAPI.withdrawPlayer(p, 75000);
                comprarTerreno(p, Types.GRANDE);
                p.closeInventory();
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Comprar.grande-successful-buy-message")));
                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
                return;
            }

            if (e.getRawSlot() == 15) {
                if (Terrenos.terrenosNaLoc(p.getLocation()) != null) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Comprar.you-are-on-exisisting-terrain")));
                    p.closeInventory();
                    return;
                }
                if (Terrenos.terrenosPorPerto(p.getLocation(), 25).size() >= 1) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Comprar.close-to-a-terrain")));
                    p.closeInventory();
                    return;
                }
                if (MoedasAPI.getBalance(p) < 100000) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Comprar.you-dont-have-money")));
                    return;
                }
                MoedasAPI.withdrawPlayer(p, 100000);
                comprarTerreno(p, Types.GIGANTE);
                p.closeInventory();
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Comprar.gigante-successful-buy-message")));
                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            }
        } else if (ChatColor.translateAlternateColorCodes('&', e.getView().getTitle()).equals(ChatColor.BLUE + "Upgrade seu terreno")) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null)
                return;
            if (!e.getCurrentItem().hasItemMeta())
                return;
            if (e.getRawSlot() == 0) {
                p.closeInventory();
                return;
            }
            //Quer evoluir para o terreno MINI
            if (e.getRawSlot() == 11) {
                if (Terrenos.terrenosNaLoc(p.getLocation()) == null) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-have-to-be-on-your-terrain")));
                    p.closeInventory();
                    return;
                }
                //Tem o terreno MINI
                if (Objects.requireNonNull(Terrenos.terrenosNaLoc(p.getLocation())).getTipo() == Types.MINI)
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-already-have-this-type-of-terrain")));
                    //Tem o terreno PEQUENO
                else if (Objects.requireNonNull(Terrenos.terrenosNaLoc(p.getLocation())).getTipo() == Types.PEQUENO)
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-already-have-a-better-terrain")));
                    //Tem o terreno MEDIO
                else if (Objects.requireNonNull(Terrenos.terrenosNaLoc(p.getLocation())).getTipo() == Types.MEDIO)
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-already-have-a-better-terrain")));
                    //Tem o terreno GRANDE
                else if (Objects.requireNonNull(Terrenos.terrenosNaLoc(p.getLocation())).getTipo() == Types.GRANDE)
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-already-have-a-better-terrain")));
                    //Tem o terreno GIGANTE
                else if (Objects.requireNonNull(Terrenos.terrenosNaLoc(p.getLocation())).getTipo() == Types.GIGANTE)
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-already-have-a-better-terrain")));
            }
            //Quer evoluir para o terreno PEQUENO
            else if (e.getRawSlot() == 12) {
                if (Terrenos.terrenosNaLoc(p.getLocation()) == null) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-have-to-be-on-your-terrain")));
                    p.closeInventory();
                    return;
                }
                //Tem o terreno MINI
                if (Objects.requireNonNull(Terrenos.terrenosNaLoc(p.getLocation())).getTipo() == Types.MINI) {
                    if (MoedasAPI.getBalance(p) < 16500) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-dont-have-money")));
                        return;
                    }
                    MoedasAPI.withdrawPlayer(p, 16500);
                    upgradeTerreno(p, Types.MINI, Types.PEQUENO);
                    p.closeInventory();
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.pequeno-successful-buy-message")));
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
                    return;
                }
                //Tem o terreno PEQUENO
                else if (Objects.requireNonNull(Terrenos.terrenosNaLoc(p.getLocation())).getTipo() == Types.PEQUENO)
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-already-have-this-type-of-terrain")));
                    //Tem o terreno MEDIO
                else if (Objects.requireNonNull(Terrenos.terrenosNaLoc(p.getLocation())).getTipo() == Types.MEDIO)
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-already-have-a-better-terrain")));
                    //Tem o terreno GRANDE
                else if (Objects.requireNonNull(Terrenos.terrenosNaLoc(p.getLocation())).getTipo() == Types.GRANDE)
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-already-have-a-better-terrain")));
                    //Tem o terreno GIGANTE
                else if (Objects.requireNonNull(Terrenos.terrenosNaLoc(p.getLocation())).getTipo() == Types.GIGANTE)
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-already-have-a-better-terrain")));
            }
            //Quer evoluir para o MEDIO
            else if (e.getRawSlot() == 13) {
                if (Terrenos.terrenosNaLoc(p.getLocation()) == null) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-have-to-be-on-your-terrain")));
                    p.closeInventory();
                    return;
                }
                //Tem o terreno MINI
                if (Objects.requireNonNull(Terrenos.terrenosNaLoc(p.getLocation())).getTipo() == Types.MINI) {
                    if (MoedasAPI.getBalance(p) < 44000) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-dont-have-money")));
                        return;
                    }
                    MoedasAPI.withdrawPlayer(p, 44000);
                    upgradeTerreno(p, Types.MINI, Types.MEDIO);
                    p.closeInventory();
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.medio-successful-buy-message")));
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
                    return;
                }
                //Tem o terreno PEQUENO
                else if (Objects.requireNonNull(Terrenos.terrenosNaLoc(p.getLocation())).getTipo() == Types.PEQUENO) {
                    if (MoedasAPI.getBalance(p) < 27500) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-dont-have-money")));
                        return;
                    }
                    MoedasAPI.withdrawPlayer(p, 27500);
                    upgradeTerreno(p, Types.PEQUENO, Types.MEDIO);
                    p.closeInventory();
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.medio-successful-buy-message")));
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
                    return;
                }
                //Tem o terreno MEDIO
                else if (Objects.requireNonNull(Terrenos.terrenosNaLoc(p.getLocation())).getTipo() == Types.MEDIO)
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-already-have-this-type-of-terrain")));
                    //Tem o terreno GRANDE
                else if (Objects.requireNonNull(Terrenos.terrenosNaLoc(p.getLocation())).getTipo() == Types.GRANDE)
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-already-have-a-better-terrain")));
                    //Tem o terreno GIGANTE
                else if (Objects.requireNonNull(Terrenos.terrenosNaLoc(p.getLocation())).getTipo() == Types.GIGANTE)
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-already-have-a-better-terrain")));
            }
            //Quer evoluir para o terreno GRANDE
            else if (e.getRawSlot() == 14) {
                if (Terrenos.terrenosNaLoc(p.getLocation()) == null) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-have-to-be-on-your-terrain")));
                    p.closeInventory();
                    return;
                }
                //Tem o terreno MINI
                if (Objects.requireNonNull(Terrenos.terrenosNaLoc(p.getLocation())).getTipo() == Types.MINI) {
                    if (MoedasAPI.getBalance(p) < 71500) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-dont-have-money")));
                        return;
                    }
                    MoedasAPI.withdrawPlayer(p, 71500);
                    upgradeTerreno(p, Types.MINI, Types.GRANDE);
                    p.closeInventory();
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.grande-successful-buy-message")));
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
                    return;
                }
                //Tem o terreno PEQUENO
                else if (Objects.requireNonNull(Terrenos.terrenosNaLoc(p.getLocation())).getTipo() == Types.PEQUENO) {
                    if (MoedasAPI.getBalance(p) < 55000) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-dont-have-money")));
                        return;
                    }
                    MoedasAPI.withdrawPlayer(p, 55000);
                    upgradeTerreno(p, Types.PEQUENO, Types.GRANDE);
                    p.closeInventory();
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.grande-successful-buy-message")));
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
                    return;
                }
                //Tem o terreno MEDIO
                else if (Objects.requireNonNull(Terrenos.terrenosNaLoc(p.getLocation())).getTipo() == Types.MEDIO) {
                    if (MoedasAPI.getBalance(p) < 27500) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-dont-have-money")));
                        return;
                    }
                    MoedasAPI.withdrawPlayer(p, 27500);
                    upgradeTerreno(p, Types.MEDIO, Types.GRANDE);
                    p.closeInventory();
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.grande-successful-buy-message")));
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
                    return;
                }
                //Tem o terreno Grande
                else if (Objects.requireNonNull(Terrenos.terrenosNaLoc(p.getLocation())).getTipo() == Types.GRANDE)
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-already-have-this-type-of-terrain")));
                    //Tem o terreno Gigante
                else if (Objects.requireNonNull(Terrenos.terrenosNaLoc(p.getLocation())).getTipo() == Types.GIGANTE)
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-already-have-a-better-terrain")));
            }
            //Quer evoluir para o terreno gigante:
            else if (e.getRawSlot() == 15) {
                if (Terrenos.terrenosNaLoc(p.getLocation()) == null) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-have-to-be-on-your-terrain")));
                    p.closeInventory();
                    return;
                }
                //Tem o terreno MINI
                if (Objects.requireNonNull(Terrenos.terrenosNaLoc(p.getLocation())).getTipo() == Types.MINI) {
                    if (MoedasAPI.getBalance(p) < 99000) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-dont-have-money")));
                        return;
                    }
                    MoedasAPI.withdrawPlayer(p, 99000);
                    upgradeTerreno(p, Types.MINI, Types.GIGANTE);
                    p.closeInventory();
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.gigante-successful-buy-message")));
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
                    return;
                }
                //Tem o terreno PEQUENO
                else if (Objects.requireNonNull(Terrenos.terrenosNaLoc(p.getLocation())).getTipo() == Types.PEQUENO) {
                    if (MoedasAPI.getBalance(p) < 82500) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-dont-have-money")));
                        return;
                    }
                    MoedasAPI.withdrawPlayer(p, 82500);
                    upgradeTerreno(p, Types.PEQUENO, Types.GIGANTE);
                    p.closeInventory();
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.gigante-successful-buy-message")));
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
                    return;
                }
                //Tem o terreno MEDIO
                else if (Objects.requireNonNull(Terrenos.terrenosNaLoc(p.getLocation())).getTipo() == Types.MEDIO) {
                    if (MoedasAPI.getBalance(p) < 52500) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-dont-have-money")));
                        return;
                    }
                    MoedasAPI.withdrawPlayer(p, 52500);
                    upgradeTerreno(p, Types.MEDIO, Types.GIGANTE);
                    p.closeInventory();
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.gigante-successful-buy-message")));
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
                    return;
                }
                //Tem o terreno GRANDE
                else if (Objects.requireNonNull(Terrenos.terrenosNaLoc(p.getLocation())).getTipo() == Types.GRANDE) {
                    if (MoedasAPI.getBalance(p) < 27000) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-dont-have-money")));
                        return;
                    }
                    MoedasAPI.withdrawPlayer(p, 27000);
                    upgradeTerreno(p, Types.GRANDE, Types.GIGANTE);
                    p.closeInventory();
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.gigante-successful-buy-message")));
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
                    return;
                }
                //Tem o terreno GIGANTE
                else if (Objects.requireNonNull(Terrenos.terrenosNaLoc(p.getLocation())).getTipo() == Types.GIGANTE)
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-already-have-this-type-of-terrain")));
            }
        }
    }


    @EventHandler
    public void putBlock(BlockPlaceEvent e) {
        Block b = e.getBlock();
        if (b.getLocation().getY() >= 320) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Events.build-limit")));
        }
    }

//    @EventHandler
//    public void chuva(WeatherChangeEvent e) {
//        e.setCancelled(true);
//    }

    // eventos

//    @EventHandler
//    public void place(BlockPlaceEvent e) {
//        Player p = e.getPlayer();
//        if(p.getWorld().getName().equals("world")) {
//            Terrenos t = Terrenos.terrenosNaLoc(p.getLocation());
//            if(t != null) {
//                if(t.getJogador().equals(p.getName())) {
//                    e.setCancelled(false);
//                    return;
//                }
//                if(t.getAmigos() != null) {
//                    if(t.getAmigos().contains(p.getName())) {
//                        e.setCancelled(false);
//                        return;
//                    }
//                }
//            }
//            e.setCancelled(true);
//            p.sendMessage(ChatColor.RED + "Você não pode colocar blocos aqui.");
//        }
//    }
//
//    @EventHandler
//    public void break2(BlockBreakEvent e) {
//        Player p = e.getPlayer();
//        if(p.getWorld().getName().equals("world")) {
//            Terrenos t = Terrenos.terrenosNaLoc(p.getLocation());
//            if(t != null) {
//                if(t.getJogador().equals(p.getName())) {
//                    e.setCancelled(false);
//                    return;
//                }
//                if(t.getAmigos() != null) {
//                    if(t.getAmigos().contains(p.getName())) {
//                        e.setCancelled(false);
//                        return;
//                    }
//                }
//            }
//            e.setCancelled(true);
//            p.sendMessage(ChatColor.RED + "Você não pode quebrar blocos aqui.");
//        }
//    }

    @EventHandler
    public void dano(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player) {
            if (e.getDamager() instanceof Player) {
                Player p = (Player) e.getDamager();
                Player target = (Player) e.getEntity();
                if (target.getWorld().getName().equals("world")) {
                    Terrenos t = Terrenos.terrenosNaLoc(target.getLocation());
                    if (t != null) {
                        if (t.isPvp()) {
                            e.setCancelled(false);
                            return;
                        } else {
                            e.setCancelled(true);
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Events.pvp")));
                            return;
                        }
                    }
                } else {
                    return;
                }
            } else if (e.getDamager() instanceof Projectile) {
                if (((Projectile) e.getDamager()).getShooter() instanceof Player) {
                    Player p = (Player) ((Projectile) e.getDamager()).getShooter();
                    Player target = (Player) e.getEntity();
                    if (target.getWorld().getName().equals("world")) {
                        Terrenos t = Terrenos.terrenosNaLoc(target.getLocation());
                        if (t != null) {
                            if (t.isPvp()) {
                                e.setCancelled(false);
                                return;
                            } else {
                                e.setCancelled(true);
                                p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Events.pvp")));
                                return;
                            }
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    @EventHandler
//public void interagir(PlayerInteractEvent e) {
//    Player p = e.getPlayer();
//    if(p.getWorld().getName().equals("world")) {
//        Block targetBlock = p.getTargetBlock(null, 6);
//        if (targetBlock != null) {
//            Terrenos t = Terrenos.terrenosNaLoc(targetBlock.getLocation());
//            if (t != null) {
//                if (t.getJogador().equals(p.getName())) {
//                    return;
//                } else if (t.getAmigos() != null) {
//                    if (t.getAmigos().contains(p.getName())) {
//                        return;
//                    }
//                }
//                e.setCancelled(true);
//                p.sendMessage(ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Events.interact")));
//                return;
//            }
//        }
//    }
//}
//}
    public void interagir(PlayerInteractEvent e) {
        Terrenos t;
        Player p = e.getPlayer();
        if (p.getWorld().getName().equals("world")) {

            t = Terrenos.terrenosNaLoc(p.getLocation());

            //Não tem terreno na localização do player
            if (t == null) {
                Block targetBlock = p.getTargetBlock(null, 6);
                if (targetBlock != null) {
                    t = Terrenos.terrenosNaLoc(targetBlock.getLocation());

                    //Tambem não tem terreno aonde o player ta olhando
                    if (t == null) {
                        return;
                    }
                    //Tem aonde o player ta olhando
                    else {
                        if (t.getJogador().equals(p.getName())) {
                            return;
                        } else if (t.getAmigos() != null) {
                            if (t.getAmigos().contains(p.getName())) {
                                return;
                            }
                        } else if (p.isOp()) {
                            return;
                        }
                        e.setCancelled(true);
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Events.interact")));
                        return;
                    }
                }
            }

            //Tem terreno na localização do player
            else {
                Block targetBlock = p.getTargetBlock(null, 6);
                if (targetBlock != null) {
                    t = Terrenos.terrenosNaLoc(targetBlock.getLocation());

                    //Mas não tem terreno aonde o player ta olhando
                    if (t == null) {
                        return;
                    }
                    //Tem aonde o player ta olhando
                    else {
                        if (t.getJogador().equals(p.getName())) {
                            return;
                        } else if (t.getAmigos() != null) {
                            if (t.getAmigos().contains(p.getName())) {
                                return;
                            }
                        } else if (p.isOp()) {
                            return;
                        }
                        e.setCancelled(true);
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Terrains.instance.getConfig().getString("Messages.Events.interact")));
                        return;
                    }
                }
            }
        }
    }
}