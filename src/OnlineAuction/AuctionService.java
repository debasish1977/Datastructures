package OnlineAuction;

import java.math.BigDecimal;
import java.time.Instant;

public interface AuctionService {
    Auction createAuction(
            Long sellerId,
            Long itemId,
            BigDecimal startingPrice,
            Instant startTime,
            Instant endTime);

    Auction getAuction(Long auctionId);
    void closeAuction(Long auctionId);
}
