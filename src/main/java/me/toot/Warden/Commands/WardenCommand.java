package me.toot.Warden.Commands;

import me.toot.Warden.Guis.MainGui;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

import java.util.concurrent.atomic.AtomicBoolean;

public class WardenCommand extends CommandBase {
    private final AtomicBoolean shouldOpenGui = new AtomicBoolean(false);

    public WardenCommand() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public String getCommandName() {
        return "warden";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/Warden";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        shouldOpenGui.set(true);
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onInput(InputEvent event) {
        if (shouldOpenGui.get()) {
            shouldOpenGui.set(false);
            Minecraft.getMinecraft().displayGuiScreen(new MainGui());
        }
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
}