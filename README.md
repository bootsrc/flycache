# flycache

## 简介
flycache是redis分布式分片存储的一个系统，支持弹性伸缩。 基于Java实现的一致性hash


flycache: Based on Java consistent-hashing Redis elastic shard storage.

## 功能
1. 弹性伸缩，提供控制面板，管理员可以增加和删除Redis节点
2. Redis运行状态监控，报警
3. Redis故障或者网络故障的灾难应对

## 原理
1. consistent-hashing一致性hash
2. zookeeper保持一致性和监听

## 文章
[http://blog.csdn.net/lsm135/article/details/79081776](http://blog.csdn.net/lsm135/article/details/79081776)

 