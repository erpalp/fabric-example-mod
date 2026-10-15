package com.example;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;

import java.util.ArrayList;
import java.util.List;

public class ExampleModClient implements ClientModInitializer {
    private static final List<ItemStack> markedItems = new ArrayList<>();

    @Override
    public void onInitializeClient() {
        // Registrierung der Logik über den Fabric-Client-Tick
        net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents.END_CLIENT_TICK.register(client -> {
            // Taste X abfragen (GLFW_KEY_X = 88)
            if (net.minecraft.client.util.InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), 88)) {
                handleItemMarking(client);
            }
            // Taste V abfragen (GLFW_KEY_V = 86)
            if (net.minecraft.client.util.InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), 86)) {
                handleShulkerExport(client);
            }
        });
    }

    private void handleItemMarking(MinecraftClient client) {
        if (client.currentScreen instanceof HandledScreen<?> screen) {
            Slot hoveredSlot = screen.focusedSlot;
            if (hoveredSlot != null && hoveredSlot.hasStack()) {
                ItemStack stack = hoveredSlot.getStack();
                if (markedItems.size() >= 27) {
                    if (client.player != null) {
                        client.player.sendMessage(Text.literal("§cShulker Box ist voll! (Max. 27 Items)"), true);
                    }
                    return;
                }
                markedItems.add(stack.copy());
                if (client.player != null) {
                    client.player.sendMessage(Text.literal("§aMarkiert: " + stack.getCount() + "x " + stack.getName().getString() + " (" + markedItems.size() + "/27)"), true);
                }
            }
        }
    }

    private void handleShulkerExport(MinecraftClient client) {
        if (markedItems.isEmpty()) {
            if (client.player != null) {
                client.player.sendMessage(Text.literal("§cKeine Items markiert!"), true);
            }
            return;
        }

        DefaultedList<ItemStack> containerInv = DefaultedList.ofSize(27, ItemStack.EMPTY);
        for (int i = 0; i < markedItems.size(); i++) {
            containerInv.set(i, markedItems.get(i));
        }

        // Generiert den Give-Befehl über die standardisierte NBT-Block-Komponente von Minecraft 1.21
        StringBuilder nbtBuilder = new StringBuilder();
        nbtBuilder.append("/give @p purple_shulker_box{BlockEntityTag:{Items:[");
        for (int i = 0; i < containerInv.size(); i++) {
            ItemStack stack = containerInv.get(i);
            if (!stack.isEmpty()) {
                String id = net.minecraft.registry.Registries.ITEM.getId(stack.getItem()).toString();
                nbtBuilder.append("{Slot:").append(i).append("b,id:\"").append(id).append("\",Count:").append(stack.getCount()).append("b},");
            }
        }
        if (nbtBuilder.charAt(nbtBuilder.length() - 1) == ',') {
            nbtBuilder.deleteCharAt(nbtBuilder.length() - 1);
        }
        nbtBuilder.append("]}} 1");

        client.keyboard.setClipboard(nbtBuilder.toString());

        if (client.player != null) {
            client.player.sendMessage(Text.literal("§b§lBefehl für Shulker Box in die Zwischenablage kopiert!"), false);
        }
        markedItems.clear();
    }
}
