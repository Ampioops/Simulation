package Simulation;

import java.util.HashMap;

class Emojis {
    public static  HashMap<String,String> mapEmojis = new HashMap<>();

    static {
        String emojiGrass = new String(Character.toChars(0x1F33F));
        String emojiRock = new String(Character.toChars(0x1FAA8));
        String emojiTree = new String(Character.toChars(0x1F333));
        String emojiHerbivore = new String(Character.toChars(0x1F407));
        String emojiPredator = new String(Character.toChars(0x1F43A));
        String emojiEmptyWay = new String(Character.toChars(0x2606));

        mapEmojis.put("Grass",emojiGrass);
        mapEmojis.put("Rock",emojiRock);
        mapEmojis.put("Tree",emojiTree);
        mapEmojis.put("Herbivore",emojiHerbivore);
        mapEmojis.put("Predator",emojiPredator);
        mapEmojis.put("EmptyWay",emojiEmptyWay);
    }
}
