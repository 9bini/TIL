// 전

function setDimension(name, value) {
  if (name === "height") {
    this._height = value;
    return;
  }

  if (name === "width") {
    this._width = value;
    return;
  }
}

// 후

function setHeight(value) {
  this._height = value;
}
function setWidth(value) {
  this._width = value;
}

// 예시 1

function deliverDate(anOrder, isRush) {
  if (isRush) {
    let deliveryTime;
    if (["MA", "CT"].includes(anOrder.deliveryState)) deliveryTime = 1;
    else if (["MY", "NH"].includes(anOrder.deliveryState)) deliveryTime = 2;
    else deliveryTime = 3;
    return anOrder.placeOn.plusDays(1 + deliveryTime);
  } else {
    if (["MA", "CT", "MY"].includes(anOrder.deliveryState)) deliveryTime = 2;
    else if (["ME", "NH"].includes(anOrder.deliveryState)) deliveryTime = 3;
    else deliveryTime = 4;
    return anOrder.placeOn.plusDays(2 + deliveryTime);
  }
}
// 1. 조건문 분해하기
function deliverDate(anOrder, isRush) {
  if (isRush) return rushDeliveryDate(anOrder);
  else return regularDeliveryDate(anOrder);
}
function rushDeliveryDate(anOrder) {
  let deliveryTime;
  if (["MA", "CT"].includes(anOrder.deliveryState)) deliveryTime = 1;
  else if (["MY", "NH"].includes(anOrder.deliveryState)) deliveryTime = 2;
  else deliveryTime = 3;
  return anOrder.placeOn.plusDays(1 + deliveryTime);
}
function regularDeliveryDate(anOrder) {
  if (["MA", "CT", "MY"].includes(anOrder.deliveryState)) deliveryTime = 2;
  else if (["ME", "NH"].includes(anOrder.deliveryState)) deliveryTime = 3;
  else deliveryTime = 4;
  return anOrder.placeOn.plusDays(2 + deliveryTime);
}

aShopment.deliveryDate = rushDeliveryDate(anOrder);

// 예시 2

function deliverDate(anOrder, isRush) {
  let result;
  let deliveryTime;
  if (anOrder.deliveryState === "MA" || anOrder.deliveryState === "CT")
    deliveryTime = isRush ? 1 : 2;
  else if (anOrder.deliveryState === "NY" || anOrder.deliveryState === "NH") {
    deliveryTime = 2;
    if (anOrder.deliveryState === "NH" && !isRush) deliveryTime = 3;
  } else if (isRush) deliveryTime = 3;
  else if (anOrder.deliveryState === "ME") deliveryTime = 3;
  else deliveryTime = 4;
  result = anOrder.placeOn.plusDays(2 + deliveryTime);
  if (isRush) result = result.minusDays(1);
}
