# 11.12 오류 코드를 예외로 바꾸기

## 전

```javascript
if (data) return new ShoppingRules(data);
else return -23;
```

## 후

```javascript
if (data) return new ShoppingRules(data);
else throw new OrderProcessingError(-23);
```

## 배경

- 경험
  - 예외를 던지는 코드를 프로그램 종료 코드로 바꿔도 프로그램이 여천히 정상 동작할지를 따져보는 것이다.
    - 정상 동작하지 않을 것 같다면 예외를 사용하지 말라는 신회다.
    - 예외 대신 오류를 검출하여 프로그램을 정상 흐름으로 되돌리끔 처리해야한다.
- 오류가 예상된 것이라면 예외

## 예시

```javascript
function localShippingRules(country){
    const data = countryData.shippingRules[country];
    if (data) reutnr new ShoppingRules(data);
    else return -23;
}

function calculateShoppingCosts(anOrder){
    // 관련 없는 코드
    const shippingRules = localShippingRules(anOrder.country);
    if (shippingRules)return shippingRules;// 오류 전파
}

const status = calculateShoppingCosts(orderData);
if(status <0) erroorList.push({order:orderData, errorCode: status});
```

### 최상위에 예외 핸들러를 갖춘다.

```javascript
let status;
try {
  status = calculateShoppingCosts(orderData);
} catch (e) {
  // 예외 처리 로직
  throw e;
}
if (status < 0) erroorList.push({ order: orderData, errorCode: status });
```

### 이번 리팩터링으로 추가된 예외만을 처리하고자 한다면 다른 예외와 구별할 방법이 필요하다

- 클래스 기반 언어는 서브클래스를 만드는 게 가장 자연스럽다.

```javascript
class OrderProcessingError extends Error {
  constructor(errorCode) {
    super("주문 처리 오류${errorCode}");
    this.code = errorCode;
  }
  get name() {
    return "OrderProcessingError";
  }
}
```

### 예외 클래스를 처리하는 로직을 추가된

```javascript
let status;
try {
  status = calculateShoppingCosts(orderData);
} catch (e) {
  if (e instanceof OrderProcessingError)
    erroorList.push({ order: orderData, errorCode: status });
  else throw e;
}
if (status < 0) erroorList.push({ order: orderData, errorCode: status });
```

### 다음 오류 검출 코드르 수정하여 오류 코드 대신 이 예외를 던지도록 한다.

```javascript
function localShippingRules(country){
    const data = countryData.shippingRules[country];
    if (data) reutnr new ShoppingRules(data);
    else throw new OrderProcessingError(-23);
}

```

### 함정을 추가한 후 테스트

```javascript
function calculateShoppingCosts(anOrder) {
  // 관련 없는 코드
  const shippingRules = localShippingRules(anOrder.country);
  if (shippingRules < 0) throw new Error("오류 코드가 다 사라지지 않았습니다.");
}
```

### 오류 코드를 전파하는 임시 코드를 제거

```javascript
function calculateShoppingCosts(anOrder) {
  // 관련 없는 코드
  const shippingRules = localShippingRules(anOrder.country);
}

try {
  calculateShoppingCosts(orderData);
} catch (e) {
  if (e instanceof OrderProcessingError)
    erroorList.push({ order: orderData, errorCode: status });
  else throw e;
}
```
