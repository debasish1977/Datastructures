package OnlineAuction;

import java.time.Instant;
import java.util.List;

public class Item {
    private Long itemId;
    private Long sellerId;
    private String title;
    private String descripotion;
    private List<String> imageUrls;
    private ItemCondition condition;
    private Instant createdAt;
}
