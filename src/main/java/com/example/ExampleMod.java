
Skip to content

    erpalp
    fabric-example-mod

Repository navigation

    Code
    Pull requests
    Agents
    Actions
    Projects
    Security and quality
    Insights
    Settings

Java CI with Gradle
Java CI with Gradle #4

    All jobs
    Run details

build
failed now in 1m 10s
2s
1s
0s
1s
3s
59s
    location: class ExampleMod
Error:   /home/runner/work/fabric-example-mod/fabric-example-mod/src/main/java/com/example/ExampleMod.java:53: error: cannot find symbol
          if (client.currentScreen instanceof HandledScreen<?> screen) {
                                              ^
    symbol:   class HandledScreen
    location: class ExampleMod
Error:   /home/runner/work/fabric-example-mod/fabric-example-mod/src/main/java/com/example/ExampleMod.java:54: error: cannot find symbol
              Slot hoveredSlot = screen.focusedSlot;
              ^
    symbol:   class Slot
    location: class ExampleMod
Error:   /home/runner/work/fabric-example-mod/fabric-example-mod/src/main/java/com/example/ExampleMod.java:56: error: cannot find symbol
                  ItemStack stack = hoveredSlot.getStack();
                  ^
    symbol:   class ItemStack
    location: class ExampleMod
Error:   /home/runner/work/fabric-example-mod/fabric-example-mod/src/main/java/com/example/ExampleMod.java:59: error: cannot find symbol
                          client.player.sendMessage(Text.literal("§cShulker Box ist voll! (Max. 27 Items)"), true);
                                                    ^
    symbol:   variable Text
    location: class ExampleMod
Error:   /home/runner/work/fabric-example-mod/fabric-example-mod/src/main/java/com/example/ExampleMod.java:65: error: cannot find symbol
                      client.player.sendMessage(Text.literal("§aMarkiert: " + stack.getCount() + "x " + stack.getName().getString() + " (" + markedItems.size() + "/27)"), true);
                                                ^
    symbol:   variable Text
    location: class ExampleMod
Error:   /home/runner/work/fabric-example-mod/fabric-example-mod/src/main/java/com/example/ExampleMod.java:74: error: cannot find symbol
                  client.player.sendMessage(Text.literal("§cKeine Items markiert!"), true);
                                            ^
    symbol:   variable Text
    location: class ExampleMod
Error:   /home/runner/work/fabric-example-mod/fabric-example-mod/src/main/java/com/example/ExampleMod.java:79: error: cannot find symbol
          DefaultedList<ItemStack> containerInv = DefaultedList.ofSize(27, ItemStack.EMPTY);
          ^
    symbol:   class DefaultedList
    location: class ExampleMod
Error:   /home/runner/work/fabric-example-mod/fabric-example-mod/src/main/java/com/example/ExampleMod.java:79: error: cannot find symbol
          DefaultedList<ItemStack> containerInv = DefaultedList.ofSize(27, ItemStack.EMPTY);
                        ^
    symbol:   class ItemStack
    location: class ExampleMod
Error:   /home/runner/work/fabric-example-mod/fabric-example-mod/src/main/java/com/example/ExampleMod.java:79: error: cannot find symbol
          DefaultedList<ItemStack> containerInv = DefaultedList.ofSize(27, ItemStack.EMPTY);
                                                                           ^
    symbol:   variable ItemStack
    location: class ExampleMod
Error:   /home/runner/work/fabric-example-mod/fabric-example-mod/src/main/java/com/example/ExampleMod.java:79: error: cannot find symbol
          DefaultedList<ItemStack> containerInv = DefaultedList.ofSize(27, ItemStack.EMPTY);
                                                  ^
    symbol:   variable DefaultedList
    location: class ExampleMod
Error:   /home/runner/work/fabric-example-mod/fabric-example-mod/src/main/java/com/example/ExampleMod.java:84: error: cannot find symbol
          ContainerComponent containerComponent = ContainerComponent.fromStacks(containerInv);
          ^
    symbol:   class ContainerComponent
    location: class ExampleMod
Error:   /home/runner/work/fabric-example-mod/fabric-example-mod/src/main/java/com/example/ExampleMod.java:84: error: cannot find symbol
          ContainerComponent containerComponent = ContainerComponent.fromStacks(containerInv);
                                                  ^
    symbol:   variable ContainerComponent
    location: class ExampleMod
Error:   /home/runner/work/fabric-example-mod/fabric-example-mod/src/main/java/com/example/ExampleMod.java:89: error: cannot find symbol
              client.player.sendMessage(Text.literal("§b§lBefehl für Shulker Box in die Zwischenablage kopiert!"), false);
                                        ^
    symbol:   variable Text
    location: class ExampleMod
Error:   /home/runner/work/fabric-example-mod/fabric-example-mod/src/main/java/com/example/ExampleMod.java:4: error: package net.fabricmc.fabric.api.client.event.lifecycle.v1 does not exist
  import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
                                                          ^
Error:   /home/runner/work/fabric-example-mod/fabric-example-mod/src/main/java/com/example/ExampleMod.java:5: error: package net.fabricmc.fabric.api.client.keybinding.v1 does not exist
  import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
                                                     ^
Error:   /home/runner/work/fabric-example-mod/fabric-example-mod/src/main/java/com/example/ExampleMod.java:6: error: package net.minecraft.client does not exist
  import net.minecraft.client.MinecraftClient;
                             ^
Error:   /home/runner/work/fabric-example-mod/fabric-example-mod/src/main/java/com/example/ExampleMod.java:7: error: package net.minecraft.client.gui.screen.ingame does not exist
  import net.minecraft.client.gui.screen.ingame.HandledScreen;
                                               ^
Error:   /home/runner/work/fabric-example-mod/fabric-example-mod/src/main/java/com/example/ExampleMod.java:8: error: package net.minecraft.client.option does not exist
  import net.minecraft.client.option.KeyBinding;
                                    ^
Error:   /home/runner/work/fabric-example-mod/fabric-example-mod/src/main/java/com/example/ExampleMod.java:9: error: package net.minecraft.client.util does not exist
  import net.minecraft.client.util.InputUtil;
                                  ^
Error:   /home/runner/work/fabric-example-mod/fabric-example-mod/src/main/java/com/example/ExampleMod.java:10: error: package net.minecraft.component.type does not exist
  import net.minecraft.component.type.ContainerComponent;
                                     ^
Error:   /home/runner/work/fabric-example-mod/fabric-example-mod/src/main/java/com/example/ExampleMod.java:11: error: package net.minecraft.item does not exist
  import net.minecraft.item.ItemStack;
                           ^
Error:   /home/runner/work/fabric-example-mod/fabric-example-mod/src/main/java/com/example/ExampleMod.java:12: error: package net.minecraft.screen.slot does not exist
  import net.minecraft.screen.slot.Slot;
                                  ^
Error:   /home/runner/work/fabric-example-mod/fabric-example-mod/src/main/java/com/example/ExampleMod.java:13: error: package net.minecraft.text does not exist
  import net.minecraft.text.Text;
                           ^
Error:   /home/runner/work/fabric-example-mod/fabric-example-mod/src/main/java/com/example/ExampleMod.java:14: error: package net.minecraft.util.collection does not exist
  import net.minecraft.util.collection.DefaultedList;
                                      ^
Error:   /home/runner/work/fabric-example-mod/fabric-example-mod/src/main/java/com/example/ExampleMod.java:30: error: package InputUtil does not exist
0s
1s
0s
0s
0s
