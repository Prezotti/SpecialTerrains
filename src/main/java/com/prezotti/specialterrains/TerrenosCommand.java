package com.prezotti.specialterrains;

import jdk.jfr.internal.consumer.StringParser;
import net.milkbowl.vault.chat.Chat;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TerrenosCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;

            if (command.getName().equalsIgnoreCase("terrenos")){

                if (args.length == 0){

                    for (String string : Terrains.instance.getConfig().getStringList("Messages.Comandos.Terrenos")){
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', string));
                    }
                    return true;
                }

                if (args.length == 1){

                   String subComando1 = args[0];

                    if (subComando1.equalsIgnoreCase("comprar")) {

                        if (p.hasPermission("bla")){

                        }

                        if (Terrains.instance.TerrenosCache.containsKey(p.getName())) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Comprar.you-already-have-a-terrain")));
                            return true;

                        }

                       Inventory inv = Bukkit.createInventory(null, 3 * 9, ChatColor.BLUE + "Adquira seu terreno");

                       inv.setItem(11, TerrainCriar.add(Material.HORN_CORAL_BLOCK, "Terreno Mini",
                               new String[] { ChatColor.WHITE+"Terreno 10x10.", " ", ChatColor.GRAY+"Preço"+ChatColor.WHITE+":"+ChatColor.RED+" 10.000" }));
                       inv.setItem(12, TerrainCriar.add(Material.TUBE_CORAL_BLOCK, ChatColor.BLUE+"Terreno Pequeno",
                               new String[] { ChatColor.WHITE+"Terreno 15x15.", " ", ChatColor.GRAY+"Preço"+ChatColor.WHITE+":"+ChatColor.RED+" 25.000" }));
                       inv.setItem(13, TerrainCriar.add(Material.BRAIN_CORAL_BLOCK, ChatColor.BLUE+"Terreno Médio",
                               new String[] { ChatColor.WHITE+"Terreno 20x20.", " ", ChatColor.GRAY+"Preço"+ChatColor.WHITE+":"+ChatColor.RED+" 50.000" }));
                       inv.setItem(14, TerrainCriar.add(Material.BUBBLE_CORAL_BLOCK, ChatColor.BLUE+"Terreno Grande",
                               new String[] { ChatColor.WHITE+"Terreno 25x25.", " ", ChatColor.GRAY+"Preço"+ChatColor.WHITE+":"+ChatColor.RED+" 75.000" }));
                       inv.setItem(15, TerrainCriar.add(Material.FIRE_CORAL_BLOCK, ChatColor.BLUE+"Terreno Gigante",
                               new String[] { ChatColor.WHITE+"Terreno 30x30.", " ", ChatColor.GRAY+"Preço"+ChatColor.WHITE+":"+ChatColor.RED+" 100.000" }));
                       inv.setItem(0, TerrainCriar.add(Material.BARRIER,ChatColor.RED + "Fechar", new String[] { " " }));
                       for(int i : new int[]{1,2,3,4,5,6,7,8,9,17,18,19,20,21,22,23,24,25,26}){
                           inv.setItem(i, TerrainCriar.add(Material.GREEN_STAINED_GLASS_PANE," ", new String[] { " " }));
                       }

                       p.openInventory(inv);

                    }

                    else if (subComando1.equalsIgnoreCase("upgrade")){
                        if (Terrenos.terrenosNaLoc(p.getLocation()) == null) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-have-to-be-on-your-terrain")));
                            return true;
                        }
                        else{
                            if (!(Terrenos.terrenosNaLoc(p.getLocation()).getJogador().equalsIgnoreCase(p.getName()))) {
                                p.sendMessage(ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-are-not-the-owner")));
                                return true;
                            }

                            Inventory inv = Bukkit.createInventory(null, 3 * 9, ChatColor.BLUE + "Upgrade seu terreno");

                            //GUI TERRENO MINI
                            if (Terrenos.terrenosNaLoc(p.getLocation()).getTipo() == Types.MINI){
                                inv.setItem(11, TerrainCriar.add(Material.DEAD_HORN_CORAL_BLOCK, ChatColor.RED + "Terreno Mini",
                                        new String[] { ChatColor.WHITE+"Terreno 10x10.", " ", ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-already-have-this-type-of-terrain"))}));
                                inv.setItem(12, TerrainCriar.add(Material.TUBE_CORAL_BLOCK, ChatColor.BLUE+"Terreno Pequeno",
                                        new String[] { ChatColor.WHITE+"Terreno 15x15.", " ", ChatColor.GRAY+"Preço"+ChatColor.WHITE+":"+ChatColor.RED+" 16.500"}));
                                inv.setItem(13, TerrainCriar.add(Material.BRAIN_CORAL_BLOCK, ChatColor.BLUE+"Terreno Médio",
                                        new String[] { ChatColor.WHITE+"Terreno 20x20.", " ", ChatColor.GRAY+"Preço"+ChatColor.WHITE+":"+ChatColor.RED+" 44.000" }));
                                inv.setItem(14, TerrainCriar.add(Material.BUBBLE_CORAL_BLOCK, ChatColor.BLUE+"Terreno Grande",
                                        new String[] { ChatColor.WHITE+"Terreno 25x25.", " ", ChatColor.GRAY+"Preço"+ChatColor.WHITE+":"+ChatColor.RED+" 71.500" }));
                                inv.setItem(15, TerrainCriar.add(Material.FIRE_CORAL_BLOCK, ChatColor.BLUE+"Terreno Gigante",
                                        new String[] { ChatColor.WHITE+"Terreno 30x30.", " ", ChatColor.GRAY+"Preço"+ChatColor.WHITE+":"+ChatColor.RED+" 99.000" }));
                            }
                            //GUI TERRENO PEQUENO
                            else if (Terrenos.terrenosNaLoc(p.getLocation()).getTipo() == Types.PEQUENO){
                                inv.setItem(11, TerrainCriar.add(Material.DEAD_HORN_CORAL_BLOCK, ChatColor.RED + "Terreno Mini",
                                        new String[] { ChatColor.WHITE+"Terreno 10x10.", " ", ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-already-have-a-better-terrain"))}));
                                inv.setItem(12, TerrainCriar.add(Material.DEAD_TUBE_CORAL_BLOCK, ChatColor.RED+"Terreno Pequeno",
                                        new String[] { ChatColor.WHITE+"Terreno 15x15.", " ", ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-already-have-this-type-of-terrain"))}));
                                inv.setItem(13, TerrainCriar.add(Material.BRAIN_CORAL_BLOCK, ChatColor.BLUE+"Terreno Médio",
                                        new String[] { ChatColor.WHITE+"Terreno 20x20.", " ", ChatColor.GRAY+"Preço"+ChatColor.WHITE+":"+ChatColor.RED+" 27.500" }));
                                inv.setItem(14, TerrainCriar.add(Material.BUBBLE_CORAL_BLOCK, ChatColor.BLUE+"Terreno Grande",
                                        new String[] { ChatColor.WHITE+"Terreno 25x25.", " ", ChatColor.GRAY+"Preço"+ChatColor.WHITE+":"+ChatColor.RED+" 55.000" }));
                                inv.setItem(15, TerrainCriar.add(Material.FIRE_CORAL_BLOCK, ChatColor.BLUE+"Terreno Gigante",
                                        new String[] { ChatColor.WHITE+"Terreno 30x30.", " ", ChatColor.GRAY+"Preço"+ChatColor.WHITE+":"+ChatColor.RED+" 82.500" }));
                            }
                            //GUI TERRENO MEDIO
                            else if (Terrenos.terrenosNaLoc(p.getLocation()).getTipo() == Types.MEDIO){
                                inv.setItem(11, TerrainCriar.add(Material.DEAD_HORN_CORAL_BLOCK, ChatColor.RED + "Terreno Mini",
                                        new String[] { ChatColor.WHITE+"Terreno 10x10.", " ", ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-already-have-a-better-terrain"))}));
                                inv.setItem(12, TerrainCriar.add(Material.DEAD_TUBE_CORAL_BLOCK, ChatColor.RED+"Terreno Pequeno",
                                        new String[] { ChatColor.WHITE+"Terreno 15x15.", " ", ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-already-have-a-better-terrain"))}));
                                inv.setItem(13, TerrainCriar.add(Material.DEAD_BRAIN_CORAL_BLOCK, ChatColor.RED+"Terreno Médio",
                                        new String[] { ChatColor.WHITE+"Terreno 20x20.", " ", ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-already-have-this-type-of-terrain")) }));
                                inv.setItem(14, TerrainCriar.add(Material.BUBBLE_CORAL_BLOCK, ChatColor.BLUE+"Terreno Grande",
                                        new String[] { ChatColor.WHITE+"Terreno 25x25.", " ", ChatColor.GRAY+"Preço"+ChatColor.WHITE+":"+ChatColor.RED+" 27.500" }));
                                inv.setItem(15, TerrainCriar.add(Material.FIRE_CORAL_BLOCK, ChatColor.BLUE+"Terreno Gigante",
                                        new String[] { ChatColor.WHITE+"Terreno 30x30.", " ", ChatColor.GRAY+"Preço"+ChatColor.WHITE+":"+ChatColor.RED+" 52.500" }));
                            }
                            //GUI TERRENO GRANDE
                            else if (Terrenos.terrenosNaLoc(p.getLocation()).getTipo() == Types.GRANDE) {
                                inv.setItem(11, TerrainCriar.add(Material.DEAD_HORN_CORAL_BLOCK, ChatColor.RED + "Terreno Mini",
                                        new String[]{ChatColor.WHITE + "Terreno 10x10.", " ", ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-already-have-a-better-terrain"))}));
                                inv.setItem(12, TerrainCriar.add(Material.DEAD_TUBE_CORAL_BLOCK, ChatColor.RED + "Terreno Pequeno",
                                        new String[]{ChatColor.WHITE + "Terreno 15x15.", " ", ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-already-have-a-better-terrain"))}));
                                inv.setItem(13, TerrainCriar.add(Material.DEAD_BRAIN_CORAL_BLOCK, ChatColor.RED + "Terreno Médio",
                                        new String[]{ChatColor.WHITE + "Terreno 20x20.", " ", ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-already-have-a-better-terrain"))}));
                                inv.setItem(14, TerrainCriar.add(Material.DEAD_BUBBLE_CORAL_BLOCK, ChatColor.RED + "Terreno Grande",
                                        new String[]{ChatColor.WHITE + "Terreno 25x25.", " ", ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-already-have-this-type-of-terrain"))}));
                                inv.setItem(15, TerrainCriar.add(Material.FIRE_CORAL_BLOCK, ChatColor.BLUE + "Terreno Gigante",
                                        new String[]{ChatColor.WHITE + "Terreno 30x30.", " ", ChatColor.GRAY + "Preço" + ChatColor.WHITE + ":" + ChatColor.RED + " 27.000"}));
                            }
                            //GUI TERRENO GIGANTE
                            else if (Terrenos.terrenosNaLoc(p.getLocation()).getTipo() == Types.GIGANTE) {
                                inv.setItem(11, TerrainCriar.add(Material.DEAD_HORN_CORAL_BLOCK, ChatColor.RED + "Terreno Mini",
                                        new String[]{ChatColor.WHITE + "Terreno 10x10.", " ", ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-already-have-a-better-terrain"))}));
                                inv.setItem(12, TerrainCriar.add(Material.DEAD_TUBE_CORAL_BLOCK, ChatColor.RED + "Terreno Pequeno",
                                        new String[]{ChatColor.WHITE + "Terreno 15x15.", " ", ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-already-have-a-better-terrain"))}));
                                inv.setItem(13, TerrainCriar.add(Material.DEAD_BRAIN_CORAL_BLOCK, ChatColor.RED + "Terreno Médio",
                                        new String[]{ChatColor.WHITE + "Terreno 20x20.", " ", ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-already-have-a-better-terrain"))}));
                                inv.setItem(14, TerrainCriar.add(Material.DEAD_BUBBLE_CORAL_BLOCK, ChatColor.RED + "Terreno Grande",
                                        new String[]{ChatColor.WHITE + "Terreno 25x25.", " ", ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-already-have-a-better-terrain"))}));
                                inv.setItem(15, TerrainCriar.add(Material.DEAD_FIRE_CORAL_BLOCK, ChatColor.BLUE + "Terreno Gigante",
                                        new String[]{ChatColor.WHITE + "Terreno 30x30.", " ", ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Upgrade.you-already-have-this-type-of-terrain"))}));
                            }

                            inv.setItem(0, TerrainCriar.add(Material.BARRIER,ChatColor.RED + "Fechar", new String[] { " " }));
                            for(int i : new int[]{1,2,3,4,5,6,7,8,9,17,18,19,20,21,22,23,24,25,26}){
                                inv.setItem(i, TerrainCriar.add(Material.GREEN_STAINED_GLASS_PANE," ", new String[] { " " }));
                            }

                            p.openInventory(inv);

                        }
                    }

                    else if (subComando1.equalsIgnoreCase("info")) {
                        if (Terrenos.terrenosNaLoc(p.getLocation()) == null) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Info.there-is-not-a-terrain-here")));

                        } else {
                            Terrenos t = Terrenos.terrenosNaLoc(p.getLocation());
                            p.sendMessage(" ");
                            p.sendMessage(ChatColor.BLUE+"Terreno em sua localização");
                            p.sendMessage(" ");
                            p.sendMessage(ChatColor.BLUE+"Dono:" + ChatColor.WHITE + t.getJogador() + ChatColor.BLUE+".");
                            p.sendMessage(ChatColor.BLUE+"Tipo:" + ChatColor.WHITE + t.getTipo().toString() + ChatColor.BLUE+".");
                            if (t.isPvp()) {
                                p.sendMessage(ChatColor.BLUE + "PVP:" + ChatColor.WHITE + " Ativado" + ChatColor.BLUE +".");
                            } else {
                                p.sendMessage(ChatColor.BLUE + "PVP:" + ChatColor.WHITE + " Desativado" + ChatColor.BLUE +".");
                            }
                            if (t.getAmigos() == null || t.getAmigos().isEmpty()) {
                                p.sendMessage(ChatColor.BLUE +"Amigos:" + ChatColor.WHITE + " Nenhum amigo adicionado" + ChatColor.BLUE +".");
                            } else {
                                StringBuilder sb = new StringBuilder();
                                for (String add : t.getAmigos()) {
                                    sb.append(ChatColor.WHITE + add);
                                    sb.append(ChatColor.BLUE + ", ");
                                }
                                p.sendMessage(ChatColor.BLUE + "Amigos:" + ChatColor.WHITE + sb.substring(0, sb.toString().length() - 2)
                                        + ChatColor.BLUE+".");
                            }
                            p.sendMessage(" ");
                        }

                   }

                    else if (subComando1.equalsIgnoreCase("add")) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Add.missing-one-argument")));

                    } else if (subComando1.equalsIgnoreCase("remover")) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Remover.missing-one-argument")));

                    } else if (subComando1.equalsIgnoreCase("abandonar")) {
                        if (!Terrains.instance.TerrenosCache.containsKey(p.getName())) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Abandonar.you-dont-have-a-terrain")));
                            return true;
                        }
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Abandonar.successful-leave-terrain-message")));
                        Terrains.instance.TerrenosCache.remove(p.getName());

                    } else if (subComando1.equalsIgnoreCase("pvp")) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Pvp.missing-one-argument")));

                    } else {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.argument-not-found")));
                    }
                    return true;

                }

                if (args.length == 2) {
                    String subComando1 = args[0];
                    if (subComando1.equalsIgnoreCase("comprar")) {
                        if (Terrains.instance.TerrenosCache.containsKey(p.getName())) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Comprar.you-already-have-a-terrain")));
                            return true;
                        }

                        Inventory inv = Bukkit.createInventory(null, 3 * 9, ChatColor.BLUE + "Adquira seu terreno");

                        inv.setItem(11, TerrainCriar.add(Material.HORN_CORAL_BLOCK, "Terreno Mini",
                                new String[] { ChatColor.WHITE+"Terreno 10x10.", " ", ChatColor.GRAY+"Preço"+ChatColor.WHITE+":"+ChatColor.RED+" 10.000" }));
                        inv.setItem(12, TerrainCriar.add(Material.TUBE_CORAL_BLOCK, ChatColor.BLUE+"Terreno Pequeno",
                                new String[] { ChatColor.WHITE+"Terreno 15x15.", " ", ChatColor.GRAY+"Preço"+ChatColor.WHITE+":"+ChatColor.RED+" 25.000" }));
                        inv.setItem(13, TerrainCriar.add(Material.BRAIN_CORAL_BLOCK, ChatColor.BLUE+"Terreno Médio",
                                new String[] { ChatColor.WHITE+"Terreno 20x20.", " ", ChatColor.GRAY+"Preço"+ChatColor.WHITE+":"+ChatColor.RED+" 50.000" }));
                        inv.setItem(14, TerrainCriar.add(Material.BUBBLE_CORAL_BLOCK, ChatColor.BLUE+"Terreno Grande",
                                new String[] { ChatColor.WHITE+"Terreno 25x25.", " ", ChatColor.GRAY+"Preço"+ChatColor.WHITE+":"+ChatColor.RED+" 75.000" }));
                        inv.setItem(15, TerrainCriar.add(Material.FIRE_CORAL_BLOCK, ChatColor.BLUE+"Terreno Gigante",
                                new String[] { ChatColor.WHITE+"Terreno 30x30.", " ", ChatColor.GRAY+"Preço"+ChatColor.WHITE+":"+ChatColor.RED+" 100.000" }));
                        inv.setItem(0, TerrainCriar.add(Material.BARRIER,ChatColor.RED + "Fechar", new String[] { " " }));
                        for(int i : new int[]{1,2,3,4,5,6,7,8,9,17,18,19,20,21,22,23,24,25,26}){
                            inv.setItem(i, TerrainCriar.add(Material.GREEN_STAINED_GLASS_PANE," ", new String[] { " " }));
                        }

                        p.openInventory(inv);

                    } else if (subComando1.equalsIgnoreCase("info")) {
                        if (Terrenos.terrenosNaLoc(p.getLocation()) == null) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Info.there-is-not-a-terrain-here")));
                        } else {
                            Terrenos t = Terrenos.terrenosNaLoc(p.getLocation());
                            p.sendMessage(" ");
                            p.sendMessage(ChatColor.BLUE+"Terreno em sua localização");
                            p.sendMessage(" ");
                            p.sendMessage(ChatColor.BLUE+"Dono:" + ChatColor.WHITE + t.getJogador() + ChatColor.BLUE+".");
                            p.sendMessage(ChatColor.BLUE+"Tipo:" + ChatColor.WHITE + t.getTipo().toString() + ChatColor.BLUE+".");
                            if (t.isPvp()) {
                                p.sendMessage(ChatColor.BLUE + "PVP:" + ChatColor.WHITE + " Ativado" + ChatColor.BLUE +".");
                            } else {
                                p.sendMessage(ChatColor.BLUE + "PVP:" + ChatColor.WHITE + " Desativado" + ChatColor.BLUE +".");
                            }
                            if (t.getAmigos() == null || t.getAmigos().isEmpty()) {
                                p.sendMessage(ChatColor.BLUE +"Amigos:" + ChatColor.WHITE + " Nenhum amigo adicionado" + ChatColor.BLUE +".");
                            } else {
                                StringBuilder sb = new StringBuilder();
                                for (String add : t.getAmigos()) {
                                    sb.append(ChatColor.WHITE + add);
                                    sb.append(ChatColor.BLUE + ", ");
                                }
                                p.sendMessage(ChatColor.BLUE + "Amigos:" + ChatColor.WHITE + sb.substring(0, sb.toString().length() - 2)
                                        + ChatColor.BLUE+".");
                            }
                            p.sendMessage(" ");
                        }

                    }    else if (subComando1.equalsIgnoreCase("add")) {
                        if (!Terrains.instance.TerrenosCache.containsKey(p.getName())) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Add.you-dont-have-a-terrain")));
                            return true;
                        }
                        Player alvo = Bukkit.getPlayer(args[1]);
                        if (alvo == null) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Add.target-offline")));
                            return true;
                        }
                        if (alvo.getName().equalsIgnoreCase(p.getName())) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Add.add-yourself")));
                            return true;
                        }
                        Terrenos t = Terrenos.terrenosNaLoc(p.getLocation());
                        if (!t.getJogador().equals(p.getName())) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Add.you-have-to-be-on-your-terrain")));
                            return true;
                        }
                        if (t.getAmigos() == null) {
                            List<String> jogadores = new ArrayList<>();
                            alvo.sendMessage(ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Add.successful-you-were-added-message").replace("{FRIEND}",p.getName())));
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Add.successful-add-friend-message").replace("{FRIEND}",alvo.getName())));
                            jogadores.add(alvo.getName());
                            t.setAmigos(jogadores);
                            return true;
                        }
                        List<String> jogadores = t.getAmigos();
                        if (jogadores.contains(alvo.getName())) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Add.player-already-in-terrains-friends-list")));
                            return true;
                        }
                        alvo.sendMessage(ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Add.successful-you-were-added-message").replace("{FRIEND}",p.getName())));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Add.successful-add-friend-message").replace("{FRIEND}",alvo.getName())));
                        jogadores.add(alvo.getName());
                        t.setAmigos(jogadores);
                    } else if (subComando1.equalsIgnoreCase("remover")) {
                        if (!Terrains.instance.TerrenosCache.containsKey(p.getName())) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Remover.you-dont-have-a-terrain")));
                            return true;
                        }
                        Player alvo = Bukkit.getPlayer(args[1]);
                        if (alvo == null) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Remover.target-offline")));
                            return true;
                        }
                        if (alvo.getName().equalsIgnoreCase(p.getName())) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Remover.remove-yourself")));
                            return true;
                        }
                        Terrenos t = Terrenos.terrenosNaLoc(p.getLocation());
                        if (!t.getJogador().equals(p.getName())) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Remover.you-have-to-be-on-your-terrain")));
                            return true;
                        }
                        List<String> jogadores = t.getAmigos();
                        if (!jogadores.contains(alvo.getName())) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Remover.player-not-in-terrains-friends-list")));
                            return true;
                        }
                        alvo.sendMessage(ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Remover.successful-you-were-removed-message").replace("{FRIEND}",p.getName())));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Remover.successful-remove-friend-message").replace("{FRIEND}",alvo.getName())));
                        jogadores.remove(alvo.getName());
                        t.setAmigos(jogadores);

                    } else if (subComando1.equalsIgnoreCase("abandonar")) {
                        if (!Terrains.instance.TerrenosCache.containsKey(p.getName())) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Abandonar.you-dont-have-a-terrain")));
                            return true;
                        }
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Abandonar.successful-leave-terrain-message")));
                        Terrains.instance.TerrenosCache.remove(p.getName());
                        Terrains.getInstance().DataFile.getConfig().set("Terrenos."+p.getName(),"");
                    } else if (subComando1.equalsIgnoreCase("pvp")) {
                        if (!Terrains.instance.TerrenosCache.containsKey(p.getName())) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Pvp.you-dont-have-a-terrain")));
                            return true;
                        }
                        Terrenos t = Terrains.instance.TerrenosCache.get(p.getName());
                        if (args[1].equalsIgnoreCase("ativado")) {
                            if (t.isPvp()) {
                                p.sendMessage(ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Pvp.already-on")));
                                return true;
                            }
                            t.setPvp(true);
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Pvp.successful-turn-on")));
                        } else if (args[1].equalsIgnoreCase("desativado")) {
                            if (!t.isPvp()) {
                                p.sendMessage(ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Pvp.already-off")));
                                return true;
                            }
                            t.setPvp(false);
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Pvp.successful-turn-off")));
                        } else {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.Pvp.wrong-argument")));
                        }
                    }  else {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.argument-not-found")));
                    }
                    return true;
                }
                if (args.length > 2) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&',Terrains.instance.getConfig().getString("Messages.Comandos.too-many-arguments")));
                    return true;
                }


            }

        }

        return false;
    }
}
