package berdnne.bgambling;

import berdnne.bgambling.block.ModBlocks;
import berdnne.bgambling.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrendensGambling implements ModInitializer {

	public static final String MOD_ID = "bgambling";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerItems();
		ModItems.registerItemGroups();
		ModBlocks.registerModBlocks();

	}
}