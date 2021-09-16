package com.fastcampus.pickingtdd.service;

import com.fastcampus.pickingtdd.entity.Picker;
import com.fastcampus.pickingtdd.entity.PickerStateEnum;
import com.fastcampus.pickingtdd.entity.PickingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PickerServiceImpl implements PickerService {

    @Autowired
    PickingListService pickingListService;

    @Override
    public Picker assignPickingList(Picker picker, PickingList pickingList) {
        picker.setAssignedPickList(pickingList);;
        picker.setAssignedOrder(pickingList.getOrder());
        picker.setState(PickerStateEnum.ASSIGNED);

        if (pickingList.getPicker() == null || !picker.equals(pickingList.getPicker())){
            // pickingList.setPicker(picker);로 처리할 수 있지만 PickerService 영역에서 벗에난 행동이다
            pickingListService.assignPicker(pickingList, picker);
        }

         return picker;
    }
}
