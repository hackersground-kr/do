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

# 서버 배포 설명서

## 설치 방법

> **아래 제공하는 설치 방법을 통해 심사위원단이 여러분의 제품/서비스를 실제 Microsoft 애저 클라우드에 배포하고 설치할 수 있어야 합니다. 만약 아래 설치 방법대로 따라해서 배포 및 설치가 되지 않을 경우 본선에 진출할 수 없습니다.**

### 사전 준비 사항

- **Microsoft Azure** Account
- `do` repository code (fork)
- mysql 8.0 설치

## 시작하기

### 데이터베이스 구축

> 1. Azure Database for MySQL 서버를 선택한다.
> 2. 유연한 서비스 방법을 선택한다.
> 3. 서버이름을 `ddoo`로 입력하고 지역을 `Korea Center`로 선택한뒤, mysql 버젼 `8.0`을 선택한다. 인증방법은 MySQL 인증만을 선택한다. 관리자 사용자 이름을 `do`로, 암호는 `1q2w3e4r5t!`로 설정한다.
> 4. 다음 네트워킹으로 넘어가서 방화벽 규칙을 모든 ip를 허용으로 선택한다.
> 5. 다음 만들기를 클릭하여 데이터베이스를 만든다.
> 6. 데이터베이스에 접속(터미널에서 `mysql -u do -h ddoo.mysql.database.azure.com -P 3306 -p` 명령어 실행 및 패스워드 `1q2w3e4r5t!` 작성)하여 `create database do;` 명령을 이용해 do 스키마를 생성한다.

### App Service 배포

1. Microsoft Azure에서 App Services 만들기를 누르고, `웹 앱`을 선택한다.
2. 인스턴스 이름은 `dddo`를 입력하고 런타임 스택을 `Node 18 LTS`로 설정한다. `Linux` 운영체제를 사용하고 `Korea Center` 지역을 선택하고 배포로 넘어간다.

<img width="1624" alt="image" src="https://github.com/hackersground-kr/do/assets/80818534/efe640d1-30c3-4f49-8711-b4e5cde38210">
 
4. Github Action 설정을 사용으로 바꾸고 세부 정보의 조직, 리포지토리에는 `do`, 분기에는 `main`을 입력한다.
5. 그리고 만들기를 눌러 App Service를 생성한다. (참고로, App Service를 생성 후 첫 github action을 실행할 때에는 배포에 실패한다.)
6. 새로 생성된 `main-dddo.yml` 파일에서 `Deploy to Azure Web App` 스텝의 with 옵션의 `publish-profile`의 값을 복사한다.
7. `main-dddo.yml` 파일의 내용을 아래 yml 파일의 전체 내용으로 대체한다. (덮어쓰기)

```yml
# Docs for the Azure Web Apps Deploy action: https://github.com/Azure/webapps-deploy
# More GitHub Actions for Azure: https://github.com/Azure/actions

name: Build and deploy Node.js app to Azure Web App - do

on:
  push:
    branches:
      - main
  workflow_dispatch:

jobs:
  build:
    runs-on: ubuntu-latest
    defaults:
      run:
        working-directory: ./do-backend

    steps:
      - uses: actions/checkout@v2

      - name: Set up Node.js version
        uses: actions/setup-node@v1
        with:
          node-version: "18.x"

      - name: npm install, build
        run: |
          npm install --legacy-peer-deps
          npm run build --if-present

      - run: |
          zip -r node-app.zip .
      - name: Upload artifact for deployment job
        uses: actions/upload-artifact@v2
        with:
          name: node-app
          path: do-backend/node-app.zip

  deploy:
    runs-on: ubuntu-latest
    needs: build
    environment:
      name: "Production"
      url: ${{ steps.deploy-to-webapp.outputs.webapp-url }}

    steps:
      - name: Download artifact from build job
        uses: actions/download-artifact@v2
        with:
          name: node-app
      - run: |
          unzip node-app.zip
          rm node-app.zip

      - name: "Deploy to Azure Web App"
        id: deploy-to-webapp
        uses: azure/webapps-deploy@v2
        with:
          app-name:
          slot-name: "Production"
          publish-profile:
          package: .
```

8. 위 6번에서 복사한 `publish-profile`의 값을 새로운 내용으로 대체한 `main-dddo.yml`의 `Deploy to Azure Web App` 스텝의 `publish-profile: ` 뒤에 추가해준다. (값을 할당)
9. `main-dddo.yml` 파일에 `Deploy to Azure Web App` 스텝의 with 옵션의 `app-name: ` 뒤에 `dddo`를 추가해준다. (값을 할당)
10. do-backend/src/config/config.ts을 해당 내용으로 대체한다.

