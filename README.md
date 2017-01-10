# Reflection

Java反射封装库，简化反射使用！可完美反射各种修饰符修饰的属性-方法-对象等！

## 效果
![](https://github.com/wzgiceman/Reflection/blob/master/gif/reflect.gif)

## 依赖

```java

allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

```java
dependencies {
	        compile 'com.github.wzgiceman:Reflection:1.0'
	}

```

如果第一次依赖下载不成功，需要科学上网！

## 使用

* ReflectUtils.on 包裹一个类或者对象，表示在这个类或对象上进行反射，类的值可以使Class,也可以是完整的类名（包含包名信息）
* ReflectUtils.create 用来调用之前的类的构造方法，有两种重载，一种有参数，一种无参数
* ReflectUtils.call 方法调用，传入方法名和参数，如有返回值还需要调用get
* ReflectUtils.get 获取（field和method返回）值相关，会进行类型转换，常与call和field组合使用
* ReflectUtils.field 获取属性值相关，需要调用get获取该值
* ReflectUtils.set 设置属性相关。

## 案例

```java
 User user;

    /*反射初始化对象*/
    @OnClick(value = R.id.btn_craete)
    void onBtnCraeteClick(View view) {
        user = ReflectUtils.on(User.class).create("wzg").get();
        mTvMsg.setText(user.getMsg());
    }

    /*反射方法*/
    @OnClick(value = R.id.btn_get)
    void onBtnGetClick(View view) {
        if(user==null){
            Toast.makeText(this,"先初始化对象",Toast.LENGTH_SHORT).show();
            return;
        }
        String msg = ReflectUtils.on(user).call("setName","wzg_call").call("getName").get();
        mTvMsg.setText(msg);
    }

    /*反射属性*/
    @OnClick(value = R.id.btn_set)
    void onBtnSetClick(View view) {
        if(user==null){
            Toast.makeText(this,"先初始化对象",Toast.LENGTH_SHORT).show();
            return;
        }
        /*先设置在获取*/
        String msg = ReflectUtils.on(user).set("name", "wzg_set").field("name").get();
        mTvMsg.setText(msg);
    }

```

更多用法请下载demo查看

## QQ交流群

>[聊聊人生，谈谈梦想，交流技术，你可以在这里找到我](https://github.com/wzgiceman/Rxbus/blob/master/gif/qq.png)