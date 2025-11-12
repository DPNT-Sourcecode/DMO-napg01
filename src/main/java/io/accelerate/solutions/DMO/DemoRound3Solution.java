package io.accelerate.solutions.DMO;

import io.accelerate.runner.SolutionNotImplementedException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class DemoRound3Solution {
  private final ConcurrentMap<String, InventoryItem> itemsBySku = new ConcurrentHashMap<>();
  private final ConcurrentMap<InventoryItem, Integer> stock = new ConcurrentHashMap<>();

  public int inventoryAdd(InventoryItem item, int quantity) {
    itemsBySku.put(item.sku(), item);
    return stock.merge(item, quantity, Integer::sum);
  }

  public int inventorySize() {
    return stock.size();
  }

  public InventoryItem inventoryGet(String sku) {
    return itemsBySku.get(sku);
  }
}
