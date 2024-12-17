package com.app.playerservicejava;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PlayerServiceJavaApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void playerServiceIsNotNull() {
        assertThat(playerService).isNotNull();
    }

    @Test
    void testCreatePlayer() {
        Player player = new Player("John", "Doe");
        Player savedPlayer = playerService.createPlayer(player);
        assertThat(savedPlayer).isNotNull();
        assertThat(savedPlayer.getId()).isNotNull();
        assertThat(savedPlayer.getFirstName()).isEqualTo("John");
        assertThat(savedPlayer.getLastName()).isEqualTo("Doe");
    }

    @Test
    void testFindPlayerById() {
        Player player = new Player("Jane", "Doe");
        Player savedPlayer = playerService.createPlayer(player);
        Player foundPlayer = playerService.findPlayerById(savedPlayer.getId());
        assertThat(foundPlayer).isNotNull();
        assertThat(foundPlayer.getId()).isEqualTo(savedPlayer.getId());
    }

    @Test
    void testDeletePlayer() {
        Player player = new Player("Alice", "Smith");
        Player savedPlayer = playerService.createPlayer(player);
        playerService.deletePlayer(savedPlayer.getId());
        Player foundPlayer = playerService.findPlayerById(savedPlayer.getId());
        assertThat(foundPlayer).isNull();
    }
}
