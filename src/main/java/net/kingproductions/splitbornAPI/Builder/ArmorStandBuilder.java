package net.kingproductions.splitbornAPI.Builder;

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
    private boolean customNameVisible = false;

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

    public ArmorStandBuilder enableSpin(boolean enabledSpin){
        this.enabledSpin = enabledSpin;
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

    public ArmorStand build(World world) {
        if (location == null) throw new IllegalStateException("ERROR - PLEASE REPORT THIS (135 - ArmorStandBuilder)");

        ArmorStand armorStand = (ArmorStand) world.spawnEntity(location, EntityType.ARMOR_STAND);

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

//        KingEntities.add(armorStand);

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

        new BukkitRunnable(){

            @Override
            public void run() {
                if (enabledSpin){
                    if (armorStand.isDead()){
                        this.cancel();
                        return;
                    }
                    EulerAngle oldRot = armorStand.getHeadPose();
                    EulerAngle newRot = oldRot.add(0f, 0.5f, 0.f);
                    armorStand.setHeadPose(newRot);
                }
            }
        }.runTaskTimer(plugin, 0, 1);

        return armorStand;
    }
}
