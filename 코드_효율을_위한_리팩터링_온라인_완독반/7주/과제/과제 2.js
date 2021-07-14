
class Account {
    constructor() {
        this._value = 0;
    }

    investBTC(amount) {
        this._value += amount * (Math.random()*2 - 1) * 1.0;
    }

    investStock(amount) {
        this._value += amount * (Math.random()*2 - 1) * 0.1;
    }

    invest(BTC, Stock){
        this.investBTC(BTC);
        this.investStock(Stock);
    }

    get value() {return this._value;}
}

function testFunction(account) {
    account.invest(100, 50)
    return account.value;
}

// 이하 수정 금지
Math.random = ()=>{return 0.5;}
let account = new Account();
console.log(testFunction(account));


