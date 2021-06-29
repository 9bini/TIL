# ArgumentResolver - 아규먼트 리졸버

## 아규먼트 리졸버란?

- 컨트롤러의 메소드의 인자로 사용자가 임의의 값을 전달하는 방법을 제공하고자 할 때 사용됩니다.
- 예를 들어, 세션에 저장되어 있는 값중 특정 이름의 값을 메소드 인자로 전달합니다.

Argument Resolver를 이용하면 Controller의 파라미터에 대한 공통 기능을 제공 할 수 있다.

블로그에서는 생성,수정 작업할 때 IP 값, 웹 정보 가져오는 것
커뮤니티에서는 세션에서 정보를 가져올때, vo 혹은 map으로 k,v매핑을 할때 사용된다?

출처:

- https://jaehun2841.github.io/2018/08/10/2018-08-10-spring-argument-resolver/#custom-argument-resolver-%EB%A7%8C%EB%93%A4%EA%B8%B0 - 공통
- https://www.boostcourse.org/web326/lecture/59003?isDesc=false
- https://okky.kr/article/584370?note=1702361 - 매핑
- https://okky.kr/article/699651?note=1945439 - 세션
