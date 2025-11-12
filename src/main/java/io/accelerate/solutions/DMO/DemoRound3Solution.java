package io.accelerate.solutions.DMO;

import io.accelerate.runner.SolutionNotImplementedException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class DemoRound3Solution {
  private final ConcurrentMap<InventoryItem, Integer> stock = new ConcurrentHashMap<>();

  public int inventoryAdd(InventoryItem item, int quantity) {
    stock.put(item, quantity);
    return quantity;
  }

  public int inventorySize() {
    return stock.size();
  }

  public InventoryItem inventoryGet(String sku) {
    throw new SolutionNotImplementedException();
  }
}


