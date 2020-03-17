# 项目设计说明 

## 项目命名说明

## 项目框架层 - framework layer(fw)

### ace-xxx-diagram
    各领域数据库设计
    
### ace-fw-xxx
    框架层
    主要职责
        1.提供基础功能，如：json xml log
### ace-fw-xxx-autoconfigure
    自动配置工程
    主要职责
        1.使用spring boot spring.factories机制，进行自动配置

## 基础微服务层 - Base Layer

### ace-xxx-base-projects
    基础微服务工程
    主要职责
        1.管理对应领域基础微服务，所有工程
        
### ace-xxx-base-api 
    基础微服务接口层
    主要职责 
        1.controller接口层
        2.feign client接口层
        
### ace-xxx-base-api-client-autoconfigure
    基础微服务feign client接口层自动配置，主要职责
	    1.自动配置ace-xxx-xxx-base-api项目的feign clietn接口层

### ace-xxx-base-api-web
    基础微服务接口层web实现
    主要职责 
        1. 基础微服务controller接口层实现

### ace-xxx-define
    基础微服务定义层，独立工程，不进行项目中其它工程
    主要职责
        1.定义贯穿整个基础微服务领域的实体
        2.定义dao base与logic层相关实体 枚举 request response

### ace-xxx-define-mq
    基础微服务mq定义层，独立工程，不进行项目中其它工程
    主要职责
        1.定义贯穿整个基础微服务领域的mq

## 逻辑微服务层 - Logic Layer

### ace-xxx-logic-projects
    逻辑微服务工程
    主要职责
        1.管理对应领域逻辑微服务，所有工程
        
### ace-xxx-logic-api 
    逻辑微服务接口层
    主要职责 
        1.对外controller接口层
        2.feign client接口层

### ace-xxx-logic-api-web
    逻辑微服务接口层web实现
    主要职责 
        1. 逻辑微服务controller接口层实现
        
### ace-xxx-logic-api-client-autoconfigure
    逻辑微服务feign client接口层自动配置，主要职责
	    1.自动配置ace-xxx-logic-api项目的feign clietn接口层
 
 