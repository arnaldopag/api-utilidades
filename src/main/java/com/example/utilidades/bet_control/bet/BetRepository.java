package com.example.utilidades.bet_control.bet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BetRepository extends JpaRepository<Bet,Long>, QuerydslPredicateExecutor<Bet> {

}
