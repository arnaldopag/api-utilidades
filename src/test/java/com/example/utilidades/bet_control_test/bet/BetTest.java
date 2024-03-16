package com.example.utilidades.bet_control_test.bet;

import com.example.utilidades.bet_control.bet.Bet;
import com.example.utilidades.bet_control.bet.BetRequestDTO;
import com.example.utilidades.bet_control.enums.BetStatus;
import com.example.utilidades.bet_control.enums.BetClassification;
import com.example.utilidades.bet_control.player.Player;
import com.example.utilidades.bet_control.team.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class BetTest {
    private Bet bet;

    @Mock
    private BetRequestDTO betRequestDTO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        bet = new Bet();
    }

    @Test
    public void testBetInitializationWithDTO() {
        // Mock data for BetRequestDTO
        long odd = 2L;
        BigDecimal betAmount = BigDecimal.valueOf(100);
        BetStatus status = BetStatus.PENDING;
        String betTeam = "Team A";
        LocalDateTime betDeadLine = LocalDateTime.now().plusDays(1);
        BetClassification betClassification = BetClassification.WINNER;
        Team team = new Team(); // Assuming you have a Team class defined
        Player player = new Player(); // Assuming you have a Player class defined

        // Mock behavior for BetRequestDTO
        when(betRequestDTO.odd()).thenReturn(odd);
        when(betRequestDTO.betAmount()).thenReturn(betAmount);
        when(betRequestDTO.status()).thenReturn(status);
        when(betRequestDTO.betTeam()).thenReturn(betTeam);
        when(betRequestDTO.betDeadLine()).thenReturn(betDeadLine);
        when(betRequestDTO.betClassification()).thenReturn(betClassification);
        when(betRequestDTO.team()).thenReturn(team);
        when(betRequestDTO.player()).thenReturn(player);

        // Initialize Bet object with mocked BetRequestDTO
        bet = new Bet(betRequestDTO);

        // Assertions
        assertEquals(odd, bet.getOdd());
        assertEquals(betAmount, bet.getBetAmount());
        assertEquals(status, bet.getStatus());
        assertEquals(betTeam, bet.getBetTeam());
        assertEquals(betDeadLine, bet.getBetDeadLine());
        assertEquals(betClassification, bet.getBetType());
        assertEquals(team, bet.getTeams());
        assertEquals(player, bet.getPlayer());
    }
}
