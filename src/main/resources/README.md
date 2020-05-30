#首次提交 展示页面 （有邮件发送）

#设置端口为465，因为阿里云的25端口被禁用了
spring.mail.port=465
spring.mail.properties.mail.smtp.socketFactory.port = 465
spring.mail.properties.mail.smtp.socketFactory.class = javax.net.ssl.SSLSocketFactory
spring.mail.properties.mail.smtp.socketFactory.fallback = false
## 邮件系统
spring.mail.host=smtp.163.com
spring.mail.username=***6@163.com
spring.mail.password=**
spring.mail.default-encoding=UTF-8
## 邮件发送者 表明发送者（可以不写，个人喜好）
mail.fromMail.addr=15518901416@163.com
##如果不加下面3句,会报530错误
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
spring.mail.properties.mail.smtp.starttls.required=true


```$xslt
static目录下面添加一个error目录，目录中添加404.html这样
如果有未知的请求就会统一到达这个页面中了
```

```$xslt
2020年5月30日
准备配置一下shiro进行权限判断

```