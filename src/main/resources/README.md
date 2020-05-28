#首次提交 展示页面 （有邮件发送）

###阿里云禁用了25端口
```markdown
#mail配置
# 设置邮箱主机
spring.mail.host=smtp.163.com
#设置端口为465，因为阿里云的25端口被禁用了
spring.mail.port=465
spring.mail.properties.mail.smtp.socketFactory.port = 465
spring.mail.properties.mail.smtp.socketFactory.class = javax.net.ssl.SSLSocketFactory
spring.mail.properties.mail.smtp.socketFactory.fallback = false

# 设置用户名
spring.mail.username=yuanxueba_2018@163.com
# 设置密码，该处的密码是邮箱开启SMTP的授权码而非邮箱登录密码
spring.mail.password=********

# 设置是否需要认证，如果为true,那么用户名和密码就必须的，
# 如果设置false，可以不设置用户名和密码，当然也得看你的对接的平台是否支持无密码进行访问的。
spring.mail.properties.mail.smtp.auth=true

# STARTTLS[1]  是对纯文本通信协议的扩展。它提供一种方式将纯文本连接升级为加密连接（TLS或SSL），而不是另外使用一个端口作加密通信。
spring.mail.properties.mail.smtp.starttls.enable=true
spring.mail.properties.mail.smtp.starttls.required=true

```
