package com.fastcampus.pickingtdd.service;

import com.fastcampus.pickingtdd.entity.Order;
import com.fastcampus.pickingtdd.entity.Picker;
import com.fastcampus.pickingtdd.entity.PickingList;

public interface PickingListService {
    PickingList makePickingList(Order order);

    PickingList assignPicker(PickingList pickingList, Picker picker);
}
