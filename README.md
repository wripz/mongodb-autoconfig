# mongodb-autoconfig
MongoDB 引入后自动配置，配置好yml，项目中直接注入MongoTemplate即可使用

yml如下
app:
  project: compoentTest
  mongodb:
    host: ip
    port: port
    database: database name
    username: username
    password: password

spring:
  profiles:
    include:
    - mongodb
    
    
    
service中直接注入
@Autowired
private MongoTemplate mongoTemplate;

即可使用
