# JavaWeb_userlogin
Login page for java web project

# Servlet

## Servlet的定义

- 是由java编写的服务器端组件
- 运行在服务器上
- 接收服务器端的请求
- 与平台协议无关
- 可拓展

## 请求-响应序列图

![请求响应图](relation.png)

## request对象和response对象

- request对象用来装载请求的信息

  - 常用方法(获得指定参数)：`request.getParameter(key);`

- response用来实现响应动作

⬇<br>
直接响应内容到浏览器

```
Writer out = response.getWriter();
out.print("");
```

⬇<br>
目的：将1.html的内容响应给浏览器。<br>
本质：重新请求服务器，让服务器找到1.html，并将内容响应给浏览器

```
response.sendRedirect("1.html");
```

## 定义Servlet类：

继承HttpServlet, 需要重写service方法

```java
public void service (HttpServletRequest req, HttpServletResponse resp)
    throws IOException, ServletException
{
    ...
}
```

在web.xml中做如下配置并记录映射关系

```xml
<!--
    如果浏览器发送test请求，服务器会创建TestServlet类，调用service方法
       如果服务器能够创建TestServlet对象，前提要求TestServlet是一个Servlet对象
    注意！： url-pattern 指定的请求前一定有 /
-->

<servlet>
        <servlet-name>TestServlet</servlet-name>
        <servlet-class>com.TestServlet</servlet-class>
</servlet>

<servlet-mapping>
    <servlet-name>TestServlet</servlet-name>
    <url-pattern>/test</url-pattern>
</servlet-mapping>
```

## 拓展

### 请求时乱码问题

- get：需要为每一个乱码字符串重新组装。

  ```java
  uname = new String(uname.getBytes("iso8859-1"), "utf-8");
  ```

- post：需要在获取参数之前，使用代码转码

  ```java
  request.setCharacterEncoding("utf-8");
  ```

### 响应时乱码

- 使用`response.getWriter.print();`直接响应中文内容需要在之前附加代码<br>
  表示相应内容以utf-8格式编码

  ```java
  response.setContentType("text/html;charset=utf-8");
  ```

- 使用`response.sendRedirect();`响应指定网页内容，如果网页中存在中文则需要meta标签utf-8解决乱码

### 单例模式

- 内存中对象只有一份
- 不能让所有类都能创建对象。

  1. 定义一个私有构造器
  2. 定义一个私有的静态当前类型变量，并创建对象。
  3. 定义一个共有的静态方法，返回2的变量
