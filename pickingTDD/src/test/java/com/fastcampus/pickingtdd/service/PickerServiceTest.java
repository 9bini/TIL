package com.fastcampus.pickingtdd.service;

import com.fastcampus.pickingtdd.entity.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class PickerServiceTest {
    @Autowired
    PickerService pickerService;

    @Test
    public void assignedPickerList(){
        Picker picker = new Picker();
        picker.setId(1L);
        picker.setState(PickerStateEnum.REST);

        PickingList pickingList = new PickingList();
        pickingList.setOrder(new Order());


        Picker assignPicker = pickerService.assignPickingList(picker, pickingList);

        assertEquals(PickerStateEnum.ASSIGNED, assignPicker.getState());
        assertNotNull(assignPicker.getAssignedOrder());
        assertNotNull(assignPicker.getAssignedPickList());
        assertNotNull(assignPicker.getAssignedPickList().getPicker());
    }
}
