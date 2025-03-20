package me.toot.Warden;

import me.toot.Warden.Commands.WardenCommand;
import me.toot.Warden.gui.IGuiHandler;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(modid = TestingClass.MODID, name = TestingClass.NAME, version = TestingClass.VERSION, clientSideOnly = true)
public class TestingClass {
    public static final String MODID = "warden";

    public static final String NAME = "Warden";
    public static final String VERSION = "0.0.1";
    public static final int GUI_EXAMPLE_ID = 0;

    @Mod.Instance(MODID)
    public static TestingClass instance;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        ClientCommandHandler.instance.registerCommand(new WardenCommand());
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new IGuiHandler());
    }
}
