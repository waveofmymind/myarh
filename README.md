# Algorithm Review Board

알고리즘 문제를 해결하면, 풀었다는 마음으로 해당 문제를 넘어가는 경우가 있습니다.

혼자 해결하지 못하고 구글링을 하거나 타인의 코드에서 해결법을 찾을 경우, 넘어가게 되면 다음에 비슷한 유형의 문제를 만나도 해결하지 못할 수 있습니다.

그래서 문제를 해결하고 해결했던 코드와 풀이를 함께 저장하여 언제든 다시 복기할 수 있으며, 시간이 지나 같은 문제를 다시 풀더라도 

리뷰를 남겨 알고리즘 문제 학습에 도움을 주기 위한 웹 프로젝트 입니다.

## 주요 기능

- 해결한 문제를 코드와 풀이를 함께 저장합니다.
- 태그와 난이도를 함께 등록하여 태그별 조회, 난이도별 조회를 할 수 있습니다.
- 알림 시간을 설정하여 슬랙으로 복습을 할 시간에 알림을 받을 수 있습니다.
- 권한이 없을 경우 문제 수정 및 삭제, 리뷰 등록, 수정 및 삭제 기능이 제한됩니다.



## 목차

- [기술 스택](#기술-스택)

- [아키텍처](#아키텍처)

- [ERD](#엔티티-관계-다이어그램)

- [API 설계](#api-설계)

- [테스트 코드(단위테스트 , 통합테스트)](#테스트-코드)

- [트러블 슈팅](#트러블-슈팅)

- 프로젝트 진행하면서 학습한 내용

- [마주친 에러와 조치 내용](#마주친-에러와-조치-내용) 

## 기술 스택

- Java 17.0.5
- Spring Boot 3.0.2
- Spring Data JPA
- Querydsl
- MySQL
- Lombok
- Validation
- MapStruct
- Swagger

### Devops

- Github Actions
- Docker
- AWS EC2
- AWS RDS

## 아키텍처

![image](https://user-images.githubusercontent.com/93868431/219997375-f33ffbab-1e73-4865-9f8f-1179667c4c53.png)



## 프로젝트  구조

![image](https://user-images.githubusercontent.com/93868431/218949577-fe7ebaf4-11f8-418f-a3d0-9aecf77e93ee.png)


## 엔티티 관계 다이어그램

![image](https://user-images.githubusercontent.com/93868431/216944449-49d25ef3-5339-4b16-ad3f-26e509973e74.png)


## API 설계

### API 응답 메시지

```
@Data
@AllArgsConstructor
public class ResponseApiDto<T> {

    private int status; // HTTP코드 
    private String message; // 서버 메시지
    private T data; //보낼 데이터
```

- [[POST]문제 등록](https://github.com/waveofmymind/myarh/wiki/%5BPOST%5D%EB%AC%B8%EC%A0%9C-%EB%93%B1%EB%A1%9D)

- [[GET]문제 상세 조회](https://github.com/waveofmymind/myarh/wiki/%5BGET%5D-%EB%AC%B8%EC%A0%9C-%EC%83%81%EC%84%B8-%EC%A1%B0%ED%9A%8C)

- [[GET]문제 전체 조회](https://github.com/waveofmymind/myarh/wiki/%5BGET%5D-%EC%A0%84%EC%B2%B4-%EB%AC%B8%EC%A0%9C-%EC%A1%B0%ED%9A%8C)

- [[PUT]문제 수정](https://github.com/waveofmymind/myarh/wiki/%5BPUT%5D-%EB%AC%B8%EC%A0%9C-%EC%88%98%EC%A0%95)

- [[DELETE]문제 삭제](https://github.com/waveofmymind/myarh/wiki/%5BDELETE%5D-%EB%AC%B8%EC%A0%9C-%EC%82%AD%EC%A0%9CC)

- [[POST]리뷰 등록](https://github.com/waveofmymind/myarh/wiki/%5BPOST%5D-%EB%A6%AC%EB%B7%B0-%EB%93%B1%EB%A1%9D)

- [[PUT]리뷰 수정]()

- [[DELETE]리뷰 삭제](https://github.com/waveofmymind/myarh/wiki/%5BDELETE%5D-%EB%A6%AC%EB%B7%B0-%EC%82%AD%EC%A0%9C)



## 주요 기능

### 문제 등록(+리뷰 등록)

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

- 통합 테스트

![스크린샷 2023-02-22 오전 12 45 40](https://user-images.githubusercontent.com/93868431/220482803-85accc0c-7e5a-4d02-9bff-46dbc420f789.png)



## 기술적 도전

- 레이어간 객체를 넘길때 엔티티에 대한 의존성을 낮추기 위해 DTO를 사용했다. 또한 엔티티 - DTO 간에 변환할때 어느 한 쪽에 변환 메서드를 두게 되면 의존성이 생길 것을 염두해 Mapstruct를 이용하여 제 3의 클래스에서 레이어간 객체 변환을 담당한다.

- Spring AOP를 이용하여 비즈니스 예외에 대해 GlobalExceptionHandler 한 클래스에서 모두 처리하도록 유지보수성을 높였다.

- Sl4fj 로그를 더 관리하기 용이하도록 에러가 났을때 Slack Bot을 통해 슬랙으로 알림을 받도록 했다.

- Docker 를 사용하여 OS 관계없이 동일한 환경을 제공 한다.

- GitHub Actions 를 이용하여  브랜치에 푸시 , PR 행위가 발생할 경우 workflows 를 따라 자동 배포 진행 + 테스트 코드가 실패할 경우 에러가 발생해 배포 불가

- Authorization Code로 권한을 체크할때, Spring AOP를 이용하여 권한 체크 커스텀 어노테이션을 구현하여 권한 체크를 하는 모듈을 분리했다.


## 트러블 슈팅

- Entity를 레이어간 정보 이동에 사용할 시, 민감하거나 불필요한 정보가 오가며, 의존성이 생길수도 있다고 생각했다.
  
  -> 엔티티를 직접 사용하는 것보다 리포지토리에서만 엔티티를 뽑아오고, 그 외에는 DTO를 사용해서 데이터 교환을 하도록 구현했다.

- toEntity(), toDto() 메서드를 엔티티, Dto 어디에 구현해도 의존성이 생길것이라고 생각했다.

  -> mapstruct의 @Mapper를 이용하여 제 3자의 클래스에서 엔티티 <-> DTO를 변환시킬수 있도록  역할을 분리했다.
  
- 문제를 전체 조회할 때 예상치 못한 쿼리 N+1 문제

  -> 문제를 전체 조회할 때에는 Review를 모두 조회할 필요가 없다고 생각해서 연관관계를 모두 지연 로딩으로 하였고, 문제만을 조회할 수 있는 Dto를 만들었다.
  
- 문제를 전체 조회할 때에는 리뷰리스트는 보여질 필요가 없으므로 ProblemOnlyDto를 따로 두었다. 



## 마주친 에러와 조치 내용 

- MapStruct 사용하여 Mapper 인터페이스 선언하였으나, DTO - 엔티티간 매핑 안되는 이슈 발생(NPE)
    -> Mapstruct의 경우, source에서 getter로 값을 얻어와서 Builddr로 target 객체를 생성한다. 그러므로 소스에 @Getter, 타겟에 @Builder를 선언해야한다. 

## 레퍼런스

- [Git Flow](https://gyoogle.dev/blog/github/Git%20vs%20GitHub%20vs%20GitLab%20Flow.html)

- [패키징 구조 - 도메인 집중형](https://github.com/cheese10yun/spring-guide/blob/master/docs/directory-guide.md)
