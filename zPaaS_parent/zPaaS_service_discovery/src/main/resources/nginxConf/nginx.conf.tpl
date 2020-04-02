
#user  nobody;
worker_processes  6;

#error_log  logs/error.log;
#error_log  logs/error.log  notice;
#error_log  logs/error.log  info;

#pid        logs/nginx.pid;


events {
    worker_connections  1024;
}


http {
    include       mime.types;
    default_type  application/octet-stream;

    sendfile        on;
    #tcp_nopush     on;

    #keepalive_timeout  0;
    keepalive_timeout  65;

    gzip_static on;
    gzip_proxied expired no-cache no-store private auth;
    gzip_disable msie6;
    gzip  on;
    gzip_min_length 1k;
    gzip_buffers 4 16k;
    gzip_http_version 1.1;
    gzip_comp_level 3;
    gzip_types text/plain application/x-javascript application/javascript text/css text/javascript application/x-httpd-php image/jpeg image/gif image/png;
    gzip_vary on;
    
{{RANGE}}
	include {{configPath}}/*.upstream.conf;
{{END}}
	
    server {
        listen       80;
        server_name  121.31.32.99;
        client_max_body_size 16M;
        client_header_buffer_size 128k;
        large_client_header_buffers 4 128k;
        proxy_request_buffering off;
        
        if ( $host ~* ^(.+)\.pecan\.yunjiacloud\.com ) {
            set $subdomain $1;
            rewrite ^(.*)$ http://pecan.yunjiacloud.com/$subdomain permanent;
        }
	
{{RANGE}}
		include {{configPath}}/*.localtion.conf;
{{END}}
	
    }
}