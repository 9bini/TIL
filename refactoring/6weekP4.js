class Seat {
  constructor(laptop) {
    this._laptop = laptop;
  }
  /* blah blah */
  get laptop() {
    return this._laptop;
  }
}

class Laptop {
  constructor(model, price, accessory) {
    this._model = model;
    this._price = price;
    this._accessory = accessory;
  }
  get model() {
    return this._model;
  }
  set price(price) {
    this._price = price;
  }
  get price() {
    return this._price;
  }
  get accessory() {
    return this._accessory;
  }
}

function usecase1(seat) {
  const laptop = seat.laptop;
  return invalid(laptop) ? UnknownLaptop.nonExistingModel : laptop.model;
}

function usecase2(seat) {
  const laptop = seat.laptop;
  return notInvalid(laptop) ? UnknownLaptop.zeroPrice : laptop.price;
}

function usecase3(seat) {
  const laptop = seat.laptop;
  return notInvalid(laptop)
    ? (laptop.price = UnknownLaptop.price999)
    : laptop.price;
}

function usecase4(seat) {
  const laptop = seat.laptop;
  return notInvalid(laptop) ? laptop.accessory.count : UnknownLaptop.price0;
}

// 함수 추출
function invalid(laptop) {
  return laptop === "invalid";
}
function notInvalid(laptop) {
  return !invalid(laptop);
}

// 10.5 특이 케이스 추가하기
class UnknownLaptop {
  get nonExistingModel() {
    return "NonExistingModel";
  }
  get price0() {
    return 0;
  }
  get price999() {
    return 0;
  }
}
