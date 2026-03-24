# MyNote

Local Web筆記空間📖，提供使用者登入與建立、編輯、刪除筆記；  
筆記依建立日期排序，儲存同步顯示於左側清單，並更新修改日期。

### 初始化環境
1. 使用MySQL，匯入 *[mynote.sql](https://github.com/persimmon0/MyNote/blob/main/mynote.sql)* (內含預設使用者與筆記資料)
2. 於 *[application.properties](https://github.com/persimmon0/MyNote/blob/main/MyNote/src/main/resources/application.properties)* 修改資料庫連線設定(username,password)
3. 執行專案
4. 瀏覽器輸入 `http://localhost:8080/login` 進入

### 專案架構
```
採用 Spring Boot + MyBatis + Thymeleaf
```
***
登入頁
<img width="1920" height="988" alt="01" src="https://github.com/user-attachments/assets/c2051384-9a6f-4582-a1fd-37b7a1a775d3" />
筆記頁
<img width="1920" height="986" alt="02" src="https://github.com/user-attachments/assets/4a8c8850-b928-4cd3-8b37-6754f6f33be6" />

