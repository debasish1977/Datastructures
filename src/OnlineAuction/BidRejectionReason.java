package OnlineAuction;

public enum BidRejectionReason {
    AUCTION_NOT_ACTIVE,
    AUCTION_ENDED,
    BID_TOO_LOW,
    SELLER_CANNOT_BID,
    DUPLICATE_REQUEST
}
