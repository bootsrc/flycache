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
 <a href="http://blog.csdn.net/lsm135/article/details/79081776" target="_blank">http://blog.csdn.net/lsm135/article/details/79081776</a>

## 测试
[http://localhost:20200/test1](http://localhost:20200/test1)

[http://localhost:20200/nodeGroup](http://localhost:20200/nodeGroup)

如果您愿意捐助一下项目，可以通过微信/支付宝捐助哟~

|支付宝         | 微信           | 余额宝领红包|
| ------------- |:-------------:|:-------------:|
| ![](https://github.com/flylib/flycache/blob/master/alipay.png)      | ![](https://github.com/flylib/flycache/blob/master/wechat.png) | ![](https://github.com/flylib/flycache/blob/master/redPacket.png) |

