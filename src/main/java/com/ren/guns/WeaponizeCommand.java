package com.ren.guns;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WeaponizeCommand implements CommandExecutor {

    private boolean isGlobal, isDHoe, isIHoe, isDShovel, isIShovel, isDSword, isISword;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if(args.length == 1) {
                if(args[0].equalsIgnoreCase("Diamond_Hoe")) {
                    isDHoe = true;
                } else if(args[0].equalsIgnoreCase("Iron_Hoe")) {
                    isIHoe = true;
                } else if(args[0].equalsIgnoreCase("Diamond_Shovel")) {
                    isDShovel = true;
                } else if(args[0].equalsIgnoreCase("Iron_Shovel")) {
                    isIShovel = true;
                } else if(args[0].equalsIgnoreCase("Diamond_Sword")) {
                    isDSword = true;
                } else if(args[0].equalsIgnoreCase("Iron_Sword")) {
                    isISword = true;
                }
            } else {
                    isGlobal = true;
                }
        }
        return false;
    }
}
