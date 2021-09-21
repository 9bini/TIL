package com.fastcampus.inventorytdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InventoryHelperTests {

    @Test
    void capacity_good(){
        InventoryHelper inventoryHelper = new InventoryHelper();
        Inventory inventory = new Inventory();
        inventory.setCapacity(10);
        inventory.setCurrent(5);

        int usableCapacity = inventoryHelper.getUsableCapacity(inventory);
        Assertions.assertEquals(5, usableCapacity);

    }

    @Test
    void inbound_true(){
        InventoryHelper inventoryHelper = new InventoryHelper();
        Inventory inventory = new Inventory();
        inventory.setCapacity(40);

        Assertions.assertTrue(inventoryHelper.inbound(inventory, 10));
        Assertions.assertEquals(10, inventory.getCurrent());
    }
    @Test
    void inbound_false(){
        InventoryHelper inventoryHelper = new InventoryHelper();
        Inventory inventory = new Inventory();
        inventory.setCapacity(5);

        Assertions.assertFalse(inventoryHelper.inbound(inventory, 10));
        Assertions.assertEquals(0, inventory.getCurrent());
    }
    @Test
    void inboundCheck_true(){
        InventoryHelper inventoryHelper = new InventoryHelper();
        Inventory inventory = new Inventory();
        inventory.setCapacity(10);
        inventory.setCurrent(5);
        Assertions.assertTrue(inventoryHelper.getInboundCheck(inventory,3));
    }
    @Test
    void inboundCheck_false(){
        InventoryHelper inventoryHelper = new InventoryHelper();
        Inventory inventory = new Inventory();
        inventory.setCapacity(10);
        inventory.setCurrent(5);
        Assertions.assertFalse(inventoryHelper.getInboundCheck(inventory,10));
    }

    @Test
    void newInventory(){
        InventoryHelper inventoryHelper = new InventoryHelper();
        Inventory inventory = inventoryHelper.createInventory();

        Assertions.assertTrue(inventory instanceof Inventory);
    }

}
