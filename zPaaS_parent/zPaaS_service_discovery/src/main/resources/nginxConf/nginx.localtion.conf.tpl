{{RANGE}}
        location {{frontContext}}/ {
            root   html;
            index  index.html index.htm;
            proxy_store off;
            proxy_redirect http:// $scheme://;
            proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
            proxy_set_header X-Real-IP $remote_addr;
            proxy_set_header Host $host;
            proxy_set_header Upgrade $http_upgrade;
            proxy_set_header Connection "upgrade";
            proxy_next_upstream {{proxy_next_upstream}};
            proxy_read_timeout {{proxy_read_timeout}};
            proxy_connect_timeout {{proxy_connect_timeout}};
            proxy_send_timeout {{proxy_send_timeout}};
            proxy_pass http://{{backend}}/{{deployName}}/;
        }
{{END}}