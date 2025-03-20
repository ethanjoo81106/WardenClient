package me.toot.Warden.Commands;

import me.toot.Warden.gui.IGuiHandler;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

public class WardenCommand extends CommandBase{

    @Override
    public String getCommandName(){
        return "warden";
    }

    @Override
    public String getCommandUsage(ICommandSender sender){
        return "/Warden";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args){
        sender.addChatMessage(new ChatComponentText(String.valueOf(args.length)));
        sender.addChatMessage(new ChatComponentText(String.valueOf("Attempting to open GUI")));

        IGuiHandler.openGui(IGuiHandler.TEST_GUI_2);
    }

    @Override
    public int getRequiredPermissionLevel(){
        return 0;
    }
}
