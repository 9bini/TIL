package com.fastcampus.inventorytdd;

public class InventoryHelper {
    public int getUsableCapacity(Inventory inventory) {
        return inventory.getCapacity() - inventory.getCurrent();
    }

    public boolean inbound(Inventory inventory, int count) {
        if (!getInboundCheck(inventory, count))return false;
        inventory.setCurrent(inventory.getCurrent() + count);
        return true;


    }

    public boolean getInboundCheck(Inventory inventory, int count) {
        return getUsableCapacity(inventory) >= count;
    }

    public Inventory createInventory() {
        return new Inventory();
    }
}
