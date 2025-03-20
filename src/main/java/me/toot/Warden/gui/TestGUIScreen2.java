package me.toot.Warden.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;

import java.io.IOException;

public class TestGUIScreen2 extends GuiScreen {

    @Override
    public void initGui(){
        System.out.println("Initializing Gui 2");
        super.initGui();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks){
        try {
            System.out.println("Test - Drawing GUI");
            drawDefaultBackground();

            int centerX = this.width / 2;
            int centerY = this.height / 2;

            int rectangleHeight = 100;
            int rectangleWidth = 50;

            drawRect(centerX - rectangleWidth / 2, centerY - rectangleHeight / 2,
                    centerX + rectangleWidth / 2, centerY + rectangleHeight / 2, 0xFF00FF00);
            drawCenteredString(this.fontRendererObj, "Test GUI 2", centerX,
                    centerY - (this.fontRendererObj.FONT_HEIGHT / 2), 0xFFFFFFFF);
        } catch (Exception e) {
            System.out.println("Error in drawScreen: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public boolean doesGuiPauseGame(){
        return true;
    }

    @Override
    public void onGuiClosed() {
        System.out.println("GUI Closed 2 - Active GUI before closing: " + Minecraft.getMinecraft().currentScreen);
        new Exception("Stack Trace:").printStackTrace();
        super.onGuiClosed();
    }

    @Override
    public void updateScreen(){
        super.updateScreen();
        System.out.println("Updating Gui 2");
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) {
        System.out.println("Key Typed: " + typedChar + ", keyCode: " + keyCode);
        if (keyCode == 1) {
            System.out.println("ESC Pressed - Blocking Exit");
            return; // Don't call super
        }
        try {
            super.keyTyped(typedChar, keyCode);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
