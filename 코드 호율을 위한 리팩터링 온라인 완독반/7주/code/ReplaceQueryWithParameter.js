// 전

targetTemperature(aPlan)

function targetTemperature(aPlan){
    currentTemperature = thermostat.currentTemperature;
}

// 후

targetTemperature(aPlan, currentTemperature)

function targetTemperature(aPlan, currentTemperature){
}

// 예시

class HeatingPlan{
    get targetTemperature(){
        if(thermostat.selectedTemperature>this._max)return this._max;
        else if (thermostat.selectedTemperature < this._min)return this.min;
        else return thermostat.selectedTemperature;
    }
}

function test(){
    const thePlan= new HeatingPlan;
    if (thePlan.temperature > thermostat.currentTemperature) setToHeat();
    if (thePlan.temperature < thermostat.currentTemperature) setToColl();
    else setOff();
}

// 1. 변수 추출하기를

class HeatingPlan{
    get targetTemperature(){
        let selectedTemperature = thermostat.selectedTemperature;
        if(selectedTemperature>this._max)return this._max;
        else if (selectedTemperature < this._min)return this.min;
        else return selectedTemperature;
    }
}

// 2. 메소드 추출
class HeatingPlan{
    get targetTemperature(){
        let selectedTemperature = thermostat.selectedTemperature;
        return this.xxNEWtargetTemperature(selectedTemperature);
    }

    xxNEWtargetTemperature(selectedTemperature) {
        if (selectedTemperature > this._max) return this._max;
        else if (selectedTemperature < this._min) return this.min;
        else return selectedTemperature;
    }
}
// 3. 추출한 변수를 인라인
class HeatingPlan{
    get targetTemperature(){
        return this.xxNEWtargetTemperature(thermostat.selectedTemperature);
    }

    xxNEWtargetTemperature(selectedTemperature) {
        if (selectedTemperature > this._max) return this._max;
        else if (selectedTemperature < this._min) return this.min;
        else return selectedTemperature;
    }
}
// 4. 메소드까지 인라인

class HeatingPlan2{
    targetTemperature(selectedTemperature) {
        if (selectedTemperature > this._max) return this._max;
        else if (selectedTemperature < this._min) return this.min;
        else return selectedTemperature;
    }
}

function test(){
    const thePlan= new HeatingPlan2;
    let selectedTemperature = thermostat.selectedTemperature;
    if (thePlan.targetTemperature(selectedTemperature) > thermostat.currentTemperature)
        setToHeat();
    if (thePlan.targetTemperature(selectedTemperature) < thermostat.currentTemperature)
        setToColl();
    else setOff();
}

