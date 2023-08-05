# Backrooms.net MC
Backrooms plugin for backrooms.net Minecraft servers.

# Installation

Backrooms server plugin is NOT a mod. That means, you must 
install the plugin into a Minecraft server.

To install ...
1. Stop the server. 
2. Place the plugin into the 'plugins' folder on the server. 
3. Delete the existing overworld.
4. Start the server and let the overworld regenerate.

# Season 2 (Current Release)

This Backrooms Minecraft plugin treats the overworld as the Frontrooms. 
You spawn into the backrooms when you first join. Then your goal is
to find a way out of the backrooms into the overworld.

The backrooms generates in a NEW world as the lowest level of the world. 
It is as large as the overworld in size.

If you die for any reason, before or after escaping the backrooms, you
are respawned back into the backrooms. This makes your world nearly as
challenging as a hardcore world, without the permanent loss of access
to the overworld that you get in normal hardcore worlds.

Backrooms Season 2 acts as a better option than hardcore mode.  

## Version
Minecraft 1.20.1 is the target version of the plugin, but there 
is no reason it wouldn't run on other versions. Test it, if you want.

# Season 3 (Under development)
Buttons that apply/cost level score that added to random chunks and send score to backrooms.net season score board for tallying. Additional "Escapee" button outside the the spawn drop for special scoreboard. 

* Check and add some of the following ... mcMMO, MythicMobs, Advanced Enchantments, SkillsPro, Heroes, and Quests
  * mcMMO (https://www.spigotmc.org/resources/official-mcmmo-original-author-returns.64348/)
  * recommended GriefDefender (https://www.spigotmc.org/resources/griefdefender.68900/)
  * recommended NoCheatPlus w/CompatNoCheatPlus (http://dev.bukkit.org/bukkit-plugins/compatnocheatplus-cncp/)
* Possibly move greif prevention back to surface levels and programatically block explosion at the backrooms levels from destroying blocks. 

  * MythicMobs (https://mythiccraft.io/index.php?resources/mythicmobs.1/)
* Add other levels by Chance and Esther
* Add other escapes
* Flesh out RPG plugins
* * Anyone climbing out of backrooms for first time get's a golden shovel, book with condratulation, and name recorded in Season champions board

## Season 3 Walls
Season 3 of Backrooms.net Minecraft involves random chunk tiles,
seeded off game seed+coords, placed in each chunk. Each chunk
tile specifies an exit from all four sides. Chunks that are in
odd coords (x or z) check the ajoining tiles' exit metadata and
project their exits two blocks into their own space by make
those projections air blocks.

Spawners in special dark chunks.

## Winning
Sign with WINNER button congratulating winners placed on top of spawn drop.
The only way to get there is to fly.