```typescript
export const config = {
  port: 8080,
  baseUrl: "dddo.azurewebsites.net",
  DBHost: "ddoo.mysql.database.azure.com",
  DBPort: 3306,
  DBUsername: "do",
  DBPassword: "1q2w3e4r5t",
  DBDatabase: "do",
};
```

11. 이후 `git add .`, `git commit -m "Update"`, `git push origin main`을 실행하여 github action이 동작하도록 한다.

위 과정을 수행하면 github action 작업 3개 중 하나(main-dddo.yml)가 완료될 것이다.

12. Azure Portal의 dddo App Service에 들어가서  `개발 도구` -> `SSH`에 접속하여, `cd site`, `cd wwwroot`, `rm -rf node_modules`를 차례로 실행하고 기다린 후, `npm i` 커맨드를 실행한다.
13. Github에서 해당 레포지토리의 성공한 github action 작업에 들어가서, `Re-run all jobs` 버튼을 눌러 다시 deploy한다.

위 작업을 완료하면 https://dddo.azurewebsites.net/ 로 서버가 띄워진다.

# Android 배포 설명서

## 사전 준비 사항

- **Github** Account
- **Appcenter** Account
- `do` repository code (fork)

### Appcenter에 내 앱 추가하기

Appcenter에 로그인할 경우의 아래의 화면이 보입니다.

- `Add new` or `Add new app` 버튼을 클릭합니다.
  <img width="1552" alt="스크린샷 2023-06-22 오후 9 56 33" src="https://github.com/hackersground-kr/do/assets/80940200/f1c7c462-233f-4d71-8529-84c879e24340">

화면 우측의 창에서 아래 사진과 같이 입력 및 선택합니다.
<img width="1552" alt="스크린샷 2023-06-22 오후 10 03 11" src="https://github.com/hackersground-kr/do/assets/80940200/7695c19f-80f0-4152-8e36-f2a1be91811c">

- `App Name` : 서비스 이름을 입력합니다.
- `Icon` : 원하는 아이콘을 넣습니다.
- `Release Type` : 현재 상황에 해당하는 옵션을 선택합니다.
- `OS` : Android를 배포하기에 Android를 선택합니다.
- `Platform` : 본 문서는 Java/Kotlin 프로젝트를 기반으로 작성되었습니다.

자동으로 Overview 페이지로 넘어가며 fork된 프로젝트는 지시된 세팅이 완료된 상태입니다.

단 하나의 사항만 적용하면 쉽게 아래 과정을 완수할 수 있습니다.
<img width="1552" alt="스크린샷 2023-06-22 오후 10 06 42" src="https://github.com/hackersground-kr/do/assets/80940200/462f2a13-1b5d-42a7-8428-b45379bc49f5">

