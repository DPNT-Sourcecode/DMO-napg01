package io.accelerate.solutions.DMO;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class InventoryTest {
  @Test
  public void storesItems() {
    var inventory = new DemoRound3Solution();
    var quantity = inventory.inventoryAdd(new InventoryItem("SKU", "name", 7), 3);
    assertThat(quantity, equalTo(3));
    assertThat(inventory.inventorySize(), equalTo(1));
  }

  @Test
  public void storesMultipleItems() {
    var inventory = new DemoRound3Solution();
    inventory.inventoryAdd(new InventoryItem("SKU", "name", 7), 3);
    var quantity = inventory.inventoryAdd(new InventoryItem("ABC", "thing", 8), 4);
    assertThat(quantity, equalTo(4));
    assertThat(inventory.inventorySize(), equalTo(2));
  }

    @Test
    public void remembersQuantity() {
        var inventory = new DemoRound3Solution();
        inventory.inventoryAdd(new InventoryItem("SKU", "name", 7), 3);
        var quantity = inventory.inventoryAdd(new InventoryItem("SKU", "name", 7), 4);
        assertThat(quantity, equalTo(7));
        assertThat(inventory.inventorySize(), equalTo(1));
    }

    @Test
    public void getsItemBySku() {
        var inventory = new DemoRound3Solution();
        InventoryItem storedItem = new InventoryItem("SKU", "name", 7);
        inventory.inventoryAdd(storedItem, 3);
        var retrievedItem = inventory.inventoryGet("SKU");
        assertThat(retrievedItem, equalTo(storedItem));
    }

    @Test
    public void returnsNullIfItemIsNotFoundBySku() {
        var inventory = new DemoRound3Solution();
        inventory.inventoryAdd(new InventoryItem("SKU", "name", 7), 3);
        var retrievedItem = inventory.inventoryGet("wibble");
        assertThat(retrievedItem, equalTo(null));
    }
}
