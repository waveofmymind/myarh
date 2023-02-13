# MyArh

해당 프로젝트는 기존에 진행했던 알고리즘 리뷰 도우미 프로젝트를 스프링부트 3.0.2로 리팩토링하는 프로젝트입니다

## 목차

- [기술 스택](#기술-스택)

- 아키텍처

- [프로젝트 구조](프로젝트-구조)

- [ERD](#엔티티-관계-다이어그램)

- 서비스 별 시퀀스 다이어그램 (노션 링크)

- 기능 설명(간단히)

- 테스트 코드 ( 단위테스트 , 통합테스트 )

- 기술적 도전

- 트러블 슈팅

- 프로젝트 진행하면서 학습한 내용

- 마주친 에러와 조치 내용 

## 기술 스택

- Java 17
- Spring Boot 3.0.2
- Spring Data JPA
- Querydsl
- MySQL
- Lombok
- Validation
- MapStruct


## 프로젝트 구조

![image](https://user-images.githubusercontent.com/93868431/218382249-b5b5eb47-92ee-4cda-bd46-7ad1bdc47e3f.png)


## 엔티티 관계 다이어그램

![image](https://user-images.githubusercontent.com/93868431/216944449-49d25ef3-5339-4b16-ad3f-26e509973e74.png)

- Problem - Review: 일대다 관계

- Problem - Problem Tag - Tag: Problem과 Tag는 관계를 직접적으로 연결시킬경우 다대다 관계이기 때문에, 중간에 Problem Tag를 두어 각각 일대다, 다대일로 풀어냈습니다.


## 주요 기능

### 문제 등록(+리뷰 등록)

문제 등록의 경우 title,link,level,tagList,content를 받습니다. 
tagList는 List<String>의 형태로 request를 받습니다.

- 문제 삭제

- 문제 수정

- 문제 조회

## 트러블 슈팅

- MapStruct 사용하여 Mapper 인터페이스 선언하였으나, DTO - 엔티티간 매핑 안되는 이슈 발생(NPE)

- Travis Ci 사용중 유료화로 인한 CI/CD Github Actions

## 레퍼런스

- [패키징 구조 - 도메인 집중형](https://github.com/cheese10yun/spring-guide/blob/master/docs/directory-guide.md)
