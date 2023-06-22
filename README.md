# `도현욱` - `인지도(Human Map)`

해커그라운드 해커톤에 참여하는 `도현욱` 팀의 `인지도(Human Map)`입니다.

## 참고 문서

> 아래 두 링크는 해커톤에서 앱을 개발하면서 참고할 만한 문서들입니다. 이 문서들에서 언급한 서비스 이외에도 더 많은 서비스들이 PaaS, SaaS, 서버리스 형태로 제공되니 참고하세요.

- [순한맛](./REFERENCES_BASIC.md)
- [매운맛](./REFERENCES_ADVANCED.md)

## 제품/서비스 소개

<!-- 아래 링크는 지우지 마세요 -->
[제품/서비스 소개 보기](TOPIC.md)
<!-- 위 링크는 지우지 마세요 -->

## 오픈 소스 라이센스

<!-- 아래 링크는 지우지 마세요 -->
[오픈소스 라이센스 보기](./LICENSE)
<!-- 위 링크는 지우지 마세요 -->

## 설치 방법

> **아래 제공하는 설치 방법을 통해 심사위원단이 여러분의 제품/서비스를 실제 Microsoft 애저 클라우드에 배포하고 설치할 수 있어야 합니다. 만약 아래 설치 방법대로 따라해서 배포 및 설치가 되지 않을 경우 본선에 진출할 수 없습니다.**

### 사전 준비 사항

> ### 데이터베이스
> 1. Azure Database for MySQL 서버를 선택한다.
> 2. 유연한 서비스 방법을 선택한다.
> 3. 서버이름을 ddoo로 입력하고 지역을 Korea Center로 선택한뒤 mysql 버젼 8.0을 선택한다. 인증방법은 MySQL 인증만을 선택한다. 관리자 사용자 이름을 do로, 암호는 b1nd0108!로 설정한다.
> 4. 다음 네트워킹으로 넘어가서 방화벽 규칙을 모든 ip를 허용으로 선택한다.
> 5. 다음 만들기를 클릭하여 데이터베이스를 만든다.
> 6. 그리고 해당 데이터베이스에 접속하여 do 스키마를 생성한다.
>
> ### 환경변수
> 1. Github Repository Setting에서 Secrets and variabls의 Actions를 들어가서 아래값들을 name과 secret에 값을 넣어준다.

#
      PORT=8080
      APP_HOST=http://localhost
      DB_CONNECTION=mysql
      DB_HOST=ddoo.mysql.database.azure.com
      DB_PORT=3306
      DB_USERNAME=do
      DB_PASSWORD=b1nd0108!
      DB_DATABASE=do
      DB_SYNCHRONIZE=false
      DB_LOGGING=TRUE
      DB_ENTITIES=src/api/models/**/*.ts,src/api/models/**/*.js
      DB_MIGRATIONS=src/database/migrations/*.ts,src/database/migrations/*.js

## 시작하기

> ### 서버
> 1. App Services 선택한다.
> 2. 인스턴스 이름은 ododo를 입력하고 런타임 스택을 Node 18 LTS로 설정한다. Linux 운영체제를 사용하고 Korea Center 지역을 선택하고 배포로 넘어간다.
> 3. Github Action 설정을 사용으로 바꾸고 세부 정보의 조직, 리포지토리 (do), 분기(main)을 입력한다.
> 4. 그리고 만들기를 눌러 App Service를 생성한다.
> 5. App Service를 생성 후 첫 github action을 실행할 때에는 배포에 실패한다.
> 6. main-ododo.yml 파일에 backend_realese.yml 파일의 내용을 복사 붙여넣기한다.
> 7. 이후 커밋과 푸시를 하여 github action이 동작하도록 한다.

> ### 안드
