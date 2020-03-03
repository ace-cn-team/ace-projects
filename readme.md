# 项目设计说明 

## 项目命名说明
Base Layer
	BaseService
	DbService
	Mapper

Logic Layer
	LogicService
	Logic
	Base Layer BaseService
### 模块
| 名称模板 | 说明  
| :-  | :- |  
| ace-{领域名称}-projects | 某领域项目聚合模块 |    
| ace-{领域名称}-micro-mybatisPlusDbService-biz | 某领域微服务业务实现层 |
| ace-{领域名称}-micro-mybatisPlusDbService-biz-api | 某领域微服务业务接口层 |
| ace-{领域名称}-micro-mybatisPlusDbService-dal | 某领域微服务资源访问实现层 |
| ace-{领域名称}-micro-mybatisPlusDbService-dal-api | 某领域微服务资源访问接口层 |
| ace-{领域名称}-common | 某领域公共层 |  
| ace-{领域名称}-task | 某领域定时任务 |
| ace-{领域名称}-mq-consumer | 某领域消息消费者 |

### 实例
| 名称模板 | 说明  
| :-  | :- |  
| ace-account-projects | 用户领域项目聚合模块 |    
| ace-account-micro-mybatisPlusDbService-biz | 用户领域微服务业务实现层 |
| ace-account-micro-mybatisPlusDbService-biz-api | 用户领域微服务业务接口层 |
| ace-account-micro-mybatisPlusDbService-dal | 用户领域微服务资源访问实现层 |
| ace-account-micro-mybatisPlusDbService-dal-api | 用户领域微服务资源访问接口层 |
| ace-account-common | 用户领域公共层 |  
| ace-account-task | 用户领域定时任务 |
| ace-account-mq-consumer | 用户领域消息消费者 |

 - ace-demo-projects 
        
        demo项目聚合
 
 - ace-starter-projects
        
        spring starter项目聚合
        
 - ace-account-projects
         
        用户项目聚合   
     
 - ace
    ace-{模块名称}-projects 项目聚合模块
    ace-{模块名称}-micro-mybatisPlusDbService-biz      微服务某领域业务实现层
    ace-{模块名称}-micro-mybatisPlusDbService-biz-api  微服务某领域业务实现层
    ace-{模块名称}-micro-mybatisPlusDbService-dal      微服务某领域资源访问层

 - ace-demo-projects 
        
        demo项目聚合
 
 - ace-starter-projects
        
        spring starter项目聚合
        
 