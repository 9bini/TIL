// 전
function tenPercentRaise(aPerson) {
  aPerson.salary = aPerson.salary.multiply(1.1);
}

function fivePercentRaise(aPerson) {
  aPerson.salary = aPerson.salary.multiply(1.05);
}

// 후
function raise(aPerson, factor) {
  aPerson.salary = aPerson.salary.multiply(factor);
}

// 예시

function baseChange(usage) {
  if (usage < 0) return usd(0);
  const amount =
    bottomBand(usage) * 0.03 + middleBand(usage) * 0.05 + topBand(usage) * 0.07;
  return usd(amount);
}

function bottomBand(usage) {
  return Math.min(usage, 100);
}

function middleBand(usage) {
  return usage > 100 ? Math.min(usage, 200) - 100 : 0;
}

function topBand(usage) {
  return usage > 200 ? usage - 200 : 0;
}

// 2. 함수 선언 바꾸기로 리터럴을 매개변수로 추가한다.
function withinBand(usage, bottom, top) {
  return usage > 100 ? Math.min(usage, 200) - 100 : 0;
}

function baseChange(usage) {
  if (usage < 0) return usd(0);
  const amount =
    bottomBand(usage) * 0.03 +
    middleBand(usage, 100, 200) * 0.05 +
    topBand(usage) * 0.07;
  return usd(amount);
}

// 5. 적절한 매개변수로 대체한다.
function withinBand(usage, bottom, top) {
  return usage > bottom ? Math.min(usage, top) - bottom : 0;
}

// 6. 대역의 하한을 호출하는 부분도 새로 만든 매개변수화 함수를 호출하도록 바꾼다.

function baseChange(usage) {
  if (usage < 0) return usd(0);
  const amount =
    withinBand(usage, 0, 100) * 0.03 +
    withinBand(usage, 100, 200) * 0.05 +
    withinBand(usage, 200, infinite) * 0.07;
  return usd(amount);
}
