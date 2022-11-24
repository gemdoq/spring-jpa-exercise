# SPRING_JPA_EXERCISE
- - -
## 배포
```shell
sudo sh deploy.sh {db.url} {db.username} {db.password} {port} {imagename} {imageversion}
```
- - -
## EC2 접속주소
```shell
ec2-43-201-101-29.ap-northeast-2.compute.amazonaws.com:{port}
```
- - -
## Endpoint
- - -
### Book 전체 조회
GET `/api/v1/books`

### Book 단일 조회
GET `/api/v1/books/{id}`

### 병원 Review 등록
POST `/api/v1/hospitals/{id}/reviews`

### Review 단일 조회
GET `/api/v1/reviews/{id}`

### 병원 Review 전체 조회
GET `/api/v1/hospitals/{id}/reviews`

### 병원 정보와 함께 Review 전체 조회
GET `/api/v1/hospitals/{id}`
- - -