package me.toot.Warden.gui;

import net.minecraft.client.gui.GuiScreen;

public class TestGUIScreen extends GuiScreen {

    @Override
    public void initGui(){
        super.initGui();
        System.out.println("Test Gui Initialized.");
        System.out.println("Width - " + this.width + " height - " + this.height);
    }

    @Override
    public void updateScreen(){
        super.updateScreen();
        System.out.println("Screen had been updated");
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks){
        drawDefaultBackground();
        drawCenteredString(this.fontRendererObj, "Ltc is gay ye", this.width / 2, this.height / 2, 0xFFFFFFFF);
        System.out.println("Ltc IS still gay xD");
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode){
        if (keyCode == 1){
            this.mc.displayGuiScreen(null);
        }
    }

    @Override
    public boolean doesGuiPauseGame(){
        return false;
    }
}
