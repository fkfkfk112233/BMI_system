# BMI Calculator System

使用 Java Swing 開發的 BMI（Body Mass Index）計算系統，採用 MVC（Model-View-Controller）架構設計，提供圖形化介面供使用者輸入資料並計算 BMI 指數。

## 專案功能

* 輸入姓名
* 選擇性別
* 輸入身高（公分）
* 輸入體重（公斤）
* 自動計算 BMI
* 顯示 BMI 判定結果
* 顯示建立日期
* 即時顯示系統時間
* 清除資料功能
* 列印結果功能
* 離開系統功能

---

## BMI 判定標準

| BMI值        | 判定結果 |
| ----------- | ---- |
| BMI < 18.5  | 過輕   |
| 18.5 ~ 23.9 | 正常   |
| 24 ~ 26.9   | 過重   |
| BMI ≥ 27    | 肥胖   |

---

## 專案架構

```text
BMI_system
│
└── src
    └── com
        ├── BMI_UI.java
        ├── BMI_controller.java
        └── BMI_model.java
```

### BMI_UI.java

負責：

* 建立 Swing 視窗介面
* 接收使用者輸入
* 顯示 BMI 計算結果
* 處理按鈕事件

### BMI_controller.java

負責：

* BMI 計算邏輯
* BMI 結果判斷

主要方法：

```java
calcBMI(double height, double weight)
```

```java
getResult(double bmi)
```

### BMI_model.java

負責：

* 儲存使用者資料
* 封裝 BMI 相關欄位

資料欄位：

```java
name
height
weight
bmi
```

---

## 使用技術

* Java
* Java Swing
* Eclipse IDE
* WindowBuilder
* MVC Design Pattern

---

## 執行畫面流程

1. 輸入姓名
2. 選擇性別
3. 輸入身高
4. 輸入體重
5. 點擊【計算】
6. 顯示 BMI 結果

範例：

```text
姓名：王小明    性別：男
身高：170.0    體重：65.0
BMI：22.49     結果：正常

建立時間：2026-06-23
```

---

## 開發環境

| 項目            | 版本                      |
| ------------- | ----------------------- |
| JDK           | 8+                      |
| Eclipse       | IDE for Java Developers |
| WindowBuilder | 最新版                     |

---

## 未來可擴充功能

* BMI 歷史紀錄
* 資料庫儲存功能（MySQL）
* 使用者登入系統
* 圖表分析（Chart）
* 健康建議功能
* 匯出 PDF 報表
* 雲端資料同步

---

## 作者

GitHub：fkfkfk112233

Java Swing 練習專案
