package com.diamondworld.bosstracker;

import java.util.HashMap;
import java.util.Map;

public class BossData {
    private static final Map<String, Integer> BOSS_LEVELS = new HashMap<>();
    
    static {
        BOSS_LEVELS.put("Кригер", 15);
        BOSS_LEVELS.put("Слизень", 20);
        BOSS_LEVELS.put("Кысиный король", 25);
        BOSS_LEVELS.put("Кошмар", 30);
        BOSS_LEVELS.put("Вендиго", 35);
        BOSS_LEVELS.put("Ульдрик", 40);
        BOSS_LEVELS.put("Пахучиха", 45);
        BOSS_LEVELS.put("Мерлок", 50);
        BOSS_LEVELS.put("Элементалист", 55);
        BOSS_LEVELS.put("Жнец", 60);
        BOSS_LEVELS.put("Наездник", 65);
        BOSS_LEVELS.put("Разбойник", 70);
        BOSS_LEVELS.put("Шаман", 75);
        BOSS_LEVELS.put("Варден", 80);
        BOSS_LEVELS.put("Королевская жаба", 90);
        BOSS_LEVELS.put("Гигант", 100);
        BOSS_LEVELS.put("Бессмертный легион", 105);
        BOSS_LEVELS.put("Безумный алхимик", 110);
        BOSS_LEVELS.put("Некромант", 115);
        BOSS_LEVELS.put("Пожиратель тьмы", 120);
        BOSS_LEVELS.put("Чудовище", 125);
        BOSS_LEVELS.put("Октопус", 130);
        BOSS_LEVELS.put("Кузнец", 140);
        BOSS_LEVELS.put("Повелитель грома", 150);
        BOSS_LEVELS.put("Грагулья", 160);
        BOSS_LEVELS.put("Всадник", 170);
        BOSS_LEVELS.put("Кобольд", 180);
        BOSS_LEVELS.put("Самураи", 190);
        BOSS_LEVELS.put("Повелитель мертвых", 200);
        BOSS_LEVELS.put("Рыцарь света", 210);
        BOSS_LEVELS.put("Гигантская черепаха", 220);
        BOSS_LEVELS.put("Змеиная жрица", 230);
        BOSS_LEVELS.put("Могущественный шалкер", 240);
        BOSS_LEVELS.put("Снежный монстр", 250);
        BOSS_LEVELS.put("Дух леса", 260);
        BOSS_LEVELS.put("Спектральный куб", 270);
        BOSS_LEVELS.put("Циклоп", 280);
        BOSS_LEVELS.put("Гидра", 300);
        BOSS_LEVELS.put("Магнус", 320);
        BOSS_LEVELS.put("Вестница ада", 330);
        BOSS_LEVELS.put("Цербер", 340);
        BOSS_LEVELS.put("Король ифритов", 345);
        BOSS_LEVELS.put("Бафомет", 350);
        BOSS_LEVELS.put("Лавовый монстр", 360);
        BOSS_LEVELS.put("Королева пиглинов", 370);
        BOSS_LEVELS.put("Дракаина", 380);
        BOSS_LEVELS.put("Верховный бес", 390);
        BOSS_LEVELS.put("Брутальный пиглин", 400);
        BOSS_LEVELS.put("Адский слизень", 410);
        BOSS_LEVELS.put("Зоглин", 420);
        BOSS_LEVELS.put("Демонический рыцарь", 430);
        BOSS_LEVELS.put("Синтия", 440);
        BOSS_LEVELS.put("Рыцарь энда", 450);
        BOSS_LEVELS.put("Маг пространства", 460);
        BOSS_LEVELS.put("Шалкеровый страж", 470);
        BOSS_LEVELS.put("Эндер голем", 480);
        BOSS_LEVELS.put("Королева теней", 490);
        BOSS_LEVELS.put("Хранитель", 500);
        BOSS_LEVELS.put("Воид", 510);
        BOSS_LEVELS.put("Странник измерений", 520);
    }
    
    public static Integer getLevel(String bossName) {
        Integer level = BOSS_LEVELS.get(bossName);
        if (level != null) return level;
        
        for (Map.Entry<String, Integer> entry : BOSS_LEVELS.entrySet()) {
            if (bossName.contains(entry.getKey()) || entry.getKey().contains(bossName)) {
                return entry.getValue();
            }
        }
        return null;
    }
}