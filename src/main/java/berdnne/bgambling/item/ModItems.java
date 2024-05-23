package berdnne.bgambling.item;

import berdnne.bgambling.BrendensGambling;
import berdnne.bgambling.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item WHITE_CHIP = registerItem("white_chip", new Item(new Item.Settings()));
    public static final Item RED_CHIP = registerItem("red_chip", new Item(new Item.Settings()));
    public static final Item GREEN_CHIP = registerItem("green_chip", new Item(new Item.Settings()));
    public static final Item BLACK_CHIP = registerItem("black_chip", new Item(new Item.Settings()));

    public static final ItemGroup GAMBLING_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(BrendensGambling.MOD_ID, "gambling"), FabricItemGroup.builder()
                    .displayName(Text.translatable("itemgroup.gambling"))
                    .icon(() -> new ItemStack(ModItems.WHITE_CHIP)).entries((displayContext, entries) -> {

                        entries.add(ModItems.WHITE_CHIP);
                        entries.add(ModItems.RED_CHIP);
                        entries.add(ModItems.GREEN_CHIP);
                        entries.add(ModItems.BLACK_CHIP);
                        entries.add(ModBlocks.BLACKJACK_TABLE);

                    }).build());

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(BrendensGambling.MOD_ID, name), item);
    }

    public static void registerItems() {

        BrendensGambling.LOGGER.info("Registering Mod Items");

    }

    public static void registerItemGroups(){

        BrendensGambling.LOGGER.info("Registering Mod Item Groups");

    }

}
