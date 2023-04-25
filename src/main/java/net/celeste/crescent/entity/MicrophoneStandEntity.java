package net.celeste.crescent.entity;

import net.celeste.crescent.Crescent;
import net.celeste.crescent.item.CrescentItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.EulerAngle;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;


public class MicrophoneStandEntity extends LivingEntity {
    private static final Float BOOM_ROTATION_RANGE = 120.0f;
    private static final Float BOOM_ROTATION_STEPS = 9.0f;
    private static final Float BOOM_ROTATION_STEP_DEGREE = BOOM_ROTATION_RANGE / (BOOM_ROTATION_STEPS - 1);
    private static final EulerAngle DEFAULT_HEAD_ROTATION = new EulerAngle(0.0f, 0.0f, 0.0f);
    private static final EulerAngle DEFAULT_BODY_ROTATION = new EulerAngle(0.0f, 0.0f, 0.0f);
    private static final Float DEFAULT_BOOM_ROTATION = -10.0f;
    private EulerAngle headRotation = DEFAULT_HEAD_ROTATION;
    private EulerAngle bodyRotation = DEFAULT_BODY_ROTATION;
    private float boomRotation = DEFAULT_BOOM_ROTATION;
    private float prevBoomRotation = boomRotation;
    private boolean invisible;
    public long lastHitTime;
    public boolean reset;
    public long lastResetTime;
    public long lastShakeTime;
    public static final TrackedData<EulerAngle> TRACKER_HEAD_ROTATION = DataTracker.registerData(MicrophoneStandEntity.class, TrackedDataHandlerRegistry.ROTATION);
    public static final TrackedData<EulerAngle> TRACKER_BODY_ROTATION = DataTracker.registerData(MicrophoneStandEntity.class, TrackedDataHandlerRegistry.ROTATION);
    public static final TrackedData<Float> TRACKER_BOOM_ROTATION = DataTracker.registerData(MicrophoneStandEntity.class, TrackedDataHandlerRegistry.FLOAT);

