package com.fastcampus.pickingtdd.service;

import com.fastcampus.pickingtdd.entity.Picker;
import com.fastcampus.pickingtdd.entity.PickingList;

public interface PickerService {
    Picker assignPickingList(Picker picker, PickingList pickingList);
}
