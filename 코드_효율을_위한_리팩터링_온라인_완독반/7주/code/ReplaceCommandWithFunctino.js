// 명령을 함수로 바꾸기

// 전

class ChargeCalculator {

    constructor(customer, usage) {
        this._customer = customer;
        this._usage = usage;
    }

    excute() {
        return this._customer.rate * this._usage;
    }
}

function charge(customer, usage) {
    return customer.rate * usage;
}


// 명령은 복잔한 연산을 다룰 수 이쓴ㄴ 강력한 메커니즘을 제공한다.
// 큰 연산 하나를 여러 개의 작은 메서드로 쪼개고 필드를 이용해 쪼개진 메서드들끼리 정보를 공유할 수 있다.
// 어떤 메서드를 호출하냐에 따라 다른 효과를 줄 수 있고 각 단계를 거치며 데이터를 조금씩 완성해갈 수 있다.

// 이 모든 것은 비용이 든다.
// 로직이 단순하면 명령 객체는 장점보다 단점이 크니 평범한 함수로 바꿔주는 게 낫다.

// 예시

class ChargeCalculator {

    constructor(customer, usage, provider) {
        this._customer = customer;
        this._usage = usage;
        this._provider = provider;
    }

    get baseCharge() {
        return this._customer.baseRate * this._usage;
    }

    get charge() {
        return this.baseCharge + this._provider.connectionCharge;
    }
}


// 1. 이 클래스를 생성하고 호출하는 코드를 함께 함수로 추출한다.

function charge(customer, usage, provider) {
    return new ChargeCalculator(customer, usage, provider).charge;
}

// 2. 이때 보조 메서드들을 어떻게 다룰지 정해야하는데,
// baseCharge()가 이러한 보조 메서드에 속한다.
// 값을 반환하는 메서드라면 먼저 반환할 값을 변수로 추출한다.
// + 보조 메서드를 인라인화한다.
class ChargeCalculator {

    constructor(customer, usage, provider) {
        this._customer = customer;
        this._usage = usage;
        this._provider = provider;
    }

    get charge() {
        const baseCharge = this._customer.baseRate * this._usage;
        return baseCharge + this._provider.connectionCharge;
    }
}

// 3. 생성자에 전달되는 모든 데이터를 주 메서드로 옮겨야한다.

class ChargeCalculator {

    constructor(customer, usage, provider) {
        this._customer = customer;
        this._usage = usage;
        this._provider = provider;
    }

    charge(customer, usage, provider) {
        const baseCharge = this._customer.baseRate * this._usage;
        return baseCharge + this._provider.connectionCharge;
    }
}
function charge(customer, usage, provider) {
    return new ChargeCalculator(customer, usage, provider).charge(customer, usage, provider);
}

// 4. 필드 대신 건네받은 매개변수를 사용하도록 수정한다.
class ChargeCalculator {

    charge(customer, usage, provider) {
        const baseCharge = customer.baseRate * usage;
        return baseCharge + provider.connectionCharge;
    }
}


// 5. 최상위 charge() 함수로 인라인할 수 있다.
// 이는 생성자와 메서드 호출을 함께 인라인하는 특별한 형태의 "6.2 함수 인라인"하기다.

function charge(customer, usage, provider) {
    const baseCharge = customer.baseRate * usage;
    return baseCharge + provider.connectionCharge;
}