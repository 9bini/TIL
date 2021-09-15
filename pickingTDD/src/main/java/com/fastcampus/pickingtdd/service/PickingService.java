package com.fastcampus.pickingtdd.service;

import com.fastcampus.pickingtdd.entity.PickingList;
import com.fastcampus.pickingtdd.entity.Sku;

public interface PickingService {
    void pick(PickingList pickingList, Sku sku);
}
