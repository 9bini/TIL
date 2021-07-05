let scores = [
  87, 57, 98, 61, 5, 27, 25, 19, 26, 57, 83, 72, 41, 65, 67, 74, 100, 40, 85,
  16,
];

function sumOfPassedScores() {
  return scores.reduce((sum, score) => (score >= 50 ? sum + score : sum), 0);
}

console.log("sum of passed scores : " + e_sumOfPassedScores());
