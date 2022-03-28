package com.prezotti.specialterrains;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TerrainsTab implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List <String> results = new ArrayList<>();

        if (args.length == 1){
            return StringUtil.copyPartialMatches(args[0], Arrays.asList("comprar", "upgrade", "info", "add", "remover", "pvp", "abandonar"), new ArrayList<>());
        }
        else if (args.length == 2){
            if (args[0].equalsIgnoreCase("pvp")) {
                return StringUtil.copyPartialMatches(args[1], Arrays.asList("ativado", "desativado"), new ArrayList<>());
            }
            else if (args[0].equalsIgnoreCase("add")){
                List<String> names = new ArrayList<>();
                for (Player player : Bukkit.getOnlinePlayers()){
                    names.add(player.getName());
                }
                return StringUtil.copyPartialMatches(args[1], names, new ArrayList<>());
            }
            else if (args[0].equalsIgnoreCase("remover")){
                List<String> names = new ArrayList<>();
                for (Player player : Bukkit.getOnlinePlayers()){
                    names.add(player.getName());
                }
                return StringUtil.copyPartialMatches(args[1], names, new ArrayList<>());
            }
        }


        return new ArrayList<>();
    }
}
