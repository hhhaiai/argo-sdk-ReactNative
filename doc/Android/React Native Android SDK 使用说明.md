# React Native Android SDK 使用说明

## 1. 集成准备

### 1.1 搭建`React Native`环境
参照`React Native` 官方文档 [搭建开发环境](https://reactnative.cn/docs/getting-started/)

### 1.2 易观SDK配置<span id = "SDKSetting">
参照 [Android SDK 使用说明](https://ark.analysys.cn/docs/v2/manual/sdk_android.html)，完成第一部分《集成准备》及第二部分《SDK初始化》工作。

## 2. AndroidStudio中配置<span id = "moduleImport">

### 2.1 java文件复制
* 将`RNAnalysysAgentModule.java`和`RNAnalysysAgentPackage.java`两个文件Copy到工程中。

### 2.2 Application 中添加调用

* 将ReactPackage的实现类RNAnalysysAgentPackage，添加到ReactNativeHost中，示例如下：
    
    ```Java
    private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
        @Override
        public boolean getUseDeveloperSupport() {
          return BuildConfig.DEBUG;
        }
    
        @Override
        protected List<ReactPackage> getPackages() {
          return Arrays.<ReactPackage>asList(
              new MainReactPackage(), new RNAnalysysAgentPackage()
          );
        }
    
        @Override
        protected String getJSMainModuleName() {
          return "index";
        }
      };
    ```
    
    
## 3. React Native 中 JS 使用
### 3.1 js 获取 Analysys 模块
在 js 中获取 `RNAnalysysAgentModule` 模块

```js
//  易观统计模块
import { NativeModules } from "react-native";

const RNAnalysysAgentModule = NativeModules.RNAnalysysAgentModule;
```

### 3.2 接口调用
#### 3.2.1 接口调用方法

在相关需要进行统计的部分进行埋点。以点击购买事件为例：

```js
//  事件名称为：buy(购买)  事件附加属性为：ptype(产品分类): iPhone; model(型号): iPhone X
var properties = {
    'ptype': 'iPhone',
    'model': 'Apple iPhoneX'
}
RNAnalysysAgentModule.track('buy',properties)
```

#### 3.2.2 其他接口调用

其他接口调用参考 [4.2 demo 示例](#demo)。

## 4. 运行 Demo 工程
### 4.1 搭建 React Native 开发环境

根据React Native官方文档 《搭建开发环境》 中 [安装依赖](https://reactnative.cn/docs/getting-started/#%E5%AE%89%E8%A3%85%E4%BE%9D%E8%B5%96)

### 4.2 Demo 示例<span id = "demo">
<!--
1. 创建工程
$ react-native init AnalysysReactDemo
2. 添加java文件RNAnalysysAgentPackage.java和RNAnalysysAgentModule.java
3. 在Application中添加 RNAnalysysAgentPackage
4. 复制src文件夹到项目目录
5. 将`项目/index.js`文件内App指向，由`import App from './App';`修改为`import App from './src/index';`
-->
1. 打开下载安装包
2. 进入 AnalysysReactDemo 目录下，执行命令：

    ```shell
    $ npm install  //  添加依赖
    ```
3. Demo调用示例
    * 文件位置：
        AnalysysReactDemo/src/public：
    * 接口调用
        在pageView.js、profile.js、reset.js、superProperty.js、track.js 文件中查看相应的Demo调用示例
4. 运行demo
     进入AnalysysReactDemo目录下，执行命令：

    ```
    react-native run-android //使用命令运行android项目
    ```
    或 执行命令：
    
    ```
    react-native start // 启动服务
    ```
    然后在AndroidStudio中启动Android项目。
    
<!--
    * 完成 [1.2 易观SDK配置](#SDKSetting)
    * 将 SDK 文件夹下 `RNAnalysysAgentModule.h` 和 `RNAnalysysAgentModule.m` 导入工程参照[2.1](#moduleImport)
    * 完成 [2.2 Application中添加调用](#moduleRegist)
    * 运行AndroidStudio，点击Demo按钮，在Logcat中查看日志信息
-->



