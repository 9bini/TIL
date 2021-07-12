// 수정된 값 반환하기

// 전
let totalAscent = 0;
calculateAscent();

function calculateAscent() {
    for (let i = 1; i < points.length; i++) {
        const verticalChange = points[i].elevation - points[i - 1].elevation;
        totalAscent += (verticalChange > 0) ? verticalChange : 0;
    }
}

// 후

const totalAscent = calculateAscent();

function calculateAscent() {
    let result = 0;
    for (let i = 1; i < points.length; i++) {
        const verticalChange = points[i].elevation - points[i - 1].elevation;
        result += (verticalChange > 0) ? verticalChange : 0;
    }
    return result;
}

// 수정된 데이터를 추적하는 일은 코드에서 이해하기 가장 어려운 부분 중 하나다.
// 데이터가 수정된다면 그 사실을 명확히 알려주어서,
// 어느 함수가 무슨 일을 하는지 쉽게 알 수 있게 하는 일이 대단히 중요하다.

// 예시 이번 리팩토링 고도 상승분계산만 고려한다.
let totalAscent = 0;
let totalTime = 0;
let totalDistance = 0;
calculateAscent();
calculateTime();
calculateDistance();
const pace = totalTime / 60 / totalDistance;
// totalAscent갱신 사실을 밖으로 알리자.
function calculateAscent() {
    for (let i = 1; i < points.length; i++) {
        const verticalChange = points[i].elevation - points[i - 1].elevation;
        totalAscent += (verticalChange > 0) ? verticalChange : 0;
    }
}

// 1. 먼저 totalAscent 값을 반환하고, 호출한 곳에서 변수에 대입하게 고친다.

let totalAscent = calculateAscent();
let totalTime = 0;
let totalDistance = 0;
calculateAscent();
calculateTime();
calculateDistance();
const pace = totalTime / 60 / totalDistance;
// totalAscent갱신 사실을 밖으로 알리자.
function calculateAscent() {
    for (let i = 1; i < points.length; i++) {
        const verticalChange = points[i].elevation - points[i - 1].elevation;
        totalAscent += (verticalChange > 0) ? verticalChange : 0;
    }
    return totalAscent
}

// 2. 반환할 값을 담을 변수인 totalAscent 를 선언한다.

let totalAscent = calculateAscent();
let totalTime = 0;
let totalDistance = 0;
calculateAscent();
calculateTime();
calculateDistance();
const pace = totalTime / 60 / totalDistance;
// totalAscent갱신 사실을 밖으로 알리자.
function calculateAscent() {
    let totalAscent = 0;
    for (let i = 1; i < points.length; i++) {
        const verticalChange = points[i].elevation - points[i - 1].elevation;
        totalAscent += (verticalChange > 0) ? verticalChange : 0;
    }
    return totalAscent
}

// 피호출 함수의 변수 이름을 새 역할에 어울리도록 바꾼다.

function calculateAscent() {
    let result = 0;
    for (let i = 1; i < points.length; i++) {
        const verticalChange = points[i].elevation - points[i - 1].elevation;
        result += (verticalChange > 0) ? verticalChange : 0;
    }
    return result
}

// 계산이 변수 선언과 동시에 수행되도록 하고, 변수에 const를 붙여서 불변으로 만든다.

const totalAscent = calculateAscent();
const totalTime = calculateTime();;
const totalDistance = calculateDistance();;

