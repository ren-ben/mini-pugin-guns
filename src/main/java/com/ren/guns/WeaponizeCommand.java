package com.ren.guns;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeaponizeCommand implements CommandExecutor {

    public static boolean isGlobal, isDHoe, isIHoe, isDShovel, isIShovel, isDSword, isISword;

    //Hex Codes For The Cool Gradient
    private String color_DHoe = "#1f6afeD#2766fei#3063fea#385ffem#405cfeo#4958fen#5155fed #5951feH#624efeo#6a4afee #7247ffW#7a43ffe#8340ffa#8b3cffp#9339ffo#9c35ffn#a432ffi#ac2effz#b52bffe#bd27ffd";
    private String color_IHoe = "#1f6afeI#2966fer#3362feo#3d5dfen #4759feH#5055feo#5a51fee #644dfeW#6e49ffe#7844ffa#8240ffp#8c3cffo#9638ffn#9f34ffi#a92fffz#b32bffe#bd27ffd";
    private String color_DShovel = "#1f6afeD#2667fei#2d64fea#3561fem#3c5efeo#435bfen#4a58fed #5155feS#5852feh#604ffeo#674cfev#6e49ffe#7545ffl #7c42ffW#843fffe#8b3cffa#9239ffp#9936ffo#a033ffn#a730ffi#af2dffz#b62affe#bd27ffd";
    private String color_IShovel = "#1f6afeI#2766fer#3063feo#385ffen #405cfeS#4958feh#5155feo#5951fev#624efee#6a4afel #7247ffW#7a43ffe#8340ffa#8b3cffp#9339ffo#9c35ffn#a432ffi#ac2effz#b52bffe#bd27ffd";
    private String color_DSword = "#1f6afeD#2767fei#2e64fea#3660fem#3d5dfeo#455afen#4c57fed #5454feS#5b50few#634dfeo#6a4afer#7247ffd #7944ffW#8141ffe#883dffa#903affp#9737ffo#9f34ffn#a631ffi#ae2dffz#b52affe#bd27ffd";
    private String color_ISword = "#1f6afeI#2866fer#3163feo#395ffen #425bfeS#4b57few#5454feo#5c50fer#654cfed #6e49ffW#7745ffe#8041ffa#883dffp#913affo#9a36ffn#a332ffi#ab2effz#b42bffe#bd27ffd";
    private String color_rm = "#eb4034A#e83f3el#e53e48l #e23d52T#df3c5co#dc3b67o#d93a71l#d6397bs #d33885D#d0378fe#ce3799-#cb36a3W#c835ade#c534b7a#c233c1p#bf32cco#bc31d6n#b930e0i#b62feaz#b32ef4e#b02dfed";
    private String color_all = "#1f6afeA#2866fel#3262fel #3b5efeT#445afeo#4d56feo#5752fel#604efes #694afeW#7347ffe#7c43ffa#853fffp#8f3bffo#9837ffn#a133ffi#aa2fffz#b42bffe#bd27ffd";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        redo(); //reset every boolean to false
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if(args.length == 1) {
                if(args[0].equalsIgnoreCase("Diamond_Hoe")) {
                    isDHoe = true;
                    player.sendMessage(translate(color_DHoe));
                } else if(args[0].equalsIgnoreCase("Iron_Hoe")) {
                    isIHoe = true;
                    player.sendMessage(translate(color_IHoe));
                } else if(args[0].equalsIgnoreCase("Diamond_Shovel")) {
                    isDShovel = true;
                    player.sendMessage(translate(color_DShovel));
                } else if(args[0].equalsIgnoreCase("Iron_Shovel")) {
                    isIShovel = true;
                    player.sendMessage(translate(color_IShovel));
                } else if(args[0].equalsIgnoreCase("Diamond_Sword")) {
                    isDSword = true;
                    player.sendMessage(translate(color_DSword));
                } else if(args[0].equalsIgnoreCase("Iron_Sword")) {
                    isISword = true;
                    player.sendMessage(translate(color_ISword));
                } else if(args[0].equalsIgnoreCase("rm")) {
                    redo();
                    player.sendMessage(translate(color_rm));
                }
            } else {
                    isGlobal = true;
                    player.sendMessage(translate(color_all));
                }
        }
        return false;
    }

    private Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");

    private String translate(String input) {
        Matcher matcher = pattern.matcher(input);
        while(matcher.find()) {
            String color = input.substring(matcher.start(), matcher.end());
            input = input.replace(color, ChatColor.of(color) + "");
            matcher = pattern.matcher(input);
        }
        return input;
    }

    public void redo() {
        isGlobal = false;
        isDHoe = false;
        isIHoe = false;
        isDShovel = false;
        isIShovel = false;
        isDSword = false;
        isISword = false;
    }
}
