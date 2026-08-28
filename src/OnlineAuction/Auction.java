package OnlineAuction;

import java.math.BigDecimal;
import java.time.Instant;

public class Auction {
    private Long auctionId;
    private Long itemId;
    private Long sellerId;
    private BigDecimal startingPrice;
    private BigDecimal currentPrice;
    private Long highestBid;
    private Long highestBidderId;
    private Instant startTime;
    private Instant endTime;
    private Long version;
    private Instant createdAt;
    private Instant updatedAt;
}
