#Servidor de imagenes

docker run -p 8181:80 -d aesveln/imageserver:latest httpd -D FOREGROUND
