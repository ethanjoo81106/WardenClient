package me.toot.Warden.Guis;

import me.toot.Warden.Util.ColoredGuiButton;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ChatComponentText;

public class MainGui extends GuiScreen {

    @Override
    public void initGui(){

        int centerX = this.width / 2;
        int centerY = this.width / 2;

        this.buttonList.add(new GuiButton(0, centerX - 100, (90 + this.height) - this.height, 80, 20 , "Config"));
        this.buttonList.add(new GuiButton(1, centerX + 20, (90 + this.height) - this.height, 80, 20 , "Gui Locations"));
        this.buttonList.add(new ColoredGuiButton(2, centerX - 40, centerY, 80, 20 , "Credits", 0x00ff00));
        this.buttonList.add(new ColoredGuiButton(99, centerX - 50, centerY - 30, 100, 20 , "Close", 0xFF0000));

        this.buttonList.add(new GuiButton(2, this.width-20, this.height-20, 20, 20, "1"));
        this.buttonList.add(new GuiButton(3, this.width-20, 0, 20, 20, "2"));
        this.buttonList.add(new GuiButton(4, 0, this.height-20, 20, 20, "3"));
        this.buttonList.add(new GuiButton(5, 0, 0, 20, 20, "4"));
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks){
        this.drawDefaultBackground();

        GlStateManager.pushMatrix();

        {
            float scale = 2.0F;
            GlStateManager.scale(scale, scale, scale);

            float scaledX = (this.width / 2) / scale;
            float scaledY = ((50 + this.height) - this.height) / scale;

            this.drawCenteredString(this.fontRendererObj, "Warden", (int) scaledX, (int) scaledY, 0x18848e);
        }

        GlStateManager.popMatrix();

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public void actionPerformed(GuiButton button){
        if (button.id == 99){
            this.mc.displayGuiScreen(null);
        } else if (button.id == 0){
            Minecraft.getMinecraft().displayGuiScreen(new configSelectionGui());
        }
    }

    @Override
    public boolean doesGuiPauseGame(){
        return false;
    }
}
