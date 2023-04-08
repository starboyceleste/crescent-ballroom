package net.celeste.crescent.item;

import net.celeste.crescent.entity.CrescentEntityType;
import net.celeste.crescent.entity.MicrophoneStandEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.*;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.function.Consumer;

public class MicrophoneStandItem extends Item {
    public MicrophoneStandItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        Direction direction = context.getSide();
        if (direction == Direction.DOWN) {
            return ActionResult.FAIL;
        }
        World world = context.getWorld();
        ItemPlacementContext itemPlacementContext = new ItemPlacementContext(context);
        BlockPos blockPos = itemPlacementContext.getBlockPos();
        ItemStack itemStack = context.getStack();
        Vec3d vec3d = Vec3d.ofBottomCenter(blockPos);
        Box box = CrescentEntityType.MICROPHONE_STAND.getDimensions().getBoxAt(vec3d.getX(), vec3d.getY(), vec3d.getZ());
        if (!world.isSpaceEmpty(null, box) || !world.getOtherEntities(null, box).isEmpty()) {
            return ActionResult.FAIL;
        }
        if (world instanceof ServerWorld serverWorld) {
            Consumer<MicrophoneStandEntity> consumer = EntityType.nbtCopier(entity -> {}, serverWorld, itemStack, context.getPlayer());
            MicrophoneStandEntity microphoneStandEntity = CrescentEntityType.MICROPHONE_STAND.create(serverWorld, itemStack.getNbt(), consumer, blockPos, SpawnReason.SPAWN_EGG, true, true);
            if (microphoneStandEntity == null) {
                return ActionResult.FAIL;
            }
            if (context.getPlayer() == null) {
                return ActionResult.FAIL;
            }
            context.getPlayer().sendMessage(Text.of(".getYaw(): " + (context.getPlayer().getYaw())));
            context.getPlayer().sendMessage(Text.of(".getPlayerYaw(): " + (context.getPlayerYaw())));
            float f = MathHelper.wrapDegrees(context.getPlayerYaw() - 180.0f);
            microphoneStandEntity.refreshPositionAndAngles(microphoneStandEntity.getX(), microphoneStandEntity.getY(), microphoneStandEntity.getZ(), f, 0.0f);
            serverWorld.spawnEntityAndPassengers(microphoneStandEntity);
            world.playSound(null, microphoneStandEntity.getX(), microphoneStandEntity.getY(), microphoneStandEntity.getZ(), SoundEvents.BLOCK_NETHERITE_BLOCK_PLACE, SoundCategory.BLOCKS, 0.75f, 0.8f);
            microphoneStandEntity.emitGameEvent(GameEvent.ENTITY_PLACE, context.getPlayer());
        }
        itemStack.decrement(1);
        return ActionResult.success(world.isClient);
    }
}
