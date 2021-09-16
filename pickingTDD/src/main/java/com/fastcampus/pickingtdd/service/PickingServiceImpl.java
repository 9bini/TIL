package com.fastcampus.pickingtdd.service;

import com.fastcampus.pickingtdd.entity.PickerStateEnum;
import com.fastcampus.pickingtdd.entity.PickingList;
import com.fastcampus.pickingtdd.entity.PickingStateEnum;
import com.fastcampus.pickingtdd.entity.Sku;
import org.springframework.stereotype.Service;

@Service
public class PickingServiceImpl implements PickingService {
    @Override
    public void pick(PickingList pickingList, Sku sku) throws Exception{
        if (!pickingList.getSkuAmountMap().keySet().contains(sku)) throw new Exception("wrong sku");
        else{
            if (pickingList.getPickedMap().get(sku)  == pickingList.getSkuAmountMap().get(sku))
                throw new Exception("to much sku");
            pickingList.getPickedMap().put(sku, pickingList.getPickedMap().get(sku) + 1);
        }
        this.setStatus(pickingList, null);
    }

    private void setStatus(PickingList pickingList, PickingStateEnum state){
        if (state == null){
            boolean isDone = false;
            for (Sku sku : pickingList.getSkuAmountMap().keySet()) {
                isDone = pickingList.getSkuAmountMap().get(sku) == pickingList.getPickedMap().get(sku);
            }

            if (isDone){
                setStatus(pickingList, PickingStateEnum.DONE);
            }else{
                pickingList.setState(PickingStateEnum.PROGRESS);
                pickingList.getPicker().setState(PickerStateEnum.PROCESS);
            }


        }else{
            pickingList.setState(state);
            if(state == PickingStateEnum.DONE){
                pickingList.getPicker().setState(PickerStateEnum.DONE);
            }
            if(state == PickingStateEnum.ERROR){
                pickingList.getPicker().setState(PickerStateEnum.ERROR);
            }
            if(state == PickingStateEnum.PENDING){
                pickingList.getPicker().setState(PickerStateEnum.ERROR);
            }

        }
    }
}
