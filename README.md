# 实验二 UI控件代码生成以及MVC

姓名：张雨鑫  学号：2024110548

包名：`cn.edu.sicnu.stu.zhangyuxin.second`

应用标题：张雨鑫2024110548

## 构建与运行
Android Studio 打开本目录。使用 JDK 17 或更高版本，Android SDK 37、Build Tools 36.0.0。运行 app 模块；也可执行 `gradlew.bat assembleDebug`。

## 实验功能
- 区1输入内容后点击添加，使用 Kotlin 动态创建 TextView，ScrollView 嵌套 LinearLayout 支持滚动。支持清空、空输入校验和状态保存。
- 区2选择学习方向并查询推荐，提供移动应用、Web、数据分析与人工智能、系统与算法四类方向。
- MVC：布局 XML 为 View，MainActivity 为 Controller，ProgramAdviser 为 Model。
- 界面标题、按钮、提示、列表和推荐文本全部来自字符串资源。

## 文件
`app/src/main/java/cn/edu/sicnu/stu/zhangyuxin/second/`：控制器与模型。
`app/src/main/res/layout/activity_main.xml`：界面。
`app/src/main/res/values/strings.xml`：字符串资源。
