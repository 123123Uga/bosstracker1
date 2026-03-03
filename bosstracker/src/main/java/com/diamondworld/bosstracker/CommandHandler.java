package com.diamondworld.bosstracker;

import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.text.Text;
import net.minecraft.client.MinecraftClient;
import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.*;

public class CommandHandler {
    private static int maxLevel = 520;
    
    public static void register() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
            dispatcher.register(literal("tplv")
                .then(argument("level", integer(0, 520))
                    .executes(context -> {
                        int level = integer("level").get(context);
                        maxLevel = level;
                        sendMessage("§a[БоссТрекер] §fЛимит: §e" + level);
                        return 1;
                    })
                )
                .executes(context -> {
                    sendMessage("§cИспользуй: /tplv <уровень>");
                    return 1;
                })
            );
            
            dispatcher.register(literal("bosssettings")
                .executes(context -> {
                    sendMessage("§a[БоссТрекер] §fМакс. уровень: §e" + maxLevel);
                    return 1;
                })
            );
            return 1;
        });
    }
    
    public static int getMaxLevel() {
        return maxLevel;
    }
    
    private static void sendMessage(String text) {
        if (MinecraftClient.getInstance().player != null) {
            MinecraftClient.getInstance().player.sendMessage(Text.literal(text), false);
        }
    }
}