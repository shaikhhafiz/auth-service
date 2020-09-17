To get access token and refresh token use below curl
curl -X POST http://erp:secret@localhost:8084/oauth/token  -H 'Content-Type: application/x-www-form-urlencoded' -d 'grant_type=password&username=admin&password=jwtpass'

To validate access token use below curl
curl -X POST http://localhost:8084/oauth/check_token/?token=<access_token>