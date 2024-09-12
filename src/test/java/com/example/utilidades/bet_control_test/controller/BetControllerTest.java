package com.example.utilidades.bet_control_test.controller;


import com.example.utilidades.bet_control.bet.Bet;
import com.example.utilidades.bet_control.bet.BetRepository;
import com.example.utilidades.bet_control.bet.BetRequestDTO;
import com.example.utilidades.bet_control.bet.BetResponseDTO;
import com.example.utilidades.bet_control.betting_house.BettingHouse;
import com.example.utilidades.bet_control.bet.BetController;
import com.example.utilidades.bet_control.enums.BetClassification;
import com.example.utilidades.bet_control.enums.BetElement;
import com.example.utilidades.bet_control.enums.BetStatus;
import com.example.utilidades.bet_control.enums.Sports;
import com.example.utilidades.bet_control.league.League;
import com.example.utilidades.bet_control.player.Player;
import com.example.utilidades.bet_control.team.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class BetControllerTest {

    private MockMvc mockMvc;

    @Mock
    private BetRepository betRepository;

    @InjectMocks
    private BetController betController;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(betController).build();
    }

    @Test
    public void testGetAll_ReturnsEmptyList() {

        //Arrange
        when(betRepository.findAll()).thenReturn(Collections.emptyList());

        //Act
        ResponseEntity<List<BetResponseDTO>> response = betController.getAll();

        //Assert
        assertEquals(200, response.getStatusCode().value());
        assertEquals(Collections.emptyList(), response.getBody());
    }


    @Test
    public void testGetAll_ReturnsBetList() {

        //Arrenge
        Bet bet = new Bet();
        List<Bet> betList = List.of(bet);
        when(betRepository.findAll()).thenReturn(betList);
        BetResponseDTO betResponseDTO = new BetResponseDTO(bet);
        List<BetResponseDTO> expectedResponse = List.of(betResponseDTO);

        //Act
        ResponseEntity<List<BetResponseDTO>> response = betController.getAll();

        //Assert
        assertEquals(200, response.getStatusCode().value());
        assertEquals(expectedResponse, response.getBody());
    }


    @Test
    public void testSaveBet() {
        // Create a BetRequestDTO object with test data
        BetRequestDTO betRequestDTO = new BetRequestDTO(
                BigDecimal.valueOf(2),
                BigDecimal.valueOf(100),
                BetStatus.PENDING,
                LocalDateTime.now().plusDays(1),
                BetClassification.WINNER,
                BetElement.MAP,
                new League(),
                new Team(),
                new Player(),
                Sports.CS,
                new BettingHouse()
        );

        // Create a Bet object to be returned by the mocked repository
        Bet bet = new Bet(betRequestDTO);

        when(betRepository.save(any(Bet.class))).thenReturn(bet);

        // Call the saveBet method
        ResponseEntity<Bet> response = betController.saveBet(betRequestDTO);

        // Verify the response
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(bet, response.getBody());
    }
}