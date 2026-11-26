package net.kingproductions.splitbornAPI.Builder;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;

import java.util.UUID;

import static net.kingproductions.splitbornAPI.Main.SplitbornAPI.plugin;

public class ArmorStandBuilder{
    private Location location;
    private String displayName;
    private boolean visible = true;
    private boolean hasArms = false;
    private boolean hasBasePlate = true;
    private boolean isSmall = false;
    private boolean isMarker = false;
    private boolean hasGravity = false;
    private ItemStack helmet, chestplate, leggings, boots, mainHand, offHand;
    private EulerAngle headPose, bodyPose, leftArmPose, rightArmPose, leftLegPose, rightLegPose;
    private boolean enabledSpin = false;
    private boolean enableHover = false;
    private boolean customNameVisible = false;
    private boolean spinAndHover = false;

    private String CustomName = "§e";

    public ArmorStandBuilder setLocation(Location location) {
        this.location = location;
        return this;
    }

    public ArmorStandBuilder setDisplayName(String name) {
        this.displayName = ChatColor.translateAlternateColorCodes('&', name);
        return this;
    }

    public ArmorStandBuilder setVisible(boolean visible) {
        this.visible = visible;
        return this;
    }

    public ArmorStandBuilder setArms(boolean hasArms) {
        this.hasArms = hasArms;
        return this;
    }

    public ArmorStandBuilder setBasePlate(boolean hasBasePlate) {
        this.hasBasePlate = hasBasePlate;
        return this;
    }

    public ArmorStandBuilder setSmall(boolean isSmall) {
        this.isSmall = isSmall;
        return this;
    }

    public ArmorStandBuilder setGravity(boolean hasGravity){
        this.hasGravity = hasGravity;
        return this;
    }

    public ArmorStandBuilder setMarker(boolean isMarker) {
        this.isMarker = isMarker;
        return this;
    }

    public ArmorStandBuilder setCustomName(String s){
        this.CustomName = s;
        return this;
    }

    public ArmorStandBuilder setCustomNameVisible(boolean b){
        this.customNameVisible = b;
        return this;
    }

    public ArmorStandBuilder setHelmet(ItemStack helmet) {
        this.helmet = helmet;
        return this;
    }

    public ArmorStandBuilder setChestplate(ItemStack chestplate) {
        this.chestplate = chestplate;
        return this;
    }

    public ArmorStandBuilder setLeggings(ItemStack leggings) {
        this.leggings = leggings;
        return this;
    }

    public ArmorStandBuilder setBoots(ItemStack boots) {
        this.boots = boots;
        return this;
    }

    public ArmorStandBuilder setMainHand(ItemStack mainHand) {
        this.mainHand = mainHand;
        return this;
    }

    public ArmorStandBuilder setOffHand(ItemStack offHand) {
        this.offHand = offHand;
        return this;
    }

    public ArmorStandBuilder setHeadPose(EulerAngle angle) {
        this.headPose = angle;
        return this;
    }

    public ArmorStandBuilder setBodyPose(EulerAngle angle) {
        this.bodyPose = angle;
        return this;
    }

    public ArmorStandBuilder setLeftArmPose(EulerAngle angle) {
        this.leftArmPose = angle;
        return this;
    }

    public ArmorStandBuilder setRightArmPose(EulerAngle angle) {
        this.rightArmPose = angle;
        return this;
    }

    public ArmorStandBuilder setLeftLegPose(EulerAngle angle) {
        this.leftLegPose = angle;
        return this;
    }

    public ArmorStandBuilder setRightLegPose(EulerAngle angle) {
        this.rightLegPose = angle;
        return this;
    }
    public ArmorStandBuilder setSpinAndHover(boolean b){
        this.spinAndHover = b;
        return this;
    }
    public ArmorStandBuilder setSpin(boolean b){
        this.enabledSpin = b;
        return this;
    }

    public ArmorStandBuilder setHover(boolean b){
        this.enableHover = b;
        return this;
    }

    private static void keepChunksLoaded(Location center, int radius) {
        for (int x = (center.getBlockX() - radius) >> 4; x <= (center.getBlockX() + radius) >> 4; x++) {
            for (int z = (center.getBlockZ() - radius) >> 4; z <= (center.getBlockZ() + radius) >> 4; z++) {
                center.getWorld().addPluginChunkTicket(x, z, plugin);
            }
        }
    }

