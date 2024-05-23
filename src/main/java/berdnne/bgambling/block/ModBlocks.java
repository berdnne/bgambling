package berdnne.bgambling.block;

import berdnne.bgambling.BrendensGambling;
import berdnne.bgambling.block.custom.BlackjackTableBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block BLACKJACK_TABLE = registerBlock("blackjack_table", new BlackjackTableBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS)));

    private static Block registerBlock(String name, Block block) {

        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(BrendensGambling.MOD_ID, name), block);

    }

    private static Item registerBlockItem(String name, Block block) {

        return Registry.register(Registries.ITEM, new Identifier(BrendensGambling.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));

    }

    public static void registerModBlocks() {

        BrendensGambling.LOGGER.info("Registering Mod Blocks");

    }

}
