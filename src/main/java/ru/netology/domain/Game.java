package ru.netology.domain;

import java.util.ArrayList;
import java.util.Collection;

public class Game {
    private Collection<Player> gamers = new ArrayList<>();

    public void register(Player player) {
        if (findById(player.getId()) != null) {
            throw new AlreadyExistsException("Player with id:" + player.getId() + " already exist");
        }
        gamers.add(player);
    }

    public Player findById(int id) {
        for (Player gamer : gamers) {
            if (gamer.getId() == id) {
                return gamer;
            }
        }
        return null;
    }

    public Player findByName(String name) {
        for (Player gamer : gamers) {
            if (gamer.getName().equals(name)) return gamer;
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        if (findByName(playerName1) == null) {
            throw new NotRegisteredException("Player with name " + playerName1 + "no registered");
        }
        if (findByName(playerName2) == null) {
            throw new NotRegisteredException("Player with name " + playerName2 + "no registered");
        }
        if (findByName(playerName1).getStrength() - findByName(playerName2).getStrength() > 0) return 1;
        if (findByName(playerName1).getStrength() - findByName(playerName2).getStrength() < 0) return 2;
        else return 0;

    }
}
