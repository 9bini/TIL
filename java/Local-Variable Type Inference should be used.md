# 로컬 변수 추론

자바 10에서는 로컬 변수 유형 추론이 도입되었다.
변수를 var 키워드로 선언하여 변수의 예상 유형을 생략할 수 있습니다.
변수를 선언하는 이 새로운 방법을 사용하는 것이 항상 가능하거나 더 깨끗한 것은 아니지만,
왼쪽의 유형이 할당의 오른쪽 유형과 동일할 때, 변수를 사용하면 보다 간결한 코드를 얻을 수 있습니다.
이 규칙은 변수의 예상 유형이 반환된 식의 할당된 형식과 동일한 경우 문제를 보고합니다.
