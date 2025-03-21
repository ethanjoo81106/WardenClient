package me.toot.Warden.Guis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ChatComponentText;

public class MainGui extends GuiScreen {

    @Override
    public void initGui(){
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 2 - 40, 20, 20, "Features"));
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 2 - 80, 20, 20, "Close"));
    }

    @Override
    public void actionPerformed(GuiButton button){
        if (button.id == 0){
            this.mc.displayGuiScreen(null);
        } else if (button.id == 1){
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Placeholder for gui for now"));
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks){
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.drawCenteredString(this.fontRendererObj, "Warden Client", this.width / 2, this.height / 2 - 50, 0xA3A3A3);
    }

    @Override
    public boolean doesGuiPauseGame(){
        return false;
    }
}
