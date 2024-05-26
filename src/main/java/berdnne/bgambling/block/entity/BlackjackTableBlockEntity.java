package berdnne.bgambling.block.entity;

import berdnne.bgambling.screen.BlackjackScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BlackjackTableBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);

    private static final int SLOT_0 = 0;
    private static final int SLOT_1 = 1;
    private static final int SLOT_2 = 2;
    private static final int SLOT_3 = 3;

    protected final PropertyDelegate propertyDelegate;
    
    private int total_money = 0;
    private int bet_amount = 0;

    public BlackjackTableBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.BLACKJACK_TABLE_BLOCK_ENTITY, pos, state);
        this.propertyDelegate = new PropertyDelegate() {

            @Override
            public int get(int index) {
                return switch (index){
                    case 0 -> BlackjackTableBlockEntity.this.total_money;
                    case 1 -> BlackjackTableBlockEntity.this.bet_amount;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index){
                    case 0 -> BlackjackTableBlockEntity.this.total_money = value;
                    case 1 -> BlackjackTableBlockEntity.this.bet_amount = value;
                }
            }

            // num of integers used in this class
            @Override
            public int size() {
                return 2;
            }
        };
    }

    // will likely need a rework for 1.21
    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {

        super.readNbt(nbt, registryLookup);
        Inventories.readNbt(nbt, inventory, registryLookup);
        total_money = nbt.getInt("total_money");
        bet_amount = nbt.getInt("bet_amount");

    }

    // will likely need a rework for 1.21
    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {

        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, inventory, registryLookup);
        nbt.putInt("total_money", total_money);
        nbt.putInt("bet_amount", bet_amount);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return null;
    }

    @Override
    public Object getScreenOpeningData(ServerPlayerEntity player) {
        return null;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("container.blackjack_table");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new BlackjackScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }


    public void tick(World world, BlockPos pos, BlockState state) {

        if (world.isClient()){
            return;
        }

        // table logic goes here (ticked 20 times per second)

    }
}
