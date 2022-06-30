package ru.netology.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Game {
    private HashMap<String, Integer> gamers = new HashMap<>();

    public void register(Player player) {
        if (gamers.containsKey(player.getName())) {
            throw new AlreadyExistsException("Player with id:" + player.getId() + " already exist");
        }
        gamers.put(player.getName(), player.getStrength());
    }

    public int round(String playerName1, String playerName2) {
        if (!gamers.containsKey(playerName1)) {
            throw new NotRegisteredException("Player with name " + playerName1 + "no registered");
        }
        if (!gamers.containsKey(playerName2)) {
            throw new NotRegisteredException("Player with name " + playerName2 + "no registered");
        }
        Integer player1 = gamers.get(playerName1);
        Integer player2 = gamers.get(playerName2);
        if (player1 - player2 > 0) return 1;
        if (player1 - player2 < 0) return 2;
        else return 0;

    }
}
