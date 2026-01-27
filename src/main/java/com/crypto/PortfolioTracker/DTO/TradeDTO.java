package com.crypto.PortfolioTracker.DTO;

import com.crypto.PortfolioTracker.ENUMs.Side;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TradeDTO(String assetSymbol,
                       BigDecimal quantity,
                       Side side,
                       BigDecimal price,
                       LocalDateTime executedAt) {
}
