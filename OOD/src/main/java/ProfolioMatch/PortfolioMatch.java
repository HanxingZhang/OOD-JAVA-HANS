package ProfolioMatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PortfolioMatch {
    static List<Asset> pStock = new ArrayList<>(); // stock in the portfolio
    static List<Asset> pBond = new ArrayList<>(); // bond in the portfolio
    static List<Asset> bStock = new ArrayList<>(); // stock in the benchmark
    static List<Asset> bBond = new ArrayList<>(); // bond in the benchmark
    static List<String> sellList = new ArrayList<>();
    static List<String> buyList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while((line = in.readLine()) != null) {
            PortfolioMatch.match(line);
            if (sellList.size() > 0) {
                for (int j = 0; j < sellList.size(); j++)
                    System.out.println(sellList.get(j));
            }
            if (buyList.size() > 0) {
                for (int j = 0; j < buyList.size(); j++)
                    System.out.println(buyList.get(j));
            }
            updateList();
        }
    }

    public static void match(String input) {
        String[] inputs = input.split(":");
        String[] portfolio = inputs[0].split("\\|");
        String[] benchmark = inputs[1].split("\\|");

        classify(portfolio, pBond, pStock);
        classify(benchmark, bBond, bStock);
        Collections.sort(pBond);
        Collections.sort(pStock);
        Collections.sort(bBond);
        Collections.sort(bStock);
        comparePortBench(pBond, bBond);
        comparePortBench(pStock, bStock);
    }

    public static void updateList() {
        pStock = new ArrayList<>();
        pBond = new ArrayList<>();
        bStock = new ArrayList<>();
        bBond = new ArrayList<>();
        sellList = new ArrayList<>();
        buyList = new ArrayList<>();
    }

    public static void classify(String[] source, List<Asset> bond, List<Asset> stock) {
        for (String s : source) {
            String[] assetStr = s.split(",");
            String name = assetStr[0].trim();
            String assetType = assetStr[1].trim();
            int share = Integer.parseInt(assetStr[2].trim());
            Asset asset = new Asset(name, assetType, share);
            if (assetType.toLowerCase().contains("bond")) {
                bond.add(asset);
            } else if (assetType.toLowerCase().contains("stock")) {
                stock.add(asset);
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void comparePortBench(List<Asset> p, List<Asset> b) {
        int pIndex = 0;
        int bIndex = 0;
        // compare assets in portfolio and benchmark
        while (pIndex < p.size() || bIndex < b.size()) {
            if (pIndex >= p.size()) { // remaining assets in benchmark not in portfolio
                for (int i = bIndex; i < b.size(); i++) {
                    Asset asset = b.get(i);
                    buyList.add("BUY," + asset.getName() + "," + asset.getAssetType() + ","
                            + asset.getShares());
                }
                break;
            }
            if (bIndex >= b.size()) { // remaining assets in portfolio not in benchmark
                for (int i = pIndex; i < p.size(); i++) {
                    Asset asset = p.get(i);
                    sellList.add("SELL," + asset.getName() + "," + asset.getAssetType() + ","
                            + asset.getShares());
                }
                break;
            }
            Asset portAsset = p.get(pIndex);
            Asset benchAsset = b.get(bIndex);
            // compare the number of share of assets in both portfolio and benchmark
            if (portAsset.getName().compareTo(benchAsset.getName()) == 0) {
                if (portAsset.getShares() < benchAsset.getShares()) { // less than expected
                    buyList.add("BUY," + portAsset.getName() + "," + portAsset.getAssetType() + ","
                            + (benchAsset.getShares() - portAsset.getShares()));
                } else if (portAsset.getShares() > benchAsset.getShares()) { // more than expected
                    sellList.add("SELL," + portAsset.getName() + "," + portAsset.getAssetType() + ","
                            + (portAsset.getShares() - benchAsset.getShares()));
                }
                pIndex++;
                bIndex++;
            }
            // this asset is in portfolio, but not in benchmark
            else if (portAsset.getName().compareTo(benchAsset.getName()) < 0) {
                sellList.add("SELL," + portAsset.getName() + "," + portAsset.getAssetType() + ","
                        + portAsset.getShares());
                pIndex++;
            }
            // the asset in benchmark is not in portfolio
            else if (portAsset.getName().compareTo(benchAsset.getName()) > 0) {
                buyList.add("BUY," + benchAsset.getName() + "," + benchAsset.getAssetType() + ","
                        + benchAsset.getShares());
                bIndex++;
            }
        }
    }


}
