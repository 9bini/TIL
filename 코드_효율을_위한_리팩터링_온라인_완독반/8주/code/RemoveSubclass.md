# 12.7 서브클래스 제거하기

## 전

```javascript
class Person {
  get genderCode() {
    return "X";
  }
}
class Male extends Person {
  get genderCode() {
    return "M";
  }
}

class Female extends Person {
  get genderCode() {
    return "F";
  }
}
```

## 후

```javascript
class Person {
  get genderCode() {
    return this._genderCode;
  }
}
```

## 배경

개발을 진행하면서 서브클래스의 의미가 사라지면
슈퍼클래스의 필드로 대체해 제거하는 게 최선이다.

## 예시

```javascript
class Person {
  constructor(name) {
    this._name = name;
  }
  get name() {
    return this._name;
  }
  get genderCode() {
    return "X";
  }
}
class Male extends Person {
  get genderCode() {
    return "M";
  }
}

class Female extends Person {
  get genderCode() {
    return "F";
  }
}
```

### 먼저 현재의 표현을 캡셜화하여 이번 변호가 클라이언트 코드에 주는 영향을 최소화한다.

서브 클래스를 캡슐화하는 방법은 11.8 생성자를 팩터리 함수로 바꾸기

```javascript
function createPerson(name) {
  return new Person(name);
}
function createMale(name) {
  return new Mail(name);
}

function createFemale(name) {
  return new Female(name);
}
```

```javascript
function loaddFromInput(data) {
  const result = [];
  data.forEach((aRecord) => {
    let p;
    switch (aRecord.genderCode) {
      case "M":
        p = new Male(aRecord.name);
        break;
      case "W":
        p = new Female(aRecord.name);
        break;
      default:
        p = new Person(aRecord.name);
        break;
    }
    result.push(p);
  });
  return result;
}
```

### 생성할 클래스를 선택하는 로직을 6.1 함수 추출 하고 추출한 함수를 팩토리로 삼는다.

```javascript
function createPerson(aRecord) {
  let p;
  switch (aRecord.genderCode) {
    case "M":
      p = new Male(aRecord.name);
      break;
    case "W":
      p = new Female(aRecord.name);
      break;
    default:
      p = new Person(aRecord.name);
      break;
  }
  return p;
}

function loaddFromInput(data) {
  const result = [];
  data.forEach((aRecord) => {
    result.push(createPerson(aRecord));
  });
  return result;
}
```

### 변수 P를 인라인화

```javascript
function createPerson(aRecord) {
  switch (aRecord.genderCode) {
    case "M":
      return new Male(aRecord.name);
    case "W":
      return new Female(aRecord.name);
    default:
      return new Person(aRecord.name);
  }
}

function loaddFromInput(data) {
  const result = [];
  data.forEach((aRecord) => {
    result.push(createPerson(aRecord));
  });
  return result;
}
```

### 8.8 반복문을 파이프라인으로 변경

```javascript
function loaddFromInput(data) {
  return data.map((aRecord) => createPerson(aRecord));
}
```

```javascript
const numberOfMails = people.filter((p) => p instanceof Male).length;
```

### 타임 검사 코드를 6.1 함수 추출한

```javascript
const numberOfMails = people.filter((p) => isMale(p)).length;
function isMale(p) {
  return p instanceof Male;
}
```

### 8.1 추출한 함수를 Person으로 옮긴다.

```javascript
class Person {
  constructor(name) {
    this._name = name;
  }
  get name() {
    return this._name;
  }
  get genderCode() {
    return "X";
  }
  get isMale(p) {
  return p instanceof Male;
  }
}
const numberOfMails = people.filter((p) => p.isMale).length;
```

### 서브클래스들의 차이를 나타내는 필드 추가

```javascript
class Person {
  constructor(name, genderCode) {
    this._name = name;
    this._genderCode = genderCode || "X";
  }
  get name() {
    return this._name;
  }
  get genderCode() {
    return this._genderCode;
  }
  get isMale(p) {
  return p instanceof Male;
  }
}
```

### 서브클래스를 슈퍼클래스로 옮긴다.

```javascript
function createPerson(aRecord) {
  switch (aRecord.genderCode) {
    case "M":
      return new Person(aRecord.name, "M");
    case "W":
      return new Female(aRecord.name, "W");
    default:
      return new Person(aRecord.name, "X");
  }
}

class Person {
  constructor(name, genderCode) {
    this._name = name;
    this._genderCode = genderCode;
  }
  get name() {
    return this._name;
  }
  get genderCode() {
    return this._genderCode;
  }
  get isMale() {
    return "M" === this._genderCode;
  }
}
```
