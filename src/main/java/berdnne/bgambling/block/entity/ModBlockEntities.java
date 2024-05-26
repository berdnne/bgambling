package berdnne.bgambling.block.entity;

import berdnne.bgambling.BrendensGambling;
import berdnne.bgambling.block.ModBlocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {

    public static final BlockEntityType<BlackjackTableBlockEntity> BLACKJACK_TABLE_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(BrendensGambling.MOD_ID, "blackjack_table_block_entity"),
                    BlockEntityType.Builder.create(BlackjackTableBlockEntity::new, ModBlocks.BLACKJACK_TABLE).build());

    public static void registerBlockEntities(){

        BrendensGambling.LOGGER.info("Registering Mod Block Entities");

    }

}