- 페이지를 스크롤하여 `Integrate app secret` 을 찾습니다.

    <img width="720" alt="new1" src="https://github.com/hackersground-kr/do/assets/80940200/7e10710a-8530-4827-b715-bd3ca3c1713b">

  아래 `secret` 문자열을 복사하여 fork한 코드에 넣어줍니다.

  ```
  do/do-android/app/src/main/java/kr/hackersground/wsi/dodo/features/main/view/MainActivity.kt
  ```

  위 경로의 `MainActivity.kt` 파일로 접속합니다.

  ```kotlin
  @AndroidEntryPoint
  class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main) {

      override val viewModel: MainViewModel by viewModels()
      private lateinit var navController: NavController

      override fun start() {
          AppCenter.start(
              application,
              "e59cdf02-8630-4ebc-8201-4fbb6789e5ba", // <- 변경해 주세요!!
              Analytics::class.java,
              Crashes::class.java
          )
          setNavigation()
      }

      private fun setNavigation() {
          val navHostFragment = supportFragmentManager.findFragmentById(R.id.fcv_main) as NavHostFragment
          navController = navHostFragment.navController
          binding.bnvMain.setupWithNavController(navController)
      }

      fun setNavVisible(demand: Boolean) {
          binding.bnvMain.visibility = if (demand) View.VISIBLE else View.GONE
      }
  }
  ```

  위 문자열을 복사한 `secret`으로 변경합니다.

  Github 저장소에 저장(push)합니다.

  ## 시작하기

  ### 1. App API Tokens 발급 받기

  Appcenter에서 `Setting`으로 접속합니다.

    <img width="1552" alt="new2" src="https://github.com/hackersground-kr/do/assets/80940200/0203525d-98ba-4e53-bacb-5a15b1baa0ed">

  아래로 스크롤하여 `App API Tokens`를 클릭합니다.

    <img width="1552" alt="new3" src="https://github.com/hackersground-kr/do/assets/80940200/5ac3223b-3398-417e-b8ff-0e780336c2b9">

  `New API Token` 버튼을 클릭한 후 정보를 입력합니다.

    <img width="1552" alt="new4" src="https://github.com/hackersground-kr/do/assets/80940200/36973324-dfe7-4a00-a723-6118672ef068">

  위 사진과 같이 설명과 권한을 입력 후 `Add new API token`을 클릭합니다.

    <img width="1552" alt="new5" src="https://github.com/hackersground-kr/do/assets/80940200/cc7f84b1-15b4-4ed8-b9e7-0c1ab263567d">

  `API token`을 복사합니다.

  ### 2. sercret.APP_CENTER_TOKEN 설정하기

  Github에서 fork한 레포지토리로 접속합니다.

  **Setting** → **Secrets and Variables → Actions 로 들어갑니다.**

    <img width="1552" alt="new6" src="https://github.com/hackersground-kr/do/assets/80940200/4434de7d-ae4b-46d2-80a5-89ec53679b82">
    
    우측 `New repository secret` 버튼을 클릭합니다.
    
    <img width="1552" alt="new7" src="https://github.com/hackersground-kr/do/assets/80940200/e3a0b82c-0a4f-4968-802f-fabd00f3ef68">
    
    Name에 APP_CENTER_TOKEN을 입력한 후 Secret에 복사한 Token Api를 입력합니다.
    
    그리고 Add secret 버튼을 클릭합니다.
    
    ### 3. `aos_release.yml` 파일 수정하기
    
    `.github/workflows/aos_release.yml` 경로의 `yml` 파일을 수정합니다.
    
    ```yaml
    name: AOS Release
    
    on: [push]
    
    jobs:
      apk:
          name: Generate APK
          runs-on: ubuntu-latest
          
          steps:
            - uses: actions/checkout@v1
            - name: set up JDK 17
              uses: actions/setup-java@v1
              with:
                java-version: 17
            - name: Build debug APK
              run: bash ./gradlew assembleDebug --stacktrace
              working-directory: ./do-android
            - name: Upload APK
              uses: actions/upload-artifact@v1
              with:
                name: app
                path: do-android/app/build/outputs/apk/debug
            - name: upload artefact to App Center
              uses: wzieba/AppCenter-Github-Action@v1
              with:
                appName: appName 변경하기
                token: ${{secrets.APP_CENTER_TOKEN}}
                group: Collaborators
                file: do-android/app/build/outputs/apk/debug/app-debug.apk
                notifyTesters: true
                debug: false
    ```
    
    하단의 `appName` 항목을 변경해야 합니다.
    
    > appName: 계정이름/서비스이름
    > 
    
    ex) appName: mooooong/do | 아래 사진과 같이 작성합니다.
  <img width="596" alt="스크린샷 2023-06-23 오전 5 20 11" src="https://github.com/hackersground-kr/do/assets/80940200/8558bb36-87ad-4b3e-86a7-f4a6035bd8d0">

    
    변경사항을 commit → push 합니다.
    
    <aside>
    👻 Push와 동시에 Github Action이 실행되며 실행이 정상적으로 종료된 후 Appcenter를 확인하면 정상적으로 배포된 모습을 볼 수 있습니다.
    </aside>
    
    <img width="1552" alt="new8" src="https://github.com/hackersground-kr/do/assets/80940200/c4abdf50-ac52-4bec-8bbb-1b863b591ab4">
    
    위 `Download` 버튼 옆의 아이콘을 클릭하여 다운받을 수 있습니다.
    자세한 다운로드 방법은 아래와 같습니다.
    <img width="1552" alt="스크린샷 2023-06-23 오전 5 21 41" src="https://github.com/hackersground-kr/do/assets/80940200/a90c8a54-f457-44c5-9d45-f00fd043c123">
    appcenter -> 본인의 프로젝트 -> distribute -> Releases 에서 위 사진과 같이 박스 모양의 아이콘이 있는 Bar를 클릭합니다.
    <img width="1552" alt="스크린샷 2023-06-23 오전 5 24 07" src="https://github.com/hackersground-kr/do/assets/80940200/cc1b7765-e07a-4460-b999-951477fdcbfe">
    위와 같은 화면이 나오는데 우측 상단의 설치 아이콘을 클릭합니다.
    그 후 등장하는 QR 코드를 찍으면 무사히 apk 파일이 설치됩니다.
    <img width="408" alt="스크린샷 2023-06-23 오전 5 25 15" src="https://github.com/hackersground-kr/do/assets/80940200/c903623e-c7d6-4f9b-ae79-6ea47490b066">

   App Center에서 아래와 같이 서비스가 구성되었음을 확인할 수 있습니다!
   <img width="1552" alt="스크린샷 2023-06-23 오전 5 53 31" src="https://github.com/hackersground-kr/do/assets/80940200/7319f30c-fc80-4304-bb4d-75f224688a05">
