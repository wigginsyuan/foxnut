# foxnut接口自动化测试框架

#### 项目介绍

众泽睿诚 接口自动化测试框架

#### 软件架构

maven + testNg + httpclient + jenkins


#### 初始化项目

1. git clone git@git.zz.com:qa/foxnut.git
2. idea打开项目并修改Maven配置
2. 通过maven安装jar包
3. 修改org.zzrc.conf.Constant文件中参数配置

#### 使用说明

1. 本地调试直接运行test代码目录下用例即可
2. mvn clean test跑testNg.xml下所有用例
3. 修改testNg.xml中class可自定义测试套件
4. 通过jenkins任务集成此项目

#### 日常开发

1. git fetch --all拉去最新代码
2. 新建 qa_yuanweixin_lkxd1146_v1 分支
3. 提交代码到远程分支
4. 合并master

#### 持续集成

http://192.168.15.111:8080/jenkins/view/ZQQS_INTERFACE/job/ZQQS_INTERFACE_START00/

#### 后续功能
1. dubbo接口测试
2. 单元测试