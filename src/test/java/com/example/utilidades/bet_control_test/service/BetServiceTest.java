package com.example.utilidades.bet_control_test.service;

import com.example.utilidades.bet_control.bet.Bet;
import com.example.utilidades.bet_control.bet.BetRepository;
import com.example.utilidades.bet_control.enums.BetStatus;
import com.example.utilidades.bet_control.bet.BetService;
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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BetServiceTest {

    private MockMvc mockMvc;

    @Mock
    private BetRepository betRepository;

    @InjectMocks
    private BetService betService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(betService).build();
    }

    @Test
    public void testChangeStatusBetNotFound() {

        // Configura o repositório para retornar um Optional.empty() quando o ID não for encontrado
        when(betRepository.findById(any(Long.class))).thenReturn(Optional.empty());

        // Cria um objeto Bet com um ID que não existe no repositório
        Bet updatedBet = new Bet();
        updatedBet.setId(1L);
        updatedBet.setStatus(BetStatus.WiN);

        // Chama o método changeStatus
        ResponseEntity<Bet> response = betService.changeStatus(updatedBet);

        // Verifica a resposta
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testChangeStatusSuccess() {
        // Cria um objeto Bet existente
        Bet existingBet = new Bet();
        existingBet.setId(1L);
        existingBet.setStatus(BetStatus.PENDING);

        // Configura o repositório para retornar o Bet existente
        when(betRepository.findById(any(Long.class))).thenReturn(Optional.of(existingBet));
        when(betRepository.save(any(Bet.class))).thenReturn(existingBet);

        // Cria um objeto Bet atualizado
        Bet updatedBet = new Bet();
        updatedBet.setId(1L);
        updatedBet.setStatus(BetStatus.WiN);

        // Chama o método changeStatus
        ResponseEntity<Bet> response = betService.changeStatus(updatedBet);

        // Verifica a resposta
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(BetStatus.WiN, response.getBody().getStatus());
    }

    @Test
    public void testChangeStatusException() {
        // Configura o repositório para lançar uma exceção
        when(betRepository.findById(any(Long.class))).thenThrow(new RuntimeException());

        // Cria um objeto Bet atualizado
        Bet updatedBet = new Bet();
        updatedBet.setId(1L);
        updatedBet.setStatus(BetStatus.WiN);

        // Chama o método changeStatus
        ResponseEntity<Bet> response = betService.changeStatus(updatedBet);

        // Verifica a resposta
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

}
