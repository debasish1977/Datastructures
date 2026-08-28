package OnlineAuction;

import java.math.BigDecimal;
import java.time.Instant;

public class Bid {
    private Long bidId;
    private Long auctionId;
    private Long bidderId;
    private BigDecimal amount;
    private BidStatus status;
    private Instant createdAt;


}
