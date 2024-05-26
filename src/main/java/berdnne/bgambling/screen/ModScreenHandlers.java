package berdnne.bgambling.screen;

import berdnne.bgambling.BrendensGambling;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {

    public static final ScreenHandlerType<BlackjackScreenHandler> BLACKJACK_SCREEN_HANDLER = Registry.register(Registries.SCREEN_HANDLER, new Identifier(BrendensGambling.MOD_ID, "blackjack"),
            new ExtendedScreenHandlerType<>(BlackjackScreenHandler::new));

    public static void registerModScreenHandlers(){

        BrendensGambling.LOGGER.info("Registering Mod Screen Handlers");

    }

}
