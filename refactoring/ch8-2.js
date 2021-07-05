let scores = [
  87, 57, 98, 61, 5, 27, 25, 19, 26, 57, 83, 72, 41, 65, 67, 74, 100, 40, 85,
  16, 1,
];

// 이 위로 수정 불가
// 반복문을 파이프라인으로 바꾸기
function getStatsOfScores() {
  const sum = scores.reduce((sum, score) => sum + score, 0);
  const min = scores.reduce((min, score) => (score < min ? score : min), 100);
  const max = scores.reduce((max, score) => (score > max ? score : max), 0);
  const avg = sum / scores.length;
  return { sum: sum, avg: avg, max: max, min: min };
}

// 이 아래로 수정 불가

let stat = getStatsOfScores();
console.log("sum of scores : " + stat.sum);
