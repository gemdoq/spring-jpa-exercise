Book Store

## EC2 접속주소

```shell
ec2-43-201-101-29.ap-northeast-2.compute.amazonaws.com:{port}/api/v1/books
```


## 배포

```shell
sudo sh deploy.sh {db.url} {db.username} {db.password} {port} {imagename} {imageversion}
```

## Endpoint
### Book 전체 조회
`/api/v1/books`

### Book 단일 조회
`/api/v1/books/{id}`