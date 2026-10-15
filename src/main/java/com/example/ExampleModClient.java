package com.example;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.component.type.ContainerComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.List;

public class ExampleModClient implements ClientModInitializer {
    private static KeyBinding markKey;
    private static KeyBinding exportKey;
    private static final List<ItemStack> markedItems = new ArrayList<>();

    @Override
    public void onInitializeClient() {
        // Tasten registrieren: X zum Markieren, V zum Exportieren
        markKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.shulkermarker.mark",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_X,
                "category.shulkermarker"
        ));

        exportKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.shulkermarker.export",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_V,
                "category.shulkermarker"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (markKey.wasPressed()) {
                handleItemMarking(client);
            }
            if (exportKey.wasPressed()) {
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

        ContainerComponent containerComponent = ContainerComponent.fromStacks(containerInv);
        String command = "/give @p purple_shulker_box[container=" + containerComponent.toString() + "]";
        client.keyboard.setClipboard(command);

        if (client.player != null) {
            client.player.sendMessage(Text.literal("§b§lBefehl für Shulker Box in die Zwischenablage kopiert!"), false);
        }
        markedItems.clear();
    }
}
