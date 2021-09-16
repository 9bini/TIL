package com.fastcampus.pickingtdd.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Picker {
    private Long id;
    private PickerStateEnum state;
    private Order assignedOrder;
    private PickingList assignedPickList;
}
