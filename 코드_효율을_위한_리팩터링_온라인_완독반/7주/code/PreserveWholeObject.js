// 전
const low = aRoom.daysTempRange.low;
const high = aRoom.daysTempRange.high;
if (aPlan.withinRange(low, high)) {
}

// 후
if (aPlan.withinRange(aRoom.daysTempRange)) {
}

// 예시 1

const low = aRoom.daysTempRange.low;
const high = aRoom.daysTempRange.high;
if (aPlan.withinRange(low, high))
  alter.push("방 온도가 지정 범위를 벗어났습니다.");

class HeatingPlan {
  withinRange(bottom, top) {
    return (
      bottom >= this._temperatureRange.low && top <= this._temperatureRange.high
    );
  }
}

// 1. 인터페이스를 갖춘 빈 메소드를 만든다.
class HeatingPlan {
  xxNEWwithinRange(aNumberRange) {}
}

// 2. 새 메서드의 본문은 기존 메소드를 호출하는 코드로 채운다.
class HeatingPlan {
  withinRange(bottom, top) {
    return (
      bottom >= this._temperatureRange.low && top <= this._temperatureRange.high
    );
  }
  xxNEWwithinRange(aNumberRange) {
    return this.withinRange(aNumberRange.low, aNumberRange.high);
  }
}

// 4. 기존 함수를 => 새 함수 + 불필요한 코드 제거
if (aPlan.xxNEWwithinRange(aRoom.daysTempRange))
  alter.push("방 온도가 지정 범위를 벗어났습니다.");

// 5. 원래 함수를 인라인 해준다.
class HeatingPlan {
  withinRange(bottom, top) {
    return (
      bottom >= this._temperatureRange.low && top <= this._temperatureRange.high
    );
  }
  xxNEWwithinRange(aNumberRange) {
    return;
    aNumberRange.low >= this._temperatureRange.low &&
      aNumberRange.high <= this._temperatureRange.high;
  }
}

// 예시 2
// 1. 변수 추출하기
const tempRange = aRoom.daysTempRange;
const low = tempRange.low;
const high = tempRange.high;
let isWithinRange = aPlan.withinRange(low, high);
if (isWithinRange)
  alter.push("방 온도가 지정 범위를 벗어났습니다.");

// 2. 함수 추출하기
const tempRange = aRoom.daysTempRange;
let isWithinRange = xxNEWwithinRange(aPlan, tempRange);
if (isWithinRange)
  alter.push("방 온도가 지정 범위를 벗어났습니다.");

function xxNEWwithinRange(aPlan, tempRange) {
  const low = tempRange.low;
  const high = tempRange.high;
  let isWithinRange = aPlan.withinRange(low, high);
  return isWithinRange;
}

// 3. 함수 옮기기
class HeatingPlan {
  withinRange(bottom, top) {
    return (
        bottom >= this._temperatureRange.low && top <= this._temperatureRange.high
    );
  }
   xxNEWwithinRange(aPlan, tempRange) {
    const low = tempRange.low;
    const high = tempRange.high;
    let isWithinRange = aPlan.withinRange(low, high);
    return isWithinRange;
  }
}

const tempRange = aRoom.daysTempRange;
let isWithinRange = aPlan.xxNEWwithinRange(tempRange);
if (isWithinRange)
  alter.push("방 온도가 지정 범위를 벗어났습니다.");