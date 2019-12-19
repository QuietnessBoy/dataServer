## moco server 

#### 说明
moco server主要为了解决在无接口依赖情况下设定的虚拟服务器,通过虚拟接口拿到数据去使用
(详情请问访问官网)

#### 使用方法
1. 下载moco-runner-xxx-standalone.jar  (以提供至moco文件夹)
2. 创建xxx.json格式文件,格式如下:

带参接口URL: http://localhost:5638/user/getUser?name=jack 
格式:{ 
     "request" : { 
        "uri" : "/user/getUser",
         "queries": { "name":"jack" } 
      },
      "response" : {
           "text" : "Hey. I'm jack" 
         }  
     }

3. 终端输入命令
    java -jar moco-runner-xxx-standalone.jar start -p port -c xxx.json
    
    注: port表示mock服务被监听的端口.url对应指定的requestMappering即可
