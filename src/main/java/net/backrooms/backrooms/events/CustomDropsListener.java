package net.backrooms.backrooms.events;

import net.backrooms.backrooms.Backrooms;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomDropsListener implements Listener {

    Random rand = new Random();

    private final Backrooms plugin;
    Logger log;

    public CustomDropsListener(Backrooms plugin, Logger log) {
        this.plugin = plugin;
        this.log = log;
    }

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {

        Location spawnLocation = event.getLocation();
        int y = spawnLocation.getBlockY();

        // if spawning happened in the backrooms lobby
        if ( y < Backrooms.BACKROOMS_LOBBY_CEILING && y > Backrooms.BOTTOM_OF_LOBBY)
        {
            int xChunk = (spawnLocation.getBlockX() / 16);
            int zChunk = (spawnLocation.getBlockZ() / 16);

            //prevent baby zombies in lobby unless over 60 chuncks from spawn
            if (event.getEntityType() == EntityType.ZOMBIE && (xChunk < 60 && zChunk < 60)) {
                Zombie zombie = (Zombie) event.getEntity();
                if (! zombie.isAdult()) {
                    event.setCancelled(true);
                    return;
                }
            }

            // tag all spawned monsters in lobby with location of spawn
            String chunkLocation = xChunk + "_" + y + "_" + zChunk;
            event.getEntity().setMetadata("br_lobby_spawn_chunk", new FixedMetadataValue(plugin, chunkLocation));
        }

//        if (event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.SPAWNER)
//        {
//            if (event.getEntityType() == EntityType.ZOMBIE)
//            Location spawnerLocation = event.getLocation();
//            //Note that the y location is not divided by 16 because it does not affect the chunk location
//            String chunkLocation = (spawnerLocation.getBlockX() / 16) + "_" + spawnerLocation.getBlockY() + "_" + (spawnerLocation.getBlockZ() / 16);
//            event.getEntity().setMetadata("br_lobby_spawner_chunk", new FixedMetadataValue(plugin, chunkLocation));
//        }
    }


    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {

        //handle spawn location drops of zombies in the backrooms lobby
        if (event.getEntity().hasMetadata("br_lobby_spawn_chunk") &&
                event.getEntityType() == EntityType.ZOMBIE)
        {
            String chunkString = event
                    .getEntity()
                    .getMetadata("br_lobby_spawn_chunk")
                    .get(0)
                    .asString();

            String [] coords = chunkString.split("_");
            int x = Integer.parseInt( coords[0] );
            int z = Integer.parseInt( coords[2] );

            if (x > 60 || z > 60)
            {
                //event.getDrops().clear();
                int dropInt = rand.nextInt(0, 40);
                if (dropInt > 35) {
                    event.getDrops().add(new ItemStack(Material.DIAMOND_SWORD, 1));
                } else if (dropInt == 20) {
                    event.getDrops().add(new ItemStack(Material.NETHERITE_PICKAXE, 1));
                } else if (dropInt == 19) {
                    event.getDrops().add(new ItemStack(Material.DIAMOND_AXE, 1));
                } else if (dropInt == 18) {
                    event.getDrops().add(new ItemStack(Material.DIAMOND_BOOTS, 1));
                } else if (dropInt == 17) {
                    event.getDrops().add(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
                } else if (dropInt == 16) {
                    event.getDrops().add(new ItemStack(Material.DIAMOND_HELMET, 1));
                } else if (dropInt == 16) {
                    event.getDrops().add(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
                }
            }
            else if (x > 30 || z > 30)
            {
                //event.getDrops().clear();
                int dropInt = rand.nextInt(0, 40);
                if (dropInt > 37) {

                    // create the unenchanted sword
                    ItemStack sword = new ItemStack(Material.IRON_SWORD, 1);

                    // get the sword's item meta
                    ItemMeta meta = sword.getItemMeta();

                    // apply the Sharpness 5 enchantment to the item meta
                    meta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);

                    // apply the Unbreaking 3 enchantment to the item meta
                    meta.addEnchant(Enchantment.DURABILITY, 3, true);

                    // apply the enchanted meta to the sword
                    sword.setItemMeta(meta);

                    // drop the enchanted sword
                    event.getDrops().add(sword);
                } else if (dropInt > 35) {
                    event.getDrops().add(new ItemStack(Material.IRON_SWORD, 1));
                } else if (dropInt == 20) {
                    event.getDrops().add(new ItemStack(Material.DIAMOND_PICKAXE, 1));
                } else if (dropInt == 19) {
                    event.getDrops().add(new ItemStack(Material.IRON_AXE, 1));
                } else if (dropInt == 18) {
                    event.getDrops().add(new ItemStack(Material.IRON_BOOTS, 1));
                } else if (dropInt == 17) {
                    event.getDrops().add(new ItemStack(Material.IRON_CHESTPLATE, 1));
                } else if (dropInt == 16) {
                    event.getDrops().add(new ItemStack(Material.IRON_HELMET, 1));
                } else if (dropInt == 16) {
                    event.getDrops().add(new ItemStack(Material.IRON_LEGGINGS, 1));
                }
            }
            else if (x > 18 || z > 18)
            {
                //event.getDrops().clear();
                int dropInt = rand.nextInt(0, 25);
                if (dropInt > 23)
                {
                    // create the unenchanted sword
                    ItemStack sword = new ItemStack(Material.WOODEN_SWORD, 1);

                    // get the sword's item meta
                    ItemMeta meta = sword.getItemMeta();

                    // apply the Sharpness 5 enchantment to the item meta
                    meta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);

                    // apply the Unbreaking 3 enchantment to the item meta
                    meta.addEnchant(Enchantment.DURABILITY, 3, true);

                    // apply the enchanted meta to the sword
                    sword.setItemMeta(meta);

                    // drop the enchanted sword
                    event.getDrops().add(sword);
                }
                else if (dropInt > 21)
                {
                    ItemStack shield = new ItemStack(Material.SHIELD, 1);

                    ItemMeta meta = shield.getItemMeta();

                    // apply the Unbreaking III enchantment to the item meta
                    meta.addEnchant(Enchantment.DURABILITY, 3, true);

                    // apply the enchanted meta to the sword
                    shield.setItemMeta(meta);

                    // drop the enchanted sword
                    event.getDrops().add(shield);
                }
                else if (dropInt == 19) {
                    ItemStack armor = new ItemStack(Material.LEATHER_BOOTS, 1);

                    ItemMeta meta = armor.getItemMeta();

                    meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
                    meta.addEnchant(Enchantment.DURABILITY, 3, true);
                    meta.addEnchant(Enchantment.THORNS, 3, true);

                    armor.setItemMeta(meta);

                    event.getDrops().add(armor);
                } else if (dropInt == 18) {
                    ItemStack armor = new ItemStack(Material.LEATHER_CHESTPLATE, 1);

                    ItemMeta meta = armor.getItemMeta();

                    meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
                    meta.addEnchant(Enchantment.DURABILITY, 3, true);
                    meta.addEnchant(Enchantment.THORNS, 3, true);

                    armor.setItemMeta(meta);

                    event.getDrops().add(armor);
                } else if (dropInt == 17) {
                    ItemStack armor = new ItemStack(Material.LEATHER_HELMET, 1);

                    ItemMeta meta = armor.getItemMeta();

                    meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
                    meta.addEnchant(Enchantment.DURABILITY, 3, true);
                    meta.addEnchant(Enchantment.THORNS, 3, true);

                    armor.setItemMeta(meta);

                    event.getDrops().add(armor);
                } else if (dropInt == 16) {
                    ItemStack armor = new ItemStack(Material.LEATHER_LEGGINGS, 1);

                    ItemMeta meta = armor.getItemMeta();

                    meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
                    meta.addEnchant(Enchantment.DURABILITY, 3, true);
                    meta.addEnchant(Enchantment.THORNS, 3, true);

                    armor.setItemMeta(meta);

                    event.getDrops().add(armor);
                } else if (dropInt > 13) {
                    event.getDrops().add(new ItemStack(Material.IRON_PICKAXE, 1));
                }
            }
            else
            {
                //event.getDrops().clear();
                int dropInt = rand.nextInt(0,40);
                if (dropInt > 36)
                {
                    // create the unenchanted sword
                    ItemStack sword = new ItemStack(Material.WOODEN_SWORD, 1);

                    // get the sword's item meta
                    ItemMeta meta = sword.getItemMeta();

                    // apply the Sharpness I enchantment to the item meta
                    meta.addEnchant(Enchantment.DAMAGE_ALL, 3, true);

                    // apply the Unbreaking III enchantment to the item meta
                    meta.addEnchant(Enchantment.DURABILITY, 2, true);

                    // apply the enchanted meta to the sword
                    sword.setItemMeta(meta);

                    // drop the enchanted sword
                    event.getDrops().add(sword);

                }
                else if (dropInt > 30)
                {
                    event.getDrops().add(new ItemStack(Material.WOODEN_SWORD, 1));
                }
                else if (dropInt > 27)
                {
                    event.getDrops().add(new ItemStack(Material.SHIELD, 1));
                }
                else if (dropInt > 25) {
                    event.getDrops().add(new ItemStack(Material.LEATHER_BOOTS, 1));
                } else if (dropInt > 23) {
                    event.getDrops().add(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
                } else if (dropInt > 21) {
                    event.getDrops().add(new ItemStack(Material.LEATHER_HELMET, 1));
                } else if (dropInt > 19) {
                    event.getDrops().add(new ItemStack(Material.LEATHER_LEGGINGS, 1));
                }
                else if (dropInt > 18)
                {
                    event.getDrops().add(new ItemStack(Material.STICK, 1));
                }
                else if (dropInt > 17)
                {
                    event.getDrops().add(new ItemStack(Material.COAL, 1));
                }
                else if (dropInt > 16)
                {
                    event.getDrops().add(new ItemStack(Material.FLINT, 1));
                }
                else if (dropInt > 15)
                {
                    event.getDrops().add(new ItemStack(Material.FEATHER, 1));
                }
            }
            //log.log(Level.INFO, "Backrooms Lobby zombie died. Was spawned at chunk ... " + chunkString);
        }
    }

}
