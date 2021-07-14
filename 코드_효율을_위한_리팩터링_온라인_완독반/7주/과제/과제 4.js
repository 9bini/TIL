
class Physics {
	constructos() {
		this._gravity = 10
	}

	set gravity(grav) {this._gravity = grav;}
	get gravity() {return this._gravity;}

	setDefaultGravity() {
		this._gravity = 10;
	}
}

function testFunction(physics) {
	physics.setDefaultGravity()
	return physics.gravity
}

// 이하 수정 금지

let physics = new Physics();
physics.gravity = 9.8;
console.log(testFunction(physics))