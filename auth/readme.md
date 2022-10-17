# Authentications


部分可以选择不实现 (例如使用第三方auth, Google Identity Platform, Pocketbase)

**使用 JWT Token**

### 可选实现
* createUser
* loginWithEmailPassword
* loginWithOAuth
* passwordLess etc.

### 必须实现
* verifyToken