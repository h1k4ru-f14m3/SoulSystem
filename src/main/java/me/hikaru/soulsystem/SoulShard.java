package me.hikaru.soulsystem;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

public class SoulShard implements PlayerInventory {
    @Override
    public @Nullable ItemStack @NotNull [] getArmorContents() {
        return new ItemStack[0];
    }

    @Override
    public @Nullable ItemStack @NotNull [] getExtraContents() {
        return new ItemStack[0];
    }

    @Override
    public @Nullable ItemStack getHelmet() {
        return null;
    }

    @Override
    public @Nullable ItemStack getChestplate() {
        return null;
    }

    @Override
    public @Nullable ItemStack getLeggings() {
        return null;
    }

    @Override
    public @Nullable ItemStack getBoots() {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public int getMaxStackSize() {
        return 0;
    }

    @Override
    public void setMaxStackSize(int i) {

    }

    @Override
    public @Nullable ItemStack getItem(int i) {
        return null;
    }

    @Override
    public void setItem(int i, @Nullable ItemStack itemStack) {

    }

    @Override
    public @NotNull HashMap<Integer, ItemStack> addItem(@NotNull ItemStack... itemStacks) throws IllegalArgumentException {
        return null;
    }

    @Override
    public @NotNull HashMap<Integer, ItemStack> removeItem(@NotNull ItemStack... itemStacks) throws IllegalArgumentException {
        return null;
    }

    @Override
    public @NotNull HashMap<Integer, ItemStack> removeItemAnySlot(@NotNull ItemStack... itemStacks) throws IllegalArgumentException {
        return null;
    }

    @Override
    public @Nullable ItemStack @NotNull [] getContents() {
        return new ItemStack[0];
    }

    @Override
    public void setContents(@Nullable ItemStack @NotNull [] itemStacks) throws IllegalArgumentException {

    }

    @Override
    public @Nullable ItemStack @NotNull [] getStorageContents() {
        return new ItemStack[0];
    }

    @Override
    public void setStorageContents(@Nullable ItemStack @NotNull [] itemStacks) throws IllegalArgumentException {

    }

    @Override
    public boolean contains(@NotNull Material material) throws IllegalArgumentException {
        return false;
    }

    @Override
    public boolean contains(@Nullable ItemStack itemStack) {
        return false;
    }

    @Override
    public boolean contains(@NotNull Material material, int i) throws IllegalArgumentException {
        return false;
    }

    @Override
    public boolean contains(@Nullable ItemStack itemStack, int i) {
        return false;
    }

    @Override
    public boolean containsAtLeast(@Nullable ItemStack itemStack, int i) {
        return false;
    }

    @Override
    public @NotNull HashMap<Integer, ? extends ItemStack> all(@NotNull Material material) throws IllegalArgumentException {
        return null;
    }

    @Override
    public @NotNull HashMap<Integer, ? extends ItemStack> all(@Nullable ItemStack itemStack) {
        return null;
    }

    @Override
    public int first(@NotNull Material material) throws IllegalArgumentException {
        return 0;
    }

    @Override
    public int first(@NotNull ItemStack itemStack) {
        return 0;
    }

    @Override
    public int firstEmpty() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void remove(@NotNull Material material) throws IllegalArgumentException {

    }

    @Override
    public void remove(@NotNull ItemStack itemStack) {

    }

    @Override
    public void clear(int i) {

    }

    @Override
    public void clear() {

    }

    @Override
    public int close() {
        return 0;
    }

    @Override
    public @NotNull List<HumanEntity> getViewers() {
        return null;
    }

    @Override
    public @NotNull InventoryType getType() {
        return null;
    }

    @Override
    public void setItem(@NotNull EquipmentSlot equipmentSlot, @Nullable ItemStack itemStack) {

    }

    @Override
    public @NotNull ItemStack getItem(@NotNull EquipmentSlot equipmentSlot) {
        return null;
    }

    @Override
    public void setArmorContents(@Nullable ItemStack[] itemStacks) {

    }

    @Override
    public void setExtraContents(@Nullable ItemStack[] itemStacks) {

    }

    @Override
    public void setHelmet(@Nullable ItemStack itemStack) {

    }

    @Override
    public void setChestplate(@Nullable ItemStack itemStack) {

    }

    @Override
    public void setLeggings(@Nullable ItemStack itemStack) {

    }

    @Override
    public void setBoots(@Nullable ItemStack itemStack) {

    }

    @Override
    public @NotNull ItemStack getItemInMainHand() {
        return null;
    }

    @Override
    public void setItemInMainHand(@Nullable ItemStack itemStack) {

    }

    @Override
    public @NotNull ItemStack getItemInOffHand() {
        return null;
    }

    @Override
    public void setItemInOffHand(@Nullable ItemStack itemStack) {

    }

    @Override
    public @NotNull ItemStack getItemInHand() {
        return null;
    }

    @Override
    public void setItemInHand(@Nullable ItemStack itemStack) {

    }

    @Override
    public int getHeldItemSlot() {
        return 0;
    }

    @Override
    public void setHeldItemSlot(int i) {

    }

    @Override
    public @Nullable HumanEntity getHolder() {
        return null;
    }

    @Override
    public @Nullable InventoryHolder getHolder(boolean b) {
        return null;
    }

    @Override
    public @NotNull ListIterator<ItemStack> iterator() {
        return null;
    }

    @Override
    public @NotNull ListIterator<ItemStack> iterator(int i) {
        return null;
    }

    @Override
    public @Nullable Location getLocation() {
        return null;
    }
}
