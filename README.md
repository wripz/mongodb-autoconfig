MongoDB 引入后自动配置，配置好yml，项目中直接注入MongoTemplate即可使用

<pre><code>
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
</code></pre>

即可使用

项目启动时会打印日志“已连接到MongoDB，database：database name”
