package com.kikermint;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameShould {
    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void game_a_bowling() {
        rollMany(20, 0);
        assertThat(game.score()).isEqualTo(0);
    }

    private void rollMany(int roll, int pins) {
        for (int i = 0; i < roll; i++) {
            game.roll(pins);
        }
    }

    @Test
    public void test_all_ones() {
        rollMany(20, 1);
        assertThat(game.score()).isEqualTo(20);
    }

    @Test
    public void test_one_spare() {
        rollSpare();
        game.roll(3);
        rollMany(17, 0);

        assertThat(game.score()).isEqualTo(16);
    }

    @Test
    public void test_one_strike() {
        rollStrike(10);
        game.roll(3);
        game.roll(4);
        rollMany(16, 0);

        assertThat(game.score()).isEqualTo(24);
    }

    @Test
    public void a_perfect_game() {
        rollMany(12, 10);
        assertThat(game.score()).isEqualTo(300);
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }

    private void rollStrike(int i) {
        game.roll(i);
    }
}