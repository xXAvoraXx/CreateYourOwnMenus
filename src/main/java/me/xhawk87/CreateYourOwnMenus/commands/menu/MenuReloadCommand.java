/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.xhawk87.CreateYourOwnMenus.commands.menu;

import me.xhawk87.CreateYourOwnMenus.CreateYourOwnMenus;
import me.xhawk87.CreateYourOwnMenus.commands.IMenuCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/**
 *
 * @author XHawk87
 */
public class MenuReloadCommand implements IMenuCommand {

    private CreateYourOwnMenus plugin;

    public MenuReloadCommand(CreateYourOwnMenus plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Expecting no parameters
        if (args.length != 0) {
            return false;
        }

        plugin.reloadMenus();
        sender.sendMessage(plugin.translate(sender, "menus-reloaded", "Menus reloaded from disk"));
        return true;
    }

    @Override
    public String getUsage() {
        return "/menu reload - Reloads all menus from disk";
    }

    @Override
    public String getPermission() {
        return "cyom.commands.menu.reload";
    }
}
