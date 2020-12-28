package ProfolioMatch;

public class Transaction {
    private String transactionType;
    private String name;
    private String assetType;
    private String shares;

    public Transaction(String transactionType, String name, String assetType, String shares) {
        this.transactionType = transactionType;
        this.name = name;
        this.assetType = assetType;
        this.shares = shares;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public String getName() {
        return name;
    }

    public String getAssetType() {
        return assetType;
    }

    public String getShares() {
        return shares;
    }
}
