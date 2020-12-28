package ProfolioMatch;

public class Asset implements Comparable<Asset>{
    private String name;
    private String assetType;
    private int shares;

    public Asset(String name, String assetType, int shares) {
        this.name = name;
        this.assetType = assetType;
        this.shares = shares;
    }

    public String getName() {
        return name;
    }

    public String getAssetType() {
        return assetType;
    }

    public int getShares() {
        return shares;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    @Override
    public int compareTo(Asset o) {
        return this.getName().compareTo(o.getName());
    }
}
