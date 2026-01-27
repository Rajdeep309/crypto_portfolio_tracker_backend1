package com.crypto.PortfolioTracker.Repository;

import com.crypto.PortfolioTracker.DTO.TradeDTO;
import com.crypto.PortfolioTracker.ENUMs.Side;
import com.crypto.PortfolioTracker.Model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long> {

    @Query("SELECT t.assetSymbol, MAX(t.executedAt) FROM Trade t WHERE t.user.id = :userId GROUP BY t.assetSymbol")
    List<Object[]> findAllMaxExecutedAtByUserId(@Param("userId") Long userId);

    List<Trade> findByUser_IdOrderByExecutedAtAsc(Long userId);

    @Query("SELECT new com.crypto.PortfolioTracker.DTO.TradeDTO(t.assetSymbol, t.quantity, t.side, t.price, t.executedAt) " +
            "FROM Trade t WHERE t.user.id = :userId")
    List<TradeDTO> findCurrentTradesByUserId(@Param("userId") Long userId);
}
