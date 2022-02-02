package com.ren.guns;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Objects.requireNonNull(getCommand("w")).setExecutor(new WeaponizeCommand());
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) { //Fires whenever the Player Interacts with an item

        if(e.hasItem() && Objects.equals(e.getHand(), EquipmentSlot.HAND)) {  //If the player has an Item and the Item is in his main hand
            Player player = e.getPlayer();
            if(Objects.requireNonNull(e.getItem()).getType().equals(Material.DIAMOND_HOE)) { //If it's a Diamond Hoe
                if(WeaponizeCommand.isGlobal || WeaponizeCommand.isDHoe) {
                    launchCustomProjectile(player, Fireball.class);
                }
            } else if(e.getItem().getType().equals(Material.IRON_HOE)) { //If it's an Iron Hoe
                if(WeaponizeCommand.isGlobal || WeaponizeCommand.isIHoe) {
                    launchCustomProjectile(player, ThrownExpBottle.class);
                }
            } else if(e.getItem().getType().equals(Material.DIAMOND_SHOVEL)) { //If it's a Diamond Shovel
                if(WeaponizeCommand.isGlobal || WeaponizeCommand.isDShovel) {
                    launchCustomProjectile(player, EnderPearl.class);
                }
            } else if(e.getItem().getType().equals(Material.IRON_SHOVEL)) { //If it's an Iron Shovel
                if(WeaponizeCommand.isGlobal || WeaponizeCommand.isIShovel) {
                    launchCustomProjectile(player, Snowball.class);
                }
            } else if(e.getItem().getType().equals(Material.DIAMOND_SWORD)) { //If it's a Diamond Sword
                if(WeaponizeCommand.isGlobal || WeaponizeCommand.isDSword) {
                    launchCustomProjectile(player, Trident.class);
                }
            } else if(e.getItem().getType().equals(Material.IRON_SWORD)) { //If it's an Iron Shovel
                if(WeaponizeCommand.isGlobal || WeaponizeCommand.isISword) {
                    launchCustomProjectile(player, Arrow.class);
                }
            }
        }
    }

    //Makes it, so I don't have to type this over and over again
    public void launchCustomProjectile(Player player, Class functionalInterface) {
        player.launchProjectile(functionalInterface, player.getLocation().getDirection());
    }
}