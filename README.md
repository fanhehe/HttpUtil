# ShopUtil

[![](https://jitpack.io/v/fanhehe/ShopUtil.svg)](https://jitpack.io/#fanhehe/ShopUtil)

## 提供功能：

 通用工具组件，封装的原因来自于[Shop应用](https://github.com/fanhehe/Shop)的SOA经常需要不同业务间打交道，因此封装通用的方法。

1. 前后端交互，约束协议**IResult**。
2. java.time的通用方法的二次封装。
3. 基于`httpclient`及`fluent-hc`的业务封装的通用HttpClient工具。


> Shop服务地址: [https://github.com/fanhehe/Shop](https://github.com/fanhehe/Shop)

## 要求

- Java 8

## 安装

### maven

```xml

<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependency>
    <groupId>com.github.fanhehe</groupId>
    <artifactId>ShopUtil</artifactId>
    <version>[1.0,)</version>
</dependency>

```

### gradle

```gradle

repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.fanhehe:ShopUtil:[1.0,)'
}

```

## 使用示例

注：前后端通信标准接口格式如下

```json
{
    "code": 0,
    "message": "",
    "data": null
}
```

> 当且仅当code == 0时，才代表业务逻辑上的成功。

```java

import java.util.Map;
import java.util.HashMap;
import com.fanhehe.util.http.HttpUtil;
import com.fanhehe.util.result.IResult;
import com.fanhehe.util.result.InvokeResult;

// Model: 可以自行补充 getter/setter
class Model {
    private int id;
    private String name;
    private String pasword;
}

// Service
interface IService {
    IResult<Model> getVisit(Model model);
    IResult<Model> postVisit(Model model);
}

class Service extends HttpUtil<Model> implements IService {

    @Override
    public String getEndpoint() {
        return "127.0.0.1:8080"; // 指定IP + PORT
    }

    @Override
    public IResult<Model> getVisit(Model model) {

        Map<String, String> params = new HashMap<>();

        params.put("id", model.getId());
        params.put("name", model.getName());
        params.put("password", model.getPassword());

        return this.get("/api/message/captcha/email/send", params);
    }

    @Override
    public IResult<Model> postVisit(Model model) {

        Map<String, String> params = new HashMap<>();
        Map<String, String> headers = new HashMap<>();

        params.put("id", model.getId());
        params.put("name", model.getName());
        params.put("password", model.getPassword());

        headers.put("Accept", "application/json");

        return this.post("/api/message/captcha/email/send", params, headers);
    }
}


class Main {
    public static void invoke() {
        IService service = new Service();

        IResult<Model> result = service.getVisit(new Model());

        if (result.isSuccess()) {
            System.out.println("调用成功: " + result.getMessage());
        }

        // or

        if (result.isFailure()) {
            System.out.println("调用失败:" + result.getMessage());
        }
    }
}

```

## 测试

```bash
mvn test
```

## 版本

```
### 1.0.0

+ 初始化
```
