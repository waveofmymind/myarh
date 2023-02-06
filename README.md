# MyArh

해당 프로젝트는 기존에 진행했던 알고리즘 리뷰 도우미 프로젝트를 스프링부트 3.0.2로 리팩토링하는 프로젝트입니다

프로젝트를 도커라이징하고, 젠킨스를 통한 CI/CD 파이프라인 구축을 해서 프로젝트를 관리합니다.

## 엔티티 관계 다이어그램

![image](https://user-images.githubusercontent.com/93868431/216944449-49d25ef3-5339-4b16-ad3f-26e509973e74.png)

- Problem - Review: 일대다 관계

- Problem - Problem Tag - Tag: Problem과 Tag는 관계를 직접적으로 연결시킬경우 다대다 관계이기 때문에, 중간에 Problem Tag를 두어 각각 일대다, 다대일로 풀어냈습니다.


## 주요 기능

- 회원 가입

- 문제 등록(+리뷰 등록)

- 문제 삭제

- 문제 수정

- 문제 조회

## 레퍼런스

- [패키징 구조 - 도메인 집중형](https://github.com/cheese10yun/spring-guide/blob/master/docs/directory-guide.md)

##환경

Java 17

Spring Boot 3.0.2
