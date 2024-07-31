package com.example.utilidades.bet_control_test.bet;

import com.example.utilidades.bet_control.bet.Bet;
import com.example.utilidades.bet_control.bet.BetRequestDTO;
import com.example.utilidades.bet_control.betting_house.BettingHouse;
import com.example.utilidades.bet_control.enums.BetStatus;
import com.example.utilidades.bet_control.enums.BetClassification;
import com.example.utilidades.bet_control.enums.Sports;
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

    @Mock
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
        BigDecimal odd = BigDecimal.valueOf(2);
        BigDecimal betAmount = BigDecimal.valueOf(100);
        BetStatus status = BetStatus.PENDING;
        LocalDateTime betDeadLine = LocalDateTime.now().plusDays(1);
        BetClassification betClassification = BetClassification.WINNER;
        Team team = new Team();
        Player player = new Player();
        Sports sports = Sports.CS;
        BettingHouse bettingHouse = new BettingHouse();
        // Mock behavior for BetRequestDTO
        when(betRequestDTO.odd()).thenReturn(odd);
        when(betRequestDTO.betAmount()).thenReturn(betAmount);
        when(betRequestDTO.status()).thenReturn(status);
        when(betRequestDTO.team()).thenReturn(team);
        when(betRequestDTO.betDeadLine()).thenReturn(betDeadLine);
        when(betRequestDTO.betClassification()).thenReturn(betClassification);
        when(betRequestDTO.team()).thenReturn(team);
        when(betRequestDTO.player()).thenReturn(player);
        when(betRequestDTO.sports()).thenReturn(sports);
        when(betRequestDTO.bettingHouse()).thenReturn(bettingHouse);

        // Initialize Bet object with mocked BetRequestDTO
        bet = new Bet(betRequestDTO);

        // Assertions
        assertEquals(odd, bet.getOdd());
        assertEquals(betAmount, bet.getBetAmount());
        assertEquals(status, bet.getStatus());
        assertEquals(team, bet.getTeam());
        assertEquals(betDeadLine, bet.getBetDeadLine());
        assertEquals(betClassification, bet.getBetClassification());
        assertEquals(team, bet.getTeam());
        assertEquals(player, bet.getPlayer());
        assertEquals(sports,bet.getSports());
        assertEquals(bettingHouse,bet.getBettingHouse());
    }
}
