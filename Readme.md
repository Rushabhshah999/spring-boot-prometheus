docker compose up --build -d -- run this

http://localhost:8080/hello -- end point

http://localhost:8080/actuator/prometheus -- prometheus data

check below on logs and that means it's working

JVM metrics
Look for:
jvm_memory_used_bytes → heap usage
jvm_threads_live → active threads
jvm_gc_* → garbage collection counts & times
HTTP metrics
Look for:
http_server_requests_seconds_count → total number of requests per endpoint
http_server_requests_seconds_sum → total time spent processing requests
http_server_requests_seconds_max → longest request time

http://localhost:3000/ -- grafana login using admin/admin

create new dashboard and new datasource as prometheus. prometheus url will
http://prometheus:9090

