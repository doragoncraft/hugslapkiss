package me.carl230690.main;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.EntityEffect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class main extends JavaPlugin
{
  public final Logger logger = Logger.getLogger("Minecraft");
  public static main plugin;

  public void onDisable()
  {
    PluginDescriptionFile pdfFile = getDescription();
    this.logger.info(pdfFile.getName() + " Has Been Disabled!!!!");
  }

  public void onEnable()
  {
    PluginDescriptionFile pdfFile = getDescription();
    this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " Has Been Enabled!");
  }
  public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String[] args) {
    Player player = (Player)sender;
    if (commandlabel.equalsIgnoreCase("hug")) {
      if (args.length == 0)
      {
        player.sendMessage(ChatColor.DARK_RED + "You need to put a name silly" + ChatColor.DARK_BLUE + " /hug <player>");
      } else if (args.length == 1) {
    	  
        Player targetPlayer = player.getServer().getPlayer(args[0]);
        Ocelot o = (Ocelot)player.getWorld().spawn(player.getLocation(), Ocelot.class);
        o.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,70000,2));
        o.playEffect(EntityEffect.WOLF_HEARTS);
        o.remove();
        
        Ocelot o2 = (Ocelot)targetPlayer.getWorld().spawn(targetPlayer.getLocation(), Ocelot.class);
        o2.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,70000,2));
        o2.playEffect(EntityEffect.WOLF_HEARTS);
        o2.remove();
        targetPlayer.sendMessage(ChatColor.LIGHT_PURPLE + "You have been hugged by " + ChatColor.WHITE + player.getDisplayName() + ChatColor.LIGHT_PURPLE + "!");
  	    player.sendMessage(ChatColor.LIGHT_PURPLE + "You have hugged " + ChatColor.WHITE + targetPlayer.getDisplayName());
      }
    }
    else if (commandlabel.equalsIgnoreCase("kiss")) {
      if (args.length == 0) {
        player.sendMessage(ChatColor.DARK_RED + "You need to put a name silly" + ChatColor.DARK_BLUE + " /kiss <player>");
      } else if (args.length == 1) {
        Player targetPlayer1 = player.getServer().getPlayer(args[0]);
        Ocelot o = (Ocelot)player.getWorld().spawn(player.getLocation(), Ocelot.class);
        o.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,70000,2));
        o.playEffect(EntityEffect.WOLF_HEARTS);
        o.remove();
        Ocelot o2 = (Ocelot)targetPlayer1.getWorld().spawn(targetPlayer1.getLocation(), Ocelot.class);
        o2.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,70000,2));
        o2.playEffect(EntityEffect.WOLF_HEARTS);
        o2.remove();
        targetPlayer1.sendMessage(ChatColor.LIGHT_PURPLE + "You have been kissed by " + ChatColor.WHITE + player.getDisplayName() + ChatColor.LIGHT_PURPLE + "!");
  	    player.sendMessage(ChatColor.LIGHT_PURPLE + "You have kissed " + ChatColor.WHITE + targetPlayer1.getDisplayName());
      }
    }
    else if (commandlabel.equalsIgnoreCase("slap")) {
        if (args.length == 0) {
          player.sendMessage(ChatColor.RED + "Error: " + ChatColor.DARK_RED + "Player not specified!");
        }
        if (args.length == 1) {
          if ((player.getServer().getPlayer(args[0]) == null) || (!player.getServer().getPlayer(args[0]).isOnline()))
          {
            player.sendMessage(ChatColor.RED + "Error: " + ChatColor.DARK_RED + "The specified player is not online.");
          }
          else if ((player.getServer().getPlayer(args[0]) != null) || (player.getServer().getPlayer(args[0]).isOnline()))
          {
            Player targetPlayer2 = player.getServer().getPlayer(args[0]);
            if (player.getName().equalsIgnoreCase(targetPlayer2.getName()))
            {
              player.sendMessage(ChatColor.RED + "Error: " + ChatColor.DARK_RED + "You cannot slap yourself!");
            }
            else {
              sender.sendMessage(ChatColor.RED + "You slapped " + targetPlayer2.getName());
              targetPlayer2.sendMessage(ChatColor.RED + sender.getName() + " just slapped you!");
              targetPlayer2.damage(2d);
    return false;}}}}
	return false;}}