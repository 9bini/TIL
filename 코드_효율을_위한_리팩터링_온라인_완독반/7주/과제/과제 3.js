class DeepFryer {
	constructor() {
		this._maxTemp = 20;
		this._minTemp = 20;
		this._currentTemp = 23;
	}

	adjustTemperature(fryingObject) {
		this._minTemp = fryingObject.minTemp;
		this._maxTemp = fryingObject.maxTemp;

		if(this._currentTemp < this._minTemp) {
			this._currentTemp += (this._minTemp-this._currentTemp)/2;
		}
		if(this._currentTemp > this._maxTemp) {
			this._currentTemp -= (this._currentTemp - this._maxTemp)/2;
		}
	}

	get currentTemp() {return this._currentTemp;}
}

class FryingObject {
	constructor(name, minTemp, maxTemp) {
		this._name = name;
		this._minTemp = minTemp;
		this._maxTemp = maxTemp;
	}

	get name() {return this._name;}
	get minTemp() {return this._minTemp;}
	get maxTemp() {return this._maxTemp;}
}

function testFunction(deepFryer, fryingObject) {
	deepFryer.adjustTemperature(fryingObject);
	return deepFryer.currentTemp;
}

// 이하 수정 금지
let deepFryer= new DeepFryer();
let fryingObject = new FryingObject("shoe", 130, 150);
console.log(testFunction(deepFryer, fryingObject));