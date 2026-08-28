package OnlineAuction;

import java.math.BigDecimal;

public class BidResult {
    private Long bidId;
    private Long auctionId;
    private boolean accepted;
    private BigDecimal currentPrice;
    private Long highestBidderId;
    private BidRejectionReason rejectionReason;

}
