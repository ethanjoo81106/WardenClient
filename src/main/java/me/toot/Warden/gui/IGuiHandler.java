package me.toot.Warden.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class IGuiHandler implements net.minecraftforge.fml.common.network.IGuiHandler {
    public static final int TEST_GUI_2 = 0; // Unique ID for your GUI

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return null; // This is only needed for container-based GUIs
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == TEST_GUI_2) {
            return new TestGUIScreen2(); // Return your GUI screen
        }
        return null;
    }

    public static void openGui(int guiID) {
        Minecraft.getMinecraft().displayGuiScreen(new TestGUIScreen2());
    }
}
