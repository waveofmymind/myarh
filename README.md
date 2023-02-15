# Algorithm Review Board


해결한 알고리즘을 풀이와 함께 저장할 수 있는  API 

## 목차

- [기술 스택](#기술-스택)

- [아키텍처](#아키텍처)

- [프로젝트 구조](프로젝트-구조)

- [ERD](#엔티티-관계-다이어그램)

- 서비스 별 시퀀스 다이어그램 (노션 링크)

- [API 설계](#api-설계)

- 기능 설명(간단히)

- [테스트 코드(단위테스트 , 통합테스트)](#테스트-코드)

- [기술적 도전](#기술적-도전)

- [트러블 슈팅](#트러블-슈팅)

- 프로젝트 진행하면서 학습한 내용

- [마주친 에러와 조치 내용](#마주친-에러와-조치-내용) 

## 기술 스택

- Java 17
- Spring Boot 3.0.2
- Spring Data JPA
- MySQL
- Lombok
- Validation
- MapStruct




## 프로젝트 구조

![image](https://user-images.githubusercontent.com/93868431/218667426-753e8905-fe74-4a1a-a146-28d62028bac0.png)


## 엔티티 관계 다이어그램

![image](https://user-images.githubusercontent.com/93868431/216944449-49d25ef3-5339-4b16-ad3f-26e509973e74.png)

- Problem - Review: 일대다 관계

- Problem - Problem Tag - Tag: Problem과 Tag는 관계를 직접적으로 연결시킬경우 다대다 관계이기 때문에, 중간에 Problem Tag를 두어 각각 일대다, 다대일로 풀어냈습니다.

## API 설계

- [[POST]문제 등록](https://github.com/waveofmymind/arh/wiki/%5BPOST%5D-%EB%AC%B8%EC%A0%9C-%EB%93%B1%EB%A1%9D)

- [[GET]문제 세부 조회](https://github.com/waveofmymind/arh/wiki/%5BGET%5D-%EB%AC%B8%EC%A0%9C-%EC%84%B8%EB%B6%80-%EC%A1%B0%ED%9A%8C)

- [[GET]문제 전체 조회](https://github.com/waveofmymind/arh/wiki/%5BGET%5D-%EC%A0%84%EC%B2%B4-%EB%AC%B8%EC%A0%9C-%EC%A1%B0%ED%9A%8C)

- [[PUT]문제 수정](https://github.com/waveofmymind/arh/wiki/%5BPUT%5D-%EB%AC%B8%EC%A0%9C-%EC%88%98%EC%A0%95)

- [[DELETE]문제 삭제](https://github.com/waveofmymind/arh/wiki/%5BDELETE%5D-%EB%AC%B8%EC%A0%9C-%EC%82%AD%EC%A0%9C)

- [[POST]리뷰 등록](https://github.com/waveofmymind/arh/wiki/%5BPOST%5D-%EB%A6%AC%EB%B7%B0-%EB%93%B1%EB%A1%9D)

- [[PUT]리뷰 수정]()

- [[DELETE]리뷰 삭제]()



## 주요 기능

### 문제 등록(+리뷰 등록)

문제 등록의 경우 title,link,level,tagList,content를 받습니다. 
tagList는 List<String>의 형태로 request를 받습니다.

- 문제 삭제

- 문제 수정

- 문제 조회

## 테스트 코드

- 문제 등록 & 매핑 테스트

![image](https://user-images.githubusercontent.com/93868431/218948990-3d267c94-514a-40f3-99dd-3e4ddea2957b.png)
  
![image](https://user-images.githubusercontent.com/93868431/218949117-e7bbafc3-a8fb-4c7a-86e1-037593d5fae1.png)

- 리뷰 등록 & 매핑 테스트

![image](https://user-images.githubusercontent.com/93868431/218939715-8d5bfe7b-0318-4e79-ab68-85b2ace10d5e.png)
  
![image](https://user-images.githubusercontent.com/93868431/218949229-7baebdeb-c37a-4b51-93db-86014f4f07c0.png)




## 기술적 도전

- @ControllerAdvice, @ExceptionHandler를 활용한 예외처리


## 트러블 슈팅

- Entity를 레이어간 정보 이동에 사용할 시, 민감하거나 불필요한 정보가 오가며, 의존성이 생길수도 있다고 생각했다.
  
  -> 엔티티를 직접 사용하는 것보다 리포지토리에서만 엔티티를 뽑아오고, 그 외에는 DTO를 사용해서 데이터 교환을 하도록 구현했다.

- toEntity(), toDto() 메서드를 엔티티, Dto 어디에 구현해도 의존성이 생길것이라고 생각했다.

  -> mapstruct의 @Mapper를 이용하여 제 3자의 클래스에서 엔티티 <-> DTO를 변환시킬수 있도록  역할을 분리했다.
 



## 마주친 에러와 조치 내용 

- [MapStruct 사용하여 Mapper 인터페이스 선언하였으나, DTO - 엔티티간 매핑 안되는 이슈 발생(NPE)](https://waveofymymind.tistory.com/74)

## 레퍼런스

- [Git Flow](https://gyoogle.dev/blog/github/Git%20vs%20GitHub%20vs%20GitLab%20Flow.html)

- [패키징 구조 - 도메인 집중형](https://github.com/cheese10yun/spring-guide/blob/master/docs/directory-guide.md)
