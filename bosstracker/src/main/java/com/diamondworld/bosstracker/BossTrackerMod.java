package com.diamondworld.bosstracker;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BossTrackerMod implements ClientModInitializer {
    private static final Map<String, Long> LAST_TELEPORT = new HashMap<>();
    private static final long COOLDOWN_MS = 2000;
    private static final Pattern BOSS_PATTERN = Pattern.compile("Áîññ\\s+([À-ßà-ÿ\\s]+?)\\s+ïîÿâèëñÿ\\.?");
    
    @Override
    public void onInitializeClient() {
        CommandHandler.register();
        
        ClientReceiveMessageEvents.ALLOW_GAME.register((message, overlay) -> {
            String text = message.getString();
            checkBossSpawn(text);
            return true;
        });
    }
    
    private void checkBossSpawn(String message) {
        String cleanMessage = message.replaceAll("§[0-9a-fklmnor]", "");
        Matcher matcher = BOSS_PATTERN.matcher(cleanMessage);
        
        if (matcher.find()) {
            String bossName = matcher.group(1).trim();
            Integer level = BossData.getLevel(bossName);
            
            if (level == null || level > CommandHandler.getMaxLevel()) return;
            
            long now = System.currentTimeMillis();
            if (LAST_TELEPORT.containsKey(bossName) && 
                now - LAST_TELEPORT.get(bossName) < COOLDOWN_MS) return;
            
            LAST_TELEPORT.put(bossName, now);
            
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    if (MinecraftClient.getInstance().player != null) {
                        MinecraftClient.getInstance().player.sendCommand("boss " + level);
                        sendMessage("§a[Áîññ] §fÒåëåïîðò ê §e" + bossName + " §f(§e" + level + "§f)");
                    }
                }
            }, 300);
        }
    }
    
    private void sendMessage(String text) {
        if (MinecraftClient.getInstance().player != null) {
            MinecraftClient.getInstance().player.sendMessage(Text.literal(text), false);
        }
    }
}