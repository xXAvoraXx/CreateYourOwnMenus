/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.xhawk87.CreateYourOwnMenus.commands.menu;

import me.xhawk87.CreateYourOwnMenus.CreateYourOwnMenus;
import me.xhawk87.CreateYourOwnMenus.commands.IMenuCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 *
 * @author XHawk87
 */
public abstract class IMenuScriptCommand implements IMenuCommand {

    protected CreateYourOwnMenus plugin;

    public IMenuScriptCommand(CreateYourOwnMenus plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        throw new UnsupportedOperationException("Not supported.");
    }

    public abstract boolean onCommand(CommandSender sender, Player target, Command command, String label, String[] args);

    protected int getIndex(String indexString, int maxIndex, CommandSender sender) {
        int index;
        try {
            index = Integer.parseInt(indexString);
            if (index < 0) {
                sender.sendMessage(plugin.translate(sender, "error-negative-index", "The index must be at least 0: {0}", indexString));
                return -1;
            }
            if (index >= maxIndex) {
                sender.sendMessage(plugin.translate(sender, "error-index-too-high", "The index must be less than the number of lines in the lore ({0}): {1}", maxIndex, indexString));
                return -1;
            }
            return index;
        } catch (NumberFormatException ex) {
            sender.sendMessage(plugin.translate(sender, "expected-integer-index", "The index must be a whole number: {0}", indexString));
            return -1;
        }
    }
}
