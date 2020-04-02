global
    log        		127.0.0.1 local2
    chroot      	/var/lib/haproxy
    pidfile    		/var/run/haproxy.pid
    maxconn    		4000
    #user        	haproxy
    #group      		haproxy
    daemon
    stats socket 	/var/lib/haproxy/stats
    
defaults
    mode                    http
    log                    	global
    option                  httplog
    option                  dontlognull
    option 					http-server-close
    option 					forwardfor      except 127.0.0.0/8
    option                  redispatch
    retries                	3
    timeout 				http-request    10s
    timeout 				queue         	1m
    timeout 				connect        	10s
    timeout 				client          1m
    timeout 				server          1m
    timeout 				http-keep-alive 10s
    timeout 				check          	10s
    maxconn                	3000
    
listen stats
    mode 			http
    bind 			0.0.0.0:1080
    stats 			enable
    stats 			hide-version
    stats 			uri    		/haproxyadmin?stats
    stats 			realm  		Haproxy\ Statistics
    stats 			auth    	admin:admin
    stats 			admin 		if TRUE
    
frontend http-in
    bind 			*:80
    mode 			http
    log 			global
    option 			httpclose
    option 			logasap
    option 			dontlognull
    capture 		request  header Host len 20
    capture 		request  header Referer len 60
{{RANGE}}    
    acl 	{{aclRule}}      path_beg      -i {{frontContext}}
{{END}}
{{RANGE}}      
    use_backend {{backend}} 	if 	{{aclRule}} 
{{END}}
 
{{RANGE}}   
backend {{backend}}
    balance roundrobin
{{FOREACH_serverInsts}}    server {{serverName}}{{INDEX}} {{backendUrl}} check maxconn 1000

{{END}}