    public ArmorStand build(World world) {
        if (location == null) throw new IllegalStateException("-");
        keepChunksLoaded(location, 5);

        ArmorStand armorStand = world.spawn(location, ArmorStand.class);

        if (displayName != null) {
            armorStand.setCustomName(displayName);
            armorStand.setCustomNameVisible(true);
        }

        armorStand.setVisible(visible);
        armorStand.setArms(hasArms);
        armorStand.setBasePlate(hasBasePlate);
        armorStand.setSmall(isSmall);
        armorStand.setMarker(isMarker);

        armorStand.setGravity(hasGravity);
        armorStand.setCustomName(CustomName);
        armorStand.setCustomNameVisible(customNameVisible);

        armorStand.setPersistent(true);
        armorStand.setRemoveWhenFarAway(false);

        if (helmet != null) armorStand.getEquipment().setHelmet(helmet);
        if (chestplate != null) armorStand.getEquipment().setChestplate(chestplate);
        if (leggings != null) armorStand.getEquipment().setLeggings(leggings);
        if (boots != null) armorStand.getEquipment().setBoots(boots);
        if (mainHand != null) armorStand.getEquipment().setItemInMainHand(mainHand);
        if (offHand != null) armorStand.getEquipment().setItemInOffHand(offHand);

        if (headPose != null) armorStand.setHeadPose(headPose);
        if (bodyPose != null) armorStand.setBodyPose(bodyPose);
        if (leftArmPose != null) armorStand.setLeftArmPose(leftArmPose);
        if (rightArmPose != null) armorStand.setRightArmPose(rightArmPose);
        if (leftLegPose != null) armorStand.setLeftLegPose(leftLegPose);
        if (rightLegPose != null) armorStand.setRightLegPose(rightLegPose);

        armorStand.addEquipmentLock(EquipmentSlot.HEAD, ArmorStand.LockType.REMOVING_OR_CHANGING);
        armorStand.addEquipmentLock(EquipmentSlot.HEAD, ArmorStand.LockType.ADDING_OR_CHANGING);
        armorStand.addEquipmentLock(EquipmentSlot.CHEST, ArmorStand.LockType.REMOVING_OR_CHANGING);
        armorStand.addEquipmentLock(EquipmentSlot.CHEST, ArmorStand.LockType.ADDING_OR_CHANGING);
        armorStand.addEquipmentLock(EquipmentSlot.LEGS, ArmorStand.LockType.REMOVING_OR_CHANGING);
        armorStand.addEquipmentLock(EquipmentSlot.LEGS, ArmorStand.LockType.ADDING_OR_CHANGING);
        armorStand.addEquipmentLock(EquipmentSlot.FEET, ArmorStand.LockType.REMOVING_OR_CHANGING);
        armorStand.addEquipmentLock(EquipmentSlot.FEET, ArmorStand.LockType.ADDING_OR_CHANGING);
        armorStand.addEquipmentLock(EquipmentSlot.HAND, ArmorStand.LockType.REMOVING_OR_CHANGING);
        armorStand.addEquipmentLock(EquipmentSlot.HAND, ArmorStand.LockType.ADDING_OR_CHANGING);
        armorStand.addEquipmentLock(EquipmentSlot.OFF_HAND, ArmorStand.LockType.REMOVING_OR_CHANGING);
        armorStand.addEquipmentLock(EquipmentSlot.OFF_HAND, ArmorStand.LockType.ADDING_OR_CHANGING);
        armorStand.addEquipmentLock(EquipmentSlot.BODY, ArmorStand.LockType.REMOVING_OR_CHANGING);
        armorStand.addEquipmentLock(EquipmentSlot.BODY, ArmorStand.LockType.ADDING_OR_CHANGING);
        armorStand.addEquipmentLock(EquipmentSlot.SADDLE, ArmorStand.LockType.REMOVING_OR_CHANGING);
        armorStand.addEquipmentLock(EquipmentSlot.SADDLE, ArmorStand.LockType.ADDING_OR_CHANGING);

        UUID armorStandUUID = armorStand.getUniqueId();

        if (enabledSpin){
            new BukkitRunnable(){
                int ticks = 0;
                int iterations = 0;

                @Override
                public void run() {
                    ArmorStand upToDateArmorStand = Bukkit.getEntity(armorStandUUID) != null ? (ArmorStand) Bukkit.getEntity(armorStandUUID) : null;
                    if (iterations == 20*20 && upToDateArmorStand == null || iterations == 20*20 && upToDateArmorStand.isDead()){
                        this.cancel();
                        return;
                    }
                    if (upToDateArmorStand == null || upToDateArmorStand.isDead()){
                        return;
                    }
                    EulerAngle oldRot = armorStand.getHeadPose();
                    EulerAngle newRot = oldRot.add(0f, 0.2f, 0.f);
                    armorStand.setHeadPose(newRot);

                    ticks++;
                    iterations ++;
                }
            }.runTaskTimer(plugin, 20, 1);
        }
        if (enableHover){
            new BukkitRunnable(){
                int ticks = 0;
                boolean goingUp = true;
                int iterations = 0;

                @Override
                public void run() {
                    ArmorStand upToDateArmorStand = Bukkit.getEntity(armorStandUUID) != null ? (ArmorStand) Bukkit.getEntity(armorStandUUID) : null;
                    if (iterations == 20*20 && upToDateArmorStand == null || iterations == 20*20 && upToDateArmorStand.isDead()){
                        this.cancel();
                        return;
                    }
                    if (upToDateArmorStand == null || upToDateArmorStand.isDead()){
                        return;
                    }
                    if (ticks >= 20) {
                        goingUp = !goingUp;
                        ticks = 0;
                    }

                    double yOffset = goingUp ? 0.03 : -0.03;
                    armorStand.teleport(armorStand.getLocation().clone().add(0, yOffset, 0));

                    ticks++;
                    iterations ++;
                }
            }.runTaskTimer(plugin, 20, 1);
        }
        if (spinAndHover){
            new BukkitRunnable(){
                int ticks = 0;
                boolean goingUp = true;
                int iterations = 0;

                @Override
                public void run() {
                    ArmorStand upToDateArmorStand = Bukkit.getEntity(armorStandUUID) != null ? (ArmorStand) Bukkit.getEntity(armorStandUUID) : null;
                    if (iterations == 20*20 && upToDateArmorStand == null || iterations == 20*20 && upToDateArmorStand.isDead()){
                        this.cancel();
                        return;
                    }
                    if (upToDateArmorStand == null || upToDateArmorStand.isDead()){
                        return;
                    }
                    EulerAngle oldRot = armorStand.getHeadPose();
                    EulerAngle newRot = oldRot.add(0f, 0.2f, 0.f);
                    armorStand.setHeadPose(newRot);

                    if (ticks >= 20) {
                        goingUp = !goingUp;
                        ticks = 0;
                    }

                    double yOffset = goingUp ? 0.03 : -0.03;
                    armorStand.teleport(armorStand.getLocation().clone().add(0, yOffset, 0));

                    ticks++;
                    iterations ++;
                }
            }.runTaskTimer(plugin, 20, 1);
        }

        return armorStand;
    }
}
