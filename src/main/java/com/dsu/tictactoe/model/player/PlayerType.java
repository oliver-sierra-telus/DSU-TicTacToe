package com.dsu.tictactoe.model.player;

public enum PlayerType {
    HUMAN,
    COMPUTER;

    private static String[] arrayNames;

    public static PlayerType getPlayerType(int index) {
        if (!(index>=0 && index<PlayerType.values().length)){
            return null;
        }
        return PlayerType.values()[index];
    }

    public static String[] getStringArrayPlayerTypes(){
        if (arrayNames == null){
            
            arrayNames = new String[PlayerType.values().length];
            PlayerType [] types = PlayerType.values();
            for (int i = 0; i < types.length; i++) {
                arrayNames[i] = types[i].name();
            }
        }
        return arrayNames;
    }
}
