보낸 사람: 개발팀 <dev@woowacourse.io>

받는 사람: 비즈니스팀 <biz@woowacourse.io>

제목: '12월 이벤트 플래너' 개발 완료 사항 서전 공유

안녕하세요. 개발팀입니다!

항상 좋은 아이디어를 기획해 주셔서 정말 감사합니다.
내일 진행할 '12월 이벤트 플래너' 개발 회의전 현재까지 진행한 개발 내용과 기능들을 알려드리고자 합니다.

개발 내용의 설명에 앞서  고객이 사용할 '12월 이벤트 플래너'는 식당을 방문하기전에 사전에 개발한 프로그램을 이용하여 주문을 했을 경우 확인할 수 있는 혜택을 알려주는 것 을
목적으로 이해를 하였습니다.

즉 , 플래너에서 고객이 선택한 주문과 실제 방문시의 주문과 다를 수 있다라는 점을 인지하고 개발을 하였습니다.

지난주에 보내주신 기대하신 '12월의 이벤트 플래너'의 모습과 맞춰 다음과 같이 개발을 완료하였습니다.

```

12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)
3
주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)
티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1
12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!

<주문 메뉴>
티본스테이크 1개
바비큐립 1개
초코케이크 2개
제로콜라 1개

<할인 전 총주문 금액>
142,000원

<증정 메뉴>
샴페인 1개

<혜택 내역>
크리스마스 디데이 할인: -1,200원
특별 할인: -1,000원
평일 할인: -4,046원
증정 이벤트: -25,000원

<총혜택 금액>
-6,246원

<할인 후 예상 결제 금액>
135,754원

<12월 이벤트 배지>
산타

```


추가적인 개발 내용 및 확인해 주실 사항은 다음과 같습니다.

1. 보내주신 예시에 더하여 , 총주문 금액이 10,000원 보다 작은 경우에만 10,000원 이상부터 이벤트가 적용되는 것을 알려주는 메시지를 추가해 두었습니다.

```
12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)
26
주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)
타파스-1,제로콜라-1
주문 금액 10,000원 이상부터 이벤트가 적용됩니다.

12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!

<주문 메뉴>
타파스 1개
제로콜라 1개

<할인 전 총주문 금액>
8,500원

<증정 메뉴>
없음

<혜택 내역>
없음

<총혜택 금액>
0원

<할인 후 예상 결제 금액>
8,500원

<12월 이벤트 배지>
없음
```
 
3. 2024 신년 이벤트를 위한 배지를 부여하는 것이기 때문에 혜택 금액에 따라 배지의 종류가 바뀌며, 예상 식당 방문 날짜에 맞는 총 혜택 금액에 따라 배지를 가집니다.
 
    예)  한 고객이 3번 동안 이벤트 프래너를 사용하는 상황입니다.
   예상 방문 날짜를 입력하며 확인 할때 다음과 같이  3만원,1만원,8천원의 예상 주문을 입력합니다.  
   "당일" 방문 날짜에 맞는 총혜택을 고려한 이벤트 배지를 보여지기 때문에.
   3번의 결과동안 산타, 트리, 별 을 보여줍니다.

4.  플레너에서는 결제를 하지 않기 때문에, 올해 12 월이 지난 5년 중 최고의 판매 금액을 달성했는지 "12월 이벤트 플레너"에서 확인이 가능한 기능은 개발하지 않았습니다. 

5. 이벤트 플래너로 확인 한 날짜의 고객이 식당을 방문을 하지 않을 수 도 있기 때문에, 12월 이벤트 참여 고객의 5%가 내년 1월 새해 이벤트에 재참하는 여부를 확인하는 개발은 하지 않았습니다.
    그러나 사용자가 가장 마지막에 입력한 예상 방문 날짜를 데이터에 저장을 해두었기 때문에 활용할 수 있을 것 같습니다.

   
이번 12월 이벤트 플래너의 개발과 관련하여 언제든지 편하게 이메일이나, Slack으로 편하게 연락 주시면 감사하겠습니다.