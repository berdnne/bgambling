package berdnne.bgambling;

import berdnne.bgambling.screen.BlackjackScreen;
import berdnne.bgambling.screen.ModScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class BrendensGamblingClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        HandledScreens.register(ModScreenHandlers.BLACKJACK_SCREEN_HANDLER, BlackjackScreen::new);

    }
}
