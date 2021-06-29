# 인터셉터(Interceptor)?

interceptor는 Dispatcher servlet에서 Handler(Controller)로 요청을 보낼 때, Handler에서 Dispatcher servletDispatcher servlet으로 응답을 보앨 때 동작합니다.

![인터셉터](https://cphinf.pstatic.net/mooc/20180222_261/1519262329628q8DQN_JPEG/1.jpg)

## 인터셉터와 필터의 차이

필터: 요청과 응답을 거른뒤 정제하는 역할
[ 필터의 실행메서드 ]

- init() - 필터 인스턴스 초기화
- doFilter() - 전/후 처리
- destroy() - 필터 인스턴스 종료
  인터셉터: 요청에 대한 작업 전/후로 가로챈다(로그인 체크, 권한체크, 프로그램 실행시간 계산작업 로그확인 등의 업무처리)

[ 인터셉터의 실행메서드 ]

- preHandler() - 컨트롤러 메서드가 실행되기 전
- postHanler() - 컨트롤러 메서드 실행직 후 view페이지 렌더링 되기 전
- afterCompletion() - view페이지가 렌더링 되고 난 후

출처:

- https://goddaehee.tistory.com/154 [갓대희의 작은공간]
- https://www.boostcourse.org/web326/lecture/59002/?isDesc=false
