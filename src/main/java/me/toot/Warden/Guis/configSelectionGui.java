package me.toot.Warden.Guis;

import me.toot.Warden.Util.ColoredGuiButton;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class configSelectionGui extends GuiScreen {

    @Override
    public void initGui(){

        int centerX = this.width / 2;
        int centerY = this.width / 2;

        this.buttonList.add(new GuiButton(0, centerX - 100, (90 + this.height) - this.height, 80, 20 , "General"));
        this.buttonList.add(new GuiButton(1, centerX + 20, (90 + this.height) - this.height, 80, 20 , "Misc"));

        this.buttonList.add(new ColoredGuiButton(99, centerX - 50, centerY - 30, 100, 20 , "Back", 0xFF0000));

    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks){
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public void actionPerformed(GuiButton button){
        if (button.id == 99){
            Minecraft.getMinecraft().displayGuiScreen(new MainGui());
        }
    }

    @Override
    public boolean doesGuiPauseGame(){
        return false;
    }

}
