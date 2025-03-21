package me.toot.Warden;

import me.toot.Warden.Commands.WardenCommand;
import me.toot.Warden.Guis.MainGui;
import me.toot.Warden.config.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

import java.io.File;

@Mod(modid = Warden.MODID, name = Warden.NAME, version = Warden.VERSION, clientSideOnly = true)
public class Warden {
    public static final String MODID = "warden";
    public static final String NAME = "Warden";
    public static final String VERSION = "0.0.1";

    private KeyBinding openGuiKey;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        File configFile = event.getSuggestedConfigurationFile();
        Config.init(configFile);

        openGuiKey = new KeyBinding("Open GUI", Keyboard.KEY_RSHIFT, "key.categories.misc");
        ClientRegistry.registerKeyBinding(openGuiKey);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        MinecraftForge.EVENT_BUS.register(this);

        ClientCommandHandler.instance.registerCommand(new WardenCommand());
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event){
        if (openGuiKey.isPressed()){
            Minecraft.getMinecraft().displayGuiScreen(new MainGui());
        }
    }
}
