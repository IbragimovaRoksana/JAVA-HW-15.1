package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game turnir = new Game();
    Player frank = new Player(1, "Frank", 5);
    Player jessica = new Player(2, "Jessica", 3);
    Player arnold = new Player(3, "Arnold", 10);
    Player loran = new Player(4, "Loran", 2);
    Player jacob = new Player(5, "Jacob", 4);
    Player natasha = new Player(6, "Natasha", 8);
    Player everdin = new Player(7, "Everdin", 9);
    Player michael = new Player(8, "Michael", 7);
    Player sara = new Player(9, "Sara", 10);
    Player vasya = new Player(10, "Vasya", 5);

    @BeforeEach
    void setUp() {
        turnir.register(frank);
        turnir.register(jessica);
        turnir.register(arnold);
        turnir.register(loran);
        turnir.register(jacob);
        turnir.register(natasha);
        turnir.register(everdin);
        turnir.register(michael);
        turnir.register(sara);
    }

    @Test
    void shouldRegisterFindName() {
        Player actual = turnir.findByName("Everdin");
        assertEquals(everdin, actual);
    }

    @Test
    void shouldAlreadyRegister() {
        assertThrows(AlreadyExistsException.class, () -> turnir.register(sara));
    }

    @Test
    void shouldRoundWinFirstPlayer() {
        int actual = turnir.round("Natasha", "Jessica");
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void shouldRoundWinSecondPlayer() {
        int actual = turnir.round("Loran", "Michael");
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    void shouldRoundDraw() {
        int actual = turnir.round("Sara", "Arnold");
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotRegisterFirstPlayer() {
        assertThrows(NotRegisteredException.class, () -> turnir.round("Vasya", "Jacob"));
    }

    @Test
    void shouldNotRegisterSecondPlayer() {
        assertThrows(NotRegisteredException.class, () -> turnir.round("Frank", "Vasya"));
    }
}