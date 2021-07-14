class Game {
    constructor(name) {
        this._name = name;
    }


    setConfiguration(configuration) {
        this._configuration = configuration;
    }

    get configuration() {return this._configuration;}
}

class Controller {
    constructor(name, configuration) {
        this._name = name;
        this._configuration = configuration;
    }

    get configuration() {return this._configuration;}
}

function testFunction(game, controller) {
    game.setConfiguration(controller.configuration)
    return game.configuration;
}

// 이하 수정 금지
let game = new Game("RedDeadRedemption2");
let controller = new Controller("DualShock4", "xyz_analog_trigger_vibe");
console.log(testFunction(game, controller))