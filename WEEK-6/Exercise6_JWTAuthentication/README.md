# Exercise 6 — Create Authentication Service that Returns JWT

## What this covers
- `pom.xml` — adds `spring-boot-starter-security` + `jjwt` (0.9.1)
- `SecurityConfig.java` — in-memory users (`admin`/`pwd` role ADMIN,
  `user`/`pwd` role USER); `/countries/**` and `/country` require ROLE_USER,
  `/hello` is public, `/authenticate` allows either role
- `AuthenticationController.java`:
  1. Reads the `Authorization` header (`Basic base64(user:pwd)`)
  2. Decodes it to extract the username
  3. Generates a JWT (HS256, 20-minute expiry) via `jjwt`
  4. Returns `{"token": "..."}`

## How to run
```bash
mvn clean package
mvn spring-boot:run
```

## Test it
```bash
# Without credentials -> 401 Unauthorized
curl -i http://localhost:8090/countries

# With credentials -> 200 OK, country list
curl -u user:pwd http://localhost:8090/countries

# Get a JWT
curl -s -u user:pwd http://localhost:8090/authenticate
# {"token":"eyJhbGciOiJIUzI1NiJ9....."}
```

Paste the returned token into https://jwt.io to decode and inspect its
header/payload — `sub` will be `user`, plus `iat` (issued-at) and `exp`
(expiry, 20 minutes later).