    public MicrophoneStandEntity(EntityType<? extends MicrophoneStandEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(TRACKER_HEAD_ROTATION, DEFAULT_HEAD_ROTATION);
        this.dataTracker.startTracking(TRACKER_BODY_ROTATION, DEFAULT_BODY_ROTATION);
        this.dataTracker.startTracking(TRACKER_BOOM_ROTATION, DEFAULT_BOOM_ROTATION);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return DefaultAttributeContainer.builder().add(EntityAttributes.GENERIC_MAX_HEALTH).add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE).add(EntityAttributes.GENERIC_MOVEMENT_SPEED).add(EntityAttributes.GENERIC_ARMOR).add(EntityAttributes.GENERIC_ARMOR_TOUGHNESS);
    }

    private void rotateBoom() {
        this.world.playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_FISHING_BOBBER_RETRIEVE, this.getSoundCategory(),1.0f,0.5f);
        this.lastShakeTime = this.world.getTime();
    }

    private void spawnBreakParticles() {
        if (this.world instanceof ServerWorld) {
            ((ServerWorld)this.world).spawnParticles(new BlockStateParticleEffect(ParticleTypes.BLOCK, Blocks.NETHERITE_BLOCK.getDefaultState()), this.getX(), this.getBodyY(0.6666666666666666), this.getZ(), 10, this.getWidth() / 4.0f, this.getHeight() / 4.0f, this.getWidth() / 4.0f, 0.05);
        }
    }

    private void updateHealth(DamageSource damageSource, float amount) {
        float f = this.getHealth();
        if ((f -= amount) <= 0.5f) {
            this.onBreak(damageSource);
            this.kill();
        } else {
            this.setHealth(f);
            this.emitGameEvent(GameEvent.ENTITY_DAMAGE, damageSource.getAttacker());
        }
    }

    private void breakAndDropItem(DamageSource damageSource) {
        Block.dropStack(this.world, this.getBlockPos(), new ItemStack(CrescentItems.MICROPHONE_STAND));
        this.onBreak(damageSource);
    }

    private void onBreak(DamageSource damageSource) {
        this.playBreakSound();
        this.drop(damageSource);
    }

    private void playBreakSound() {
        this.world.playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_ARMOR_STAND_BREAK, this.getSoundCategory(), 1.0f, 1.0f);
    }

    @Override
    protected float turnHead(float bodyRotation, float headRotation) {
        this.prevBodyYaw = this.prevYaw;
        this.bodyYaw = this.getYaw();
        return 0.0f;
    }

    @Override
    public void setBodyYaw(float bodyYaw) {
        this.prevBodyYaw = this.prevYaw = bodyYaw;
        this.prevHeadYaw = this.headYaw = bodyYaw;
    }

    @Override
    public void setHeadYaw(float headYaw) {
        this.prevBodyYaw = this.prevYaw = headYaw;
        this.prevHeadYaw = this.headYaw = headYaw;
    }

    @Override
    public void tick() {
        EulerAngle headAngle;
        EulerAngle bodyAngle;
        Float boomAngle;
        super.tick();

        if (!this.headRotation.equals(headAngle = this.dataTracker.get(TRACKER_HEAD_ROTATION))) {
            this.setHeadRotation(headAngle);
        }
        if (!this.bodyRotation.equals(bodyAngle = this.dataTracker.get(TRACKER_BODY_ROTATION))) {
            this.setBodyRotation(bodyAngle);
        }
        if (!(this.boomRotation == (boomAngle = this.dataTracker.get(TRACKER_BOOM_ROTATION)))) {
            this.setBoomRotation(boomAngle);
        }

        if (this.boomRotation <= DEFAULT_BOOM_ROTATION - BOOM_ROTATION_RANGE / 2) {
            reset = false;
        }

        if ((this.reset) && (this.world.getTime() - this.lastResetTime > 1)) {
            Crescent.LOGGER.info("this.boomRotation_ORIGINAL: " + this.boomRotation);
            this.setBoomRotation(this.boomRotation - BOOM_ROTATION_STEP_DEGREE);
            this.rotateBoom();
            Crescent.LOGGER.info("this.boomRotation_SET: " + this.boomRotation);
            this.lastResetTime = this.world.getTime();
        }
        this.setCustomName(Text.of((Math.round(prevBoomRotation)) + "°"));
    }

    @Override
    protected void updatePotionVisibility() {
        this.setInvisible(this.invisible);
    }

    @Override
    public void setInvisible(boolean invisible) {
        this.invisible = invisible;
        super.setInvisible(invisible);
    }

    @Override
    public void kill() {
        this.remove(Entity.RemovalReason.KILLED);
        this.emitGameEvent(GameEvent.ENTITY_DIE);
    }

    @Override
    public boolean isImmuneToExplosion() {
        return this.isInvisible();
    }

    public void setHeadRotation(EulerAngle angle) {
        this.headRotation = angle;
        this.dataTracker.set(TRACKER_HEAD_ROTATION, angle);
    }

    public void setBodyRotation(EulerAngle angle) {
        this.bodyRotation = angle;
        this.dataTracker.set(TRACKER_BODY_ROTATION, angle);
    }

    public void setBoomRotation(float rotation){
        this.boomRotation = rotation;
        this.dataTracker.set(TRACKER_BOOM_ROTATION, rotation);
    }

    public void setPrevBoomRotation(float rotation) {
        this.prevBoomRotation = rotation;
    }

    public EulerAngle getHeadRotation() {
        return this.headRotation;
    }

    public EulerAngle getBodyRotation() {
        return this.bodyRotation;
    }

    public Float getBoomRotation() { return this.boomRotation; }

    public Float getPrevBoomRotation() { return this.prevBoomRotation; }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public ActionResult interact(PlayerEntity player, Hand hand) {
        if (!player.getStackInHand(hand).isEmpty()) {
            return ActionResult.PASS;
        }
        if (this.reset) {
            return ActionResult.PASS
;       }
        if (player.isSneaking()) {
            if (this.boomRotation < DEFAULT_BOOM_ROTATION + BOOM_ROTATION_RANGE / 2) {
                this.setBoomRotation(this.boomRotation + BOOM_ROTATION_STEP_DEGREE);
                this.rotateBoom();
            } else {
                this.jump();
                this.reset = true;
                this.lastResetTime = this.world.getTime();
            }
            return ActionResult.SUCCESS;
        } else if (world instanceof ServerWorld) {
            float f = (float)MathHelper.floor((MathHelper.wrapDegrees(player.getYaw() - 180.0f) + 7.5f) / 15.0f) * 15.0f;
            this.refreshPositionAndAngles(this.getX(), this.getY(), this.getZ(), f, 0.0f);

            EulerAngle eulerAngle = this.getHeadRotation();
            EulerAngle eulerAngle2 = new EulerAngle(eulerAngle.getPitch(), eulerAngle.getYaw(), eulerAngle.getRoll());
            this.setHeadRotation(eulerAngle2);
            eulerAngle = this.getBodyRotation();
            eulerAngle2 = new EulerAngle(eulerAngle.getPitch(), eulerAngle.getYaw(), eulerAngle.getRoll());
            this.setBodyRotation(eulerAngle2);
            this.playSound(SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 1.0f, 0.8f);
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public Iterable<ItemStack> getArmorItems() {
        return DefaultedList.ofSize(4, ItemStack.EMPTY);
    }

    @Override
    public ItemStack getEquippedStack(EquipmentSlot slot) {
        return ItemStack.EMPTY;
    }

    @Override
    public void equipStack(EquipmentSlot slot, ItemStack stack) {
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putBoolean("Invisible", this.isInvisible());
        nbt.putFloat("Boom", this.getBoomRotation());
        nbt.put("Pose", this.poseToNbt());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.setInvisible(nbt.getBoolean("Invisible"));
        this.setBoomRotation(nbt.getFloat("Boom"));
        NbtCompound nbtCompound = nbt.getCompound("Pose");
        this.readPoseNbt(nbtCompound);
    }

    private void readPoseNbt(NbtCompound nbt) {
        NbtList nbtList = nbt.getList("Head", NbtElement.FLOAT_TYPE);
        this.setHeadRotation(nbtList.isEmpty() ? DEFAULT_HEAD_ROTATION : new EulerAngle(nbtList));
        NbtList nbtList2 = nbt.getList("Body", NbtElement.FLOAT_TYPE);
        this.setBodyRotation(nbtList2.isEmpty() ? DEFAULT_BODY_ROTATION : new EulerAngle(nbtList2));
    }

    private NbtCompound poseToNbt() {
        NbtCompound nbtCompound = new NbtCompound();
        if (!DEFAULT_HEAD_ROTATION.equals(this.headRotation)) {
            nbtCompound.put("Head", this.headRotation.toNbt());
        }
        if (!DEFAULT_BODY_ROTATION.equals(this.bodyRotation)) {
            nbtCompound.put("Body", this.bodyRotation.toNbt());
        }
        return nbtCompound;
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        if (this.world.isClient || this.isRemoved()) {
            return false;
        }
        if (DamageSource.OUT_OF_WORLD.equals(source)) {
            this.kill();
            return false;
        }
        if (this.isInvulnerableTo(source) || this.invisible) {
            return false;
        }
        if (source.isExplosive()) {
            this.onBreak(source);
            this.kill();
            return false;
        }
        if (DamageSource.IN_FIRE.equals(source)) {
            if (this.isOnFire()) {
                this.updateHealth(source, 0.15f);
            } else {
                this.setOnFireFor(5);
            }
            return false;
        }
        if (DamageSource.ON_FIRE.equals(source) && this.getHealth() > 0.5f) {
            this.updateHealth(source, 4.0f);
            return false;
        }
        boolean bl = source.getSource() instanceof PersistentProjectileEntity;
        boolean bl2 = bl && ((PersistentProjectileEntity)source.getSource()).getPierceLevel() > 0;
        boolean bl3 = "player".equals(source.getName());
        if (!bl3 && !bl) {
            return false;
        }
        if (source.getAttacker() instanceof PlayerEntity && !((PlayerEntity)source.getAttacker()).getAbilities().allowModifyWorld) {
            return false;
        }
        if (source.isSourceCreativePlayer()) {
            this.playBreakSound();
            this.spawnBreakParticles();
            this.kill();
            return bl2;
        }
        long l = this.world.getTime();
        if (l - this.lastHitTime <= 5L || bl) {
            this.breakAndDropItem(source);
            this.spawnBreakParticles();
            this.kill();
        } else {
            if (this.world.isClient) {
                this.world.playSound(this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_ARMOR_STAND_HIT, this.getSoundCategory(), 0.3f, 1.0f, false);
                this.lastHitTime = this.world.getTime();
            }
            this.emitGameEvent(GameEvent.ENTITY_DAMAGE, source.getAttacker());
            this.lastHitTime = l;
        }
        return true;
    }

    @Override
    public boolean handleAttack(Entity attacker) {
        return attacker instanceof PlayerEntity && !this.world.canPlayerModifyAt((PlayerEntity)attacker, this.getBlockPos());
    }

    @Override
    public boolean isMobOrPlayer() {
        return false;
    }

    @Override
    public Arm getMainArm() {
        return null;
    }
}
