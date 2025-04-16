# 학습 관리 시스템(Learning Management System)
## 진행 방법
* 학습 관리 시스템의 수강신청 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 구현 기능
- [ ] 과정 도메인
  - 기수 단위
  - 여러 개의 강의 포함
- [ ] 강의 도메인
  - 커버이미지 정보
    - 이미지 크기: 1Mb 이하
    - 이미지 허용 타입: gif, jpg/jpeg, png, svg
    - 이미지 width: 300px 이상, height: 200px 이상
    - 이미지 w/h: 3:2
  - 강의 정보
    - 무료
      - 수강 인원 무제한
    - 유료
      - 수강 인원 제한
      - 결제 금액 = 수강료와 일치시 신청 가능
    - 상태: 준비중, 모집중, 종료
- [ ] payment module
  - 결제 정보

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)